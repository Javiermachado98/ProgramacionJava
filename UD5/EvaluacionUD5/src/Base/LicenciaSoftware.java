package Base;
import Listas.*;

import java.util.Scanner;

public class LicenciaSoftware {
    private String aplicacion;
    private String version;
    private String numero;

    // Constructor
    public LicenciaSoftware() {
    }

    // Constructor
    public LicenciaSoftware(String aplicacion, String version, String numero) {
        this.aplicacion = aplicacion;
        this.version = version;
        this.numero = numero;
    }

    public void alta() {
        Scanner sc = new Scanner (System.in);
        System.out.println("\n--- Alta de Licencia de Software ---");

        System.out.print("Nombre de la aplicación: ");
        this.aplicacion = sc.nextLine();

        System.out.print("Versión: ");
        this.version = sc.nextLine();

        System.out.print("Número de licencia: ");
        this.numero = sc.nextLine();
    }

    // Getters y Setters
    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Base.LicenciaSoftware{" +
                "aplicacion='" + aplicacion + '\'' +
                ", version='" + version + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
