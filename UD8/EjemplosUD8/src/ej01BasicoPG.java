import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
/**
 *
 * @author DAW1
 */
public class ej01BasicoPG {
    public static void main(String[] args) {
        Connection con; // establece la conexion con la BD
        ResultSet rs; // clase con todos los datos de la query
        Statement sentencia; // clase que permite lanzar comandos sql
        String sql;
        String url = "jdbc:postgresql://localhost:5432/academiapg"; // la URL de la conexion de la BD
        try {
            con = DriverManager.getConnection(url, "consultor", "consultopass"); // usuario de la BD
            sentencia = con.createStatement();
            sql = "SELECT * FROM alumnos";
            rs = sentencia.executeQuery(sql);
            System.out.println("Lista de alumnos:");
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String direccion = rs.getString("direccion");
                String sexo = rs.getString("sexo");
                Date fechaNac = rs.getDate("fechanac");
                System.out.println("Alumno: " + nombre + " " + apellido1 + " " + apellido2 +
                        " direccion: " + direccion + " Sexo: " + sexo + " Fecha nac:" + fechaNac);
            }
            con.close(); //cerramos la conexión
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}