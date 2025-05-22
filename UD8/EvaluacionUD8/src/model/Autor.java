package model;

public class Autor {

    private String nombre;
    private String apellidos;
    private String lugarNacimiento;
    private int anioNacimiento;
    private String profesion;
    private String DNI;
    private ListaLibros myListaLibros = new ListaLibros();

    public Autor() {
    }

    public Autor(String nombre, String apellidos, String lugarNacimiento, int anioNacimiento, String profesion, String DNI) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.lugarNacimiento = lugarNacimiento;
        this.anioNacimiento = anioNacimiento;
        this.profesion = profesion;
        this.DNI = DNI;
    }

    public void anadirLibroAutor(Libro l){
        myListaLibros = new ListaLibros();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", lugarNacimiento='" + lugarNacimiento + '\'' +
                ", anioNacimiento=" + anioNacimiento +
                ", profesion='" + profesion + '\'' +
                ", DNI='" + DNI + '\'' +
                '}';
    }
}
