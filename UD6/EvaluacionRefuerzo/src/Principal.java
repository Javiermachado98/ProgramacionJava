import java.util.Locale;
import java.util.Scanner;

public class Principal {

    private static final int MENU_ALTA_PACIENTE = 1;
    private static final int MENU_MOSTRAR_PACIENTE = 2;
    private static final int MENU_ALTA_DE_MEDIDA = 3;
    private static final int MENU_MOSTRAR_PACIENTES_INFANTILES = 4;
    private static final int MENU_MOSTRAR_MEDIDAS_DE_PULSO = 5;
    private static final int MENU_MOSTRAR_PACIENTES_CON_FIEBRE = 6;
    private static final int MENU_MOSTRAR_SATURACION_MAS_ALTA = 7;
    private static final int MENU_ORDENAR_MEDIDAS_DE_PULSO = 8;
    private static final int MENU_SALIR = 9;



    public static void mostrarMenu() {
        System.out.println("=================================");
        System.out.println(" Medidas constantes vitales Monzon ");
        System.out.println("=================================");
        System.out.println("1.- Alta de paciente");
        System.out.println("2.- Mostrar pacientes");
        System.out.println("3.- Alta de medida");
        System.out.println("4.- Mostrar pacientes infantiles");
        System.out.println("5.- Mostrar medidas de pulso");
        System.out.println("6.- Mostrar pacientes con fiebre");
        System.out.println("7.- Mostrar saturacion mas alta");
        System.out.println("8.- Ordenar medidas de pulso");
        System.out.println("9.- Salir");
        System.out.print("Elige una opción:");
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int opcion;

        ListaPacientes miListaPacientes = new ListaPacientes();


        do {
            mostrarMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case MENU_ALTA_PACIENTE:
                    miListaPacientes.anadirUsuario();
                    break;
                case MENU_MOSTRAR_PACIENTE:
                    miListaPacientes.mostrarLista();
                    break;
                case MENU_ALTA_DE_MEDIDA:
                    break;
                case MENU_MOSTRAR_PACIENTES_INFANTILES:
                    break;
                case MENU_MOSTRAR_MEDIDAS_DE_PULSO:
                    break;
                case MENU_MOSTRAR_PACIENTES_CON_FIEBRE:
                    break;
                case MENU_MOSTRAR_SATURACION_MAS_ALTA:
                    break;
                case MENU_ORDENAR_MEDIDAS_DE_PULSO:
                    break;
                case MENU_SALIR:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }

        } while (opcion != MENU_SALIR);

    }
}
