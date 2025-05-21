package B_Supermercado;

import java.util.ArrayList;
import java.util.Arrays;

public class ListaEnvases {
    private ArrayList<Envases> listaEnvases;

    public ListaEnvases(ArrayList<Envases> listaEnvases) {
        this.listaEnvases = listaEnvases;
    }

    public void anadirEnvase(Envases env){
        listaEnvases.add(env);
    }

    public void mostrarEnvases(){
        int contadorEnvases = 1;
        for (Envases myenvase : listaEnvases){
            System.out.println(myenvase);
        }
    }
}
