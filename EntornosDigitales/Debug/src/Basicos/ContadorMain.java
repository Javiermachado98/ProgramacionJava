package Basicos;

public class ContadorMain {
    public static void main(String[] args) {
        Contador micontador = new Contador();
        micontador.contar();
        System.out.println("Hemos contado " + micontador.getResult());
    }
}
