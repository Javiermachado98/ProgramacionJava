package p01Nominas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

import static p01Nominas.Principal01LeeBBDD.listemployers;
import static p01Nominas.Principal01LeeBBDD.uploadPayroll;

/**
 *
 * @author admin
 */

public class principalFinal {

    public static ListaEmpleados listaEmpleados = new ListaEmpleados();
    private static Connection conexion;
    private static final String user = "consultor";
    private static final String password = "consultorpass";
    private static final String myMachine = "localhost";
    private static final String baseDeDatos = "empresamodesto";
    private static ResultSet rs;
    private static Statement sentencia;
    private static String sql;
    private static PreparedStatement ps;


    public static final int OPCION_ALTA_EMPLEADO = 1;
    public static final int OPCION_MOSTRAR_EMPLEADOS = 2;
    public static final int OPCION_ALTA_NOMINA = 3;
    public static final int OPCION_MOSTRAR_NOMINAS_EMPLEADO = 4;
    public static final int OPCION_MOSTRAR_TOTAL_COBRADO_EMPLEADO = 5;
    public static final int OPCION_MOSTRAR_NOMINAS_MES = 6;
    public static final int OPCION_MOSTRAR_NOMINAS_MAYORES_IMPORTE = 7;
    public static final int OPCION_SALIR = 8;

    public static ListaEmpleados miLista;


    public static Connection connectMyDatabase() {
        Connection con = null;
        String url = "jdbc:mysql://" + myMachine + "/" + baseDeDatos;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la base de datos.");
        }
        return con;
    }

    public static void cargarEmpleados() {
        conexion = connectMyDatabase();
        if (conexion == null) {
            System.out.println("No se pudo cargar empleados: conexión nula.");
            return;
        }

        try {
            conexion = connectMyDatabase();
            sentencia = conexion.createStatement();
            sql = "SELECT * FROM empleados";
            rs = sentencia.executeQuery(sql);

            while (rs.next()) {
                String DNI = rs.getString("DNI");
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");
                Empleado myempleado = new Empleado(DNI, nombre, apellidos);
                listaEmpleados.anadirEmpleado(myempleado);
            }
            conexion.close(); // cierro la conexion

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void cargarNominas() {
        try {
            conexion = connectMyDatabase();
            sentencia = conexion.createStatement();
            sql = "SELECT * FROM nominas";
            rs = sentencia.executeQuery(sql);

            while (rs.next()) {

                String dni = rs.getString("empleado");
                Empleado myempleado2 = listaEmpleados.devuelveEmpleadoDNI(dni);
                if (myempleado2 != null) {
                    tipoMes mes = tipoMes.valueOf(rs.getString("mes"));
                    int anno = rs.getInt("anno");
                    float importe = rs.getFloat("importe");

                    Nomina mynomina = new Nomina(importe, anno ,mes);
                    myempleado2.anadirNominaEmpleado(mynomina);
                }
            }

            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void mostrarNominasMayoresA(float importes) {
        try {
            conexion = connectMyDatabase();
            String sql = "SELECT * FROM nominas WHERE importe > ?";
            ps = conexion.prepareStatement(sql);
            ps.setFloat(1, importes);
            rs = ps.executeQuery();

            System.out.println("Nóminas mayores de " + importes);
            while (rs.next()) {
                float importe = rs.getFloat("importe");
                tipoMes mes = tipoMes.valueOf(rs.getString("mes"));
                int anno = rs.getInt("anno");
                String dni = rs.getString("empleado");

                //aqui buscamos de nuevo el empleado con el getdni y equal(dni)
                Empleado myempleado3 = listaEmpleados.devuelveEmpleadoDNI(dni);
                if (myempleado3 != null){
                    System.out.println("Este empleado tiene nomina mayor: " + myempleado3.getNombre() + " " + myempleado3.getApellidos());
                    System.out.println("Año: " + anno + " Mes: " + mes + " Importe: " + importe );
                }

            }

            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void guardarNuevoEmpleado(Empleado emp) {
        try {
            conexion = connectMyDatabase();
            sql = "INSERT INTO empleados (DNI, nombre, apellidos) VALUES (?, ?, ?)";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, emp.getDNI());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getApellidos());
            ps.executeUpdate();


            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void guardarNuevaNomina(String dni, Nomina nomina) {
        try {
            conexion = connectMyDatabase();
            String sql = "INSERT INTO nominas (empleado, mes, anno, importe) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, nomina.getMes().toString());
            ps.setInt(3, nomina.getAnno());
            ps.setFloat(4, nomina.getImporte());
            ps.executeUpdate();


            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }


    public static void cargaInfo() {

    }

    public static void guardaInfo() {

    }

    /**
     *
     */
    public static void mostrarMenu() {
        System.out.println("==================================================");
        System.out.println(" EMPLEADOS  ");
        System.out.println("==================================================");
        System.out.println("1.-  ALTA EMPLEADOS ");
        System.out.println("2.-  MOSTRAR EMPLEADOS ");
        System.out.println("3.-  ALTA NOMINA ");
        System.out.println("4.-  NOMINAS EMPLEADO");
        System.out.println("5.-  TOTAL COBRADO EMPLEADO");
        System.out.println("6.-  MOSTRAR NOMINAS MES");
        System.out.println("7.-  MOSTRAR MAYORES IMPORTE");
        System.out.println("8.-  SALIR");
        System.out.println("==================================================");
        System.out.print("Introduce una opción: ");
    }

    /**
     *
     * @param args
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        cargarEmpleados();
        cargarNominas();

        do {
            mostrarMenu();
            sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion) {

                case OPCION_ALTA_EMPLEADO -> {
                    System.out.println("Ingrese el DNI: ");
                    String dni = sc.next();
                    System.out.println("Nombre: ");
                    String nombre = sc.next();
                    System.out.println("Apellido: ");
                    String apellidos = sc.next();
                    Empleado myNuevoEmpleado = new Empleado(dni, nombre, apellidos);
                    listaEmpleados.anadirEmpleado(myNuevoEmpleado);
                    guardarNuevoEmpleado(myNuevoEmpleado);

                    System.out.println("Empleado añadido");
                }
                case OPCION_MOSTRAR_EMPLEADOS -> {
                    Principal01LeeBBDD.uploadEmployersDB();
                    System.out.println("Empleados cargados: ");
                    listemployers.mostrarEmpleados();

                }
                case OPCION_ALTA_NOMINA -> {
                    Empleado emp = null;
                    listaEmpleados.mostrarEmpleados();
                    System.out.print("Selecciona un empleado de la lista: ");
                    int numero = sc.nextInt();
                    if (numero >= 1 && numero <= miLista.numeroEmpleados()) {
                        emp = miLista.empleadoPosicionI(numero - 1);
                        Nomina mynomina = new Nomina();
                        mynomina.alta();
                        emp.anadirNominaEmpleado(mynomina);
                        guardarNuevaNomina(emp.getDNI(), mynomina);
                    } else {
                        System.out.println("No me líes");
                    }

                    // Muestra lista empleados, pide que se le seleccione uno y da de alta una nomina (pide datos y aÃ±ade a su lista de nominas
                }
                case OPCION_MOSTRAR_NOMINAS_EMPLEADO -> {
                    Empleado emp = null;
                    listaEmpleados.mostrarEmpleados();
                    System.out.print("Selecciona un empleado de la lista: ");
                    int numero = sc.nextInt();
                    if (numero >= 1 && numero <= listaEmpleados.numeroEmpleados()) {
                        emp = listaEmpleados.empleadoPosicionI(numero - 1);
                        emp.muestraNominasEmpleado();
                    } else {
                        System.out.println("No me líes");
                    }
                }
                case OPCION_MOSTRAR_TOTAL_COBRADO_EMPLEADO -> {
                    Empleado emp = null;
                    miLista.mostrarEmpleados();
                    System.out.print("Selecciona un empleado de la lista: ");
                    int numero = sc.nextInt();
                    if (numero >= 1 && numero <= miLista.numeroEmpleados()) {
                        emp = miLista.empleadoPosicionI(numero - 1);
                        emp.muestreTotalCobrado();
                    } else {
                        System.out.println("No me líes");
                    }
                }
                case OPCION_MOSTRAR_NOMINAS_MES -> {
                    // Pide mes y muestra todas las nominas de todos los empleados de ese mes
                    System.out.println("Dime el mes: ");
                    tipoMes mes = tipoMes.NINGUNO; // damos un valor por defecto para que nos deje validar el mes
                    mes = mes.validaMes();

                    Empleado emp = null;
                    System.out.println("Nóminas del mes " + mes);
                    for (int i = 0; i < miLista.numeroEmpleados(); i++) {
                        emp = miLista.empleadoPosicionI(i);
                        System.out.println("Empleado: " + emp.getNombre() + " " + emp.getApellidos());
                        emp.muestraNominasMes(mes);

                    }
                }

                case OPCION_MOSTRAR_NOMINAS_MAYORES_IMPORTE -> {
                    // Pide importe y muestra todas las nominas de todos los empleadosmayores que el importee
                    System.out.println("Introduce un importe");
                    float importe = sc.nextFloat();
                    float importes = importe;
                    miLista.muestraNominasEmpleadosMayores(importe);
                    mostrarNominasMayoresA(importes);
                }

                case OPCION_SALIR -> {
                    guardaInfo();
                }

                default -> {
                    System.out.println("Introduce una opción válida");
                }
            }

        } while (opcion != OPCION_SALIR);



        sc.close();
    }

}
