import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class B_Bingo {
    public static void main(String[] args) {

        final int s = 1;
        final int y = 2;
        int reiniciar = 0;
        int cantidad = 10, aciertos = 0;
        int numerosBingo = 99;
        int numeroUsuario;
        boolean repetido = false;
        int[] myBingo = new int[cantidad];
        int[] bingo = new int[numerosBingo];
        Scanner sc = new Scanner(System.in);
        Random myrandom = new Random();
        boolean cantoBingo = false;

        for (int contadorBingo = 0; contadorBingo < cantidad; contadorBingo++) {
            System.out.println("Ingrese el numero para su carton: ");
            numeroUsuario = sc.nextInt();

            if (numeroUsuario >= 1 && numeroUsuario <= 100) {

                for (int contadorConfirmador = 0; contadorConfirmador < cantidad; contadorConfirmador++) {
                    if (myBingo[contadorConfirmador] == numeroUsuario) { // la posicion de mi bingo es igual al numero del teclado
                        System.out.println("El numero esta repetido: " + numeroUsuario);
                        repetido = true; // mi bandera,pasa a ser true y si siempre esta en true, no avanza
                        contadorBingo--; // le resto iteraciones a mi lista, para ue siempre se llene
                    }
                }
                if (!repetido) {
                    myBingo[contadorBingo] = numeroUsuario; // Aqui le digo, que si la bandera es falsa agrega el valor
                } else {
                    repetido = false; // si no, agrega el numero normal y avanza con el ciclo
                }
            } else {
                System.out.println("Numero fuera de rango");
                contadorBingo--;
            }
        }
        System.out.println(Arrays.toString(myBingo));

        for (int contadorRandom = 0; contadorRandom < numerosBingo; contadorRandom++) {

            boolean repetidoBingo = false;
            int numeroRandom = myrandom.nextInt(1, 100);
            while (repetidoBingo == false) {
                for (int revisionRandom = 0; revisionRandom < numerosBingo; revisionRandom++) {
                    if (repetidoBingo == false){
                        if (bingo[revisionRandom] == numeroRandom) {
                            repetidoBingo = true;

                        } else {
                            repetidoBingo = false;
                        }
                    }
                }
                if (!repetidoBingo) {
                    bingo[contadorRandom] = numeroRandom;
                    repetidoBingo = true;
                }
                else {
                    repetidoBingo = false; // si no es false y no guarda nada, pero queda en cero 0
                    numeroRandom = myrandom.nextInt(1, 100);
                }
            }
            for (int contadorFinal = 0; contadorFinal < cantidad; contadorFinal++){
                if (bingo[contadorRandom] == myBingo[contadorFinal]){
                    System.out.println("Este numero si esta: " + myBingo[contadorFinal] + " cantidad de aciertos: " + aciertos);
                    aciertos++;
                    System.out.println(Arrays.toString(bingo));

                    if (aciertos == 10){
                        System.out.println("BINGOOOOOO!!!");
                        cantoBingo = true;
                    }
                }
            }
            if (cantoBingo){
                break;
            }
        }

        Arrays.fill(myBingo, 0);
        Arrays.fill(bingo, 0);
        System.out.println(Arrays.toString(myBingo));
        System.out.println(Arrays.toString(bingo));
    }
}
