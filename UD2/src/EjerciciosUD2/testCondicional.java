package EjerciciosUD2;

public class testCondicional {
    public static void main(String[] args) {
        int numero = 5;
        int otroNumero;


        if (numero >= 10) {
            if (numero > 10 && numero < 20){
                otroNumero = 1;
            } else {
                otroNumero = 2;
            }
        } else {
            otroNumero = 3;
        }
        System.out.println("Otro Numero: " + otroNumero);
    }
}
