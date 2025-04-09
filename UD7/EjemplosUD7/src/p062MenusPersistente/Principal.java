package p062MenusPersistente;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Principal {

    public static final int OPCION_ALTA_CLIENTE = 1;
    public static final int OPCION_MOSTRAR_CLIENTES = 2;
    public static final int OPCION_ALTA_PLATO = 3;
    public static final int OPCION_MOSTRAR_PLATOS = 4;
    public static final int OPCION_ALTA_MENU = 5;
    public static final int OPCION_MOSTRAR_MENUS = 6;
    public static final int OPCION_MUESTRA_BARATOS = 7;
    public static final int OPCION_MUESTRA_ORDENA_PLATOS_CALORIAS = 8;
    public static final int OPCION_MUESTRA_PLATOS_INTERNACIONAL= 9;
    public static final int OPCION_MUESTRA_CLIENTES_ALERGICOS_CACAHUETES = 10;
    public static final int OPCION_PUEDE_COMER = 11;
    public static final int OPCION_SALIR = 12;
    
    public static void anadirClientesEjemplo(ListaClientes miLista) {
        Cliente c1 = new Cliente("José Ramón" , "Manau Peirón", "18000000"); c1.anadeAlergeno(tipoAlergeno.HUEVOS); 
        Cliente c2 = new Cliente("Cristina" , "Berrocal Edu", "13000000");   c2.anadeAlergeno(tipoAlergeno.CACAHUETES);
        Cliente c3 = new Cliente("Rufino" , "Esteban Bernal", "93000000");   c3.anadeAlergeno(tipoAlergeno.GLUTEN);
        Cliente c4 = new Cliente("Carmen" , "Roca Saiz", "73000000");        c4.anadeAlergeno(tipoAlergeno.GLUTEN);
        Cliente c5 = new Cliente("Modesto" , "Sierra Callau", "23000000");   c5.anadeAlergeno(tipoAlergeno.LACTEOS); c5.anadeAlergeno(tipoAlergeno.HUEVOS);
        miLista.anadirCliente(c1);
        miLista.anadirCliente(c2);
        miLista.anadirCliente(c3);
        miLista.anadirCliente(c4);
        miLista.anadirCliente(c5);
    }
    
    public static void anadirPlatosEjemplo(ListaPlatos miLista) {
        Plato p1 = new Plato("Ensalada de la casa", 6, 190);                p1.anadeAlergeno(tipoAlergeno.HUEVOS);
        Plato p2 = new Plato("Macarrones gratinados", 5, 320);              p2.anadeAlergeno(tipoAlergeno.LACTEOS);
        Plato p3 = new Plato("Empanada casera", 6, 300);                    p3.anadeAlergeno(tipoAlergeno.HUEVOS); p3.anadeAlergeno(tipoAlergeno.GLUTEN);
        Plato p4 = new Plato("Verdura de temporada", 6, 120);
        Plato p5 = new Plato("Arroz tres delicias", 5, 230);
        Plato p6 = new Plato("Codornices escabechadas", 6, 190);
        Plato p7 = new Plato("Hamburquesa vegetal", 7, 190);
        Plato p8 = new Plato("Bacalao a la riojana", 7, 290);
        Plato p9 = new Plato("Chuletón de buey", 18, 400);
        Plato p10 = new Plato("Cuajada", 4, 290);
        Plato p11 = new Plato("Yogur natural", 3, 110);                     p11.anadeAlergeno(tipoAlergeno.LACTEOS);
        Plato p12 = new Plato("Tarta de chocolate", 4, 500);                p12.anadeAlergeno(tipoAlergeno.HUEVOS); p12.anadeAlergeno(tipoAlergeno.LACTEOS); p12.anadeAlergeno(tipoAlergeno.CACAHUETES);
        Plato p13 = new Plato("Fruta de temporada", 3, 100);
        miLista.anadirPlato(p1);
        miLista.anadirPlato(p2);
        miLista.anadirPlato(p3);
        miLista.anadirPlato(p4);
        miLista.anadirPlato(p5);
        miLista.anadirPlato(p6);
        miLista.anadirPlato(p7);
        miLista.anadirPlato(p8);
        miLista.anadirPlato(p9);
        miLista.anadirPlato(p11);
        miLista.anadirPlato(p12);
        miLista.anadirPlato(p13);

    }

    public static void mostrarMenu() {
        System.out.println("==================================================");
        System.out.println(" MENUS ");
        System.out.println("==================================================");
        System.out.println("1.-  ALTA CLIENTE ");
        System.out.println("2.-  MOSTRAR CLIENTES ");
        System.out.println("3.-  ALTA PLATO ");
        System.out.println("4.-  MOSTRAR PLATOS");
        System.out.println("5.-  ALTA MENÚ");
        System.out.println("6.-  MOSTRAR MENÚS");
        System.out.println("7.-  MUESTRA BARATOS");
        System.out.println("8.-  ORDENA PLATOS CALORÍAS");
        System.out.println("9.-  MUESTRA PLATOS INTERNACIONAL");
        System.out.println("10.-  MUESTRA CLIENTES ALERGICOS CACAHUETES");
        System.out.println("11.-  PUEDE COMER");
        System.out.println("12.-  SALIR");
        System.out.println("==================================================");
        System.out.print("Introduce una opción: ");
    }
    
    
    public static ListaClientes cargaInfoClientes() {
        ListaClientes miLista = null;
        try {
            ObjectInputStream entrada = new ObjectInputStream(
                    new FileInputStream("src" + File.separator
                            + "p062MenusPersistente" + File.separator + "ficheroClientes.txt"));
            miLista = (ListaClientes) entrada.readObject();

        } catch (Exception e) {
            System.out.println("Excepcion");
            System.out.println(e.toString());
        } finally {
            return miLista;
        }
    }

    public static void guardaInfoClientes(ListaClientes miLista) {
        try {
            ObjectOutputStream salida = new ObjectOutputStream(
                    new FileOutputStream("src" + File.separator
                            + "p062MenusPersistente" + File.separator + "ficheroClientes.txt"));
            salida.writeObject(miLista);

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc;
        int opcion;
        ListaClientes miListaClientes = cargaInfoClientes();
        ListaPlatos miListaPlatos = new ListaPlatos();       anadirPlatosEjemplo(miListaPlatos);
        ListaMenus miListaMenus = new ListaMenus();

        do {
            mostrarMenu();
            sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion) {

                case OPCION_ALTA_CLIENTE -> {
                    Cliente nuevoCliente = new Cliente();
                    nuevoCliente.alta();
                    miListaClientes.anadirCliente(nuevoCliente);
                }
                case OPCION_MOSTRAR_CLIENTES -> {
                    miListaClientes.muestraClientes();
                }
                case OPCION_ALTA_PLATO -> {
		    Plato nuevoPlato = new Plato();
                    nuevoPlato.alta();
                    miListaPlatos.anadirPlato(nuevoPlato);
                }
                case OPCION_MOSTRAR_PLATOS -> {
                }
                case OPCION_ALTA_MENU -> {
                }
                case OPCION_MOSTRAR_MENUS -> {
                }
                case OPCION_MUESTRA_BARATOS -> {
                }
                case OPCION_MUESTRA_ORDENA_PLATOS_CALORIAS -> {
                }
                case OPCION_MUESTRA_PLATOS_INTERNACIONAL -> {
                }
                case OPCION_MUESTRA_CLIENTES_ALERGICOS_CACAHUETES -> {
                }
                case OPCION_PUEDE_COMER-> {
                }
                case OPCION_SALIR -> {
                    guardaInfoClientes(miListaClientes);
                    System.out.println("Gracias por usar el programa");
                }
                default -> {
                    System.out.println("Introduce una opción válida");
                }
            }

        } while (opcion != OPCION_SALIR);

    }

}
