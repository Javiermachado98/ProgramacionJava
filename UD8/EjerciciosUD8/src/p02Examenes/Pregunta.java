package p02Examenes;

import java.util.Scanner;

/**
 *
 * @author DAW1
 */
public class Pregunta {

    private int idPregunta;
    private String titulo;
    private String texto;
    private String respuesta;
    private double maxPuntos;

    private static int idPreguntaMax;

    public Pregunta() {
    }

    public Pregunta(int idPregunta, String titulo, String texto, String respuesta, double maxPuntos) {
        this.idPregunta = idPregunta;
        this.titulo = titulo;
        this.texto = texto;
        this.respuesta = respuesta;
        this.maxPuntos = maxPuntos;
        if (this.idPregunta > idPreguntaMax) idPreguntaMax = idPregunta;
    }

    /**
     * @return the idPregunta
     */
    public int getIdPregunta() {
        return idPregunta;
    }

    /**
     * @param idPregunta the idPregunta to set
     */
    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
        if (this.idPregunta > idPreguntaMax) idPreguntaMax = idPregunta;     
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the respuesta
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    /**
     * @return the maxPuntos
     */
    public double getMaxPuntos() {
        return maxPuntos;
    }

    /**
     * @param maxPuntos the maxPuntos to set
     */
    public void setMaxPuntos(double maxPuntos) {
        this.maxPuntos = maxPuntos;
    }

    @Override
    public String toString() {
        return "Pregunta: " + "idPregunta=" + idPregunta + ", titulo=" + titulo + ", texto=" + texto + ", respuesta=" + respuesta + ", maxPuntos=" + maxPuntos;
    }

    public void alta() {
        Scanner sc = new Scanner(System.in);
        System.out.print("T�tulo de la pregunta: ");       this.titulo = sc.nextLine();
        System.out.print("Texto de la pregunta: ");        this.texto = sc.nextLine();
        System.out.print("Respuesta de la pregunta: ");    this.respuesta = sc.nextLine();
        System.out.print("Puntos de la pregunta: ");       this.maxPuntos = sc.nextDouble();
        idPreguntaMax++;
        this.idPregunta = idPreguntaMax;
        
    }

}
