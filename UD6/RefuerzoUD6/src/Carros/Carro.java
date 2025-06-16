package Carros;

import java.time.format.DateTimeFormatter;
//1.Para hacer un implements, creo siempre una interfaz que me permita facilitar mi proceso
//2.llamo los metodos utilitarios que necesito, especificamente para mi implementacion
interface Transportador{

    void cargar(int peso);
    void descargar(boolean cargado);
}

public class Carro {
    protected String marca;
    protected String color;
    protected String anio;
    protected int kilometros;
    protected int carga;
    boolean cargado = false;

    //extraemos la variable a local a global
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Carro(String marca, String color, String anio, int kilometros) {
        this.marca = marca;
        this.color = color;
        this.anio = anio;
        this.kilometros = kilometros;
    }

    public void decirMarca(){
        System.out.println("Carro de la marca " + marca + " de color " + color + " fabricado en " + anio);
    }

    public void rechinarRuedas(){
        System.out.println("Rechinar ruedas del carro");
    }



    public void cargar(int peso){

        if (peso < carga){
            System.out.println("El peso es correcto, se puede cargar");
            cargado = true;

        }else {
            System.out.println("El peso es mayor, no se puede cargar");
        }
    }

    public void descargar(boolean cargado){
        System.out.println("Se descargo el contenido");
        cargado = false;
    }

    public static void main(String[] args) {

        Carro mycarro = new Carro ("BWM", "Negro", "2010", 12000);
        Carro mycarro2 = new Carro("WolksWagen", "Blanco", "2015", 14000);

        mycarro.decirMarca();
        mycarro2.decirMarca();

    }
}
