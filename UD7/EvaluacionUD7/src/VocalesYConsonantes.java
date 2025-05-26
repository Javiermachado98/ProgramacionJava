import java.io.*;  // Importamos las clases para trabajar con archivos

public class VocalesYConsonantes {

    public static void main(String[] args) throws IOException {

        // Declaramos dos BufferedWriter para escribir en dos archivos distintos
        BufferedWriter streamConsonantes = null;
        BufferedWriter streamVocales = null;

        try {
            // Creamos BufferedWriter para el fichero de consonantes
            streamConsonantes = new BufferedWriter(
                    new FileWriter("src" + File.separator + "files" + File.separator + "Consonantes.txt"));

            // Creamos BufferedWriter para el fichero de vocales
            streamVocales = new BufferedWriter(
                    new FileWriter("src" + File.separator + "files" + File.separator + "vocales.txt"));

            // Recorremos el abecedario de la 'a' a la 'z'
            for (char letra = 'a'; letra <= 'z'; letra++) {
                // Comprobamos si la letra es una vocal
                if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                    // Si es vocal, escribimos en el fichero de vocales
                    streamVocales.write(letra);
                    streamVocales.newLine();  // Escribimos un salto de línea para que cada vocal esté en una línea diferente
                } else {
                    // Si no es vocal (y no contamos la ñ), escribimos en el fichero de consonantes
                    streamConsonantes.write(letra);
                    streamConsonantes.newLine();  // Salto de línea para separar letras
                }
            }

        } catch (Exception e) {
            // Si ocurre algún error, lo mostramos por pantalla
            System.out.println("Error: " + e.getMessage());

        } finally {
            // Cerramos ambos BufferedWriter para liberar recursos y guardar los cambios
            if (streamConsonantes != null) {
                streamConsonantes.close();
            }
            if (streamVocales != null) {
                streamVocales.close();
            }
        }
    }
}
