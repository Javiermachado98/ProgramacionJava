/*
 * CopiaCaracteres.java
 *
 * @author DAW 1
 */

package p04FicherosTexto;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 */
public class J01CopiaCaracteres {
        
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        FileReader streamEntrada = null;
        FileWriter streamSalida = null;

        try {
            streamEntrada = new FileReader("src" + File.separator + "files" + File.separator + "entrada.txt");
            streamSalida = new FileWriter("src" + File.separator + "files" + File.separator + "salidaChar.txt");

            int c;
            while ((c = streamEntrada.read()) != -1) {
                streamSalida.write(c);
            }
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
