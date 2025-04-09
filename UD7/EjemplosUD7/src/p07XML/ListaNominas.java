package p07XML;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/*
 * DAW1. Ejemplo Gestión Nóminas
 */

/**
 * daLista de nóminas
 */
@XmlRootElement(name = "nominas") // El elemento raíz se llamará nomina
@XmlType(propOrder = {"lista"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaNominas implements Serializable{
    @XmlElement(name = "nomina")
    private ArrayList<Nomina> lista;

    /**
     * Contructor
     */
    public ListaNominas() {
        lista = new ArrayList();
    }

    /**
     * Añade la nómina que se le pasa como  parámetro a la lista de nominas
     * @param e
     */
    public void anadirNomina(Nomina e) {
        lista.add(e);
    }

    /**
     * Muestra las nóminas de la lista
     */
    public void mostrarNominas() {
        for (Nomina e : lista) {
            System.out.println(e);
        }

    }

    /**
     * Devuelve el número de nóminas de la lista
     * @return
     */
    public int numeroNominas() {
        return (lista.size());
    }
    
    /**
     * Devuelve la nómina que se encuentra en la posición que se le pasa como parámetro
     * @param i
     * @return
     */
    public Nomina nominaPosicionI(int i) {
        return lista.get(i);
    }
    
    /** 
     * Muestra las nóminas de la lista cuyo importe es superior al parámetro
     * @param importe
     */
    public void muestraNomminasMayoresImporte(double importe) {
        for (Nomina n: lista) {
            if (n.getImporte() > importe) {
                System.out.println(n);
            }
        }
    }
    
}