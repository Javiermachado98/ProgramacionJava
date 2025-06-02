// Medida.java

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Clase Medida:
 *   - Representa una medida de una constante vital para un paciente.
 *   - Atributos:
 *       * valor: valor real de la medida.
 *       * tipo: uno de los valores del enum TipoMedida.
 *       * fecha: LocalDate correspondiente a la fecha de la toma.
 *       * hora: LocalTime correspondiente a la hora de la toma.
 *       * anotacion: texto libre para información adicional.
 *       * codigo: String que se genera a partir de los 9 dígitos del AR + HHmm + ddMMyy.
 *
 *   - Incluye un método estático alta(Paciente) que:
 *       1) lee los datos por consola,
 *       2) genera el código,
 *       3) crea la instancia Medida,
 *       4) la añade a la lista interna del paciente (usando getMedidas()).
 */
public class Medida {

    private double valor;
    private TipoMedida tipo;
    private LocalDate fecha;
    private LocalTime hora;
    private String anotacion;
    private String codigo; // Se genera a partir de AR + hora + fecha

    // Formateadores para entrada y para generar el código:
    private static final DateTimeFormatter DT_ENTRADA =
            DateTimeFormatter.ofPattern("dd/MM/yyyy"); // p. e. "14/06/2022"
    private static final DateTimeFormatter TM_ENTRADA =
            DateTimeFormatter.ofPattern("HH:mm");      // p. e. "10:00"
    private static final DateTimeFormatter DT_CODIGO =
            DateTimeFormatter.ofPattern("ddMMyy");     // p. e. "140622"
    private static final DateTimeFormatter TM_CODIGO =
            DateTimeFormatter.ofPattern("HHmm");       // p. e. "1000"

    /**
     * Constructor “privado” que recibe todos los atributos.
     * Se usa solamente desde el propio método alta() para instanciar la Medida.
     */
    private Medida(double valor, TipoMedida tipo, LocalDate fecha,
                   LocalTime hora, String anotacion, String codigo) {
        this.valor = valor;
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
        this.anotacion = anotacion;
        this.codigo = codigo;
    }

    /* =======================
       GETTERS
       ======================= */

    public double getValor() {
        return valor;
    }

    public TipoMedida getTipo() {
        return tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getAnotacion() {
        return anotacion;
    }

    public String getCodigo() {
        return codigo;
    }

    /**
     * toString(): muestra los datos de la medida: valor, tipo, fecha (formato "dd/MM/yyyy"),
     * hora (formato "HH:mm"), anotación y código generado.
     */
    @Override
    public String toString() {
        String fechaStr = DT_ENTRADA.format(fecha);
        String horaStr = TM_ENTRADA.format(hora);
        return "Medida{" +
                "valor=" + valor +
                ", tipo=" + tipo +
                ", fecha=" + fechaStr +
                ", hora=" + horaStr +
                ", anotacion='" + anotacion + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }

    /**
     * Método estático alta(Paciente paciente):
     *   - Pide por consola todos los datos de una medida (valor, tipo, fecha, hora, anotación).
     *   - Genera el código concatenando los 9 dígitos intermedios del AR del paciente +
     *     la hora en "HHmm" + la fecha en "ddMMyy".
     *   - Crea la instancia de Medida y la añade a la lista interna del paciente
     *     (usando paciente.getMedidas().add(...)).
     *
     * @param paciente Paciente al que se le va a asociar la nueva medida.
     */
    public static void alta(Paciente paciente) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Alta de medida para el paciente: " + paciente.nombre + " ===");

        // 1) Leemos el valor (número real)
        System.out.print("Valor de la medida (número real): ");
        double valorIngresado = Double.parseDouble(sc.nextLine());

        // 2) Leemos el tipo y lo convertimos a Enum (esperamos que el usuario escriba uno de los valores)
        System.out.print("Tipo de medida (SATURACION / TEMPERATURA / PULSO): ");
        String tipoStr = sc.nextLine().toUpperCase();
        TipoMedida tipoIngresado = TipoMedida.valueOf(tipoStr);

        // 3) Leemos fecha en formato "dd/MM/yyyy"
        System.out.print("Fecha de la medida (dd/MM/yyyy): ");
        String fechaStr = sc.nextLine();
        LocalDate fechaIngresada = LocalDate.parse(fechaStr, DT_ENTRADA);

        // 4) Leemos hora en formato "HH:mm"
        System.out.print("Hora de la medida (HH:mm): ");
        String horaStr = sc.nextLine();
        LocalTime horaIngresada = LocalTime.parse(horaStr, TM_ENTRADA);

        // 5) Leemos anotación libre
        System.out.print("Anotación (texto libre): ");
        String anotacionIngresada = sc.nextLine();

        // 6) Generamos el código:
        //    - Extraemos los 9 dígitos intermedios del AR (posiciones 2 a 10 de "AR123456789P")
        String codigoARCompleto = paciente.getCodigoAr();
        // Si el paciente no tiene código AR válido, pondremos “000000000” como comodín
        String nueveDigitos;
        if (codigoARCompleto != null && codigoARCompleto.length() >= 11) {
            nueveDigitos = codigoARCompleto.substring(2, 11); // ej. "123456789"
        } else {
            nueveDigitos = "000000000";
        }

        // Convertimos la hora a "HHmm" (para el código)
        String parteHoraCodigo = TM_CODIGO.format(horaIngresada); // ej. "1000"

        // Convertimos la fecha a "ddMMyy" (para el código)
        String parteFechaCodigo = DT_CODIGO.format(fechaIngresada); // ej. "140622"

        // Concatenamos: [9 dígitos] + [HHmm] + [ddMMyy]
        String codigoMedida = nueveDigitos + parteHoraCodigo + parteFechaCodigo;
        // Por ejemplo: "123456789" + "1000" + "140622" = "1234567891000140622"

        // 7) Creamos la instancia de Medida con todos los valores
        Medida nueva = new Medida(
                valorIngresado,
                tipoIngresado,
                fechaIngresada,
                horaIngresada,
                anotacionIngresada,
                codigoMedida
        );

        // 8) Añadimos esta medida a la lista interna del paciente:
        paciente.getMedidas().add(nueva);

        // Mostramos un mensaje de confirmación
        System.out.println(">>> Medida dada de alta correctamente. Código generado: " + codigoMedida);
    }
}
