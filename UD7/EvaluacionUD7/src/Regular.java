import java.util.Scanner;

public class Regular {
    public static void main(String[] args) {
        int intentos = 5;
        int contador = 0;
        String palabra = "";
        Scanner sc = new Scanner(System.in);
        for (int numero = 0; numero < intentos; numero++) {
            palabra = sc.next();
            if (palabra.matches("\\d\\d[A-Z]\\w\\w\\w\\w[f]?")) {
                System.out.println("Muy bien");
            } else {
                System.out.println("Inténtalo de nuevo");
                contador++;
            }
        }
        if (contador == 0){
            System.out.println("Buen Trabajo, no fallaste ninguna");
        }
        else {
            System.out.println("Fallaste: " + contador + " veces");
        }


    }
}