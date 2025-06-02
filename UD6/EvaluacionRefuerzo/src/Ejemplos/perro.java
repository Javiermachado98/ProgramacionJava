package Ejemplos;

public class perro extends Mascotas{
    public perro(String nombre){
    super("perro","labrador");
    }
    @Override
    public String hacerSonido(){
        System.out.println("noruido");
        return "guau";
    }
}

