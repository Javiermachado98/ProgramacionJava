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
    @XmlElement(name = "apellidos")
    private TipoRangoPolicia rango;
    @XmlElement(name = "municipio")
    private String municipio;
    private ListaInfracciones infraccionesEmitidas = new ListaInfracciones();

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
