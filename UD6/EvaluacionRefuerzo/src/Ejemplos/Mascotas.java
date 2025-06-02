package Ejemplos;

public class Mascotas {
    // es privada, pero queda accesible pro las otras clases
    protected String nombre;
    protected String tipo;

    public Mascotas(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String hacerSonido(){
        System.out.println("");
        return "Hacer sonido";
    }

    public String Presentarse(){
        return "soy " + getNombre() + getTipo();
    }
    @Override
    public String toString() {
        return "Mascotas{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
