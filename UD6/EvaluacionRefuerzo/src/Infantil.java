import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Infantil extends Paciente {
    private String nombrePadre;
    private String nombreMadre;
    private String telefonoContacto;

    private static final DateTimeFormatter DT_FECHA_NACI = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Infantil(){
        super();
    }
    public Infantil(String nombre, String primerApellido, String segundoApellido,
                    String fechaNacimientoStr, String codigoAr, String nombrePadre,
                    String nombreMadre, String telefonoContacto) {
        super(nombre, primerApellido, segundoApellido, fechaNacimientoStr, codigoAr);
        this.nombrePadre = nombrePadre;
        this.nombreMadre = nombreMadre;
        this.telefonoContacto = telefonoContacto;
    }

    public void alta(){
        super.altaPaciente();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre del padre: ");
        this.nombrePadre = sc.nextLine();

        System.out.println("Nombre de la madre: ");
        this.nombreMadre = sc.nextLine();

        System.out.println("Telefono de contacto: ");
        this.telefonoContacto = sc.nextLine();
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    @Override
    public String toString() {
        // Incluimos la parte de Paciente con super.toString(), y luego datos de Infantil
        String base = super.toString();
        return base +
                " [Infantil: padre='" + nombrePadre + '\'' +
                ", madre='" + nombreMadre + '\'' +
                ", teléfono='" + telefonoContacto + "']";
    }
}
