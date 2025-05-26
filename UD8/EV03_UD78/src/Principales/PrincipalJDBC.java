package Principales;

import controller.*;
import dao.ParcelaDAO;
import model.Parcela;
import model.Reserva;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class PrincipalJDBC {


    private static final int MENU_MOSTRAR_PARCELAS = 1;
    private static final int MENU_REALIZAR_RESERVA = 2;
    private static final int MENU_MOSTRAR_RESERVAS = 3;
    private static final int MENU_GUARDAR_RESERVAS_TEXTO = 4;
    private static final int MENU_GUARDAR_RESERVAS_XML = 5;
    private static final int MENU_REVISAR_DNI_PROXIMO_ANYO = 6;
    private static final int MENU_SALIR = 7;
    private static final String user = "consultor";
    private static final String password = "consultorpass";
    private static final String myMachine = "localhost";
    private static final String baseDeDatos = "templarios";

    public static ListaReservas miListaReservas;
    public static ListaParcelas miListaParcelas;

    public static Connection connectMyDatabase() {
        Connection con = null;
        String url = "jdbc:mysql://" + myMachine + "/" + baseDeDatos;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la base de datos.");
        }
        return con;
    }

    public static void cargarParcelasEnBD() {
        try (Connection conexion = connectMyDatabase()) {
            miListaParcelas = new ListaParcelas();
            String sqlParcelas = "SELECT * FROM parcelas";
            PreparedStatement psParcelas = conexion.prepareStatement(sqlParcelas);
            ResultSet rsParcelas = psParcelas.executeQuery();

            while (rsParcelas.next()) {

                int numeroParcela = rsParcelas.getInt("numeroParcela");
                double coordenadaX = rsParcelas.getDouble("coordenadaX");
                double coordenadaY = rsParcelas.getDouble("coordenadaY");
                double superficiem2 = rsParcelas.getDouble("superficiem2");
                Parcela myparcela = new Parcela(numeroParcela, coordenadaX, coordenadaY, superficiem2);
                miListaParcelas.anadirParcela(myparcela);
            }

            rsParcelas.close();
            psParcelas.close();

        } catch (SQLException e) {
            System.out.println("Error cargando las parcelas: " + e.getMessage());
        }

    }

    public static void cargarLasReservasEnBD() {

        cargarParcelasEnBD();
        try (Connection conexion = connectMyDatabase()) {
            miListaReservas = new ListaReservas();
            String sqlReservas = "SELECT * FROM Reservas";
            PreparedStatement psReservas = conexion.prepareStatement(sqlReservas);
            ResultSet rsReservas = psReservas.executeQuery();

            while (rsReservas.next()) {

                int idparcela = rsReservas.getInt("idparcela");
                String nombrejaima = rsReservas.getString("nombrejaima");
                String nombreasociacion = rsReservas.getString("nombreasociacion");
                String dniresponsable = rsReservas.getString("dniresponsable");
                String dniguardallave = rsReservas.getString("dniguardallaves");
                System.out.println("" + idparcela + " " + nombrejaima + " " + nombreasociacion + " " + dniresponsable + " " + dniguardallave);


                String sqlParcela = "SELECT * FROM parcelas where numeroParcela = ?";
                PreparedStatement psParcela = conexion.prepareStatement(sqlParcela);
                psParcela.setInt(1,idparcela);
                ResultSet rsParcela = psParcela.executeQuery();

                Parcela myparcela2 = null;
                if (rsParcela.next()){
                    myparcela2 = new Parcela(rsParcela.getInt("numeroParcela"),
                            rsParcela.getDouble("coordenadaX"),
                            rsParcela.getDouble("coordenadaY"),
                            rsParcela.getDouble("superficiem2"));
                }
               Reserva myreserva1 = new Reserva(myparcela2,nombrejaima, nombreasociacion, dniresponsable, dniguardallave);
                miListaReservas.anadirReserva(myreserva1);
            }

            rsReservas.close();
            psReservas.close();

        } catch (SQLException e) {
            System.out.println("Error cargando las parcelas: " + e.getMessage());
        }

    }


    public static void mostrarMenu() {
        System.out.println("=================================");
        System.out.println(" XXIII Homenaje Templario Monzón ");
        System.out.println("=================================");
        System.out.println("1.- Mostrar Parcelas");
        System.out.println("2.- Realizar Reserva");
        System.out.println("3.- Mostrar Reservas");
        System.out.println("4.- Guardar Reservas texto");
        System.out.println("5.- Guardar Reservas XML");
        System.out.println("6.- Revisar DNI Próximo Año");
        System.out.println("7.- Salir");
        System.out.print("Elige una opción:");

    }

    public static void main(String args[]) {

        connectMyDatabase();

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int opcion;

        miListaReservas = new ListaReservas();
        miListaParcelas = new ListaParcelas();


        do {
            mostrarMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case MENU_MOSTRAR_PARCELAS:
                    cargarParcelasEnBD();
                    miListaParcelas.mostrarLista();
                    break;
                case MENU_REALIZAR_RESERVA:
                    miListaReservas.anadirReserva(miListaParcelas);
                    break;
                case MENU_MOSTRAR_RESERVAS:
                    cargarLasReservasEnBD();
                    miListaReservas.mostrarLista();
                    break;
                case MENU_GUARDAR_RESERVAS_TEXTO:
                    break;
                case MENU_GUARDAR_RESERVAS_XML:
                    break;
                case MENU_REVISAR_DNI_PROXIMO_ANYO:
                    miListaReservas.revisionDni();
                    break;
                case MENU_SALIR:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }

        } while (opcion != MENU_SALIR);

    }


}