import java.util.Scanner;
import java.util.Locale;

public class Equipaje {
    private double peso;
    private double longitud;
    private double altura;
    private double anchura;
    private double bodega;
    private tipoMaleta tipo;



    public Equipaje(){

    }

    public Equipaje(double peso, double longitud, double altura, double anchura, tipoMaleta tipo) {
        this.peso = peso;
        this.longitud = longitud;
        this.altura = altura;
        this.anchura = anchura;
        this.tipo = tipo;
    }

    public double getPeso() {
        return peso;
    }
    public double getLongitud() {
        return longitud;
    }
    public double getAltura() {
        return altura;
    }
    public double getAnchura() {
        return anchura;
    }
    public tipoMaleta getTipo() {
        return tipo;
    }

    public void setTipo(tipoMaleta tipo) {
        this.tipo = tipo;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public void setAnchura(double anchura) {
        this.anchura = anchura;
    }


    public void alta (){

        Scanner sc= new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.println("Ingresa el tipo de maleta: ");
        this.tipo = tipoMaleta.valueOf(sc.next().toUpperCase());
        System.out.print("Ingrese el peso de la maleta: ");
        this.peso = sc.nextDouble();
        System.out.print("Ingrese la longitud de la maleta: ");
        this.longitud = sc.nextDouble();
        System.out.print("Ingrese el altura de la maleta: ");
        this.altura = sc.nextDouble();
        System.out.print("Ingrese el anchura de la maleta: ");
        this.anchura = sc.nextDouble();
    }



    public boolean equipajeBodega (){
        bodega = longitud + anchura + altura;
        return bodega <= 158 && peso <= 23;
    }

    public boolean equipajeMano (){
        if (longitud <= 35 && anchura <= 25 && altura <= 55 && peso <= 10) {
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Equipaje{" +
                "tipo=" + tipo +
                ", bodega=" + bodega +
                ", anchura=" + anchura +
                ", altura=" + altura +
                ", longitud=" + longitud +
                ", peso=" + peso +
                '}';
    }
}