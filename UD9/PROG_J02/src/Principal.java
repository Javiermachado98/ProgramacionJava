import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.*;
import Controller.*;

import java.io.*;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author admin
 */
public class Principal {

    public static final int OPCION_MUESTRA_TODAS_MULTAS = 1;
    public static final int OPCION_MUESTRA_MULTAS_AGENTE = 2;
    public static final int OPCION_MUESTRA_RECAUDACION_AGENTE = 3;
    public static final int OPCION_MUESTRA_AGENTE_MAS_MULTAS = 4;
    public static final int OPCION_GUARDAR_INFO_AGENTES_FICHERO_CVS = 5;
    public static final int GUARDAR_LISTA_INFRACCIONES_AGENTE = 6;
    public static final int MOSTRAR_INFRACCIONES_TRAFICO= 7;
    public static final int MOSTRAR_INFRACTORES = 8;
    public static final int OPCION_SALIR = 9;

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
        System.out.println(" 5.-  GUARDAR INFO AGENTES FICHERO CSV");
        System.out.println(" 6.-  LISTA INFRACCIONES AGENTE XML");
        System.out.println(" 7.-  MOSTRAR_INFRACCIONES_TRAFICO ");
        System.out.println(" 8.-  MOSTRAR_INFRACTORES ");
        System.out.println("9.-  SALIR");
        System.out.println("==================================================");
        System.out.print("Introduce una opción: ");
    }


    /*public static void guardaInfoXML(ListaInfracciones lista) {
        try {
            JAXBContext contexto = JAXBContext.newInstance(Agente.class);
            Marshaller myMarshaller = contexto.createMarshaller();
            myMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            String idBuscado;
            myMarshaller.marshal(lista, new FileWriter("infracciones_agente.xml"));


        } catch (Exception e) {
            System.out.println("Error guardando XML: " + e.getMessage());
        }
    }*/

    public static void guardaInfoXML(ListaInfracciones lista) {
        try {
            JAXBContext context = JAXBContext.newInstance(ListaInfracciones.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Por defecto guarda con un nombre fijo. Puedes modificar para incluir ID del agente si quieres.
            File file = new File("src/files/infracciones.xml");
            marshaller.marshal(lista, file);

        } catch (JAXBException e) {
            e.printStackTrace(); // 👈 Esto ES IMPORTANTE ME DIO LA RESPUESTA CLARA la clase exacta y la línea del error
            System.err.println("Error guardando XML: " + e.getMessage());
        }
    }

    public static void mostrarInfraccionesTrafico(ListaAgentes listaAgentes) {
        // Imprime un título para indicar que se van a mostrar las infracciones de tráfico
        System.out.println("---- INFRACCIONES DE TRÁFICO ----");

        // Recorre la lista de agentes que recibe como parámetro
        for (Agente agente : listaAgentes.getListaAgentes()) {

            // Para cada agente, recorremos la lista de infracciones que ha emitido
            for (Infraccion infraccion : agente.getInfraccionesEmitidas().getListaInfracciones()) {

                // Verificamos si la infracción actual es una instancia de InfraccionTrafico
                // Esto es para filtrar solo las infracciones de tráfico y no mostrar otras
                if (infraccion instanceof InfraccionTrafico) {

                    // Hacemos un casteo de la infracción a InfraccionTrafico para acceder a sus métodos específicos
                    InfraccionTrafico it = (InfraccionTrafico) infraccion;

                    // Imprime el identificador de la infracción
                    System.out.println("ID: " + it.getIdInfraccion());

                    // Imprime la descripción de la infracción
                    System.out.println("Descripción: " + it.getDescripcion());

                    // Imprime el DNI del infractor (persona sancionada)
                    System.out.println("DNI: " + it.getDniInfractor());

                    // Imprime la gravedad de la infracción (leve, media, grave, muy grave)
                    System.out.println("Gravedad: " + it.getGravedad());

                    // Imprime los puntos asignados a la infracción de tráfico
                    System.out.println("Puntos: " + it.getPuntosAsignados());

                    // Indica si la infracción fue pagada pronto para el descuento,
                    // muestra "Sí" si fue pagada a tiempo, "No" en caso contrario
                    System.out.println("Pronto pago: " + (it.isInfraccionPaga() ? "Sí" : "No"));

                    // Muestra la sanción que realmente se pagó, que puede ser
                    // el 50% si se pagó pronto o el importe total si no
                    System.out.println("Sanción real pagada: " + it.getSancion());

                    // Imprime una línea separadora para mejorar la legibilidad
                    System.out.println("----------------------------------");
                }
            }
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
        Infraccion i5 = new Infraccion(15, 999.0, TipoGravedadInfraccion.MUY_GRAVE, "Desacato autoridad", "500000K");
        a2.anadirInfraccion(i3);
        a2.anadirInfraccion(i4);
        a.anadirInfraccion(i5);

        misAgentes.anadirAgente(a2);

        InfraccionTrafico infra1 = new InfraccionTrafico(11, 300.0, TipoGravedadInfraccion.MUY_GRAVE, "Exceso de velocidad", "43000111J",3,true);
        InfraccionTrafico infra2 = new InfraccionTrafico(12, 400.0, TipoGravedadInfraccion.MUY_GRAVE, "Exceso de velocidad mucho mas", "43232211J",4,false);

        a.anadirInfraccion(infra1);
        a2.anadirInfraccion(infra2);



    }




   /* public static void ficheroCsv(ListaAgentes lista) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("src/files/salidaFicheroBueno.csv"))) {
            String encabezado = "idPlaca;Rango;Municipio";
            pw.println(encabezado);

            for (Agente objetoAgente : lista.getListaAgentes()) {
                // si objeto es diferente de vacio
                if (!objetoAgente.getInfraccionesEmitidas().getListaInfracciones().isEmpty()) {
                    pw.println(objetoAgente.getIdPlaca() + ";" + objetoAgente.getRango() + ";" + objetoAgente.getMunicipio());
                }
            }

        } catch (IOException e) {
            System.err.println("Error escribiendo el fichero salidaDatos.txt: " + e.getMessage());
        }
    }*/

    /**
     * @param args
     */
    public static void main(String[] args) {

        ListaAgentes miListaAgentes = new ListaAgentes();
        cargaDatosInicial(miListaAgentes);

        Scanner sc;
        int opcion;

        do {
            mostrarMenu();
            sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion) {

                case OPCION_MUESTRA_TODAS_MULTAS -> {
                    for (int i = 0; i < miListaAgentes.numeroAgentes();i++) {
                        Agente nuevoAgente = miListaAgentes.agentePosicionI(i);
                        System.out.println(nuevoAgente.getInfraccionesEmitidas());
                    }

                    miListaAgentes.mostrarAgentes();

                }
                case OPCION_MUESTRA_MULTAS_AGENTE -> {
                    System.out.println("Introduce el id de la placa del agente:");
                    String placa  = sc.next();
                    miListaAgentes.mostrarInfraccionesAgente(placa);


                }
                case OPCION_MUESTRA_RECAUDACION_AGENTE -> {
                    System.out.println("Introduce el id de la placa del agente:");
                    String placa  = sc.next();
                    miListaAgentes.recaudacionesAgente(placa);

                }
                case OPCION_MUESTRA_AGENTE_MAS_MULTAS -> {
                    miListaAgentes.mostrarAgenteConMasMultas();
                }

                case OPCION_GUARDAR_INFO_AGENTES_FICHERO_CVS -> {
                    miListaAgentes.exportarCSV("src/files/salidaFicheroBueno.csv");
                }
                case GUARDAR_LISTA_INFRACCIONES_AGENTE -> {
                    System.out.print("Introduce el ID de la placa del agente: ");
                    String placa = sc.next();
                    Agente agente = miListaAgentes.buscarAgentePorPlaca(placa);

                    if (agente != null) {
                        if (!agente.getInfraccionesEmitidas().getListaInfracciones().isEmpty()) {
                            ListaInfracciones lista = new ListaInfracciones();
                            lista.setListaInfracciones(agente.getInfraccionesEmitidas().getListaInfracciones());

                            guardaInfoXML(lista);
                            System.out.println("Infracciones guardadas en XML");
                        } else {
                            System.out.println("Este agente no tiene infracciones");
                        }
                    } else {
                        System.out.println("Agente no encontrado");
                    }
                }
                case MOSTRAR_INFRACCIONES_TRAFICO -> {
                    mostrarInfraccionesTrafico(miListaAgentes);
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


      /*  xml llamandolo desde agente
      case GUARDAR_LISTA_INFRACCIONES_AGENTE -> {
            System.out.print("Introduce el ID de la placa del agente: ");
            String placa = sc.next();
            Agente agente = miListaAgentes.buscarAgentePorPlaca(placa);

            if (agente != null) {
                agente.exportarInfraccionesXML("src/files/infracciones_" + placa + ".xml");
            } else {
                System.out.println("Agente no encontrado");
            }
        };*/

    }
}
