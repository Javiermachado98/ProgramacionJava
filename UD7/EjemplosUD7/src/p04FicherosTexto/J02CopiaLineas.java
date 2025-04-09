/*
 * CopiaLineas.java
 *
 * @author DAW 1
 */
package p04FicherosTexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author admin
 */
public class J02CopiaLineas {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader streamEntrada = null;
        BufferedWriter streamSalida = null;

        try {
            streamEntrada = new BufferedReader(new FileReader("src" + File.separator + "files" + File.separator + "entrada.txt"));
            streamSalida = new BufferedWriter(new FileWriter("src" + File.separator + "files" + File.separator + "salidaLineas.txt"));

            String l;
            while ((l = streamEntrada.readLine()) != null) {
                streamSalida.write(l);
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
