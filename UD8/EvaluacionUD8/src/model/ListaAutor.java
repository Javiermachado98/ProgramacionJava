package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaAutor implements Serializable {

    private ArrayList<Autor> lista;

    public ListaAutor() {
        lista = new ArrayList();
    }

    public void anadirAutor (Autor a){
        lista.add(a);
    }

    public void mostrarAutor(){
        int contador = 1;
        for (Autor e : lista) {
            System.out.println(contador + " " + e);
            contador++;
        }
    }

    public Autor devuelveEmpleadoDNI (String dni) {
        for (Autor e: lista) {
            if (e.getDNI().equals(dni)) {
                return e;
            }
        }
        System.out.println("No se ha encontrado autor con ese DNI");
        return null;
    }



}
