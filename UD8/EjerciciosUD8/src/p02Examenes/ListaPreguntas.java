package p02Examenes;
import java.util.ArrayList;

/*
 * Clase gesti�n de lista de Preguntas
 */

/**
 *
 * @author admin DAW2
 */
public class ListaPreguntas {

    private ArrayList<Pregunta> arrayListPreguntas;

    public ListaPreguntas() {
        arrayListPreguntas = new ArrayList();
    }

    public void anadirPregunta(Pregunta p) {
        arrayListPreguntas.add(p);
    }
    
    public void anadirPregunta() {
        Pregunta p = new Pregunta();
        p.alta();
        arrayListPreguntas.add(p);
    }

    public void listarPreguntas() {
        for (Pregunta p : arrayListPreguntas) {
            System.out.println(p);
        }
    }

    public int numeroPreguntas() {
        return (arrayListPreguntas.size());
    }

    @Override
    public String toString() {
        String resultado = "Preguntas: \n";
        for (Pregunta p : arrayListPreguntas) {
            resultado = resultado + " " + p + "\n"; 
        }
        return resultado;
    } 

}
