import controller.ArmaController;

import java.util.Scanner;

public class Principal {

    private static final int OPCION_ANADIR = 1;
    private static final int OPCION_BORRAR = 2;
    private static final int OPCION_VER_TODOS = 3;
    private static final int OPCION_SALIR = 4;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArmaController myarmacontroller = new ArmaController();

        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case OPCION_ANADIR -> myarmacontroller.anadirArma();
                case OPCION_BORRAR -> {}
                case OPCION_VER_TODOS -> myarmacontroller.verTodos();
                case OPCION_SALIR -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }


        } while (opcion != OPCION_SALIR);

    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println(OPCION_ANADIR + ". Añadir Arma");
        System.out.println(OPCION_BORRAR + ". Borrar viaje");
        System.out.println(OPCION_VER_TODOS + ". Ver todas las armas");
        System.out.println(OPCION_SALIR + ". Salir");
        System.out.print("Opción: ");
    }
}

