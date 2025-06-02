import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Medida {
    private double tomaValor;
    private tipoValor valor;
    private LocalDate fechaMedida;
    private LocalTime hora;
    private String anotacion;
    private String codigo;

    private static final DateTimeFormatter DT_MEDIDA_ENTRADA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TM_MEDIDA_ENTRADA = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter DT_CODIGO = DateTimeFormatter.ofPattern("ddMMYY");
    private static final DateTimeFormatter TM_CODIGO = DateTimeFormatter.ofPattern("HHmm");

    public Medida(double tomaValor, tipoValor valor, LocalDate fechaMedida, LocalTime hora, String anotacion, String codigo) {
        this.tomaValor = tomaValor;
        this.valor = valor;
        this.fechaMedida = fechaMedida;
        this.hora = hora;
        this.anotacion = anotacion;
        this.codigo = codigo;
    }

    public double getTomaValor() {
        return tomaValor;
    }

    public void setTomaValor(double tomaValor) {
        this.tomaValor = tomaValor;
    }

    public tipoValor getValor() {
        return valor;
    }

    public void setValor(tipoValor valor) {
        this.valor = valor;
    }

    public LocalDate getFechaMedida() {
        return fechaMedida;
    }

    public void setFechaMedida(LocalDate fechaMedida) {
        this.fechaMedida = fechaMedida;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getAnotacion() {
        return anotacion;
    }

    public void setAnotacion(String anotacion) {
        this.anotacion = anotacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public void alta(Paciente paciente){ // vamos a traer como parametro el objeto paciente
        Scanner sc = new Scanner(System.in);
        System.out.println("Valor de la medida: ");
        tomaValor = Double.parseDouble(sc.nextLine());

        System.out.println("Ingrese el tipo de medida (SATURACION || TEMPERATURA || PULSO: ");
        valor = tipoValor.valueOf(sc.next().toUpperCase());

        System.out.println("Fecha de la medicion (dd/MM/yyyy");
        String fechaEnString = sc.nextLine();
        fechaMedida = LocalDate.parse(fechaEnString, DT_MEDIDA_ENTRADA);

        System.out.println("Hora de la medida (HH:mm): ");
        String horaString = sc.nextLine();
        hora = LocalTime.parse(horaString, TM_MEDIDA_ENTRADA);

        System.out.println("Ingrese la anotacion, si tiene una: ");
        anotacion = sc.nextLine();

        //IMPORTANTE, aqui se toma el dato de los 9 digitos del objeto paciente
        // 1) Extraemos los 9 dígitos del código AR: paciente.getCodigoAR() es, por ejemplo, "AR123456789P".
        //    Los 9 dígitos están entre la pos. 2 (incluida) y la pos. 11 (excluida):

        String codigoARCompleto = paciente.getCodigoAr();
        String nueveDigitos = codigoARCompleto.substring(2, 11); //"123456789"

        // 2) Formateamos la hora para el código como "HHmm":
        String parteHoraCodigo = TM_CODIGO.format(hora); // ej. "1000"

        // 3) Formateamos la fecha para el código como "ddMMyy":
        String parteFechaCodigo = DT_CODIGO.format(fechaMedida); // ej. "140622"

        // 4) Concatenamos: [9 dígitos] + [HHmm] + [ddMMyy]
        String codigoMedida = nueveDigitos + parteHoraCodigo + parteFechaCodigo;
        // En el ejemplo: 123456789 + 1000 + 140622 = "1234567891000140622"

        Medida nuevaMedida = new Medida(
                tomaValor,
                valor,
                fechaMedida,
                hora,
                anotacion,
                codigoMedida
        );
        paciente.addMedida(nuevaMedida);
        System.out.println("Se ha registrado un medida, mediante el codigo: " + codigoMedida);



                //this.envase = tipoEnvase.valueOf(sc.next().toUpperCase());

    }



    // System.out.println("Nombre: "); nombre = sc.next();
    //        System.out.println("Primer Apellido: "); primerApellido = sc.next();
    //        System.out.println("Segundo Apellido: "); segundoApellido = sc.next();
    //        System.out.println("Ingrese la fecha de nacimiento: "); fechaNacimiento = LocalDate.parse(sc.next());
    //        System.out.println("Ingrese codigo autonomico Ar");
    //        codigoAr = sc.next();

    @Override
    public String toString() {
        return "Medida{" +
                "tomaValor=" + tomaValor +
                ", valor=" + valor +
                ", fechaMedida=" + DT_MEDIDA_ENTRADA.format(fechaMedida) +
                ", hora=" + TM_MEDIDA_ENTRADA.format(hora) +
                ", anotacion='" + anotacion + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
