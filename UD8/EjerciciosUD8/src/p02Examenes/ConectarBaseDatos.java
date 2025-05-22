package p02Examenes;

import java.sql.*;

public class ConectarBaseDatos {

    public static ListaExamenes mylistaExamenes = new ListaExamenes(); // creo una clase lista con los examenes de manera global
    private static Connection conexion;
    private static final String user = "consultor";
    private static final String password = "consultorpass";
    private static final String myMachine = "localhost";
    private static final String baseDeDatos = "examenes";
    private static ResultSet rs;
    private static Statement sentencia;
    private static PreparedStatement preparedsentencia;
    private static String sql;


    public static Connection conectarMyDataBase(){
        Connection con = null;
        String url = "jdbc:mysql://" + myMachine + "/" + baseDeDatos;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Error connecting to the DataBase.");
        }
        return con;
    }

    public static void cargarExamenesBD(){
        String url = "jdbc:mysql://" + myMachine + "/" + baseDeDatos;
        try {
            conexion = DriverManager.getConnection(url,user,password);
            sentencia = conexion.createStatement();
            sql = "SELECT * FROM examenes";
            rs = sentencia.executeQuery(sql);
            System.out.println("lista de preguntas: ");

            while (rs.next()){
                int idPregunta = rs.getInt("idPregunta");
                String titulo = rs.getString("titulo");
                String texto = rs.getString("texto");
                String respuesta = rs.getString("respuesta");
                double maxPuntos = rs.getDouble("maxPuntos");

            }



        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
