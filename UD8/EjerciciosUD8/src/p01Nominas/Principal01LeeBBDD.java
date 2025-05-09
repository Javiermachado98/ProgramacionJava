package p01Nominas;

import java.sql.*;

public class Principal01LeeBBDD {

    public static ListaEmpleados listemployers = new ListaEmpleados(); // creo una clase lista con los empleados de manera globa

    private static Connection conexion;
    private static final String user = "consultor";
    private static final String password = "consultorpass";
    private static final String myMachine = "localhost";
    private static final String baseDeDatos = "empresamodesto";
    private static ResultSet rs;
    private static Statement sentencia;
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

        // creo una clase lista con los empleados

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
            listemployers.mostrarEmpleados();

            conexion.close(); //Cerramos la conexion


        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    public static void uploadPayroll (){

    }

    public static void main(String[] args) {
        uploadEmployersDB();
        uploadPayroll();
    }
}
