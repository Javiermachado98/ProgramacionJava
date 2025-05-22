import controller.LibreriaController;
import model.ListaLibros;
import model.ListaLibrerias;
import model.Autor;
import model.Libro;
import model.ListaAutor;

import java.sql.*;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;


public class Principal {

    public static ListaAutor listaAutor = new ListaAutor();
    private static Connection conexion;
    private static final String user = "consultor";
    private static final String password = "consultorpass";
    private static final String myMachine = "localhost";
    private static final String baseDeDatos = "barbitania";
    private static ResultSet rs;
    private static Statement sentencia;
    private static String sql;
    private static PreparedStatement ps;

    private static final int MENU_NUEVO_LIBRO = 1;
    private static final int MENU_MOSTRAR_LIBROS = 2;
    private static final int MENU_MOSTRAR_AUTORES_JOVENES = 3;
    private static final int MENU_NUEVA_LIBRERIA = 4;
    private static final int MENU_MOSTRAR_LIBRERIAS = 5;
    private static final int MENU_SALIR = 6;

    public static ListaLibros miListaLibros;
    public static ListaLibrerias miListaLibrerias;

    public static Connection connectMyDatabase(){
        Connection con = null;
        String url = "jdbc:mysql://" + myMachine + "/" + baseDeDatos;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la base de datos.");
        }
        return con;
    }

    public static void cargarMyDatosEnBDMenores(){
        conexion = connectMyDatabase();
        if (conexion == null){
            System.out.println("prueba conexion");
            return;
        }

        try {
            conexion = connectMyDatabase();
            sentencia = conexion.createStatement();
            sql = "SELECT * FROM Autor";
            rs = sentencia.executeQuery(sql);


            while (rs.next()){
                String DNI = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String lugarNacimiento = rs.getString("lugarNacimiento");
                int anioNacimiento = rs.getInt("anioNacimiento");
                String profesion = rs.getString("profesion");
                Autor myautor1 = new Autor(nombre, apellidos, lugarNacimiento, anioNacimiento, profesion, DNI);
                listaAutor.anadirAutor(myautor1);

                int now = 2025;
                anioNacimiento = now - anioNacimiento;
                if (anioNacimiento < 30){
                    System.out.println("Este empleado es menor de 30 años");
                    System.out.println(myautor1.getNombre() + " " + myautor1.getApellidos());

                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Libro cargarMyLibrosEnBD(){

        try {
            conexion = connectMyDatabase();
            sentencia = conexion.createStatement();
            sql = "SELECT * FROM Libro";
            rs = sentencia.executeQuery(sql);
            if (conexion == null){
                System.out.println("prueba conexion");
                return null;
            }

            while (rs.next()){

                String DNI = rs.getString("dniAutor");
                Autor myautor2 = listaAutor.devuelveEmpleadoDNI(DNI);
                if (myautor2 != null){

                    String titulo = rs.getString("titulo");
                    String isbn = rs.getString("isbn");
                    String editorial = rs.getString("editorial");
                    int anioEdicion = rs.getInt("anioEdicion");


                    Libro mylibro = new Libro(titulo, isbn, editorial, anioEdicion, myautor2.getDNI());
                    myautor2.anadirLibroAutor(mylibro);
                    miListaLibros.anadirLibro(mylibro);

                }

            }
            rs.close();
            conexion.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public static void guardarNuevoLibro(Libro l) {


        try {

            conexion = connectMyDatabase();
            sql = "INSERT INTO Libro (isbn, titulo, editorial, anioEdicion, dniAutor) VALUES (?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, l.getIsbn());
            ps.setString(2, l.getTitulo());
            ps.setString(3, l.getEditorial());
            ps.setInt(4, l.getAnioEdicion());
            ps.setString(5, l.getAutor().getDNI());
            ps.executeUpdate();


            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }


    public static void mostrarMenu() {
        System.out.println("===============================");
        System.out.println(" Barbitania, Festival literario");
        System.out.println("===============================");
        System.out.println("1.- Nuevo libro");
        System.out.println("2.- Mostrar todos los libros");
        System.out.println("3.- Mostrar autores jóvenes");
        System.out.println("4.- Nueva librería");
        System.out.println("5.- Mostrar todas las librerías");
        System.out.println("6.- Salir");
        System.out.print("Elige una opción:");

    }



    public static void main (String args[]) {

        Scanner sc = new Scanner (System.in);
        LibreriaController mylibreriacontroller = new LibreriaController();
        sc.useLocale(Locale.US);
        int opcion;

        miListaLibros = new ListaLibros();
        miListaLibrerias = new ListaLibrerias();

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case MENU_NUEVO_LIBRO:

                    guardarNuevoLibro(miListaLibros.anadirLibro());
                break;
                case MENU_MOSTRAR_LIBROS:
                    cargarMyLibrosEnBD();


                    listaAutor.mostrarAutor();
                    miListaLibros.mostrarLista();
                break;
                case MENU_MOSTRAR_AUTORES_JOVENES:
                    cargarMyDatosEnBDMenores();
                break;
                case MENU_NUEVA_LIBRERIA:
                    mylibreriacontroller.anadirLibreria();
                break;
                case MENU_MOSTRAR_LIBRERIAS:
                    mylibreriacontroller.verTodos();
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