package Basicos;

public class OrdenarNumeros {
    public static int[] mayorMenor(int num[]) {
        int aux;
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] < num[j]) {
                    aux = num[i];
                    num[i] = num[j];
                    num[j] = aux;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int num[] = {50, 20, 45, 82, 25, 63};
        int num2[];
        int l = num.length;
        System.out.print("Valor del array : ");
        for (int i = 0; i < l; i++) {
            System.out.print(" " + num[i]);
        }
        System.out.println("\n");
        num2 = mayorMenor(num);
        System.out.print("Ordenado ascendentemente : ");
        for (int i = 0; i < l; i++) {
            System.out.print(" " + num2[i]);
        }

    }
}