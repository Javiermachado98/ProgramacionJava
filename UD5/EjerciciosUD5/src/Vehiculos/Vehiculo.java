package Vehiculos;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Vehiculo {
    private String matricula;
    private LocalDate anioMatricula;
    private String marca;
    private String modelo;
    private String codigoBastidor;
    private double consumo;

    public Vehiculo(String matricula, LocalDate anioMatricula, String marca, String modelo, String codigoBastidor) {
        this.matricula = matricula;
        this.anioMatricula = anioMatricula;
        this.marca = marca;
        this.modelo = modelo;
        this.codigoBastidor = codigoBastidor;
    }

    public Vehiculo(){

    }


    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getAnioMatricula() {
        return anioMatricula;
    }

    public void setAnioMatricula(LocalDate anioMatricula) {
        this.anioMatricula = anioMatricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCodigoBastidor() {
        return codigoBastidor;
    }

    public void setCodigoBastidor(String codigoBastidor) {
        this.codigoBastidor = codigoBastidor;
    }

    public void altaVehiculos(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la matricula: ");
        this.matricula = sc.nextLine();

        System.out.println("Introduce la fecha de matricula (yyyy-MM-dd): ");
        String fechaStr = sc.nextLine();
        this.anioMatricula = LocalDate.parse(fechaStr);

        System.out.println("Introduce la marca: ");
        this.marca = sc.nextLine();

        System.out.println("Introduce el modelo: ");
        this.modelo = sc.nextLine();

        System.out.println("introduce el codigo de bastido: ");
        this.codigoBastidor = sc.nextLine();

        System.out.println("Vehiculo creado correctamente");

    }

    public void consumoKms(double kilometros){
        this.consumo = consumo / kilometros;
        System.out.println("El consumo del carro fue: ");

                //40 km por galon
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", anioMatricula=" + anioMatricula +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", codigoBastidor='" + codigoBastidor + '\'' +
                '}';
    }
}
