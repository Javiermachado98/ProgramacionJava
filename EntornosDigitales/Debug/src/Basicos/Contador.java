package Basicos;

public class Contador {
    private int result = 0;

    public int getResult() {
        return result;
    }

    public void contar() {
        for (int i = 0; i < 100; i++) {
            result = i + 1;
        }
    }
}