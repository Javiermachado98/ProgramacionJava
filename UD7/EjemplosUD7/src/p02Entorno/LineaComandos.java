/*
 * LineaComandos.java
 * @author DAW 1
 */


package p02Entorno;

/**
 * Invocar desde directorio raíz de proyecto con "java p02File.J04LineaComandos
 * uno dos"
 */
public class LineaComandos {

    /**
     * @param args
     */
    public static void main(String args[]) {
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                System.out.println("args[" + i + "]" + args[i]);
            }
        } else {
            System.out.println(" No hay argumentos");
        }
    }
}
