package p01Nominas;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class Principal01LeeBBDD {

    public static ListaEmpleados listemployers = new ListaEmpleados(); // creo una clase lista con los empleados de manera globa
    private static Connection conexion;
    private static final String user = "consultor";
    private static final String password = "consultorpass";
    private static final String myMachine = "localhost";
    private static final String baseDeDatos = "empresamodesto";
    private static ResultSet rs;
    private static Statement sentencia;
    private static PreparedStatement preparedsentencia;
    private static String sql;

    public static Connection connectMyDatabase() {
        Connection con = null;
        String url = "jdbc:mysql://" + myMachine + "/" + baseDeDatos;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Error connecting to the DataBase.");
        }
        return con;
    }

    public static void uploadEmployersDB() {
        String url = "jdbc:mysql://localhost:3306/empresamodesto";
        try {
            conexion = DriverManager.getConnection(url, "consultor", "consultorpass");
            sentencia = conexion.createStatement();
            sql = "SELECT * FROM empleados";
            rs = sentencia.executeQuery(sql);
            System.out.println("Lista de empleados");
            while (rs.next()) {

                String DNI = rs.getString("DNI");
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");
                Empleado myempleado = new Empleado(DNI, nombre, apellidos);
                listemployers.anadirEmpleado(myempleado);

            }
            conexion.close(); //Cerramos la conexion

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void uploadPayroll() {
        uploadEmployersDB();
        String url = "jdbc:mysql://localhost:3306/empresamodesto";
        try {
            conexion = DriverManager.getConnection(url, "consultor", "consultorpass");
            sentencia = conexion.createStatement();
            sql = "SELECT * FROM nominas";
            preparedsentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery(sql);

            System.out.println("Lista de nominas");
            while (rs.next()) {

                tipoMes mes = tipoMes.valueOf(rs.getString("mes"));
                int anno = rs.getInt("anno");
                float importe = rs.getFloat("importe");
                String dni = rs.getString("empleado");

                Empleado myempleado2 = listemployers.devuelveEmpleadoDNI(dni);
                Nomina mynomina = new Nomina(importe, anno, mes);

                myempleado2.anadirNominaEmpleado(mynomina);
                myempleado2.muestraNominasEmpleado();

            }

            conexion.close(); //Cerramos la conexion

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        uploadPayroll();
    }
}

//buscar en la lista, el dni y añadir esa nomina al empleado con ese DNI
