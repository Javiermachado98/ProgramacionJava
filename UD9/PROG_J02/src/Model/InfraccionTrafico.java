package Model;

import java.util.Scanner;

public class InfraccionTrafico extends Infraccion{

    protected int puntosAsignados;
    protected boolean infraccionPaga;

    public InfraccionTrafico(){
        super();
    }

    public InfraccionTrafico(int idInfraccion, double sancion, TipoGravedadInfraccion gravedad,
                             String descripcion, String dniInfractor, int puntosAsignados, boolean infraccionPaga){

        super(idInfraccion, sancion, gravedad, descripcion, dniInfractor);
        this.puntosAsignados = puntosAsignados;
        this.infraccionPaga = infraccionPaga;

    }

    public int getPuntosAsignados() {
        return puntosAsignados;
    }

    public void setPuntosAsignados(int puntosAsignados) {
        this.puntosAsignados = puntosAsignados;
    }

    public boolean isInfraccionPaga() {
        return infraccionPaga;
    }

    public void setInfraccionPaga(boolean infraccionPaga) {
        this.infraccionPaga = infraccionPaga;
    }
/*public void alta(){
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
    }*/

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

