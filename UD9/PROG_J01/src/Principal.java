import Controller.ListaAgentes;
import Controller.ListaInfracciones;
import Model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author admin
 */
public class Principal {


    public static String FILE_PATH = "src" + File.separator + "files" + File.separator + "ficheroJSON.txt";
    public static ListaInfracciones miListainfra;

    static ArrayList<Agente> agents = new ArrayList();
    ArrayList<Infraccion> infraccions = new ArrayList();
    public static final int OPCION_MUESTRA_TODAS_MULTAS = 1;
    public static final int OPCION_MUESTRA_MULTAS_AGENTE = 2;
    public static final int OPCION_MUESTRA_RECAUDACION_AGENTE = 3;
    public static final int OPCION_GENERA_NOTIFICACIONES = 4;
    public static final int OPCION_MUESTRA_AGENTE_MAS_MULTAS = 5;
    public static final int OPCION_GUARDAR_INFO_AGENTES_FICHERO = 6;
    public static final int GUARDAR_LISTA_INFRACCIONES_AGENTE = 7;
    public static final int MOSTRAR_INFRACCIONES_TRAFICO = 8;
    public static final int MOSTRAR_INFRACTORES = 9;
    public static final int OPCION_SALIR = 10;

    /**
     *
     */

    public static void mostrarMenu() {
        System.out.println("==================================================");
        System.out.println("  MULTAS  ");
        System.out.println("==================================================");
        System.out.println(" 1.-  MUESTRA TODAS MULTAS");
        System.out.println(" 2.-  MUESTRA MULTAS AGENTE ");
        System.out.println(" 3.-  MUESTRA RECAUDACIÓN AGENTE ");
        System.out.println(" 4.-  MUESTRA AGENTE MAS MULTAS ");
        System.out.println(" 5.-  GENERA NOTIFICACIONES");
        System.out.println(" 6.-  GUARDAR INFO AGENTES FICHERO");
        System.out.println(" 7.-  LISTA INFRACCIONES AGENTE");
        System.out.println(" 8.-  INFRACCIONES TRAFICO ");
        System.out.println("10.-  SALIR");
        System.out.println("==================================================");
        System.out.print("Introduce una opción: ");
    }

    public static void guardaInfoXML() {
        try {
            JAXBContext contexto = JAXBContext.newInstance(ListaInfracciones.class);
            Marshaller m = contexto.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(miListainfra, new FileWriter("empleados2.xml"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void cargaDatosInicial(ListaAgentes misAgentes) {

        DataOutputStream salida;


        Agente a = new Agente("000111", TipoRangoPolicia.AGENTE, "Binéfar");

        Infraccion i1 = new Infraccion(7, 50.0, TipoGravedadInfraccion.LEVE, "Perro mingitando vía pública", "73200100L");
        Infraccion i2 = new Infraccion(8, 100.0, TipoGravedadInfraccion.MEDIA, "Desorden público", "73200100L");
        a.anadirInfraccion(i1);
        a.anadirInfraccion(i2);

        misAgentes.anadirAgente(a);

        Agente a2 = new Agente("0001112", TipoRangoPolicia.INSPECTOR, "Barbastro");

        Infraccion i3 = new Infraccion(9, 150.0, TipoGravedadInfraccion.MUY_GRAVE, "Daño material urbano", "73222000J");
        Infraccion i4 = new Infraccion(10, 200.0, TipoGravedadInfraccion.MEDIA, "Desacato autoridad", "43000000K");
        a2.anadirInfraccion(i3);
        a2.anadirInfraccion(i4);

        misAgentes.anadirAgente(a2);

        InfraccionTrafico infra1 = new InfraccionTrafico(11, 300.0, TipoGravedadInfraccion.MUY_GRAVE, "Exceso de velocidad", "43000111J");
        InfraccionTrafico infra2 = new InfraccionTrafico(12, 400.0, TipoGravedadInfraccion.MUY_GRAVE, "Exceso de velocidad mucho mas", "43232211J");

        a.anadirInfraccion(infra1);
        a.anadirInfraccion(infra2);
        agents.add(a);
        agents.add(a2);

    }

    public static void ficheroCsv(){

        try (PrintWriter pw = new PrintWriter(new FileWriter("src/files/salidaFicheroBueno.csv"))) {
            String encabezado = "idPlaca;Rango;Municipio";
            pw.println(encabezado);
            for (Agente p : agents) {
                pw.println(p.getIdPlaca() + ";" + p.getRango() + ";" + p.getMunicipio());
            }
        } catch (IOException e) {
            System.err.println("Error escribiendo el fichero salidaDatos.txt: " + e.getMessage());
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) {

        ListaAgentes miListaAgentes = new ListaAgentes();
        ListaInfracciones miListaInfracciones = new ListaInfracciones();
        cargaDatosInicial(miListaAgentes);

        Scanner sc;
        int opcion;

        do {
            mostrarMenu();
            sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion) {

                case OPCION_MUESTRA_TODAS_MULTAS -> {
                    miListaInfracciones.mostrarInfracciones();

                }
                case OPCION_MUESTRA_MULTAS_AGENTE -> {
                    System.out.println("Introduce el id de la placa del agente:");
                    int idPlaca = sc.nextInt();


                }
                case OPCION_MUESTRA_RECAUDACION_AGENTE -> {
                    System.out.println("Introduce el id de la placa del agente:");
                    int idPlaca = sc.nextInt();

                }
                case OPCION_MUESTRA_AGENTE_MAS_MULTAS -> {

                }
                case OPCION_GENERA_NOTIFICACIONES -> {

                }
                case OPCION_GUARDAR_INFO_AGENTES_FICHERO -> {
                    ficheroCsv();
                }
                case GUARDAR_LISTA_INFRACCIONES_AGENTE -> {
                    guardaInfoXML();
                }
                case MOSTRAR_INFRACCIONES_TRAFICO -> {

                }
                case MOSTRAR_INFRACTORES -> {

                }
                case OPCION_SALIR -> {
                }
                default -> {
                    System.out.println("Introduce una opción válida");
                }
            }

        } while (opcion != OPCION_SALIR);

    }
}
