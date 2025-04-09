import java.util.Scanner;

public class Pasajero {
    private String Nombre;
    private String Apellidos;
    private tipoDocumento documento;

    public Pasajero(){

    }

    public Pasajero(String nombre, String apellidos, tipoDocumento documento) {
        Nombre = nombre;
        Apellidos = apellidos;
        this.documento = documento;
    }

    public String getNombre() {
        return Nombre;
    }
    public String getApellidos() {
        return Apellidos;
    }
    public tipoDocumento getDocumento() {
        return documento;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }
    public void setDocumento(tipoDocumento documento) {
        this.documento = documento;
    }

    public void alta (){

        Scanner sc= new Scanner(System.in);
        System.out.println("Ingresa el Nombre: ");
        this.Nombre = sc.next();
        System.out.println("Ingresa el apellidos: ");
        this.Apellidos = sc.next();
        System.out.println("Ingresa el tipo de maleta: ");
        this.documento = tipoDocumento.valueOf(sc.next().toUpperCase());

    }

}