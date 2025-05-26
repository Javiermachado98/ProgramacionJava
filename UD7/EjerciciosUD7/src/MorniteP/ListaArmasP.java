package MorniteP;

import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.ArrayList;

@XmlRootElement(name = "listaArmas") // El elemento raíz se llamará listaarmas
@XmlType(propOrder = {"ListaArmas"})//ORDEN
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaArmasP implements Serializable {
    @XmlElement(name = "ArmaP")////CORRESPONDE A LA RAIZ DE LA CLASE DE EMPLEADO .IGUALES

    private ArrayList<ArmaP> ListaArmas;

    //CONSTRUCTOR CON EL ARRAY
    public ListaArmasP() {
        ListaArmas = new ArrayList<>();
    }

    /// MOSTRAR EL NUMERO DE ARMAS EN LA LISTA
    public int nArmas() {
        return ListaArmas.size();

    }
    /// ANADIR ARMA A A LA LISTA
    public void anadirArma() {
        ArmaP P = new ArmaP();
        P.AltaArma();
        ListaArmas.add(P);
        System.out.println("arma añadidda con exito ");

    }

    /// ACCEDER A LA POSICION DE UNA ARMA
    public ArmaP armaPosicion(int posicion) {
        return ListaArmas.get(posicion);
    }

    /// MOSTRAR ARMAS CON SU NUMERO DE ORDENEN LA LISTA
    public void mostrarArmasOrden() {
        if (ListaArmas.isEmpty()) {
            System.out.println("no hay armas almacenadas");
        } else {
            for (int i = 0; i < ListaArmas.size(); i++) {
                System.out.println("arma posicion : " + (i + 1) + "Nombre" + ListaArmas.get(i).getNombre() + "" + ListaArmas.get(i).getDannio());
            }
        }
    }

    /// además una operación sumaDaños que
    /// devolverá una suma de los daños de todas las armas de la lista de armas.
    public int SumaDanos() {
        int suma = 0;
        if (ListaArmas.isEmpty()) {
            System.out.println("no hay armas almacenadas");
        } else {
            for (int i = 0; i < ListaArmas.size(); i++) {
                suma += ListaArmas.get(i).getDannio();
            }
        }
        return suma;
    }


}
