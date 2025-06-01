package Listas;

import Base.*;

import java.util.ArrayList;

public class ListaAsignacionesLicencias {

    ArrayList<AsignacionLicencia> arrayListAsignacionesLicencias = new ArrayList();
    
    public ListaAsignacionesLicencias() {
    }
    
    public int nAsignacionLicenciaes() {
        return arrayListAsignacionesLicencias.size();
    }
    
    public void anadirAsignacionLicencia(AsignacionLicencia p) {
        arrayListAsignacionesLicencias.add(p);
    }
    
    public AsignacionLicencia AsignacionLicenciaPosicion(int posicion) {
        return arrayListAsignacionesLicencias.get(posicion-1);
    }
    
    public void mostrarLista() {
        int contador = 1;
        for (int i = 0; i < arrayListAsignacionesLicencias.size(); i++) {
            AsignacionLicencia al = arrayListAsignacionesLicencias.get(i);
            LicenciaSoftware ls = al.getLicencia();
            Usuario u = al.getUsuario();
            System.out.println(contador + " " + "Base.Usuario: " + u.getDNI() + " Licencia: " + ls.getAplicacion() + " --- " + ls.getNumero());
            contador++;
        }
    }

    // Devuelve el número de licencias que caducan este año
    public int nLicenciasCaducanEsteAnyo (int esteAnyo) {
        int nLicencias = 0;
        // Pasamos por cada asignación, extraemos el año y si coincide sumamos la variable
        for (AsignacionLicencia a : arrayListAsignacionesLicencias) {
            if (a.getFechaExpiracion().getYear() == esteAnyo) nLicencias++;
        }
        // Devolvemos el número de licencias que caducan este año
        return nLicencias;
    }

    // Devuelve el número de veces que una licencia está asignada
    public int nVecesAsignada(LicenciaSoftware licencia) {
        int nVecesAsignada = 0;
        // Pasamos por cada asignación, si coincide con la licencia, sumamos a la variable
        for (AsignacionLicencia a: arrayListAsignacionesLicencias) {
            if (a.getLicencia() == licencia) {
                nVecesAsignada++;
            }
        }
        // Devolvemos el número de veces asignada
        return nVecesAsignada;
    }
}