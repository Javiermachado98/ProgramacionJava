
import java.util.Scanner;

public class Principal1 {

    public static final int OPCION_ANADE_PRODUCTO = 1;
    public static final int OPCION_MUESTRA_PRODUCTOS = 2;
    public static final int OPCION_ANADE_CLIENTE = 3;
    public static final int OPCION_MUESTRA_CLIENTES = 4;
    public static final int OPCION_COMPRA = 5;
    public static final int OPCION_MUESTRA_CARROS = 6;
    public static final int OPCION_MUESTRA_CARROS_PRECIO = 7;
    public static final int OPCION_SALIR = 8;

    public static void mostrarMenu() {
        System.out.println("==================================================");
        System.out.println(" AMONZÓN ONLINE ");
        System.out.println("==================================================");
        System.out.println("1.-  Añade producto");
        System.out.println("2.-  Muestra productos");
        System.out.println("3.-  Añade cliente");
        System.out.println("4.-  Muestra clientes");
        System.out.println("5.-  Realiza compra");
        System.out.println("6.-  Muestra carros");
        System.out.println("7.-  Muestra carros precio");
        System.out.println("8.-  Salir");
        System.out.println("==================================================");
        System.out.print("Introduce una opción: ");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc;
        int opcion;

        ListaProductos miListaProductos = new ListaProductos();


        do {
            mostrarMenu();
            sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion) {
                case OPCION_ANADE_PRODUCTO -> {
                    Producto producto1 = new Producto();
                    System.out.println("Alta de producto: ");
                    producto1.alta();
                    miListaProductos.agregarProducto(producto1);

                }
                case OPCION_MUESTRA_PRODUCTOS -> {
                    System.out.println("Listado de productos: ");
                    miListaProductos.mostrarProductos();



                    // Muestra todos los productos de la lista de productos
                }
                case OPCION_ANADE_CLIENTE -> {
                    System.out.println("Alta de cliente: ");
                    // Solicita los datos de un cliente y lo añade a la lista de clientes
                }
                case OPCION_MUESTRA_CLIENTES -> {
                    System.out.println("Listado de clientes: ");
                    // Muestra todos los clientes de la lista de clientes
                }
                case OPCION_COMPRA -> {
                    // Crea un carro
                    // Muestra los clientes de la lista 
                    // Invita a seleccionar un cliente de la lista
                    // Asigna el cliente al carro que se acaba de crear
                    // Se realiza el proceso de compra del carro, a partir de todos los productos disponibles                
                }
                case OPCION_MUESTRA_CARROS -> {
                    System.out.println("Carros dados de alta");
                    // Muestra todos los carros de la lista
                }
                case OPCION_MUESTRA_CARROS_PRECIO -> {
                    System.out.println("Carros con información específica: ");
                    // Muestra los carros de la lista pero sólo nombre del cliente y precio del carro
                }
                case OPCION_SALIR -> {/////////////////////////////////////////////////////////
                    System.out.println("Fin del programa. Gracias por comprar en Amonzón");
                }
                default -> {
                    System.out.println("Introduce una opción válida");
                }
            }

        } while (opcion != OPCION_SALIR);

    }

}