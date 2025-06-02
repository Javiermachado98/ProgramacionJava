package Ejemplos;

import java.util.ArrayList;
import java.util.HashMap;

public class Principal {

    public static void main(String[] args) {

        //El hashmap guarda informacion, pero no tiene indices, se le pueden crear indices
        HashMap<String,String> Mascotitas = new HashMap<>();
        Mascotitas.put("benji","perro");
        Mascotitas.put("sakura", "gato");
        Mascotitas.put("firulais","perro");

        //le declaro indices al hashmap, para poder recorrerlo
        ArrayList<String> claves = new ArrayList<>(Mascotitas.keySet());

        System.out.println(Mascotitas);
        for (int i = 0; i < claves.size(); i++){
            String myclave = claves.get(i);
            String valor = Mascotitas.get(myclave);
            System.out.println(myclave);
            System.out.println(valor);

        }
    }
}
