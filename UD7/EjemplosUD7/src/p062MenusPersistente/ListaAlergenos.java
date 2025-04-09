package p062MenusPersistente;


import java.io.Serializable;
import java.util.ArrayList;

public class ListaAlergenos  implements Serializable {
 
    ArrayList<tipoAlergeno> miListaAlergenos = new ArrayList();
    
    public void anadirAlergeno (tipoAlergeno f) {
        miListaAlergenos.add(f);
    }
    
    public int numeroAlergenos() {
        return miListaAlergenos.size();
    }
    
    public tipoAlergeno AlergenoPosicionI(int i) {
        return miListaAlergenos.get(i);
    }
    
    public boolean contieneAlergeno (tipoAlergeno a) {
        return (miListaAlergenos.contains(a));
    }

    @Override
    public String toString() {
        return "ListaAlergenos{" + miListaAlergenos + '}';
    }
    
    
    
}
