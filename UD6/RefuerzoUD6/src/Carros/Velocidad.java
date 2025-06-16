package Carros;

public class Velocidad extends Carro{
    private int velocidadMaxima;
    private int tiempoAceleracion;

    public Velocidad(String marca, String color, String anio, int kilometros, int velocidadMaxima, int tiempoAceleracion){
        super(marca, color, anio, kilometros);
        this.tiempoAceleracion = tiempoAceleracion;
        this.velocidadMaxima = velocidadMaxima;
    }

    public void demostrarVelocidad(){
        System.out.println("Mi velocidad maxima es de : " + velocidadMaxima + " Con una acelaracion de " + tiempoAceleracion);
    }

    @Override
    public void rechinarRuedas(){
        super.rechinarRuedas();
        System.out.println("Las ruedas son de marca de alta velocidad, no rechina");
    }

    public static void main(String[] args) {
        Velocidad mycarrovelocidad = new Velocidad("BMW", "Blanco", "2020", 1111, 150,20);
        mycarrovelocidad.rechinarRuedas();
        mycarrovelocidad.demostrarVelocidad();
    }

}

