import java.time.LocalTime;
import java.util.Scanner;

public class Viaje {

    // Enum para los tipos de viaje
    public enum Tipo {
        AVE, AVLO, CERCANIAS
    }

    // Atributos de la clase Viaje
    private String codigo;
    private Tipo tipo;
    private String fecha;
    private String origen;
    private String destino;
    private double importeBase;

    // Constructor por defecto
    public Viaje() {}

    public Viaje(String codigo, Tipo tipo, String fecha, String origen, String destino, double importeBase) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.fecha = fecha;
        this.origen = origen;
        this.destino = destino;
        this.importeBase = importeBase;
    }

    // Método para dar de alta un viaje leyendo los datos del teclado
    public void alta() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el código del viaje: ");
        this.codigo = sc.nextLine();

        System.out.print("Introduce el tipo de viaje (AVE, AVLO, CERCANIAS): ");
        String tipoStr = sc.nextLine().toUpperCase();
        this.tipo = Tipo.valueOf(tipoStr);

        System.out.print("Introduce la fecha del viaje (formato DD/MM/AAAA): ");
        this.fecha = sc.nextLine();

        System.out.print("Introduce la localidad de origen: ");
        this.origen = sc.nextLine();

        System.out.print("Introduce la localidad de destino: ");
        this.destino = sc.nextLine();

        System.out.print("Introduce el importe base del viaje: ");
        this.importeBase = sc.nextDouble();
    }

    // Getters y Setters para los atributos
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getImporteBase() {
        return importeBase;
    }

    public void setImporteBase(double importeBase) {
        this.importeBase = importeBase;
    }

    // Método para mostrar la información del viaje
    @Override
    public String toString() {
        return "Viaje{" +
                "codigo='" + codigo + '\'' +
                ", tipo=" + tipo +
                ", fecha='" + fecha + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", importeBase=" + importeBase +
                '}';
    }

    public static void main(String[] args) {
        Viaje viaje = new Viaje();
        viaje.alta();
        System.out.println(viaje);
    }
}
