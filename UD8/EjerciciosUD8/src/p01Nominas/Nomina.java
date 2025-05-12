package p01Nominas;
import java.io.Serializable;
import java.util.Scanner;

/*
 * DAW1. Ejemplo Gestión Nóminas
 */

/**
 * Clase nómina
 */
public class Nomina implements Serializable{

    private float importe;
    private int anno;
    private tipoMes mes = tipoMes.NINGUNO;



    public Nomina(float importe, int anno, tipoMes mes) {
        this.importe = importe;
        this.mes = mes;
        this.anno = anno;

    }

    public Nomina() {

    }


    /**
     * @return the importe
     */
    public float getImporte() {
        return importe;
    }

    /**
     * @param importe the importe to set
     */
    public void setImporte(float importe) {
        this.importe = importe;
    }

    /**
     * @return the anno
     */
    public int getAnno() {
        return anno;
    }

    /**
     * @param anno the anno to set
     */
    public void setAnno(int anno) {
        this.anno = anno;
    }

    /**
     * @return the mes
     */
    public tipoMes getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(tipoMes mes) {
        this.mes = mes;
    }
    
    /**
     * Solicita los valores para inicializar los atributos del objeto
     */
    public void alta() {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Alta de nómina:");
        System.out.print("Importe: ");       importe = sc.nextInt();
        System.out.print("Año: ");      anno = sc.nextInt();
        System.out.print("Mes:");       mes = mes.validaMes();

    }
    
    /**
     * Muestra la información básica de una nómina
     * @return
     */
    @Override
    public String toString() {
        return "Nomina{" + "importe=" + importe + ", anno=" + anno + ", mes=" + mes + '}';
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Nomina miNomina = new Nomina();
        miNomina.alta();
        System.out.println(miNomina);
    }
    
    
}
