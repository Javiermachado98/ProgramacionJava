package UD4.B_Supermercados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Locale;

public class Producto {

    //Declaro las variables de mi producto

    private String nombre;
    private String marca;
    private String descripcion;
    private double precio;
    private double peso;
    private String numSerie;
    private TipoProducto tipo;
    private static final double iva = 0.21;

    public int nDiasParaCaducar(){

        //Se crea el DateTimeFormatter para realizar las conversiones
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Calculo dias desde el primero de enero
        LocalDate primeroEnero = LocalDate.parse("01/12/2022", dtf);// convertimos el Localdate en string
        LocalDate hoy = LocalDate.now(); // se asigna una variable para el dia de hoy
        long diasParaCaducar = java.time.temporal.ChronoUnit.DAYS.between (primeroEnero, hoy); //se calcula la diferencia entre dias
        return ((int) diasParaCaducar);

    }

    public boolean caducado() {
        return nDiasParaCaducar() > 0;
    }

    //Constructor

    public Producto(){
    }

    public Producto(String nombre, String marca, String descripcion, double precio, double peso, String numSerie, TipoProducto tipo) {
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
        this.peso = peso;
        this.numSerie = numSerie;
        this.tipo = tipo;
    }
    //Getters and setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }


    public double iva(){
        double valorIva;
        valorIva = this.precio * (1+iva);
        return valorIva;
    }

    public void alta(){

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.println("introduce el nombre del producto: ");
        this.nombre = sc.next();

        System.out.println("introduce la marca del producto: ");
        this.marca = sc.next();

        System.out.println("introduce la descripcion del producto: ");
        this.descripcion = sc.next();

        System.out.println("introduce el precio del producto: ");
        this.precio = sc.nextDouble();

        System.out.println("introduce el peso del producto: ");
        this.peso = sc.nextDouble();

        System.out.println("introduce el numero de serie del producto: ");
        this.numSerie = sc.next();

        System.out.println("introduce el tipo del producto: (FRUTA, VERDURA, CONGELADO, HOGAR," +
                "BEBIDAS, REPOSTERIA)");
        for (TipoProducto tp : TipoProducto.values()) {
            System.out.println("- " + tp);
        }
        this.tipo = TipoProducto.valueOf(sc.next());

    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", peso=" + peso +
                ", numSerie='" + numSerie + '\'' +
                ", tipo=" + tipo +
                ", iva=" + iva() +
                '}';
    }
}
