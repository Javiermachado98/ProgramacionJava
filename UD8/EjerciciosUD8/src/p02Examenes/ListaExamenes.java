package p02Examenes;
import java.util.ArrayList;

/*
 * Clase gesti�n de lista de Examenes
 */

/**
 *
 * @author admin DAW2
 */
public class ListaExamenes {

    private ArrayList<Examen> arrayListExamenes;

    public ListaExamenes() {
        arrayListExamenes = new ArrayList();
    }

    public void anadirExamen(Examen p) {
        arrayListExamenes.add(p);
    }
    
    public void anadirExamen() {
        Examen p = new Examen();
        p.alta();
        arrayListExamenes.add(p);
    }

    public void listarExamenes() {
        for (Examen p : arrayListExamenes) {
            System.out.println(p);
        }
    }

    public int numeroExamenes() {
        return (arrayListExamenes.size());
    }
    
    public Examen examenNumero(int id) {
        Examen eResultado = null;
        for (Examen e : arrayListExamenes) {
            if (e.getIdEnunciado() == id) {
                eResultado = e;
            }
        }
        return eResultado;
    }

    @Override
    public String toString() {
        return "ListaExamenes{" + "arrayListExamenes=" + arrayListExamenes + '}';
    }

}
