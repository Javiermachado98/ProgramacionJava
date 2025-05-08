package p01Nominas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Principal02EscribeBBDD {

    private static Connection conexion;
    private static final String user = "consultor";
    private static final String password = "consultorpass";
    private static final String myMachine = "localhost";
    private static final String baseDeDatos = "empresamodesto";

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
    public static void main(String[] args) {
        conexion = connectMyDatabase();
        Empleado myempleado = new Empleado("11111111Y", "maksym", "hyrnenko");
        System.out.println(myempleado);

        try {
            String sql = "INSERT INTO empleados (DNI, nombre, apellidos) " + "VALUES ( ?, ?, ?)";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, myempleado.getDNI());
            sentencia.setString(2, myempleado.getNombre());
            sentencia.setString(3, myempleado.getApellidos());

            int nFilas = sentencia.executeUpdate();
            conexion.close();

        }catch (SQLException ex){
            System.out.println("An error has ocurred.");
            System.out.println(ex);
        }

    }
}
