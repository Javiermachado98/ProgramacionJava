package controller;

import dao.LibreriaDAO;
import model.Libreria;

import java.util.List;
import java.util.Scanner;

public class LibreriaController {
    private final LibreriaDAO dao = new LibreriaDAO();


    public void anadirLibreria() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nDatos de la librería=====");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("CIF: ");
        String cif = sc.nextLine();
        System.out.print("Calle y número: ");
        String calle = sc.nextLine();
        System.out.print("Código Postal: ");
        String cp = sc.nextLine();
        System.out.print("Teléfono: ");
        String tel = sc.nextLine();

        Libreria l = new Libreria(nombre, cif, calle, cp, tel);
        dao.guardar(l);
        System.out.println("libreria Agregada");
    }


    public LibreriaController(){
    }

    public void verTodos(){
        List<Libreria> libreriaList = dao.ListaDeLasLibrerias();
        for (Libreria l : libreriaList){
            System.out.println(l);
        }
    }

}
