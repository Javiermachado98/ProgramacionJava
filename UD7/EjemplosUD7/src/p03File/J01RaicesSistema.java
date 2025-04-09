/*
 * AtributosFile.java
 * @author DAW 1
 */

package p03File;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author user1
 */
public class J01RaicesSistema {
    
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String args[]) throws IOException {

        System.out.println("Raices del sistema operativo ");
        File raices [] = File.listRoots();
        for (int i = 0; i < raices.length; i++)  {
            System.out.println(raices[i]);
        }     
        
    }
}


