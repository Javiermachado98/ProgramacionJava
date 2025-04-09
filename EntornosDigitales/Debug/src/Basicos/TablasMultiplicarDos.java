package Basicos;

public class TablasMultiplicarDos {
    public static void main(String[] args) {
        String s =
                "";
        for (int i = 1; i < 10; i++) {
            s = s + i + " ";
            for (int j = 1; j < 10; j++) {
                s = s + " " + i * j;
            }
            s = s + "\n";
            System.out.println(s);
        }
    }
}
