package ejemplosJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @author admin
 */
public class ej08UpdateParametrizado {
    public static void main(String[] args) {
        Connection con;
        PreparedStatement sentencia;
        String sql;

        String url = "jdbc:mysql://localhost:3306/academia";
        try {
            con = DriverManager.getConnection(url, "consultor", "consultorpass");

            sql = "UPDATE cursos "
                    + "SET maxalumnos=maxalumnos+? "
                    + "WHERE numhoras < ?";
            sentencia = con.prepareStatement(sql);

            sentencia.setInt(1, 20);
            sentencia.setInt(2, 40);

            int nFilas = sentencia.executeUpdate();
            con.close();
            System.out.println("Se ha modificado el número máximo de alumnos en " + nFilas + " registros");
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido algún error.");
            System.out.println(ex);
        }
    }

}
