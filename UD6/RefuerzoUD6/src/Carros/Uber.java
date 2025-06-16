package Carros;

//3.Creo la clase del proceso, la empresa o la entidad a desarrollar aplicando extends para heredar
//y hacer una subclase de carro ahorrandome todos los metodos que me puede brindar carro
//y consolidando mi implementacion con el llamado a la interfaz transportador
//mediante el codigo implements transportador, es decir la interfaz llama las funciones
public class Uber extends Carro implements Transportador{
//4.luego creo los atributos de la clase uber con su respetivo constructor
    private String capacidadCargar;
    private boolean cargado;

    public Uber(String marca, String color, String anio, int kilometros, String capacidadCargar, boolean cargado){
        super(marca, color,anio,kilometros);

        this.capacidadCargar = capacidadCargar;
        this.cargado = false;
    }

    //5.finalmente hago polimorfismo con las funciones requeridas para la implementacion de transportador
    @Override
    public void cargar(int peso) {
        super.cargar(peso);
        System.out.println("Aqui descargo a un super pasajero");
    }
}
