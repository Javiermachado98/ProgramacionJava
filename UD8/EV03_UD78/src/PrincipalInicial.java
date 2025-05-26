import model.Parcela;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import dao.ParcelaDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class PrincipalInicial {
    private static final ParcelaDAO dao = new ParcelaDAO();


    public static void main(String[] args) {

        List<Parcela> Parcelas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/files/parcelas.csv"))) {

            String linea = br.readLine();

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                int numeroParcela = Integer.parseInt(datos[0]);
                double coordenadaX = Double.parseDouble(datos[1]);
                double coordenadaY = Double.parseDouble(datos[2]);
                double superficem2 = Double.parseDouble(datos[3]);

                Parcela myparcela = new Parcela(numeroParcela, coordenadaX, coordenadaY,superficem2);
                dao.guardar(myparcela);
                System.out.println("Se han agregado las parcelas");
            }

        } catch (IOException e) {
            System.err.println("Error leyendo el fichero: " + e.getMessage());
        }


    }

}
