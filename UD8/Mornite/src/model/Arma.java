package model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Clase que representa un arma.
 * El autor de esta clase es "teacher DAW 1 Mor".
 */

@Entity
@Table(name = "armas")
public class Arma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Atributos de la clase Arma
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "rareza")
    private String rareza;
    @Column(name = "dano")
    private int dano;

    public Arma(){

    }

    public Arma(Long id, String nombre, String descripcion, String rareza, int dano) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rareza = rareza;
        this.dano = dano;
    }

    public Arma(String nombre, String descripcion, String rareza, int dano) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rareza = rareza;
        this.dano = dano;
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
     * @return La descripcion del arma.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion Establece la descripcinn del arma.
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
     * @return El dano que causa el arma.
     */
    public int getDano() {
        return dano;
    }

    /**
     * @param dano Establece el da�o que causa el arma.
     */
    public void setDano(int dano) {
        this.dano = dano;
    }

    /**
     * @return Una representaci�n de cadena de la clase Arma.
     */
    @Override
    public String toString() {
        return "Arma{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", rareza=" + rareza + ", dano=" + dano + '}';
    }
}
