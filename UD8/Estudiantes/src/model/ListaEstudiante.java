package model;

import java.util.ArrayList;

public class ListaEstudiante {
    private ArrayList<Estudiante> arrayListestudiantes;


    public ListaEstudiante(){
        arrayListestudiantes = new ArrayList();
    }

    public void anadirEstudiante(Estudiante e){
        arrayListestudiantes.add(e);
    }

    public void listarEstudiantes(){
        for (Estudiante e : arrayListestudiantes){
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return "ListaEstudiante{" +
                "arrayListestudiantes=" + arrayListestudiantes +
                '}';
    }
}
