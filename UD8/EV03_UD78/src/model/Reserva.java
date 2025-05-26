package model;

public class Reserva {

    private Parcela parcela;
    private String nombre;
    private String asociacion;
    private String DNIResponsable;
    private String DNIGuardaLlaves;

    public Reserva() {
    }

    public Reserva(Parcela parcela, String nombre, String asociacion, String DNIResponsable, String DNIGuardaLlaves) {
        this.parcela = parcela;
        this.nombre = nombre;
        this.asociacion = asociacion;
        this.DNIResponsable = DNIResponsable;
        this.DNIGuardaLlaves = DNIGuardaLlaves;
    }

    public Parcela getParcela() {
        return parcela;
    }

    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(String asociacion) {
        this.asociacion = asociacion;
    }

    public String getDNIResponsable() {
        return DNIResponsable;
    }

    public void setDNIResponsable(String DNIResponsable) {
        this.DNIResponsable = DNIResponsable;
    }

    public String getDNIGuardaLlaves() {
        return DNIGuardaLlaves;
    }

    public void setDNIGuardaLlaves(String DNIGuardaLlaves) {
        this.DNIGuardaLlaves = DNIGuardaLlaves;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "parcela=" + parcela +
                ", nombre='" + nombre + '\'' +
                ", asociacion='" + asociacion + '\'' +
                ", DNIResponsable='" + DNIResponsable + '\'' +
                ", DNIGuardaLlaves='" + DNIGuardaLlaves + '\'' +
                '}';
    }
}
