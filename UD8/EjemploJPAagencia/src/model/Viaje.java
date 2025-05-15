package model;

import jakarta.persistence.*;
import javax.annotation.processing.Generated;
import java.io.Serializable;



@Entity
@Table(name = "viajes")


//clase para guardar los viajes
public class Viaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "destino")
    private String destino;
    @Column(name = "agencia")
    private String agencia;
    @Column(name = "duracion")
    private int duracion;
    @Column(name = "precio")
    private double precio;

    // constructor vacio
    public Viaje() {
    }

    public Viaje(Long id, String destino, String agencia, int duracion, double precio) {
        this.id = id;
        this.destino = destino;
        this.agencia = agencia;
        this.duracion = duracion;
        this.precio = precio;
    }

    //constructor sin id
    public Viaje(String destino, String agencia, int duracion, double precio) {
        this.destino = destino;
        this.agencia = agencia;
        this.duracion = duracion;
        this.precio = precio;
    }

    /// -----------------METODOS GET
    public Long getId() {
        return id;
    }

    public String getDestino() {
        return destino;
    }

    public String getAgencia() {
        return agencia;
    }

    public int getDuracion() {
        return duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /// -----------------METODOS SET
    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /// METODO TO-STRING
    @Override
    public String toString() {
        return "Viaje{" +
                "id=" + id +
                ", destino='" + destino + '\'' +
                ", agencia='" + agencia + '\'' +
                ", duracion=" + duracion +
                ", precio=" + precio +
                '}';
    }
}