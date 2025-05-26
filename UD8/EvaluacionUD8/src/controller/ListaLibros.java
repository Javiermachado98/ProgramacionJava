package controller;

import model.Autor;
import model.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import principal.Principals;

public class ListaLibros {

    List<Libro> arrayListLibros = new ArrayList();

    /**
     * Crea una lista de Libros
     */
    public ListaLibros() {

    }

    /**
     *
     * @return el número de Libros de la lista
     */
    public int nLibros() {
        return arrayListLibros.size();
    }

    /**
     * Pedimos los datos y añadimos un libro al final de la lista
     *
     * @return
     */
    public Libro anadirLibro() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nDatos del autor =========");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = sc.nextLine();
        System.out.print("Profesión: ");
        String profesion = sc.nextLine();
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        System.out.print("Lugar de nacimiento: ");
        String lugar = sc.nextLine();
        System.out.print("Año de nacimiento: ");
        int anioNac = sc.nextInt();
        sc.nextLine();
        Autor autor = new Autor(nombre, apellidos, lugar, anioNac, profesion, dni);

        System.out.println("\nDatos del libro =========");
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Editorial: ");
        String editorial = sc.nextLine();
        System.out.print("Año de edición: ");
        int anioEdicion = sc.nextInt();
        Libro libro = new Libro(titulo, isbn, editorial, anioEdicion, autor);

        //this.anadirLibro(libro);

        try (Connection conexion = Principals.connectMyDatabase()) {

            // Insertar autor si no existe
            String checkAutor = "SELECT COUNT(*) FROM Autor WHERE dni = ?";
            PreparedStatement psCheck = conexion.prepareStatement(checkAutor);
            psCheck.setString(1, dni);
            ResultSet rs = psCheck.executeQuery();
            rs.next();

            if (rs.getInt(1) == 0) {
                String insertAutor = "INSERT INTO Autor (dni, nombre, apellidos, lugarNacimiento, anioNacimiento, profesion) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement psAutor = conexion.prepareStatement(insertAutor);
                psAutor.setString(1, dni);
                psAutor.setString(2, nombre);
                psAutor.setString(3, apellidos);
                psAutor.setString(4, lugar);
                psAutor.setInt(5, anioNac);
                psAutor.setString(6, profesion);
                psAutor.executeUpdate();
            }

            // Insertar libro
            String insertLibro = "INSERT INTO Libro (isbn, titulo, editorial, anioEdicion, dniAutor) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement psLibro = conexion.prepareStatement(insertLibro);
            psLibro.setString(1, isbn);
            psLibro.setString(2, titulo);
            psLibro.setString(3, editorial);
            psLibro.setInt(4, anioEdicion);
            psLibro.setString(5, dni);
            psLibro.executeUpdate();

            System.out.println("Libro y autor guardados correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al guardar en la base de datos: " + e.getMessage());
        }


        return libro;
    }

    /**
     * Añadimos un Libro al final de la lista
     *
     * @param p
     */
    public void anadirLibro(Libro p) {
        arrayListLibros.add(p);
    }

    /**
     *
     * @param posicion
     * @return El Libro que está en la posición posicion
     */
    public Libro libroPosicion(int posicion) {
        return arrayListLibros.get(posicion);
    }

    /**
     * Muestra todos los libros de la lista
     */
    public void mostrarLista() {
        for (int i = 0; i < arrayListLibros.size(); i++) {
            System.out.println(arrayListLibros.get(i));
        }
    }
    
}
