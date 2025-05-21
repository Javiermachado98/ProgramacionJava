package B_Supermercado;

import java.util.Locale;
import java.util.Scanner;

public class Envases {
    private String codigo;
    private double precio;
    private tipoEnvase envase;

    public Envases(){} // constructor que inicializa los objetos

    // Constructor con las variables
    public Envases(String codigo, double precio, tipoEnvase envase) {
        this.codigo = codigo;
        this.precio = precio;
        this.envase = envase;
    }

    // se crean los setters
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // se crean los getters

    public String getCodigo() {
        return codigo;
    }
    public double getPrecio() {
        return precio;
    }



    public void crearEnvase(){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.println("===============");
        System.out.println("Ingrese el codigo: ");
        this.codigo = sc.next();
        System.out.println("Ingrese el precio: ");
        this.precio = sc.nextDouble();
        System.out.println("ingrese el tipo de envase: ");
        this.envase = tipoEnvase.valueOf(sc.next().toUpperCase());

    }

    @Override
    public String toString() {
        return "Envases{" +
                "codigo='" + codigo + '\'' +
                ", precio=" + precio +
                ", bolsa=" + envase +
                '}';
    }
}
