package UD4.B_Supermercados;

import java.util.Locale;
import java.util.Scanner;

public class Envase {

    private String codigo;
    private double precio;
    private TipoEnvase tipo;

    public Envase(String codigo, double precio, TipoEnvase tipo) {
        this.codigo = codigo;
        this.precio = precio;
        this.tipo = tipo;
    }

    public Envase() {

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoEnvase getTipo() {
        return tipo;
    }

    public void setTipo(TipoEnvase tipo) {
        this.tipo = tipo;
    }

    public void alta(){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.println("introduce el codigo del envase: ");
        this.codigo = sc.next();

        System.out.println("introduce el precio del envase: ");
        this.precio = sc.nextDouble();

        System.out.println("introduce el tipo de envase: (BOLSA, BOTE O CAJA) ");
        for (TipoEnvase te : TipoEnvase.values()) {
            System.out.println("- " + te);
        }
        this.tipo = TipoEnvase.valueOf(sc.next());

    }


    @Override
    public String toString() {
        return "envase{" +
                "codigo='" + codigo + '\'' +
                ", precio=" + precio +
                ", tipo=" + tipo +
                '}';
    }


}

