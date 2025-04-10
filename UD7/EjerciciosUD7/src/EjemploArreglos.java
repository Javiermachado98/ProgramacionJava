import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EjemploArreglos {

    public static void main(String[] args) throws IOException {


        BufferedReader streamEntrada = null;


        try {
            streamEntrada = new BufferedReader(new FileReader("src" + File.separator + "files" + File.separator + "cuenta.txt"));
            String l;

            while ((l = streamEntrada.readLine()) != null) {
                String[] lineas = l.split(" ");

                System.out.println(lineas.length + "palabras");
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (streamEntrada != null) {
                streamEntrada.close();
            }

        }
    }
}


