/*
 * CopiaDatos.java
 *
 * @author DAW 1
 */

package p05FicherosBinarios;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author admin
 */
public class J02LeeDatos {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
           
        DataInputStream entrada;
               
        String nombre;
        int edad;
        boolean casada;
        try {  
            
            entrada = new DataInputStream(
                new BufferedInputStream(
                    new FileInputStream("src" + File.separator + "files" + File.separator + "salidaDatos.txt")));
                
            while (entrada.available()>0) {
                nombre = entrada.readUTF();
                edad = entrada.readInt();
                casada = entrada.readBoolean();  
                String casadaString = (casada?"está casada":"no está casada");
                System.out.println(nombre + " tiene " + edad + " y " + casadaString);
            }
            
            entrada.close(); 
        } catch (Exception e) {
            System.out.println("llegamos al final del fichero");
        }        
               
    }
}

        
        

