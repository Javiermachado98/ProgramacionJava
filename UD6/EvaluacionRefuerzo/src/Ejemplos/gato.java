package Ejemplos;

public class gato extends Mascotas{

    //se llama el constructor de la clase madre
    public gato (String nombre, String tipo){
        super("Elgato","persa");
    }

    //tengo un molde que se llama mascota
    @Override
    public String hacerSonido(){
        System.out.println("hacer ruido");
        return "miau";
    }
}
