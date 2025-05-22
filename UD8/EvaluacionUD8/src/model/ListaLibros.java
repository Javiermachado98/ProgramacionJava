package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        this.anadirLibro(libro);


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
