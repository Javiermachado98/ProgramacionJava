package Mascotas;

public class MascotaEspecial extends Mascota{

    private String especialidad;

    //creo mi constructor, en la cual tendra los atributos del padre y del hijo
    public MascotaEspecial(String nombre, String tipo, String raza, String especialidad){
        //llamo a la super clase y sus atributos, aqui hicimos herencia atributos
        super(nombre, tipo, raza);

        // llamo el atributo del hijo
        this.especialidad = especialidad;

    }

    public void demostrarEspecialidad(){
        System.out.println("Mi especialidad es: " + especialidad);
    }

    //sobreescribe un metodo y lo hace suyo o le da valores del suyo y crea otro, sobreescribe o agrega
    //hace herencia y sobreescribe el metodo heredado, para crear un polimorfismo
    @Override
    public void hacerSonido() {
        super.hacerSonido();
        System.out.println("Sonido animal, especial");
    }

    public static void main(String[] args) {
        MascotaEspecial mymascotaespecial = new MascotaEspecial("Benji", "Perro", "Labrador", "Circo");
        //llamo mi objeto y las funciones
        mymascotaespecial.hacerSonido();
        mymascotaespecial.demostrarEspecialidad();
    }
}
