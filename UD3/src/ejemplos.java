import java.util.Arrays;
import java.util.Scanner;

public class ejemplos {
    public static void main(String[] args) {

        final int MENU_INGRESO = 1;
        final int MENU_MOSTRAR_NUMEROS = 2;
        final int MENU_APARICIONES = 3;
        final int MENU_MEDIA = 4;
        final int MENU_MAS_FRECUENTE = 5;
        final int MENU_MENOS_FRECUENTE = 6;
        final int MENU_CANTIDAD_DE_PARES_IMPARES = 7;
        final int MENU_TOTAL = 8;
        final int MENU_SALIDA = 9;
        int digito;

        final int cantidad = 9;
        int valor;
        int [] misNumeros;

        misNumeros = new int [cantidad];
        Scanner sc = new Scanner(System.in);


        do {

            System.out.println("ingrese la opcion: ");
            valor = sc.nextInt();

            switch (valor) {

                case MENU_INGRESO -> {

                    System.out.print("Ingresar el numero: ");
                    for (int i = 0; i < misNumeros.length; i++){
                        digito = sc.nextInt();
                        if (digito >= 0 && digito <= 9){

                        }
                    }


                }
                case MENU_MOSTRAR_NUMEROS -> {
                    System.out.println("Numeros no elegidos");
                }
                case MENU_APARICIONES -> {
                    System.out.println("Cantidad de apariciones");
                }
                case MENU_MEDIA -> {
                    System.out.println("Ver media de frecuentes");
                }
                case MENU_MAS_FRECUENTE -> {
                    System.out.println("Numero mas frecuentes");
                }
                case MENU_MENOS_FRECUENTE -> {
                    System.out.println("Numero menos frecuentes");
                }
                case MENU_CANTIDAD_DE_PARES_IMPARES-> {
                    System.out.println("Pares e impares");
                }
                case MENU_TOTAL -> {
                    System.out.println("cantidad total de apariciones");
                    System.out.println(Arrays.toString(misNumeros));
                }
                case MENU_SALIDA -> {
                    System.out.println("Salir del programa");
                }

            }

        }
        while (valor != 9);

    }
}
