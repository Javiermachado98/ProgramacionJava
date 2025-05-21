package C_Vuelos;

public class Principal {
    public static void main(String[] args) {
        Equipaje equipaje1 = new Equipaje();
        equipaje1.alta();
        System.out.print(equipaje1);

        if(equipaje1.equipajeMano()){
            System.out.print("Es equipaje de mano");
        } else if (equipaje1.equipajeBodega()) {
            System.out.println("Es equipaje de bodega");
        }
    }
}