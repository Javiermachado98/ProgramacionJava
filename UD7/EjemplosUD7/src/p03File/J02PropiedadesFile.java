/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package p03File;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author DAW 1
 */
public class J02PropiedadesFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            File f = new File ("Fichero.txt");            
            System.out.println("toString():         " + f);            
            System.out.println("isFile:             " + f.isFile());
            System.out.println("isDirectory():      " + f.isDirectory());
            System.out.println("isHidden():         " + f.isHidden());
            System.out.println("canRead():          " + f.canRead());
            System.out.println("canWrite():         " + f.canWrite());
            System.out.println("canExecute():       " + f.canExecute());
            System.out.println("isAbsolute():       " + f.isAbsolute());
            System.out.println("length():           " + f.length());
            System.out.println("getName():          " + f.getName());
            System.out.println("getPath():          " + f.getPath());
            System.out.println("getAbsolutePath():  " + f.getAbsolutePath());
            System.out.println("getCanonicalPath(): " + f.getCanonicalPath());
            System.out.println("getParent():        " + f.isAbsolute());
            System.out.println("toURI():            " + f.toURI());
        }
        catch (IOException e) {
            System.out.println(e);
        }
        
    }

}
