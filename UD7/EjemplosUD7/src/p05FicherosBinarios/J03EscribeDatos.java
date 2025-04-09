/*
 * CopiaDatos.java
 *
 * @author DAW 1
 */
package p05FicherosBinarios;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import p01Auxiliar.Persona;

/**
 *
 * @author admin
 */
public class J03EscribeDatos {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        DataOutputStream salida;

        ArrayList<Persona> a = new ArrayList();
        a.add(new Persona("Pedro Perez", 33, true));
        a.add(new Persona("Marcos Nogueras", 37, false));
        a.add(new Persona("Marta Antunez", 31, false));

        try {
            salida = new DataOutputStream(new BufferedOutputStream(
                    new FileOutputStream("src" + File.separator + "files" + File.separator +  "salidaDatos.txt")));

            for (Persona p : a) {
                salida.writeUTF(p.getNombre());
                salida.writeInt(p.getEdad());
                salida.writeBoolean(p.isCasado());
            }
            salida.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

}
