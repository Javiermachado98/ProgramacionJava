package controller;

import dao.EstudianteDAO;
import model.Estudiante;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EstudianteController {

    private final EstudianteDAO dao = new EstudianteDAO();

    public void anadirEstudiante() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el DNI: ");
        String dni = sc.nextLine();

        System.out.println("Nombre del estudiante: ");
        String nombre = sc.nextLine();

        System.out.println("Primer apellido del estudiante: ");
        String apellido1 = sc.nextLine();

        System.out.println("Segundo apellido del estudiante: ");
        String apellido2 = sc.nextLine();

        System.out.println("Ingrese el email: ");
        String email = sc.nextLine();

        Estudiante myestudiante = new Estudiante(dni, nombre, apellido1, apellido2, email);
        dao.guardar(myestudiante);
        System.out.println("Estudiante ingresado a la BBDD");


        List<String> listaEstudiantes = new ArrayList<String>();
        listaEstudiantes.add(String.valueOf(myestudiante));

        System.out.println(listaEstudiantes);
    }

    public EstudianteController() {
    }

}
