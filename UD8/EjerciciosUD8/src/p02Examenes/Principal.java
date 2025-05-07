package p02Examenes;
import java.util.Scanner;

/**
 * Gestionamos lista de ex�menes y lista de preguntas
 *
 * @author admin
 */
public class Principal {

    public static final int OPCION_ANADIR_EXAMEN = 1;
    public static final int OPCION_LISTAR_EXAMENES = 2;
    public static final int OPCION_ANADIR_PREGUNTA = 3;
    public static final int OPCION_EXAMEN_PREGUNTAS_PROGRAMA = 4;
    public static final int OPCION_EXAMEN_PREGUNTAS_BBDD = 5;
    public static final int OPCION_SALIR = 6;

    public static void mostrarMenu() {
        System.out.println("===========================================");
        System.out.println("PROGRAMA EXAMENES");
        System.out.println("===========================================");
        System.out.println("1.- Añadir Examen");
        System.out.println("2.- Mostrar Lista Examenes");
        System.out.println("3.- Añadir Pregunta");
        System.out.println("4.- Examen Preguntas Programa");
        System.out.println("5.- Examen Preguntas BBDD");
        System.out.println("6.- Salir");
        System.out.println("===========================================");
        System.out.print("Introduce una opción: ");
    }

    public static void main(String[] args) {

        int opcion;
        Scanner sc;
        sc = new Scanner(System.in);
        ListaExamenes miListaExamenes = new ListaExamenes();

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case OPCION_ANADIR_EXAMEN -> {
                    System.out.println("=====================================");
                    System.out.println(" Añadir examen                       ");
                    System.out.println("=====================================");
                    Examen e = new Examen();
                    e.alta();
                    miListaExamenes.anadirExamen(e);
                }
                case OPCION_LISTAR_EXAMENES -> {
                    System.out.println("=====================================");
                    System.out.println(" Listar exámenes                     ");
                    System.out.println("=====================================");
                    miListaExamenes.listarExamenes();
                }
                case OPCION_ANADIR_PREGUNTA -> {
                    System.out.println("=====================================");
                    System.out.println(" Añadir pregunta                     ");
                    System.out.println("=====================================");
                    miListaExamenes.listarExamenes();
                    System.out.print("Elige un número de examen de la lista: ");
                    int numeroExamen = sc.nextInt();
                    Examen e = miListaExamenes.examenNumero(numeroExamen);
                    if (e != null) {
                        System.out.println("Información de la pregunta:");
                        Pregunta p = new Pregunta();
                        p.alta();
                        e.anadirPregunta(p);
                    } else {
                        System.out.println("Examen incorrecto");
                    }
                }
                case OPCION_EXAMEN_PREGUNTAS_PROGRAMA -> {
                    System.out.println("=====================================");
                    System.out.println(" Numero de preguntas x examen (prog) ");
                    System.out.println("=====================================");
                }
                case OPCION_EXAMEN_PREGUNTAS_BBDD -> {
                    System.out.println("=====================================");
                    System.out.println(" Numero de preguntas x examen (bbdd) ");
                    System.out.println("=====================================");
                }
                case OPCION_SALIR -> {
                    System.out.println("Gracias por usar el programa");
                }
                default -> {
                    System.out.println("Introduce una opción correcta");
                }

            }

        } while (opcion != OPCION_SALIR);

    }

}
