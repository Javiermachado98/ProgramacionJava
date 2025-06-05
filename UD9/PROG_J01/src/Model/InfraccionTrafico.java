package Model;

import java.util.Scanner;

public class InfraccionTrafico extends Infraccion{
    private int puntosAsignados;
    private boolean infraccionPaga;

    public InfraccionTrafico(){
        super();
    }

    public InfraccionTrafico(int idInfraccion, double sancion, TipoGravedadInfraccion gravedad,
                             String descripcion, String dniInfractor){
        super(idInfraccion, sancion, gravedad, descripcion, dniInfractor);
        this.puntosAsignados = puntosAsignados;
        this.infraccionPaga = infraccionPaga;

    }

    public void alta(){
        String temporalMulta;
        Scanner sc = new Scanner(System.in);
        System.out.println("Puntos Asignados");
        this.puntosAsignados = sc.nextInt();

        System.out.println("Realizo el pago antes del tiempo estipulado: \n" +
                "Indique en mayusculas SI o NO");
        temporalMulta = sc.next();
        if (temporalMulta.toLowerCase().equals("si")) infraccionPaga = true;
        else infraccionPaga = false;

        if(infraccionPaga == true){
            double valorTemporal = this.getSancion() / 2;
            setSancion(valorTemporal);
        }
    }

    @Override
    public double getSancion() {
        if(infraccionPaga == true) {
            return this.sancion/2;
        }
        else {
            return super.getSancion();
        }
    }

}


//•el número de puntos asignados a esa infracción, por ser de tráfico.
//•un booleano que indicará si la infracción se ha pagado antes del plazo para tener
//descuento por pronto pago (si esto ocurre, se produce un descuento en el importe de
//la infracción del 50%)
//Se deben realizar las siguientes tareas
//•En el método cargaDatosInicial de Principal.java, crear dos infracciones de tráfico y
//asignarlas a cualquiera de los dos agentes
//•implementar la opción MOSTRAR_INFRACCIONES_TRAFICO que mostrará la
//información sólo las infracciones que sean de tráfico, y no mostrará el resto
//•sobreescribir el método getSancion que devolverá el 50% del importe de la sanción si
//el campo de pronto pago está marcado, y el importe total si no lo está.
//•realizar los cambios necesarios en MOSTRAR_INFRACCIONES_TRAFICO para que se
//muestre el importe real pagado por cada una de las infracciones de tráfico.