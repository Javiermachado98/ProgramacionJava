package UD4.B_Supermercados;

public class principal {
    public static void main(String[] args) {

        Envase envase1 = new Envase();
        envase1.alta();
        System.out.println(envase1);

        Producto producto1 = new Producto();
        producto1.alta();
        System.out.println(producto1);
    }
}
