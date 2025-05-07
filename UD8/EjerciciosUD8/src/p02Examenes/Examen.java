package p02Examenes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/**
 *
 * @author DAW1
 */
public class Examen {
    private int idEnunciado;
    private String asignatura;
    private ListaPreguntas listaPreguntas = new ListaPreguntas();
    
    private static int idEnunciadoMax;

    public Examen() {
        
    }

    public Examen(int idEnunciado, String asignatura) {
        this.idEnunciado = idEnunciado;
        this.asignatura = asignatura;
        if (this.idEnunciado > idEnunciadoMax) idEnunciadoMax = idEnunciado;
    }
    
    /**
     * @return the idEnunciado
     */
    public int getIdEnunciado() {
        return idEnunciado;
    }

    /**
     * @param idEnunciado the idEnunciado to set
     */
    public void setIdEnunciado(int idEnunciado) {
        this.idEnunciado = idEnunciado;
         if (this.idEnunciado > idEnunciadoMax) idEnunciadoMax = idEnunciado;
    }

    /**
     * @return the asignatura
     */
    public String getAsignatura() {
        return asignatura;
    }

    /**
     * @param asignatura the asignatura to set
     */
    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
    
    
    
    public void alta() {
        Scanner sc = new Scanner (System.in);
        System.out.print("Nombre de la asignatura: "); this.asignatura = sc.nextLine();
        idEnunciadoMax++;
        this.idEnunciado = idEnunciadoMax;
    
    }

    
    public void anadirPregunta(Pregunta p) {
        this.listaPreguntas.anadirPregunta(p);
    }

    @Override
    public String toString() {
        return "Examen: " + "idEnunciado=" + idEnunciado + ", asignatura=" + asignatura + "\n" + listaPreguntas;
    }
    
    
    
    
}
