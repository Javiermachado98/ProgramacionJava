package B_Supermercado;
import java.util.Locale;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Productos {
    private String nombre;
    private String marca;
    private String descripcion;
    private double precio;
    private double precioFinal;
    private double peso;
    private int numSerie;
    private tipoProducto tipo;
    private LocalDate fechaCaducidad;
    private double iva;
    private Envases envase;

/*
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate hoy = LocalDate.now();
    long diasDeEsteAnno = java.time.temporal.ChronoUnit.DAYS.between (fechaCaducidad, hoy);*/

     // (no lo podría hacer con strings
//        System.out.println("Días desde uno de Enero: " + diasDeEsteAnno);
//
//        // Hago la conversión de LocalDate en String
//        System.out.println("Si mostrase LocalDate tal cual (aplica ya un formato): " + hoy);
//        System.out.println("Si lo convierto a mi formato" + dtf.format(hoy));

    public Productos(){}

    public Productos(String nombre, String marca, String descripcion,
                     double precioFinal, double peso, int numSerie,
                     tipoProducto tipo, LocalDate fechaCaducidad) {
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precioFinal = precioFinal;
        this.peso = peso;
        this.numSerie = numSerie;
        this.tipo = tipo;
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getNombre() {
        return nombre;
    }
    public String getMarca() {
        return marca;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public double getPrecio() {
        return precio;
    }
    public double getPrecionFinal () { return precioFinal;}
    public double getPeso() {
        return peso;
    }
    public int getNumSerie() {
        return numSerie;
    }
    public tipoProducto getTipo() {
        return tipo;
    }
    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setPrecioFinal(double precioFinal) {this.precioFinal = precioFinal;}
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }
    public void setTipo(tipoProducto tipo) {
        this.tipo = tipo;
    }
    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Envases getEnvase() {
        return envase;
    }

    public void setEnvase(Envases envase) {
        this.envase = envase;
    }

    public void crearProducto (){

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.println("===============");
        System.out.println("Ingrese el nombre del producto: ");
        this.nombre = sc.next();
        System.out.println("Ingrese la marca del producto: ");
        this.marca = sc.next();
        System.out.println("Ingrese la descripcion del producto: ");
        this.descripcion = sc.next();
        System.out.println("Ingrese el precio del producto: ");
        this.precio = sc.nextDouble();
        System.out.println("Ingrese el peso del producto: ");
        this.peso = sc.nextDouble();
        System.out.println("Ingrese el numero de serie del producto: ");
        this.numSerie = sc.nextInt();
        System.out.println("Ingrese el tipo de producto: ");
        this.tipo = tipoProducto.valueOf(sc.next().toUpperCase());

        iva = precio * 0.21;
        precioFinal = precio + iva;



    }

    @Override
    public String toString() {
        return "Productos{" +
                "nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioFinal=" + precioFinal +
                ", peso=" + peso +
                ", numSerie=" + numSerie +
                ", tipo=" + tipo +
                ", fechaCaducidad=" + fechaCaducidad +
                ", iva=" + iva +
                ", envase=" + envase +
                ", precio=" + precio +
                '}';
    }
}
