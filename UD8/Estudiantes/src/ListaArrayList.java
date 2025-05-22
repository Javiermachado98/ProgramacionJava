import model.Estudiante;

import javax.swing.plaf.TreeUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ListaArrayList {

    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;

    static ArrayList<String> mylistaEstudiantes = new ArrayList<String>();


    public static void pedirDatos() {

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
        Estudiante myestudiante2 = new Estudiante(dni, nombre, apellido1, apellido2, email);

        mylistaEstudiantes.add(String.valueOf(myestudiante));
        System.out.println(mylistaEstudiantes);
    }


    public static void llenarLista() {
        String fin;
        Scanner sc = new Scanner(System.in);
    }


    public static void main(String[] args) {
        pedirDatos();
    }
}
