import java.util.ArrayList;

public class ListaProductos {

    private ArrayList<Producto> arrayListProducto = new ArrayList();

    // Crear lista productos

    public void listaProducto() {
        arrayListProducto = new ArrayList();  // aqui se crea mi arreglo
    }

    // Agregar productos al arreglo

    public void agregarProducto(Producto p) {
        arrayListProducto.add(p); // agrego un producto a mi arreglo
    }

    // Mostrar productos del arreglo

    public void mostrarProductos() {
        if (arrayListProducto.isEmpty()) {
            System.out.println("la lista esta vacia");
        } else {
            for (Producto p : arrayListProducto) {
                System.out.println(p);
            }
        }
    }


}