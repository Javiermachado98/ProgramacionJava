/*
 * ScanFichero.java
 *
 * @author DAW 1
 */

package p04FicherosTexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class J03ScanFichero {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader("src" + File.separator + "files" + File.separator + "entrada.txt")));
            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        finally {
            if (s != null) {
                s.close();
            }
        }

    }
}
