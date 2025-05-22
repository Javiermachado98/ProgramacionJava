package B_Supermercado;

import org.w3c.dom.ls.LSOutput;

public class principal {

    public static void main(String[] args) {

        Envases envase1 = new Envases("A322Bolsa", 0.05, tipoEnvase.BOLSA);
        Envases envase2 = new Envases("B123Caja", 0.10, tipoEnvase.CAJA);


        Productos myproducto = new Productos();
        myproducto.setEnvase(envase1);

        myproducto.crearProducto();
        System.out.println(myproducto);


        myproducto.total();

    }

}
