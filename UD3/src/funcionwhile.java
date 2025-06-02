import java.util.Arrays;
import java.util.Random;

public class funcionwhile {
    public static void main(String[] args) {

        Random myrandom = new Random();
        int numerosBingo = 99;
        int[] bingo;
        bingo = new int[numerosBingo];

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

        }
        System.out.println(Arrays.toString(bingo));

    }

}
