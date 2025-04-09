package p061MenusUD9;


import java.util.Scanner;


/**
 *
 * @author admin
 */
public enum tipoAlergeno {
    GLUTEN, CRUSTACEOS, HUEVOS, PESCADO, CACAHUETES, SOJA, LACTEOS, CASCARA, APIO, MOSTAZA, SESAMO, SULFITOS, ALTRAMUCES, MOLUSCOS, NINGUNO;
    
    public void muestraAlergenos() {
        System.out.println("Lista de alérgenos-------------->");
        System.out.println(" - GLUTEN            - CASCARA");
        System.out.println(" - CRUSTACEOS        - APIO");
        System.out.println(" - HUEVOS            - MOSTAZA");
        System.out.println(" - PESCADO           - SÉSAMO");
        System.out.println(" - CACAHUETES        - SULFITOS");
        System.out.println(" - SOJA              - ALTRAMUCES");
        System.out.println(" - LACTEOS           - MOLUSCOS");
    }

            
            
    public tipoAlergeno validaAlergeno() {

        Scanner sc = new Scanner(System.in);
        boolean valorValido = false;
        muestraAlergenos();
        System.out.print("Introduce un valor válido para el alergeno:");
        String alergenoString = sc.next().toUpperCase();

        tipoAlergeno vector[] = tipoAlergeno.values();

        do {
            for (tipoAlergeno vector1 : vector) {
                if (vector1.toString().equals(alergenoString)) {
                    valorValido = true;
                }
            }
            if (!valorValido) {
                System.out.print("Introduce un valor válido para el alergeno:");
                alergenoString = sc.next();
            }
        } while (!valorValido);

        return valueOf(alergenoString);
    
    }        
    
    
}
