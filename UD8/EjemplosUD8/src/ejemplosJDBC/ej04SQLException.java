package ejemplosJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author admin
 */
public class ej04SQLException {
    public static void main(String[] args) {
        Connection con;
        Statement sentencia;
        String sql;

        String url = "jdbc:mysql://localhost:3306/academia";
        try {
            con = DriverManager.getConnection(url, "consultor", "consultorpass");
            sentencia = con.createStatement();
            sql = "UPDATE cursos "
                    + "SET maxalumnos=maxalumnos+20 "
                    + "WHERE numhoras < '200'";
            int nFilas = sentencia.executeUpdate(sql);
            con.close();
            System.out.println("Se ha modificado el número máximo de alumnos en " + nFilas + " registros");
        }  catch(SQLException ex) {
            System.out.println("Se han dado excepciones SQLException\n");
            System.out.println("========================\n");
            //Pueden existir varias SQLException encadenadas
            while(ex!=null) {
                System.out.println("SQLState :"+ex.getSQLState()+"\n");
                System.out.println("Mensaje :"+ex.getMessage()+"\n");
                System.out.println("C�digo de error :"+ex.getErrorCode()+"\n");
                ex=ex.getNextException();
                System.out.println("\n");
            }
        }
    }

}
