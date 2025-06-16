package EjerciciosUD2;
import java.util.Scanner;
import java.util.Locale;

public class H_CalculinMejorado {
    public static void main(String[] args) {
        double numeroOperable1, numeroOperable2, resultado;
        int opcion;
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.println("Bienvenido al programa “Calculete”.\n" +
                "        ¡!!!!!!!Soy un crack haciendo números!!!!!!!!\n");

        do {
            System.out.println("Ingrese el numero #1 para operar: ");
            numeroOperable1 = sc.nextDouble();
            System.out.println("Ingrese el numero #2 para operar: ");
            numeroOperable2 = sc.nextDouble();
            System.out.println("Introduce el número de la opción que responde a la operación que\n" +
                    "quieres realizar:\n" +
                    "1.- Suma\n" +
                    "2.- Resta\n" +
                    "3.- Multiplicación\n" +
                    "4.- División\n" +
                    "5.- Módulo\n" +
                    "6.- Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Tu selección es 1 que es: Suma ");
                    resultado = (numeroOperable1 + numeroOperable2);
                    System.out.println("El resultado de la operación realizada es: " + resultado + " Gracias por confiar en calculete, nos veremos muy pronto con\n" +
                            "funciones avanzadas");
                }
                case 2 -> {
                    System.out.println("Tu selección es 2 que es: Resta ");
                    resultado = (numeroOperable1 - numeroOperable2);
                    System.out.println("El resultado de la operación realizada es: " + resultado + " Gracias por confiar en calculete, nos veremos muy pronto con\n" +
                            "funciones avanzadas");
                }
                case 3 -> {
                    System.out.println("Tu selección es 3 que es: Multiplicacion ");
                    resultado = (numeroOperable1 * numeroOperable2);
                    System.out.println("El resultado de la operación realizada es: " + resultado + " Gracias por confiar en calculete, nos veremos muy pronto con\n" +
                            "funciones avanzadas");
                }
                case 4 -> {
                    System.out.println("Tu selección es 4 que es: Division ");
                    resultado = (numeroOperable1 / numeroOperable2);
                    System.out.println("El resultado de la operación realizada es: " + resultado + " Gracias por confiar en calculete, nos veremos muy pronto con\n" +
                            "funciones avanzadas");
                }
                case 5 -> {
                    System.out.println("Tu selección es 5 que es: Modulo ");
                    resultado = (numeroOperable1 % numeroOperable2);
                    System.out.println("El resultado de la operación realizada es: " + resultado + " Gracias por confiar en calculete, nos veremos muy pronto con\n" +
                            "funciones avanzadas");
                }
                case 6 -> System.out.println("Has elegido salir del programa. ¡Hasta pronto!");
                default -> System.out.println("Opción no válida. Por favor, elige una opción entre 1 y 6.");
            }

        } while (opcion != 6);
    }
}
