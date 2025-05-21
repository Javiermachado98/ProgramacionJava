package controller;

import dao.EstudianteDAO;
import model.Estudiante;

import java.util.Scanner;

public class EstudianteController {

    private final EstudianteDAO dao = new EstudianteDAO();

    public void anadirEstudiante(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre del estudiante: ");
        String nombre = sc.nextLine();

        System.out.println("Primer apellido del estudiante: ");
        String apellido1 = sc.nextLine();
    }
}
