package ejemplosJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import auxiliares.Alumno;

/**
 *
 * @author admin
 */
public class ej09InsertarAlumno {

    private static Connection conexion;
    private static final String user="consultor";
    private static final String password="consultorpass";
    private static final String maquina = "localhost";
    private static final String bbdd = "academia";

    public static Connection conectar() {
        Connection con = null;
        String url = "jdbc:mysql://" + maquina + "/" + bbdd;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Error al conectar al SGBD.");
        }
        return con;
    }

    public static void main(String[] args) {
        conexion = conectar();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse("03/06/1986",dtf);
        Alumno nuevo = new Alumno("1234567J", "Rafael", "Nadal", "Parera", "Casoplón mallorquín s/n", "V", fechaNac);
        System.out.println("El alumno a insertar es: ");
        System.out.println(nuevo);

        try {
            String sql = "INSERT INTO alumnos (dni, nombre, apellido1, apellido2, direccion, sexo, fechanac) " +
                    "VALUES (  ?,      ?,         ?,         ?,         ?,    ?,     ?)";

            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, nuevo.getDni());
            sentencia.setString(2, nuevo.getNombre());
            sentencia.setString(3, nuevo.getApellido1());
            sentencia.setString(4, nuevo.getApellido2());
            sentencia.setString(5, nuevo.getDireccion());
            sentencia.setString(6, nuevo.getSexo());
            java.sql.Date fecha = java.sql.Date.valueOf(nuevo.getFechaNacimiento());
            sentencia.setDate(7, fecha);

            int nFilas = sentencia.executeUpdate();
            conexion.close();

            System.out.println("Se ha modificado el número máximo de alumnos en " + nFilas + " registros");

        } catch (SQLException ex) {
            System.out.println("Ha ocurrido algún error.");
            System.out.println(ex);
        }

    }

}
