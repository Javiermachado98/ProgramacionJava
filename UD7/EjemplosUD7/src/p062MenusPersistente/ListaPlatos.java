package p062MenusPersistente;


import java.util.ArrayList;
import java.util.Collections;

public class ListaPlatos  {

    ArrayList<Plato> miListaPlatos = new ArrayList();

    public void anadirPlato(Plato f) {
        miListaPlatos.add(f);
    }

    public int numeroPlatos() {
        return miListaPlatos.size();
    }

    public Plato PlatoPosicionI(int i) {
        return miListaPlatos.get(i);
    }

    public boolean contienePlato(Plato a) {
        return (miListaPlatos.contains(a));
    }

    @Override
    public String toString() {
        return "ListaPlatos{" + miListaPlatos + '}';
    }

    public void muestraPlatos() {
        for (int i = 0; i < miListaPlatos.size(); i++) {
            System.out.println(i + "  " + miListaPlatos.get(i));
        }
    }
    
    
}