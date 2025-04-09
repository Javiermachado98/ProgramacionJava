package p062MenusPersistente;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Cliente implements Serializable {
	
	private String nombre;
    private String apellidos;
    private String DNI;
    private ListaAlergenos miListaAlergenos;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * @param DNI the DNI to set
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    
    public Cliente() {
        this.miListaAlergenos = new ListaAlergenos();        
    }

    public Cliente(String nombre, String apellidos, String DNI) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.miListaAlergenos = new ListaAlergenos();   
    }
    
    public void anadeAlergeno(tipoAlergeno nuevoAlergeno) {
        miListaAlergenos.anadirAlergeno(nuevoAlergeno);
    }

     public void pideNuevoAlergeno() {
         
        tipoAlergeno nuevo = tipoAlergeno.NINGUNO;
        nuevo = nuevo.validaAlergeno();
        miListaAlergenos.anadirAlergeno(nuevo);
        
    }

    public void alta() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        setNombre(sc.nextLine());
        System.out.print("Apellidos: ");
        setApellidos(sc.nextLine());
        System.out.print("DNI: ");
        setDNI(sc.nextLine());

        char opcion = 's';
        do {
            System.out.println("¿Quieres añadir un alérgeno?(S/N)");
            opcion = sc.next().toLowerCase().charAt(0);
            if (opcion == 's') {
                pideNuevoAlergeno();
            }
        } while (opcion == 's');
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + getNombre() + ", apellidos=" + getApellidos() + ", DNI=" + getDNI() + ", alergenos=" + miListaAlergenos + '}';
    }
    
    
    

}
