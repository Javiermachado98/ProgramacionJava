package ejemplosJDBC;

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
public class ej01Basico {

    public static void main(String[] args) {
        Connection con;
        ResultSet rs;
        Statement sentencia;
        String sql;

        String url = "jdbc:mysql://localhost:3306/academiamysql";
        try {
            con = DriverManager.getConnection(url, "consultor", "consultorpass");
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
                System.out.println("Alumno: " + nombre + " " + apellido1 + " "+ apellido2 +
                        " direccion: " + direccion + " Sexo: " + sexo + " Fecha nac:"  + fechaNac);
            }

            con.close(); //cerramos la conexión
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}