package controller;

import dao.ViajeDAO;
import model.Viaje;

import java.util.Scanner;

public class ViajeController {
    private final ViajeDAO dao = new ViajeDAO();

    public void anadirViaje(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Destino: ");
        String destino = sc.nextLine();

        System.out.println("Agencia: ");
        String agencia = sc.nextLine();

        System.out.println("Duracion en dias: ");
        int duracion = sc.nextInt();

        System.out.println("Precio: ");
        double precio = sc.nextDouble();


        Viaje myviaje = new Viaje(destino, agencia, duracion, precio);
        dao.guardar(myviaje);
        System.out.println("Viaje insertado en BBDD");

    }

    public ViajeController() {
    }
}
