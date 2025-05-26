package model;

import jakarta.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "parcelas")
public class Parcela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "numeroParcela")
    private int numeroParcela;
    @Column (name = "coordenadaX")
    private double coordenadaX;
    @Column (name = "coordenadaY")
    private double coordenadaY;
    @Column (name = "superficiem2")
    private double superficiem2;

    public Parcela() {
    }

    public Parcela(int numeroParcela, double coordenadaX, double coordenadaY, double superficiem2) {
        this.numeroParcela = numeroParcela;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.superficiem2 = superficiem2;
    }

    public Parcela (int numeroParcela){
        this.numeroParcela = numeroParcela;
    }

    public int getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(int numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public double getSuperficiem2() {
        return superficiem2;
    }

    public void setSuperficiem2(double superficiem2) {
        this.superficiem2 = superficiem2;
    }

    @Override
    public String toString() {
        return "Parcela{" +
                "numeroParcela=" + numeroParcela +
                ", coordenadaX=" + coordenadaX +
                ", coordenadaY=" + coordenadaY +
                ", superficiem2=" + superficiem2 +
                '}';
    }
}
