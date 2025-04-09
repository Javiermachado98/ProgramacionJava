/*
 * UsoFile.java
 * @author DAW 1
 */

package p03File;


import java.io.File;

/**
 *
 */
public class J04UsoFileCarpeta {
        
    
    /**
     * @param f
     */
    public static void listaContenido (File f) {
        String lista [];
        if (f.isDirectory()) {
            System.out.println("directorio " + f.toString());
            lista = f.list();
            for (int i = 0; i < lista.length; i++) {
                listaContenido(new File(f, lista[i]));
            }            
        }
        else {
            System.out.println("  " + f.toString());
        }
    }
    
    /**
     *
     * @param args
     */
    public static void main (String args[])  {
                        
        File fichero;
        String lista [];
        
        if (args.length > 0) {        
            if (args[0] != null) {
                fichero = new File (args[0]);
                if (fichero.exists()) {
                    listaContenido(fichero);
                }
            }   
            else {
                System.out.println("El fichero " + args[0] + "no existe");
            }
        }
        else {
            System.out.println("Necesito argumentos");
        }
    }    
}
