package p04FicherosTexto;


import java.io.*;
import java.util.Random;
import java.util.Scanner;

// PAra que este programa funcione correctamente, debes copiar en el directorio raíz del proyecto de netbeans
// (Donde están las carpetas src, build,...) el fichero ficheroDiccionario.txt

/**
 * Programa diccionario, nos ayuda a estudiar INGLES Trabajamos sobre el foro
 * https://stackoverflow.com/questions/3904579/how-to-capitalize-the-first-letter-of-a-string-in-java
 * https://stackoverflow.com/questions/17984975/convert-int-to-char-in-java
 * https://stackoverflow.com/questions/8172420/how-to-convert-a-char-to-a-string
 * Programa PALE 2021
 *
 * @author admin
 */
public class J04Diccionario {

    ////////////////////////////DECLARACIONES
    // constantes para la gestión del programa
    static final int N_PALABRAS_MAX = 100;
    static final int N_IDIOMAS = 2;
    static final int ID_ES = 0;
    static final int ID_EN = 1;

    // constantes para el menú
    static final int MENU_NUEVA = 1;
    static final int MENU_PRACTICA_ES = 2;
    static final int MENU_PRACTICA_EN = 3;
    static final int MENU_TODAS = 4;
    static final int MENU_SALIR = 5;

    // variables
    static int nPalabras = 0;
    static int opcion;             // para leer de menú
    static int numero;             // para trabajar con los randoms

    static String diccionario[][];
    static String palabra;

    static String ficheroDiccionario = "src" + File.separator + "files" + File.separator + "ficheroDiccionario.txt";

    static void leePalabrasFichero() {

        BufferedReader in = null;
        String[] subcadenas;
        try {
            in = new BufferedReader(new FileReader(ficheroDiccionario));
            String linea = in.readLine();
            while (linea != null) {
                if (nPalabras < N_PALABRAS_MAX) {
                    subcadenas = linea.split(" "); // separamos las dos palabras
                    diccionario[ID_ES][nPalabras] = subcadenas[0];
                    diccionario[ID_EN][nPalabras] = subcadenas[1];
                    nPalabras++;
                }
                linea = in.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

    }

    static void escribePalabrasFichero() {
        BufferedWriter out = null;
        String cad;
        try {
            out = new BufferedWriter(new FileWriter(ficheroDiccionario));
            for (int i = 0; i < nPalabras; i++) {
                cad = diccionario[ID_ES][i] + " " + diccionario[ID_EN][i];
                out.write(cad);
                out.newLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    /**
     * El programa main muestra un menú al usuario y actúa en consecuencia
     *
     * @param args
     */
    public static void main(String[] args) {

        //////////////////////////////PROGRAMA
        // Inicializamos
        diccionario = new String[N_IDIOMAS][N_PALABRAS_MAX];
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        leePalabrasFichero();

        do {
            System.out.println("============================================");
            System.out.println(" DICCIONARIO");
            System.out.println("============================================");
            System.out.println("1.- Introducir una nueva palabra");
            System.out.println("2.- Practicar palabra en español");
            System.out.println("3.- Practicar palabra en inglés");
            System.out.println("4.- Mostrar todas las palabras");
            System.out.println("5.- Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case MENU_NUEVA: //////////////////////////////////////////////////////////
                    if (nPalabras < N_PALABRAS_MAX) {
                        System.out.print("     Introduce la palabra en español: ");
                        diccionario[ID_ES][nPalabras] = sc.next();
                        System.out.print("     Introduce la palabra en inglés: ");
                        diccionario[ID_EN][nPalabras] = sc.next();
                        System.out.println("     Palabra introducida correctamente");
                        nPalabras++;
                    } else {
                        System.out.println("     Has alcanzado el número máximo de palabras");
                    }
                    break;
                case MENU_PRACTICA_ES://////////////////////////////////////////////////////////
                    numero = rand.nextInt();
                    numero = Math.abs(numero);
                    numero = numero % nPalabras;
                    System.out.println("     Palabra en español: " + diccionario[ID_ES][numero]);
                    System.out.print("     Introduce su equivalente en inglés: ");
                    palabra = sc.next();
                    if (diccionario[ID_EN][numero].equals(palabra)) {
                        System.out.println("     Muy bien, has acertado la palabra");
                    } else {
                        System.out.println("     La palabra correcta es: " + diccionario[ID_EN][numero]);
                    }
                    ;
                    break;
                case MENU_PRACTICA_EN://////////////////////////////////////////////////////////
                    numero = rand.nextInt();
                    numero = Math.abs(numero);
                    numero = numero % nPalabras;
                    System.out.println("     Palabra en inglés: " + diccionario[ID_EN][numero]);
                    System.out.print("     Introduce su equivalente en español: ");
                    palabra = sc.next();
                    if (diccionario[ID_ES][numero].equals(palabra)) {
                        System.out.println("     Muy bien, has acertado la palabra");
                    } else {
                        System.out.println("     La palabra correcta es: " + diccionario[ID_ES][numero]);
                    }
                    ;
                    break;
                case MENU_TODAS://////////////////////////////////////////////////////////
                    System.out.println("============================================");
                    System.out.format("%20s - %20s\n", "ESPAÑOL", "INGLÉS");
                    System.out.println("============================================");
                    for (int i = 0; i < nPalabras; i++) {
                        System.out.format("%20s - %20s\n", diccionario[ID_ES][i], diccionario[ID_EN][i]);
                    }
                    break;
                case MENU_SALIR://////////////////////////////////////////////////////////
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    break;
            }

        } while (opcion != MENU_SALIR);
        
        escribePalabrasFichero();
    }
}
