import java.io.*;
import java.util.Scanner;

public class EJ01ConvierteVocales {

    public static void main(String[] args) {
        String vocal = null;

        // Obtener la vocal a sustituir: por parámetro o teclado
        if (args.length > 0) {
            vocal = args[0].toLowerCase();
            if (!esVocalValida(vocal)) {
                System.out.println("El parámetro no es una vocal válida.");
                return;
            }
        } else {
            Scanner sc = new Scanner(System.in);
            do {
                System.out.print("Introduce la vocal para sustituir: ");
                vocal = sc.nextLine().toLowerCase();
            } while (!esVocalValida(vocal));
        }

        String ficheroEntrada = "entrada.txt";
        String ficheroSalida = obtenerNombreSalida(ficheroEntrada, vocal);

        try (
                BufferedReader br = new BufferedReader(new FileReader(ficheroEntrada));
                BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroSalida));
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Procesar línea sustituyendo vocales
                String lineaModificada = sustituirVocales(linea, vocal.charAt(0));
                bw.write(lineaModificada);
                bw.newLine();
            }
            System.out.println("Fichero generado: " + ficheroSalida);

        } catch (IOException e) {
            System.out.println("Error leyendo o escribiendo ficheros: " + e.getMessage());
        }
    }

    // Comprueba si el string es una vocal válida (a,e,i,o,u)
    private static boolean esVocalValida(String vocal) {
        return vocal.length() == 1 && "aeiou".contains(vocal);
    }

    // Construye el nombre del fichero salida insertando _vocal antes de la extensión
    private static String obtenerNombreSalida(String entrada, String vocal) {
        int pos = entrada.lastIndexOf(".");
        if (pos == -1) {
            return entrada + "_" + vocal; // si no tiene extensión
        } else {
            return entrada.substring(0, pos) + "_" + vocal + entrada.substring(pos);
        }
    }

    // Reemplaza todas las vocales de la línea por la vocal indicada, respetando mayúsculas/minúsculas
    private static String sustituirVocales(String texto, char vocal) {
        StringBuilder sb = new StringBuilder();
        for (char c : texto.toCharArray()) {
            if (esVocal(c)) {
                // Mantener mayúscula si la original lo era
                if (Character.isUpperCase(c)) {
                    sb.append(Character.toUpperCase(vocal));
                } else {
                    sb.append(vocal);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Comprueba si un caracter es vocal (mayúscula o minúscula)
    private static boolean esVocal(char c) {
        char cLower = Character.toLowerCase(c);
        return cLower == 'a' || cLower == 'e' || cLower == 'i' || cLower == 'o' || cLower == 'u';
    }
}
