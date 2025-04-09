import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class E01Ordenacion {

    public static void main(String[] args) throws IOException {
        BufferedReader streamEntrada = null;
        BufferedWriter streamSalida = null;

        try {
            streamEntrada = new BufferedReader(new FileReader("src" + File.separator + "files" + File.separator + "entrada1.txt"));
            streamSalida = new BufferedWriter(new FileWriter("src" + File.separator + "files" + File.separator + "salidaLineas.txt"));

            String linea;
            ArrayList<String> Palabras = new ArrayList<>();

            while ((linea = streamEntrada.readLine()) != null) {
                Palabras.add(linea);
            }
            Collections.sort(Palabras);
            System.out.println(Palabras);

            for (String palabra : Palabras){
                streamSalida.write(palabra);
                streamSalida.newLine();
            }


        } catch (Exception e) {
            System.out.println(e);

        } finally {
            if (streamEntrada != null) {
                streamEntrada.close();
            }
            if (streamSalida != null) {
                streamSalida.close();
            }
        }

    }

}