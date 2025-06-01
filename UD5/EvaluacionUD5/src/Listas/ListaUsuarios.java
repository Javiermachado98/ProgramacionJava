package Listas;

import Base.*;

import java.util.ArrayList;
import java.util.Collections;

public class ListaUsuarios {

    ArrayList<Usuario> arrayListUsuarios = new ArrayList();

    public ListaUsuarios() {
    }

    public int nUsuarios() {
        return arrayListUsuarios.size();
    }

    public void anadirUsuario(Usuario p) {
        arrayListUsuarios.add(p);
    }

    public Usuario UsuarioPosicion(int posicion) {
        return arrayListUsuarios.get(posicion-1);
    }

    public void mostrarLista() {
        int contador = 1;
        for (int i = 0; i < arrayListUsuarios.size(); i++) {
            System.out.println(contador + " " + arrayListUsuarios.get(i));
            contador++;
        }
    }

    public void ordenaLista() {
        Collections.sort(arrayListUsuarios);
    }

    // Mostrar solo los alumnos
    public void mostrarAlumnos() {
        for (Usuario u : arrayListUsuarios) {
            if (u.getTipoUsuario() == TipoUsuario.ALUMNO) {
                System.out.println(u);
            }
        }
    }
}