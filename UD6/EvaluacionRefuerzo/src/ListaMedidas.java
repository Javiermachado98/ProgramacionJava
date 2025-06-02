import java.util.ArrayList;

public class ListaMedidas {

    ArrayList<Medida> arrayListMedida = new ArrayList();

    public ListaMedidas(){

    }

    public int numMedida(){return arrayListMedida.size(); }

    public void anadirMedida(Medida m){arrayListMedida.add(m); }

    public Medida MedidaPosicion(int posicion){
        return arrayListMedida.get(posicion-1);
    }

    public void mostrarLista(){
        int contador = 1;
        for(int i = 0; i < arrayListMedida.size(); i++){
            System.out.println(contador + " " + arrayListMedida.get(i));
            contador++;
        }
    }

}
