package p01Auxiliar;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

/*
 * Clase Persona
 */


/**
 *
 * @author DAW 1
 */
public class Persona implements Comparable , Serializable{
    
    private String nombre;
    private int edad;
    private boolean casado;
    
    
    //Constructor
    /**
     * Constructor sin parámetros: Inicializa objetos de la clase
     */
    public Persona() {
        
    }      
    
    /**
     * Constructor con parámetro nombre y edad
     * @param nombre1 Nombre de la persona
     * @param edad1 Edad de la persona
     */
    public Persona(String nombre1, int edad1) {
        this.nombre = nombre1;
        this.edad = edad1;
    }
    
    /**
     * Constructor con parámetros nombre, edad y estado civil
     * @param nombre1 Nombre de la persona
     * @param edad1 Edad de la persona
     * @param casado1 Estado Civil
     */
    public Persona(String nombre1, int edad1, boolean casado1) {
        this.nombre = nombre1;
        this.edad = edad1;
        this.casado = casado1;
    }    
    
    //
    /**
     * Método 
     */
    public void diHola() {
        System.out.println("Hola");
    }
    
    /**
     *
     * @param palabra
     */
    public void diPalabra(String palabra) {
        System.out.println(palabra);
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre1 
     */
    public void setNombre(String nombre1) {
        this.nombre = nombre1;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    /**
     *
     */
    public void diNombre() {
        System.out.println(this.nombre);
    }
    
    /**
     *
     */
    public void cumplirAnos() {        
        edad = edad+1;
    }
    
    /**
     *
     * @return
     */
    public int anosParaJubilarse() {
        int numeroAnosJubilarse;
        numeroAnosJubilarse = 67-this.edad;
        return(numeroAnosJubilarse);
    }

    /**
     * @return the casado
     */
    public boolean isCasado() {
        return casado;
    }

    /**
     * @param casado the casado to set
     */
    public void setCasado(boolean casado) {
        this.casado = casado;
    }
    
    /**
     *
     */
    public void muestraEstadoCivil() {
        if (casado == true) {
            System.out.println("Está casado");
        }
        else {
            System.out.println("No está casado");
        }
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", casado=" + casado + "}\n";
    }

    @Override 
    /*
    El entero que devuelve este método será el equivalente a objeto1 - objeto2, es decir:
            objeto1.compareTo(objeto2);
                negativo si objeto1 < objeto2
                cero si objeto1 = objeto2
                positivo si objeto1 > objeto2
    */
    
    public int compareTo (Object o) {
        Persona p = (Persona) o;
        return this.edad - p.edad;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.edad != other.edad) {
            return false;
        }
        if (this.casado != other.casado) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    
    

    public void alta() {
        String temporalCasado;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");       nombre = sc.next();
        System.out.print("Edad: ");           edad = sc.nextInt();
        System.out.print("Casado?(S/N): "); temporalCasado = sc.next();
        if (temporalCasado.toLowerCase().equals("s")) casado = true;
        else casado = false;
        //sc.close();
    }
    

    
}
