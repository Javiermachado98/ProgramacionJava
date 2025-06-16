package Base;
import Listas.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class AsignacionLicencia {
    private Usuario usuario;
    private LicenciaSoftware licencia;
    private LocalDate fechaAsignacion;
    private LocalDate fechaExpiracion;

    /* Extraemos la variable local a global */
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public AsignacionLicencia() {
    }

    // Constructor con Strings
    public AsignacionLicencia(Usuario usuario, LicenciaSoftware licencia, String fechaAsignacion, String fechaExpiracion) {
        this.usuario = usuario;
        this.licencia = licencia;


        this.fechaAsignacion = LocalDate.parse(fechaAsignacion, formatter);
        this.fechaExpiracion = LocalDate.parse(fechaExpiracion, formatter);
    }

    // Constructor
    public AsignacionLicencia(Usuario usuario, LicenciaSoftware licencia, LocalDate fechaAsignacion, LocalDate LocalfechaExpiracion) {
        this.usuario = usuario;
        this.licencia = licencia;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaExpiracion = fechaExpiracion;
    }

    // Alta de una asignación
    public void alta(ListaUsuarios lu, ListaLicenciasSoftware ls) {
        Scanner sc = new Scanner(System.in);
        //  muestra la lista de usuarios, permite seleccionar uno y lo añade al atributo usuario
        System.out.println("Usuarios:");
        lu.mostrarLista();
        System.out.print("Selecciona un usuario: ");
        usuario = lu.UsuarioPosicion(sc.nextInt());
        //  muestra la lista de licencias, permite seleccionar una y la añade al atributo licencia
        System.out.println("Licencias");
        ls.mostrarLista();
        System.out.print("Selecciona una licencia: ");
        licencia = ls.LicenciaSoftwarePosicion(sc.nextInt());
        // Solicita una fecha de asignación y una fecha de expiración. Para la conversión, se pueden
        // revisar los constructores para ver cómo se podría hacer para leerlo de forma fácil
        System.out.print("Fecha de asignación: ");
        fechaAsignacion = LocalDate.parse(sc.next(), formatter);
        System.out.print("Fecha de expiración: ");
        fechaExpiracion = LocalDate.parse(sc.next(), formatter);
    }


    // Getters y Setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LicenciaSoftware getLicencia() {
        return licencia;
    }

    public void setLicencia(LicenciaSoftware licencia) {
        this.licencia = licencia;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    @Override
    public String toString() {
        return "Base.AsignacionLicencia{" +
                "usuario=" + usuario +
                ", licencia=" + licencia +
                ", fechaAsignacion=" + fechaAsignacion +
                ", fechaExpiracion=" + fechaExpiracion +
                '}';
    }
}