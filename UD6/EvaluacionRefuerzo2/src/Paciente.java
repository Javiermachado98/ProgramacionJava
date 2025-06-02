// Paciente.java

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase Paciente:
 * - Almacena nombre, dos apellidos, fecha de nacimiento y código AR (autonómico).
 * - Contiene internamente una lista de Medida para registrar todas las medidas de este paciente.
 * - Método alta(): lee los datos desde consola y los asigna a los atributos (tal como ya tenías).
 * - toString(): muestra información básica del paciente.
 */
public class Paciente {

    // Atributos base de un paciente
    protected String nombre;
    protected String primerApellido;
    protected String segundoApellido;
    protected LocalDate fechaNacimiento; // Se mantiene como LocalDate
    protected String codigoAr;           // Ejemplo: "AR123456789P"

    // Lista interna de medidas registradas para este paciente
    private List<Medida> medidas;

    // Para parsear/mostrar la fecha de nacimiento con el formato "dd/MM/yyyy"
    private static final DateTimeFormatter DT_FECHA_NAC =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Constructor vacío:
     *   - Permite crear un objeto Paciente sin pasar parámetros,
     *     para luego llamar a p.alta() y rellenar los campos.
     *   - Inicializamos la lista de medidas vacía.
     */
    public Paciente() {
        this.medidas = new ArrayList<>();
    }

    /**
     * Constructor “completo” (por si en algún momento quisieras instanciar un paciente
     * directamente con todos los datos de una vez). No se usa en el alta por consola,
     * pero queda aquí como referencia.
     *
     * @param nombre             Nombre del paciente.
     * @param primerApellido     Primer apellido del paciente.
     * @param segundoApellido    Segundo apellido del paciente.
     * @param fechaNacimientoStr Fecha de nacimiento en formato "dd/MM/yyyy".
     * @param codigoAr           Código autonómico (ej. "AR123456789P").
     */
    public Paciente(String nombre, String primerApellido, String segundoApellido,
                    String fechaNacimientoStr, String codigoAr) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        // Parseamos la fecha de nacimiento según el patrón "dd/MM/yyyy"
        this.fechaNacimiento = LocalDate.parse(fechaNacimientoStr, DT_FECHA_NAC);
        this.codigoAr = codigoAr;
        // Inicializamos la lista de medidas
        this.medidas = new ArrayList<>();
    }

    /**
     * Método alta(): pide por consola los datos de un paciente “no infantil”
     * (nombre, apellidos, fecha de nacimiento y código AR) y los asigna a los atributos.
     *
     * He respetado tu lógica original, pero:
     * - Uso nextLine() para leer cadenas completas (en lugar de next()),
     *   para evitar que se quede texto pendiente en el Scanner.
     * - Para la fecha, uso DateTimeFormatter.ofPattern("dd/MM/yyyy").
     *
     * Al terminar, el objeto Paciente (this) quedará con todos los campos rellenados
     * y la lista de medidas seguirá vacía hasta que se agreguen.
     */
    public void alta() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Alta de pacientes ===");

        System.out.print("Nombre: ");
        this.nombre = sc.nextLine();

        System.out.print("Primer Apellido: ");
        this.primerApellido = sc.nextLine();

        System.out.print("Segundo Apellido: ");
        this.segundoApellido = sc.nextLine();

        System.out.print("Ingrese la fecha de nacimiento (dd/MM/yyyy): ");
        // Leemos la línea completa y la parseamos con el formateador
        String fechaStr = sc.nextLine();
        this.fechaNacimiento = LocalDate.parse(fechaStr, DT_FECHA_NAC);

        System.out.print("Ingrese código autonómico AR (ej. AR123456789P): ");
        String tempCodigo = sc.nextLine();

        // Validamos el patrón "AR\d{9}[A-Z]", tal como tú indicabas
        String patron = "AR\\d{9}[A-Z]";
        if (tempCodigo.matches(patron)) {
            this.codigoAr = tempCodigo;
            System.out.println("El código AR coincide.");
        } else {
            System.out.println("El código AR no coincide. Se guardará vacío.");
            this.codigoAr = "";
        }
    }

    /**
     * Devuelve la lista de medidas que tiene este paciente.
     * Podrás usarla más adelante para añadir nuevas medidas o para filtrar.
     */
    public List<Medida> getMedidas() {
        return medidas;
    }

    /**
     * Devuelve la fecha de nacimiento (LocalDate).
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Devuelve el código autonómico AR.
     */
    public String getCodigoAr() {
        return codigoAr;
    }

    /**
     * toString(): muestra el contenido del paciente, incluyendo la fecha formateada
     * y el código AR. No incluye las medidas, pero sí el número de ellas.
     */
    @Override
    public String toString() {
        String fechaFormateada = (fechaNacimiento == null)
                ? "sin fecha"
                : DT_FECHA_NAC.format(fechaNacimiento);
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", fechaNacimiento=" + fechaFormateada +
                ", codigoAr='" + codigoAr + '\'' +
                ", númeroDeMedidas=" + medidas.size() +
                '}';
    }
}
