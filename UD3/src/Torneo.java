
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Alumno
 */
public class Torneo {

    public static void main(String[] args) {

        //Variables//
        int PuntosEquipoA = 0;
        int PuntosEquipoB = 0;
        int PuntosEquipoC = 0;
        String añadir;
        int npuntos;
        int PuntosTotalesEquipos = 0;
        //Programa//

        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("Quieres añadir mas puntos ?(si/)");
            añadir = sc.next();
            if (añadir.equalsIgnoreCase("si")) {
                System.out.println("Cuantos puntos ?");
                npuntos = sc.nextInt();
                System.out.println("A que equipo quieres añadir ?(A/B/C)");
                String equipo = sc.next();

                switch (equipo.toUpperCase()) {

                    case "A":
                        PuntosEquipoA += npuntos;
                        System.out.println("puntos totales del equipo A: " + PuntosEquipoA);
                        break;
                    case "B":
                        PuntosEquipoB += npuntos;
                        System.out.println("puntos totales del equipo B: " + PuntosEquipoB);
                        break;
                    case "C":
                        PuntosEquipoC += npuntos;
                        System.out.println("puntos totales del equipo C: " + PuntosEquipoC);
                        break;

                }
                PuntosTotalesEquipos = PuntosEquipoA + PuntosEquipoB + PuntosEquipoC;
                System.out.println("Puntos Totales de los equipos : " + PuntosTotalesEquipos);
            }

        } while (añadir.equalsIgnoreCase("si"));
        System.out.format("Porcentaje de puntos del equipoA: %2.2f %c \n", ((double) PuntosEquipoA / PuntosTotalesEquipos) * 100, '%');
        System.out.format("Porcentaje de puntos del equipoA: %2.2f %c \n", ((double) PuntosEquipoB / PuntosTotalesEquipos) * 100, '%');
      System.out.format("Porcentaje de puntos del equipoA: %2.2f %c \n", ((double) PuntosEquipoC / PuntosTotalesEquipos) * 100, '%');

        if (PuntosEquipoA > PuntosEquipoB && PuntosEquipoC < PuntosEquipoA) {
            System.out.println("el equipo ganador del torneo es el equipo A");

        } else if (PuntosEquipoB > PuntosEquipoA && PuntosEquipoC < PuntosEquipoB) {
            System.out.println("el equipo ganador del torneo es el equipo B");

        } else {
            System.out.println("el equipo ganador del torneo es el equipo C");
        }
    }

}
