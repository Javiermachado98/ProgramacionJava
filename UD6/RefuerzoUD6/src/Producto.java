import java.util.Scanner;
import java.util.Locale;
import java.util.ArrayList;

public class Producto {
    private String nombre;
    private String marca;
    private String descripcion;
    private int codigo;
    private double precio;


    private ArrayList<Producto> arrayListProducto; // arreglo para sumar los coches


    public Producto() {

    }

    public Producto(String nombre, String marca, String descripcion, int codigo, double precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.precio = precio;
    }

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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // funciones para agregar los productos a mi arreglo


    public void alta() {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.print("Ingresa el nombre del producto: ");
        this.nombre = sc.next();
        System.out.print("Ingresa la marca del producto: ");
        this.marca = sc.next();
        System.out.print("ingresa la descripcion del producto: ");
        this.descripcion = sc.next();
        System.out.print("Ingresa el codigo: ");
        this.codigo = sc.nextInt();
        System.out.print("Ingresa el precio: ");
        this.precio = sc.nextDouble();

    }

    @Override
    public String toString() {
        return "producto{" +
                "nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", codigo=" + codigo +
                ", precio=" + precio +
                '}';
    }
}