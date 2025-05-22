import com.fasterxml.jackson.databind.ObjectMapper;
import controller.EstudianteController;
import model.Estudiante;
import model.ListaEstudiante;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PrincipalEstudiantes {

    private static final int OPCION_ANADIR = 1;
    private static final int OPCION_BORRAR = 2;
    private static final int OPCION_VER_TODOS = 3;
    private static final int OPCION_SALIR = 4;
    private static final int OPCION_MOSTRAR_DEL_FICHERO = 5;

    public static String FILE_PATH = "src" + File.separator + "files" + File.separator + "PrincipalEstudiantes2.txt";
    public static ListaEstudiante mylistaEstudiantes;


    public static void guardaInfo() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(FILE_PATH), mylistaEstudiantes);
            System.out.println("Lista guardada en " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    // Carga un objeto desde un archivo JSON
   public static void cargaInfo() {
        ObjectMapper cargarMiLista = new ObjectMapper();
        try {
            mylistaEstudiantes = (ListaEstudiante) cargarMiLista.readValue(new FileReader(FILE_PATH),ListaEstudiante.class);
            if (mylistaEstudiantes == null){
                mylistaEstudiantes = new ListaEstudiante();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EstudianteController myestudianteController = new EstudianteController();

        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case OPCION_ANADIR -> myestudianteController.anadirEstudiante();
                case OPCION_BORRAR -> {}
                case OPCION_VER_TODOS -> {}
                case OPCION_MOSTRAR_DEL_FICHERO -> guardaInfo();
                case OPCION_SALIR -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != OPCION_SALIR);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println(OPCION_ANADIR + ". Añadir estudiante");
        System.out.println(OPCION_BORRAR + ". Borrar estudiante");
        System.out.println(OPCION_VER_TODOS + ". Ver todos los estudiantes");
        System.out.println(OPCION_MOSTRAR_DEL_FICHERO + ". Ver los estudiantes del fichero");
        System.out.println(OPCION_SALIR + ". Salir");
        System.out.print("Opción: ");
    }
}