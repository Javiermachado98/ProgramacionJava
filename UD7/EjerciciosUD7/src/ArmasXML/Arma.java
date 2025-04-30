package ArmasXML;
import java.util.Scanner;

/**
 * Clase que representa un arma.
 * El autor de esta clase es "teacher DAW 1 Mor".
 */
public class Arma {

    // Atributos de la clase Arma
    private String nombre;
    private String descripcion;
    private String rareza;
    private int danio;

    /**
     * M�todo para ingresar informaci�n sobre el arma.
     */
    public void alta() {
        // Crear un objeto Scanner para la entrada de datos.
        Scanner sc = new Scanner(System.in);

        // Solicitar y establecer el nombre del arma.
        System.out.print("Introduce el nombre del arma: ");
        this.nombre = sc.nextLine();

        // Solicitar y establecer la descripci�n del arma.
        System.out.print("Introduce la descripci�n del arma: ");
        this.descripcion = sc.nextLine();

        // Solicitar y establecer la rareza del arma.
        System.out.print("Introduce la rareza del arma: ");
        this.rareza = sc.nextLine();

        // Solicitar y establecer el da�o que causa el arma.
        System.out.print("Introduce el da�o que causa el arma (entero): ");
        this.danio = sc.nextInt();

    }

    /**
     * @return El nombre del arma.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Establece el nombre del arma.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return La descripci�n del arma.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion Establece la descripci�n del arma.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return La rareza del arma.
     */
    public String getRareza() {
        return rareza;
    }

    /**
     * @param rareza Establece la rareza del arma.
     */
    public void setRareza(String rareza) {
        this.rareza = rareza;
    }

    /**
     * @return El da�o que causa el arma.
     */
    public int getDanio() {
        return danio;
    }

    /**
     * @param danio Establece el da�o que causa el arma.
     */
    public void setDanio(int danio) {
        this.danio = danio;
    }

    /**
     * @return Una representaci�n de cadena de la clase Arma.
     */
    @Override
    public String toString() {
        return "Arma{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", rareza=" + rareza + ", da�o=" + danio + '}';
    }
}
