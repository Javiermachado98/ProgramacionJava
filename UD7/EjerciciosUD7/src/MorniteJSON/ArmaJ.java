package MorniteJSON;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Scanner;


public class ArmaJ implements Serializable {
    /**
     * IMPLEMENYACION jason  ARMAS
     */
    /// declaracion de los elementos o atributos

    private String nombre;
    private String descripcion;
    private String rareza;
    private int dannio;

    /// CONSTRCUTOR
    public ArmaJ(String nombre, String descripcion, String rareza, int dannio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rareza = rareza;
        this.dannio = dannio;
    }

    /// CONSTRUCTOR VACIO
    public ArmaJ() {
    }

    //METODO GET


    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getRareza() {
        return rareza;
    }

    public int getDannio() {
        return dannio;
    }

    /// METODOS SET
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setRareza(String rareza) {
        this.rareza = rareza;
    }

    public void setDannio(int dannio) {
        this.dannio = dannio;
    }

    /// METODO PARA DAR DE ALTA A UN  ARMA

    public void AltaArma() {
        Scanner sc = new Scanner(System.in);
        System.out.print("introduce el nombre de la arma: ");
        this.nombre = sc.next();
        System.out.print("introduce la descripcion del arma: ");
        this.descripcion = sc.next();
        System.out.print("introduce la rareza de la arma :común, poco común, rara," + "épica, legendaria, mítica, otras ");
        this.rareza = sc.next();
        System.out.print("introduce el daño que inglige el arma :");
        this.dannio = sc.nextInt();

    }

    /// METODO TO-STRING
    @Override
    public String toString() {
        return "ArmaP{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", rareza='" + rareza + '\'' +
                ", dannio=" + dannio +
                '}';
    }

}
