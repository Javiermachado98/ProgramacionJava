package Listas;

import Base.*;

import Base.LicenciaSoftware;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaLicenciasSoftware {

    ArrayList<LicenciaSoftware> arrayListLicenciasSoftware = new ArrayList();

    public ListaLicenciasSoftware() {
    }

    public int nLicenciasSoftware() {
        return arrayListLicenciasSoftware.size();
    }

    public void anadirLicenciaSoftware(LicenciaSoftware p) {
        arrayListLicenciasSoftware.add(p);
    }

    public LicenciaSoftware LicenciaSoftwarePosicion(int posicion) {
        return arrayListLicenciasSoftware.get(posicion-1);
    }

    public void mostrarLista() {
        int contador = 1;
        for (int i = 0; i < arrayListLicenciasSoftware.size(); i++) {
            System.out.println(contador + " " + arrayListLicenciasSoftware.get(i));
            contador++;
        }
    }

    // Muestra las licencias de una aplicación
    public void muestraLicenciasSoftware(String nombre) {
        for (LicenciaSoftware l : arrayListLicenciasSoftware) {
            if (l.getAplicacion().equals(nombre)) System.out.println(l);
        }
    }

    // Muestra una lista de licencias no asignadas a nadie
    public void mostrarLicenciasNoAsignadas(ListaAsignacionesLicencias asignaciones) {
        for (LicenciaSoftware l : arrayListLicenciasSoftware) {
            if (asignaciones.nVecesAsignada(l) == 0) System.out.println(l);
        }
    }

    // Muestra una lista de las licencias asignadas más de una vez
    public void mostrarLicenciasMasDeUna(ListaAsignacionesLicencias asignaciones) {
        for (LicenciaSoftware l : arrayListLicenciasSoftware) {
            if (asignaciones.nVecesAsignada(l) > 1) System.out.println(l);
        }
    }

    // Muestra las licencias usando un iterador
    public void mostrarListaIterador() {
        int contador = 1;

        Iterator<LicenciaSoftware> it = arrayListLicenciasSoftware.iterator();
        LicenciaSoftware licencia;

        while (it.hasNext()) {
            licencia = it.next();
            System.out.println(contador + " " + licencia);
            contador++;
        }
    }
}