package Basicos;

public class TablasMultiplicar {
    public static void main(String[] args) {
        int resultado;
        for (int i = 1; i<= 10; i++) {
            System.out.println("");
            System.out.println("Tabla del " + i);
            for (int j = 1; j<= 10; j++) {
                resultado = i * j;
                System.out.println(i + " * " + j + " = " + resultado);
            }
        }
    }
}
