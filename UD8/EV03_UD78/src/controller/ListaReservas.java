package controller;

import model.Parcela;
import model.Reserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import model.Parcela;

import Principales.PrincipalJDBC;

public class ListaReservas {

    List<Reserva> arrayListReservas = new ArrayList();

    /**
     * Crea una lista de Reservas
     */
    public ListaReservas() {

    }

    /**
     * @return el número de Reservas de la lista
     */
    public int nReservas() {
        return arrayListReservas.size();
    }

    /**
     * Pedimos los datos y añadimos un Reserva al final de la lista
     */
    public void anadirReserva(ListaParcelas listaParcelas) {
        Reserva nuevaReserva = new Reserva();

        Scanner sc = new Scanner(System.in);

        System.out.println("\n========Datos de la reserva=====");

        listaParcelas.mostrarLista();
        System.out.print("Selecciona el número de parcela sobre el que quieres hacer la reserva: ");

        int nParcela = sc.nextInt();
        sc.nextLine();
        if (nParcela >= 1 && nParcela <= listaParcelas.nParcelas()) {
            nuevaReserva.setParcela(listaParcelas.parcelaPosicion(nParcela));

            System.out.print("Nombre de la jaima: ");
            String nombre = sc.nextLine();
            nuevaReserva.setNombre(nombre);

            System.out.print("Nombre de la asociación: ");
            String nombreAsociacion = sc.nextLine();
            nuevaReserva.setAsociacion(nombreAsociacion);

            System.out.print("DNI del responsable: ");
            String DNIResponsable = sc.nextLine();
            nuevaReserva.setDNIResponsable(DNIResponsable);

            System.out.print("DNI de quien guarda las llaves: ");
            String DNIGuardaLlaves = sc.nextLine();
            nuevaReserva.setDNIGuardaLlaves(DNIGuardaLlaves);

            //this.anadirReserva(nuevaReserva);

            try (Connection conexion = PrincipalJDBC.connectMyDatabase()) {


                String CheckHabitante = "SELECT * FROM Habitantes where DNI = ?";
                PreparedStatement psCheck = conexion.prepareStatement(CheckHabitante);
                psCheck.setString(1, DNIResponsable);
                ResultSet rs = psCheck.executeQuery();
                rs.next();

                revisionDni();

                if (rs.getString(1).equals(nuevaReserva.getDNIResponsable()) || rs.getString(1).equals(nuevaReserva.getDNIGuardaLlaves())){

                    String sqlInsertar = "INSERT INTO Reservas (idparcela, nombrejaima, nombreasociacion, dniresponsable, dniguardallaves) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement psReserva = conexion.prepareStatement(sqlInsertar);
                    psReserva.setString(1, String.valueOf(nParcela));
                    psReserva.setString(2, nombre);
                    psReserva.setString(3, nombreAsociacion);
                    psReserva.setString(4, DNIResponsable);
                    psReserva.setString(5, DNIGuardaLlaves);
                    psReserva.executeUpdate();
                    System.out.println("se agrego reserva");
                }
                else {
                    System.out.println("no se agrego la reserva");
                }


                listaParcelas.parcelaPosicion(nParcela);
                System.out.println("posicion"+listaParcelas.parcelaPosicion(nParcela));






            } catch (SQLException e) {
                System.out.println("Error al guardar en la base de datos: " + e.getMessage());
            }


        } else {
            System.out.println("Número de parcela no válido");
        }

    }

    public void revisionDni(){

        Scanner sc = new Scanner(System.in);
        String patron = "^\\d{8}[J]$";
        System.out.println("Ingrese DNI");
        String DNI = sc.next();
        if(DNI.matches(patron)){
            System.out.println("DNI, Acertado");
        }
    }

    /**
     * Añadimos un Reserva al final de la lista
     *
     * @param p
     */
    public void anadirReserva(Reserva p) {
        arrayListReservas.add(p);
    }


    /**
     * Muestra todos los Reservas de la lista
     */
    public void mostrarLista() {
        for (int i = 0; i < arrayListReservas.size(); i++) {
            System.out.println(arrayListReservas.get(i));
        }
    }

}
