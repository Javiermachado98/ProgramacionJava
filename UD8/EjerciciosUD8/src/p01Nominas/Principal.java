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

import static p01Nominas.Principal01LeeBBDD.listemployers;

/**
 *
 * @author admin
 */
public class Principal {

    public static final int OPCION_ALTA_EMPLEADO = 1;
    public static final int OPCION_MOSTRAR_EMPLEADOS = 2;
    public static final int OPCION_ALTA_NOMINA = 3;
    public static final int OPCION_MOSTRAR_NOMINAS_EMPLEADO = 4;
    public static final int OPCION_MOSTRAR_TOTAL_COBRADO_EMPLEADO = 5;
    public static final int OPCION_MOSTRAR_NOMINAS_MES = 6;
    public static final int OPCION_MOSTRAR_NOMINAS_MAYORES_IMPORTE = 7;
    public static final int OPCION_SALIR = 8;

    public static ListaEmpleados miLista;

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

        ListaEmpleados lista = listemployers;

        miLista = new ListaEmpleados();
        cargaInfo();

        Scanner sc;
        int opcion;

        Empleado miEmpleado;

        do {
            mostrarMenu();
            sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion) {

                case OPCION_ALTA_EMPLEADO -> {
                    miEmpleado = new Empleado();
                    miEmpleado.alta();
                    miLista.anadirEmpleado(miEmpleado);
                    // Alta empleado y aÃ±ade a lista Empleado
                }
                case OPCION_MOSTRAR_EMPLEADOS -> {
                    Principal01LeeBBDD.uploadEmployersDB();
                }
                case OPCION_ALTA_NOMINA -> {
                    Empleado emp = null;
                    miLista.mostrarEmpleados();
                    System.out.print("Selecciona un empleado de la lista: ");
                    int numero = sc.nextInt();
                    if (numero >= 1 && numero <= miLista.numeroEmpleados()) {
                        emp = miLista.empleadoPosicionI(numero - 1);
                        Nomina nom = new Nomina();
                        nom.alta();
                        emp.anadirNominaEmpleado(nom);
                    } else {
                        System.out.println("No me líes");
                    }

                    // Muestra lista empleados, pide que se le seleccione uno y da de alta una nomina (pide datos y aÃ±ade a su lista de nominas
                }
                case OPCION_MOSTRAR_NOMINAS_EMPLEADO -> {
                    Empleado emp = null;
                    miLista.mostrarEmpleados();
                    System.out.print("Selecciona un empleado de la lista: ");
                    int numero = sc.nextInt();
                    if (numero >= 1 && numero <= miLista.numeroEmpleados()) {
                        emp = miLista.empleadoPosicionI(numero - 1);
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
                    double importe = sc.nextDouble();
                    miLista.muestraNominasEmpleadosMayores(importe);
                }

                case OPCION_SALIR -> {
                    guardaInfo();
                }

                default -> {
                    System.out.println("Introduce una opción válida");
                }
            }

        } while (opcion != OPCION_SALIR);

    }
}
