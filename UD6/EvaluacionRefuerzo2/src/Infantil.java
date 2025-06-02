// Infantil.java

import java.util.Scanner;

/**
 * Subclase de Paciente pensada para niños menores de 10 años.
 * Además de los campos de Paciente, almacena:
 *   - nombrePadre
 *   - nombreMadre
 *   - telefonoContacto
 *
 * Sobrescribe el método alta() para que, tras pedir los datos generales
 * en Paciente.alta(), pida también el nombre de los padres y el teléfono.
 */
public class Infantil extends Paciente {

    private String nombrePadre;
    private String nombreMadre;
    private String telefonoContacto;

    /**
     * Constructor vacío: permite instanciar y luego llamar a alta().
     */
    public Infantil() {
        super(); // Llama al constructor vacío de Paciente (ya inicializa lista de medidas).
    }

    /**
     * Constructor “completo” (por si en algún momento quisieras instanciar
     * directamente con todos los valores, sin pasar por alta()).
     *
     * @param nombre             Nombre del niño.
     * @param primerApellido     Primer apellido del niño.
     * @param segundoApellido    Segundo apellido del niño.
     * @param fechaNacimientoStr Fecha de nacimiento en "dd/MM/yyyy".
     * @param codigoAr           Código AR (ej. "AR123456789P").
     * @param nombrePadre        Nombre completo del padre.
     * @param nombreMadre        Nombre completo de la madre.
     * @param telefonoContacto   Teléfono de contacto de los padres.
     */
    public Infantil(String nombre, String primerApellido, String segundoApellido,
                    String fechaNacimientoStr, String codigoAr,
                    String nombrePadre, String nombreMadre, String telefonoContacto) {
        super(nombre, primerApellido, segundoApellido, fechaNacimientoStr, codigoAr);
        this.nombrePadre = nombrePadre;
        this.nombreMadre = nombreMadre;
        this.telefonoContacto = telefonoContacto;
        // La lista de medidas ya la inicializa el constructor de Paciente
    }

    /**
     * Sobrescribe el método alta() de Paciente. Primero invoca super.alta()
     * para pedir los datos base (nombre, apellidos, fecha, código AR).
     * Luego pide nombrePadre, nombreMadre y telefonoContacto.
     */
    @Override
    public void alta() {
        // Llamamos a Paciente.alta() para pedir los datos generales
        super.alta();

        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del padre: ");
        this.nombrePadre = sc.nextLine();

        System.out.print("Nombre de la madre: ");
        this.nombreMadre = sc.nextLine();

        System.out.print("Teléfono de contacto: ");
        this.telefonoContacto = sc.nextLine();
    }

    // Getters para los campos específicos de Infantil

    public String getNombrePadre() {
        return nombrePadre;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    /**
     * toString(): concatena la parte de Paciente (super.toString()) con
     * la información adicional de Infantil (padres y teléfono).
     */
    @Override
    public String toString() {
        String base = super.toString();
        return base +
                " [Infantil: padre='" + nombrePadre + '\'' +
                ", madre='" + nombreMadre + '\'' +
                ", teléfono='" + telefonoContacto + "']";
    }
}
