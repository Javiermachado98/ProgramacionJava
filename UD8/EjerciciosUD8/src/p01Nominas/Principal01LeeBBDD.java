package p01Nominas;
import java.sql.*;

public class Principal01LeeBBDD {
    public static void main(String[] args) {

        ListaEmpleados listemployers = new ListaEmpleados(); // creo una clase lista con los empleados
        Connection con;
        ResultSet rs;
        Statement sentencia;
        String sql;

        String url = "jdbc:mysql://localhost:3306/empresamodesto";

        try {
            con = DriverManager.getConnection(url, "consultor", "consultorpass");


            sentencia = con.createStatement();
            sql = "SELECT * FROM empresamodesto.empleados";
            rs = sentencia.executeQuery(sql);
            System.out.println("Lista de empleados");
            while (rs.next()){
                String DNI = rs.getString("DNI");
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");

                Empleado myempleado = new Empleado(DNI, nombre, apellidos);
                listemployers.anadirEmpleado(myempleado);
            }
            listemployers.mostrarEmpleados();

            con.close(); //Cerramos la conexion



        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
}
