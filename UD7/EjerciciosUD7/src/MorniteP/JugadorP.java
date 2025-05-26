package MorniteP;


import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class JugadorP implements Serializable {

    private String nombre;
    private int NivelExperiencia;
    private ListaArmasP ArrayArmas;
    private String estiloJuego;
    private int valorDeVida;

    /// inicialaremos a 100 luego
    /// CONSTRUCTOR SIN DATOS
    public JugadorP() {
        ArrayArmas = new ListaArmasP();
        this.valorDeVida = 100;

    }
    //CONSTRUCTOR CON DATOS


    public JugadorP(String nombre, int nivelExperiencia, String estiloJuego, int valorDeVida) {
        this.nombre = nombre;
        NivelExperiencia = nivelExperiencia;
        ArrayArmas = new ListaArmasP();
        this.estiloJuego = estiloJuego;
        this.valorDeVida = valorDeVida;
    }



    /// NETODO---GET---///
    public String getNombre() {
        return nombre;
    }

    public int getNivelExperiencia() {
        return NivelExperiencia;
    }

    public ListaArmasP getArrayArmas() {
        return ArrayArmas;
    }


    /// NETODO ----SET---///
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivelExperiencia(int nivelExperiencia) {
        NivelExperiencia = nivelExperiencia;
    }

    public void setArrayArmas(ListaArmasP arrayArmas) {
        ArrayArmas =new ListaArmasP();
    }

    public void setEstiloJuego(String estiloJuego) {
        this.estiloJuego = estiloJuego;
    }

    public void setValorDeVida(int valorDeVida) {
        this.valorDeVida = valorDeVida;
    }


    /// METODO PARA DAR DE ALTA
    public void AltaJugador() {
        Scanner sc = new Scanner(System.in);
        System.out.print("introduce el nombre del jugador: ");
        this.nombre = sc.next();
        System.out.print("introduce el nivel experiencia: ");
        this.NivelExperiencia = sc.nextInt();
        System.out.print("introduce el estilo de juego (agresivo, defensivo, estratégico):");
        this.estiloJuego = sc.next();
        System.out.print("introduce el valor de vida: ");
        this.valorDeVida = sc.nextInt();

    }

    /// metodo para anadir un arma al jugador
    public void anadirArma(ArmaP arma) {
        arma.AltaArma();

        System.out.println("arma anadidida con exito ");
    }


    /// metodo para sumar el dano de todas las armas que tenga el jugador en su inventario
    public int sumaDanos() {
        int sumaTodasArmas = 0;
        for (int i = 0; i < ArrayArmas.nArmas(); i++) {

            sumaTodasArmas += ArrayArmas.armaPosicion(i).getDannio();//sumamos el dano de todas las armas de esa lista especifica
        }
        return sumaTodasArmas;
    }

    /// metodo para restar la vida
    public void restaVida(int disminuir) {
        ///hacemos una simple comporbacion

        if (disminuir > valorDeVida) {
            System.out.println("no puedes restar mas vida de la que tienes");
        } else {
            ///ahora el coidgo restara el valor de la vida a un jugador
            this.valorDeVida -= disminuir;
            System.out.println("el valor de vida restante es :" + valorDeVida);
        }
    }

    /// METODO PARA HACER EL COMBATE ENTRE JUGADORES
    public void combate(JugadorP contrincante) {
        //comparar el valor de dano de jugador y contrincante
        int jugador = this.sumaDanos();///trabajamos sobre el jugador de esta clase
        ///lo sabemos al poner /THIS/
        int contrincantedano = contrincante.sumaDanos();

        ///hacemos la comparacion de danos
        if (jugador < contrincantedano) {
            this.restaVida(20);///disminuimos la voda al jugador
            System.out.println("el jugador ha perdido .vida restante " + this.valorDeVida);
        } else if (jugador > contrincantedano) {
            contrincante.restaVida(20);
            System.out.println("el contrincante ha perdido.Vida restante : " + contrincante.valorDeVida);
        } else {
            System.out.println("el combate ha acabado en  un empate ");
        }
    }

    /// METODO TO-STRING
    @Override
    public String toString() {
        return "JugadorP{" +
                "nombre='" + nombre + '\'' +
                ", NivelExperiencia=" + NivelExperiencia +
                ", ArrayArmas=" + ArrayArmas +
                ", estiloJuego='" + estiloJuego + '\'' +
                ", valorDeVida=" + valorDeVida +
                '}';
    }
}
