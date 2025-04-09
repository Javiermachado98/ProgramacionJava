/*
 * EntornoEjecucion.java
 * @author DAW 1
 */


package p02Entorno;


import java.util.Map;

/**
 *
 */
public class EntornoEjecucion {
    /**
     *
     * @param args
     */
    public static void main (String[] args) {
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n", envName, env.get(envName));
        }
    }
    
}
