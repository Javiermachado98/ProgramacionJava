package principal;

import controller.LibreriaController;
import controller.ListaLibros;
import controller.ListaLibrerias;
import model.Autor;
import model.Libro;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Principals {

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

    public static void cargarMyDatosEnBDMenores() {
        try (Connection conexion = connectMyDatabase();
             Statement sentencia = conexion.createStatement();
             ResultSet rs = sentencia.executeQuery("SELECT * FROM Autor")) {

            int anioActual = 2025;

            while (rs.next()) {
                int anioNacimiento = rs.getInt("anioNacimiento");
                int edad = anioActual - anioNacimiento;

                if (edad < 30) {
                    String nombre = rs.getString("nombre");
                    String apellidos = rs.getString("apellidos");
                    String profesion = rs.getString("profesion");

                    System.out.println("Este autor es menor de 30 años:");
                    System.out.println(nombre + " " + apellidos + " - " + profesion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void cargarMyLibrosEnBD() {
        try (Connection conexion = connectMyDatabase()) {  // Abre la conexión aquí
            miListaLibros = new ListaLibros(); // limpiar o crear nueva lista
            String sqlLibros = "SELECT * FROM Libro";
            PreparedStatement psLibros = conexion.prepareStatement(sqlLibros);
            ResultSet rsLibros = psLibros.executeQuery();

            while (rsLibros.next()) {
                String titulo = rsLibros.getString("titulo");
                String isbn = rsLibros.getString("isbn");
                String editorial = rsLibros.getString("editorial");
                int anioEdicion = rsLibros.getInt("anioEdicion");
                String dniAutor = rsLibros.getString("dniAutor");

                String sqlAutor = "SELECT * FROM Autor WHERE dni = ?";
                PreparedStatement psAutor = conexion.prepareStatement(sqlAutor);
                psAutor.setString(1, dniAutor);
                ResultSet rsAutor = psAutor.executeQuery();

                Autor autor = null;
                if (rsAutor.next()) {
                    autor = new Autor(
                            rsAutor.getString("nombre"),
                            rsAutor.getString("apellidos"),
                            rsAutor.getString("lugarNacimiento"),
                            rsAutor.getInt("anioNacimiento"),
                            rsAutor.getString("profesion"),
                            dniAutor);
                }
                Libro libro = new Libro(titulo, isbn, editorial, anioEdicion, autor);
                miListaLibros.anadirLibro(libro);

                rsAutor.close();
                psAutor.close();
            }

            rsLibros.close();
            psLibros.close();

        } catch (SQLException e) {
            System.out.println("Error cargando libros: " + e.getMessage());
        }
    }




    /*public static void cargarMyLibrosEnBD(){

        if (conexion == null){
            System.out.println("prueba conexion");
            return;
        }

        try {
            conexion = connectMyDatabase();
            sentencia = conexion.createStatement();
            sql = "SELECT * FROM Libro";
            rs = sentencia.executeQuery(sql);


            while (rs.next()){

                String DNI = rs.getString("dniAutor");
                Autor myautor2 = listaAutor.devuelveEmpleadoDNI(DNI);
                if (myautor2 != null){

                    String titulo = rs.getString("titulo");
                    String isbn = rs.getString("isbn");
                    String editorial = rs.getString("editorial");
                    int anioEdicion = rs.getInt("anioEdicion");


                    Libro mylibro = new Libro(titulo, isbn, editorial, anioEdicion, DNI);
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

            String sqlcheck = "SELECT COUNT(*) FROM Autor WHERE dni = ?";
            PreparedStatement verificarPs = conexion.prepareStatement(sqlcheck);
            verificarPs.setString(1,l.getAutor().getDNI());
            ResultSet rsVerificar = verificarPs.executeQuery();
            rsVerificar.next();

            //Si existe despues de la validacion

            if(rsVerificar.getInt(1) == 0){
                String sqlInsertAutor = "INSERT INTO Autor (dni, nombre, apellidos, lugarNacimiento, anioNacimiento, profesion) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement insertAutor = conexion.prepareStatement(sqlInsertAutor);
                insertAutor.setString(1, l.getAutor().getDNI());
                insertAutor.setString(2, l.getAutor().getNombre());
                insertAutor.setString(3, l.getAutor().getApellidos());
                insertAutor.setString(4, l.getAutor().getLugarNacimiento());
                insertAutor.setInt(5, l.getAutor().getAnioNacimiento());
                insertAutor.setString(6, l.getAutor().getProfesion());
                insertAutor.executeUpdate();
            }

            //Guardo el libro
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
    }*/


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


    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
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
                    miListaLibros.anadirLibro();
                    break;
                case MENU_MOSTRAR_LIBROS:
                    cargarMyDatosEnBDMenores(); // primero cargamos los autores
                    cargarMyLibrosEnBD();       // luego cargamos los libros
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