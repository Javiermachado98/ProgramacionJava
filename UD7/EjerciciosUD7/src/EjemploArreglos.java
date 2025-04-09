import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EjemploArreglos {

    public static void main(String[] args) throws IOException {
        BufferedReader streamIn = null;

        try {

            streamIn = new BufferedReader(new FileReader("src" + File.separator + "files" + File.separator + "ejemplo.txt"));

            String l;
            int contador = 1;
            while ((l = streamIn.readLine()) != null) {

                String lineas[] = l.split(" ");

                System.out.println("La linea " + contador + " tiene " + lineas.length + " palabras");

                contador++;
                }

        }catch (Exception e) {
            System.out.println(e);
        }
        finally {
            if (streamIn != null) {
                streamIn.close();
            }
        }
    }

}
