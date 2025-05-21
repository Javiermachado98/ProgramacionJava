package controller;

import dao.ArmaDAO;
import model.Arma;

import java.util.List;
import java.util.Scanner;

public class ArmaController {
    private final ArmaDAO dao = new ArmaDAO();

    public void anadirArma(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre del arma: ");
        String nombre = sc.nextLine();

        System.out.println("Descripcion del arma: ");
        String descripcion = sc.nextLine();

        System.out.println("Rareza del arma: ");
        String rareza = sc.next();

        System.out.println("daño del arma: ");
        int dano = sc.nextInt();

        Arma myarma = new Arma(nombre, descripcion, rareza, dano);
        dao.guardar(myarma);
        System.out.println("Arma insertada en BBDD");
    }

    public ArmaController(){
    }

    public void verTodos(){
        List<Arma> armaList = dao.ListaDeLasArmas();
        for (Arma a : armaList){
            System.out.println(a);
        }
    }
}
