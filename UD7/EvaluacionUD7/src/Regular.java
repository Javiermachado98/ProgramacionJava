import java.util.Scanner;

public class Regular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int aciertos = 0;  // Contador de palabras que cumplen el patrón
        int fallos = 0;    // Contador de palabras que no cumplen el patrón

        // Patrón regex:
        // ^           inicio de la cadena
        // \\d{2}      dos dígitos
        // [A-Z]{5}    cinco letras mayúsculas
        // f?          la letra 'f' opcional (0 o 1 vez)
        // $           fin de la cadena
        String patron = "^\\d{2}[A-Z]{5}f?$";

        // Mientras no haya 5 aciertos, seguimos pidiendo palabras
        while (aciertos < 5) {
            System.out.print("Introduce una palabra: ");
            String palabra = sc.next();

            if (palabra.matches(patron)) {
                System.out.println("Muy bien");
                aciertos++;
            } else {
                System.out.println("Inténtalo de nuevo");
                fallos++;
            }
        }

        // Cuando terminamos, mostramos resultado
        System.out.println("Buen trabajo");
        System.out.println("Has fallado " + fallos + " veces");
    }
}
