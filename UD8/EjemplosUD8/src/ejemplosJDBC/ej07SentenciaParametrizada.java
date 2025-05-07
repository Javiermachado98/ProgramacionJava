package ejemplosJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Date;

/**
 *
 * @author DAW1
 */
public class ej07SentenciaParametrizada {

    public static void main(String[] args) {
        Connection con;
        ResultSet rs;
        PreparedStatement sentencia;
        String sql = "";

        String genero = "M" ; // se puede cambiar esto o solicitarlo por teclado

        String url = "jdbc:mysql://localhost:3306/academiamysql";

        try {
            con = DriverManager.getConnection(url, "consultor", "consultorpass");

            sql = "SELECT * FROM alumnos WHERE sexo = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1,genero); // el primer ? corresponde al género

            rs = sentencia.executeQuery();
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
