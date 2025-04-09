package p07XML;

import java.io.FileWriter;
import java.io.Serializable;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import javax.xml.bind.annotation.*;

/*
 * DAW1. Ejemplo Gestión Nóminas
 */
/**
 * Clase para almacenar un empleado y sus nóminas
 */
@XmlRootElement(name = "empleado") 
@XmlType(propOrder = {"nombre", "apellidos", "DNI", "miListaNominas"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Empleado implements Serializable {

    @XmlElement(name = "nombre")
    private String nombre;
    @XmlElement(name = "apellidos")
    private String apellidos;
    @XmlAttribute(name = "DNI", required = true)
    private String DNI;
    @XmlElement(name = "nominas")
    private ListaNominas miListaNominas;

    public Empleado(String nombre, String apellidos, String DNI) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        miListaNominas = new ListaNominas();
    }

    
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * @param DNI the DNI to set
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Constructor de empleado
     */
    public Empleado() {
        miListaNominas = new ListaNominas();
    }

    /**
     * Solicita por teclado valores para los atributos
     */
    public void alta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Alta de empleado:");
        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        System.out.print("Apellidos: ");
        apellidos = sc.nextLine();
        System.out.print("DNI:");
        DNI = sc.nextLine();
    }

    /**
     *
     * @return cadena con atributos del objeto
     */
    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", DNI=" + DNI + '}';
    }

    /**
     * Añade la nómina que se pasa como parámetro a la lista de nóminas del
     * empleado
     *
     * @param n
     */
    public void anadirNominaEmpleado(Nomina n) {
        miListaNominas.anadirNomina(n);
    }

    /**
     * Muestra todas las nóminas de la lista de nóminas del empleado
     */
    public void muestraNominasEmpleado() {
        miListaNominas.mostrarNominas();
    }

    /**
     * Realiza la suma de los importes de las nóminas de la lista del empleado y
     * la muestra
     */
    public void muestreTotalCobrado() {
        Nomina n;
        double importeTotal = 0;
        for (int i = 0; i < miListaNominas.numeroNominas(); i++) {
            n = miListaNominas.nominaPosicionI(i);
            importeTotal += n.getImporte();
        }
        System.out.println("La suma de los importes: " + importeTotal);
    }

    /**
     * Muestra las nóminas del empleado del mes que se le pasa como parámetro
     *
     * @param mes
     */
    public void muestraNominasMes(tipoMes mes) {
        Nomina nAux;
        for (int i = 0; i < miListaNominas.numeroNominas(); i++) {
            nAux = miListaNominas.nominaPosicionI(i);
            if (nAux.getMes() == mes) {
                System.out.println(nAux);
            }
        }
    }

    /**
     * Muestra las nóminas del empleado cuyo importe es superior al parámetro
     *
     * @param importe
     */
    public void muestraNominasMayoresImporte(double importe) {
        miListaNominas.muestraNomminasMayoresImporte(importe);
    }

    /**
     * Programa principal de pruebas
     *
     * @param args
     */
    public static void main(String[] args) {
        Empleado yo = new Empleado("Modesto", "Sierra", "262723");
        Nomina nominaEnero   = new Nomina (1200, 2022, tipoMes.ENERO);
        Nomina nominaFebrero = new Nomina (1250, 2022, tipoMes.FEBRERO);
        Nomina nominaMarzo   = new Nomina (1150, 2022, tipoMes.MARZO);
        Nomina nominaAbril   = new Nomina (1320, 2022, tipoMes.ABRIL);
        yo.anadirNominaEmpleado(nominaEnero);
        yo.anadirNominaEmpleado(nominaFebrero);
        yo.anadirNominaEmpleado(nominaMarzo);
        yo.anadirNominaEmpleado(nominaAbril);
        
        System.out.println(yo);
        try {
            JAXBContext contexto = JAXBContext.newInstance(Empleado.class);
            Marshaller m = contexto.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(yo, new FileWriter("empleado1.xml"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
