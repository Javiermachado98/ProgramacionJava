package p01Nominas;
import java.util.Scanner;

/*
 * DAW1. Ejemplo Gestión Nóminas
 */

/**
 *daw1
 */
public enum tipoMes {
    NINGUNO,
    ENERO,
    FEBRERO,
    MARZO,
    ABRIL,
    MAYO,
    JUNIO,
    JULIO,
    AGOSTO,
    SEPTIEMBRE,
    OCTUBRE,
    NOVIEMBRE,
    DICIEMBRE;

    /**
     * Devuelve el valor tipoMes correspondiente a la cadena que ha introducido el usuario
     * Debe ir precedido de una sentencia de invitación a que introduzcan un mes
     * Despues, realiza la lectura de un valor de tipo Mes y repite la solicitud hasta que el usuario
     * introduce por teclado un mes válido. 
     * @return tipoMes
     */
    public tipoMes validaMes() {

        Scanner sc = new Scanner(System.in);

        boolean valorValido = false;
        String mesString = sc.next().toUpperCase();

        tipoMes vector[] = tipoMes.values();

        do {
            for (tipoMes vector1 : vector) {
                if (vector1.toString().equals(mesString)) {
                    valorValido = true;
                }
            }
            if (!valorValido) {
                System.out.print("Introduce un valor válido para el mes:");
                mesString = sc.next();
            }
        } while (!valorValido);

        return valueOf(mesString);
    
    }

};
