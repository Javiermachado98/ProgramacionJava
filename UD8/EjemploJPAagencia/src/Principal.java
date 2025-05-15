import controller.ViajeController;

import java.util.Scanner;

public class Principal {

    // Constantes de opciones de menú
    private static final int OPCION_ANADIR = 1;
    private static final int OPCION_BORRAR = 2;
    private static final int OPCION_VER_TODOS = 3;
    private static final int OPCION_VER_POR_DESTINO = 4;
    private static final int OPCION_SALIR = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ViajeController controller = new ViajeController();

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case OPCION_ANADIR -> controller.anadirViaje();
                case OPCION_BORRAR -> {}
                case OPCION_VER_TODOS -> {}
                case OPCION_VER_POR_DESTINO -> {}
                case OPCION_SALIR -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != OPCION_SALIR);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println(OPCION_ANADIR + ". Añadir viaje");
        System.out.println(OPCION_BORRAR + ". Borrar viaje");
        System.out.println(OPCION_VER_TODOS + ". Ver todos los viajes");
        System.out.println(OPCION_VER_POR_DESTINO + ". Ver viajes con destino a XXX");
        System.out.println(OPCION_SALIR + ". Salir");
        System.out.print("Opción: ");
    }
}
