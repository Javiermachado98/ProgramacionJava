/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class hazcuentas {

    public static void main(String[] args) throws IOException {

        BufferedReader streamEntrada = null;
        BufferedWriter streamSalida = null;

        ArrayList<String> Lineas = new ArrayList();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Introduce nombre de un fichero .txt");
             String   nombre = sc.nextLine();

            File f = new File(  "files" + File.separator + nombre);
            while (!f.isFile() && !f.exists()) {
                System.out.println("El fichero no existe, Introduce uno correcto: ");
                nombre = sc.nextLine();
                f = new File(  "files" + File.separator + nombre);
            }

            String nombreSalida = nombre.replace(".txt", ".out");
            streamEntrada = new BufferedReader(new FileReader(f));
            streamSalida = new BufferedWriter(new FileWriter(  "files" + File.separator + nombreSalida));

            System.out.println("Introduce una letra");
            char letra = sc.next().charAt(0);

            String l;
            String[] palabras;
            int nPalabras;
            int nAparacionesLetras ;
            int longitud;
            while ((l = streamEntrada.readLine()) != null) {
                palabras = l.split(" ");
                nPalabras = palabras.length;
                nAparacionesLetras = 0;
                for (int i = 0; i < l.length(); i++) {
                    if (letra == l.charAt(i)) {
                        nAparacionesLetras++;

                    }
                }

                longitud = l.length();
                streamSalida.write(""+nPalabras);
                streamSalida.write("   ");
                streamSalida.write(""+nAparacionesLetras);
                streamSalida.write("   ");
                streamSalida.write(""+longitud);
                streamSalida.newLine();

            }

        } catch (IOException e) {
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (streamEntrada != null) {
                streamEntrada.close();
            }
            if (streamSalida != null) {
                streamSalida.close();
            }
        }
    }
}
