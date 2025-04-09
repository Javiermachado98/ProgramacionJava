/*
 * CopiaBytes.java
 *
 * @author DAW 1
 */

package p05FicherosBinarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author admin
 */

public class J01CopiaBytes {
    
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        FileInputStream entrada = null;
        FileOutputStream salida = null;
        try {

            entrada = new FileInputStream("src" + File.separator + "files" + File.separator + "entrada.txt");
            salida = new FileOutputStream("src" + File.separator + "files" + File.separator + "salida.txt");
            int byteLeido;
                                              
            while ((byteLeido = entrada.read()) != -1) {
                salida.write(byteLeido);
            }
                        
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        finally {
            if (entrada != null) {
                entrada.close();
            }
            if (salida != null) {
                salida.close();
            }
        }
    }   
}
