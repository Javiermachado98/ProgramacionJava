package EjerciciosUD2_2;
import java.util.Random;
import java.util.Scanner;

public class A_Circulo {
    public static void main(String[] args) {

        circulo();

    }
    public static void circulo(){
        System.out.println("Ingrese el valor del radio del circulo: ");
        Scanner sc = new Scanner(System.in);
        double radio;
        radio = sc.nextDouble();
        double area = Math.PI * (radio * radio);
        System.out.println("El area del circulo es: " + area);
    }

    public static class D_Reggaeton {
        public static void main(String[] args) {
            reggaeton();
        }
        public static void reggaeton() {
            // Declaro variables

            int repeticiones, estribillo;
            String[] letras = {"Sigue","Baila","Suave","Despacito","Baby","Amor","Sabes"};
            Scanner sc = new Scanner(System.in);
            Random random = new Random(); // creo mi variable random

            //pido mis datos por consola y los almaceno

            System.out.println("Dime cuantas repeticiones tiene la cancion: ");
            repeticiones = sc.nextInt();
            System.out.println("Dime cuentas veces se repite el estribillo: ");
            estribillo = sc.nextInt();

            //Realizo mis ciclos para repetir la informacion

            if(repeticiones > 0 && repeticiones < 9) {
                if (estribillo > 0 && estribillo < 6) {
                    for (int j = 0; j < repeticiones; j++){
                        for (int k = 0; k < 6; k++){
                            int numeroRandom = random.nextInt(letras.length);
                            System.out.print(letras[numeroRandom] + " ");
                    }
                        for (int i = 0; i < estribillo; i++) {
                            System.out.print("vamos ");
                        }

                        System.out.println();
                    }
                }
            }else
            {
                System.out.println("Los datos de entrada no son validos");
            }
        }
    }
}
