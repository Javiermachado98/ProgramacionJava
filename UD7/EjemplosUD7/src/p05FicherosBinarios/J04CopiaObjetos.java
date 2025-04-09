/*
 * CopiaObjetos.java
 *
 * @author DAW 1
 */
package p05FicherosBinarios;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import p01Auxiliar.Persona;

/**
 *
 * @author admin
 */
public class J04CopiaObjetos {

    /**
     *
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<Persona> a = new ArrayList();
        a.add(new Persona("Pedro Perez", 33, true));
        a.add(new Persona("Marcos Nogueras", 37, false));
        a.add(new Persona("Marta Antunez", 31, false));

        try (
                 ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("src" + File.separator + "files" + File.separator + "salidaObjetos.txt"))) {

            for (Persona a1 : a) {
                salida.writeObject(a1);
            }

        } catch (IOException e) {
            System.out.println(e.toString());
        }

        try (
                 ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("src" + File.separator + "files" + File.separator + "salidaObjetos.txt"))) {
            Persona p;

            while (true) {
                p = (Persona) entrada.readObject();
                String casadaString = (p.isCasado() ? " está casada" : " no está casada");
                System.out.println(p.getNombre() + " tiene " + p.getEdad() + casadaString);

            }
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}
