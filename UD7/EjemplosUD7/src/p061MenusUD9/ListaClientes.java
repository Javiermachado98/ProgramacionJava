package p061MenusUD9;


import java.util.ArrayList;

public class ListaClientes {
 
    ArrayList<Cliente> miListaClientes = new ArrayList();
    
    public void anadirCliente (Cliente f) {
        miListaClientes.add(f);
    }
    
    public int numeroClientes() {
        return miListaClientes.size();
    }
    
    public Cliente ClientePosicionI(int i) {
        return miListaClientes.get(i);
    }
    
    public boolean contieneCliente (Cliente a) {
        return (miListaClientes.contains(a));
    }
    
    public void muestraClientes() {
        for (int i = 0; i < miListaClientes.size();i++) {
            System.out.println(i + "  " + miListaClientes.get(i));
        }
    }

    @Override
    public String toString() {
        return "ListaClientes{" + miListaClientes + '}';
    }
    
    
    
}