package Model;

import java.util.Scanner;

public class InfraccionTrafico extends Infraccion{

    protected int puntosAsignados;
    protected boolean infraccionPaga;

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


}

