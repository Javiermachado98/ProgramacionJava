package model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "barbitania")
public class Libreria implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cif")
    private String cif;
    @Column(name = "calle")
    private String calle;
    @Column(name = "codigoPostal")
    private String codigoPostal;
    @Column(name = "telefono")
    private String telefono;

    public Libreria() {
    }

    public Libreria(String nombre, String cif, String calle, String codigoPostal, String telefono) {
        this.nombre = nombre;
        this.cif = cif;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Libreria{" +
                "nombre='" + nombre + '\'' +
                ", cif='" + cif + '\'' +
                ", calle='" + calle + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
