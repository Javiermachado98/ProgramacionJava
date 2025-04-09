import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Cliente {
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String dni;
    private String tarjetaDeCredito;

    private ArrayList<Cliente> arrayListCliente;

    public Cliente(){

    }

    public Cliente(String nombre, String primerApellido, String segundoApellido, String dni, String tarjetaDeCredito) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.dni = dni;
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    public String getNombre() {
        return nombre;
    }
    public String getPrimerApellido() {
        return primerApellido;
    }
    public String getSegundoApellido() {
        return segundoApellido;
    }
    public String getDni() {
        return dni;
    }
    public String getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setTarjetaDeCredito(String tarjetaDeCredito) {
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    public void alta(){

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.print("Ingresa el nombre del cliente: ");
        this.nombre = sc.next();
        System.out.print("Ingresa el primer apellido: ");
        this.primerApellido = sc.next();
        System.out.print("ingresa el segundo apellido: ");
        this.segundoApellido = sc.next();
        System.out.print("Ingresa el DNI: ");
        this.dni = sc.next();
        System.out.print("Ingresa la tarjeta de credito: ");
        this.tarjetaDeCredito = sc.next();
    }

}