package p01Nominas;

import java.sql.*;

public class pruebaNomina {

    public static void main(String[] args) {

        Connection con;
        ResultSet rs;
        Statement sentencia;
        String sql;

        String url = "jdbc:mysql://localhost:3306/empresamodesto";

        try {
            con = DriverManager.getConnection(url, "consultor", "consultorpass");

            sentencia = con.createStatement();
            sql = "SELECT e.DNI, e.Nombre, e.Apellidos, n.mes, n.importe FROM empleados e LEFT JOIN nominas n ON e.DNI = n.empleado;";
            rs = sentencia.executeQuery(sql);
            System.out.println("Empleados con sus nominas: ");
            while (rs.next()){

                String DNI = rs.getString("DNI");
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");
                String mes = rs.getString("mes");
                int importe = rs.getInt("importe");
                System.out.println("DNI: " + DNI + " Nombre " + nombre + " Apellidos: " + apellidos + " Mes: " + mes + " Importe: " + importe);

            }
            con.close(); //Cerramos la conexion

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
}
