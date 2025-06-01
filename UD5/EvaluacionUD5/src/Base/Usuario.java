package Base;

import java.util.Scanner;
import Listas.*;

public class Usuario implements Comparable {
    private String nombre;
    private String apellidos;
    private String DNI;
    private TipoUsuario tipoUsuario;


    // Constructor


    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String DNI, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.tipoUsuario = tipoUsuario;
    }

    public void alta() {
        Scanner sc = new Scanner (System.in);

        System.out.println("\n--- Alta de Base.Usuario ---");

        System.out.print("Nombre: ");
        this.nombre = sc.nextLine();

        System.out.print("Apellidos: ");
        this.apellidos = sc.nextLine();

        System.out.print("DNI: ");
        this.DNI = sc.nextLine();

        System.out.println("Tipo de Base.Usuario (1-Profesor, 2-Alumno, 3-PAS, 4-Otros): ");
        int tipo = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        switch (tipo) {
            case 1 -> this.tipoUsuario = TipoUsuario.PROFESOR;
            case 2 -> this.tipoUsuario = TipoUsuario.ALUMNO;
            case 3 -> this.tipoUsuario = TipoUsuario.PAS;
            default -> this.tipoUsuario = TipoUsuario.OTROS;
        }
    }

    // Getters y Setters
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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Base.Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", DNI='" + DNI + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }

    // CompareTo a partir del apellido, si coincide, se usa el DNI
    public int compareTo(Object o) {
        Usuario u = (Usuario) o;
        // Si los apellidos son iguales, los ordenará por el DNI
        if (this.apellidos.compareTo(u.getApellidos()) == 0) {
            return this.DNI.compareTo(u.getDNI());
        } else return this.apellidos.compareTo(u.getApellidos());
    }
}
