package Model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 *
 * @author admin
 */

@XmlRootElement(name = "infracciones")
@XmlType(propOrder = {"idInfraccion", "sancion", "gravedad", "dniInfractor"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Infraccion implements Serializable {

    @XmlElement(name = "idInfraccion")
    private int idInfraccion;                    // Identificativo único
    @XmlElement(name = "sancion")
    private double sancion;                      // Importe de la multa
    @XmlElement(name = "gravedad")
    private TipoGravedadInfraccion gravedad;     // Gravedad de la infracción
    @XmlElement(name = "descripcion")
    private String descripcion;                  // Descripción
    @XmlAttribute(name = "idInfraccion", required = true)
    private String dniInfractor;                 // Dni del ciudadano multado

    
    /**
    * Constructor con parámetros
    */  
    public Infraccion(int idInfraccion, double sancion, TipoGravedadInfraccion gravedad, String descripcion, String dniInfractor) {
        this.idInfraccion = idInfraccion;
        this.sancion = sancion;
        this.gravedad = gravedad;
        this.descripcion = descripcion;
        this.dniInfractor = dniInfractor;
    }
    public Infraccion(){

    }

    /**
     * @return the idInfraccion
     */
    public int getIdInfraccion() {
        return idInfraccion;
    }

    /**
     * @param idInfraccion the idInfraccion to set
     */
    public void setIdInfraccion(int idInfraccion) {
        this.idInfraccion = idInfraccion;
    }

    /**
     * @return the sancion
     */
    public double getSancion() {
        return sancion;
    }

    /**
     * @param sancion the sancion to set
     */
    public void setSancion(double sancion) {
        this.sancion = sancion;
    }

    /**
     * @return the gravedad
     */
    public TipoGravedadInfraccion getGravedad() {
        return gravedad;
    }

    /**
     * @param gravedad the gravedad to set
     */
    public void setGravedad(TipoGravedadInfraccion gravedad) {
        this.gravedad = gravedad;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the dniInfractor
     */
    public String getDniInfractor() {
        return dniInfractor;
    }

    /**
     * @param dniInfractor the dniInfractor to set
     */
    public void setDniInfractor(String dniInfractor) {
        this.dniInfractor = dniInfractor;
    }

    @Override
    public String toString() {
        return "Infraccion{" + "idInfraccion=" + idInfraccion + ", sancion=" + sancion + ", gravedad=" + gravedad + ", descripcion=" + descripcion + ", dniInfractor=" + dniInfractor + '}';
    }
    
    
       
    
}
