package Model;

import Controller.*;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 *
 * @author admin
 */

@XmlRootElement(name = "agente")
@XmlType(propOrder = {"idPlaca", "rango", "municipio", "infraccionesEmitidas"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Agente {

    @XmlElement(name = "idPlaca")
    private String idPlaca;
    @XmlElement(name = "rango")
    private TipoRangoPolicia rango;
    @XmlElement(name = "municipio")
    private String municipio;
    @XmlElement(name = "infraccionesEmitidas")
    private ListaInfracciones infraccionesEmitidas = new ListaInfracciones();

    public void setInfraccionesEmitidas(ListaInfracciones infraccionesEmitidas) {
        this.infraccionesEmitidas = infraccionesEmitidas;
    }

    /**
     * Constructor sin parámetros
     */
    public Agente() {
    }

    /**
     * Constructor con parámetros
     */
    public Agente(String idPlaca, TipoRangoPolicia rango, String municipio) {
        this.idPlaca = idPlaca;
        this.rango = rango;
        this.municipio = municipio;
    }

    public ListaInfracciones getInfraccionesEmitidas() {
        return infraccionesEmitidas;
    }

    /**
     * @return the idPlaca
     */
    public String getIdPlaca() {
        return idPlaca;
    }

    /**
     * @param idPlaca the idPlaca to set
     */
    public void setIdPlaca(String idPlaca) {
        this.idPlaca = idPlaca;
    }

    /**
     * @return the rango
     */
    public TipoRangoPolicia getRango() {
        return rango;
    }

    /**
     * @param rango the rango to set
     */
    public void setRango(TipoRangoPolicia rango) {
        this.rango = rango;
    }

    /**
     * @return the municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void anadirInfraccion(Infraccion in) {
        infraccionesEmitidas.anadirInfraccion(in);
    }
/* infracciones desde la misma clase agente
public void exportarInfraccionesXML(String ruta) {
    if (this.getInfraccionesEmitidas().getLista().isEmpty()) {
        System.out.println("Este agente no tiene infracciones para guardar.");
        return;
    }

    try {
        JAXBContext context = JAXBContext.newInstance(ListaInfracciones.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        ListaInfracciones lista = new ListaInfracciones();
        lista.setListaInfracciones(this.getInfraccionesEmitidas().getLista());

        marshaller.marshal(lista, new File(ruta));
        System.out.println("Infracciones exportadas a XML: " + ruta);

    } catch (JAXBException e) {
        System.err.println("Error al guardar infracciones en XML: " + e.getMessage());
    }
}*/
    @Override
    public String toString() {
        return "Agente{" +
                "idPlaca='" + idPlaca + '\'' +
                ", rango=" + rango +
                ", municipio='" + municipio + '\'' +
                ", infraccionesEmitidas=" + infraccionesEmitidas +
                '}';
    }
}
