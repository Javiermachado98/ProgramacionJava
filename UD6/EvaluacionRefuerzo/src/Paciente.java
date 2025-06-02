import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Paciente {
    protected String nombre;
    protected String primerApellido;
    protected String segundoApellido;
    protected LocalDate fechaNacimiento; //
    protected String codigoAr;
    protected List<Medida> medidas;

    private static final DateTimeFormatter DT_FECHA_NACI = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Paciente(String nombre, String primerApellido, String segundoApellido, String fechaNacimientoString, String codigoAr) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = LocalDate.parse(fechaNacimientoString, DT_FECHA_NACI);
        this.codigoAr = codigoAr;
        this.medidas = new ArrayList<>();
    }

    public Paciente(){

    }

    public String getNombre(){
        return nombre;
    }

    public String setNombre(){
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimientoStr) {
        this.fechaNacimiento = LocalDate.parse(fechaNacimientoStr, DT_FECHA_NACI);
    }

    public String getCodigoAr() {
        return codigoAr;
    }

    public void setCodigoAr(String codigoAr) {
        this.codigoAr = codigoAr;
    }

    public List<Medida>  getMedidas(){
        return medidas;
    }

    //aqui esta la lista interna - revisar
    public void addMedida(Medida m){
        this.medidas.add(m);
    }

    public void altaPaciente(){
        Scanner sc = new Scanner(System.in);
        String patron = "AR\\d{9}[A-Z]";
        System.out.println("===Alta de pacientes===");
        System.out.println("Nombre: ");
        this.nombre = sc.nextLine();

        System.out.println("Primer Apellido: ");
        this.primerApellido = sc.nextLine();

        System.out.println("Segundo Apellido: ");
        this.segundoApellido = sc.nextLine();


        System.out.print("Ingrese la fecha de nacimiento (dd/MM/yyyy): ");
        // Leemos la línea completa y parseamos con el formateador
        String fechaStr = sc.nextLine();
        this.fechaNacimiento = LocalDate.parse(fechaStr, DT_FECHA_NACI);

        System.out.println("Ingrese codigo autonomico AR");
        String codigoTemporal = sc.nextLine();

        if(codigoTemporal.matches(patron)){
            this.codigoAr = codigoTemporal;
            System.out.println("El codigo AR, es valido.");
        }

        if(codigoAr.matches(patron)){
            System.out.println("el codigoAr coincide");
            System.out.println("Codigo autonomnico AR");

        }
        else {
            System.out.println("el codigo ar no coincide");
            this.codigoAr ="";
        }


    }

    @Override
    public String toString() {

        //Para mostrar la fecha nacimiento formato("dd/mm/yyyy")
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", fechaNacimiento=" + DT_FECHA_NACI.format(fechaNacimiento) +
                ", codigoAr='" + codigoAr + '\'' +
                ", medidas=" + medidas +
                '}';
    }
}
