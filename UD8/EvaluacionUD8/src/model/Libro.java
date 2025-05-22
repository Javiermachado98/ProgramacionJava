package model;

public class Libro {

    private String titulo;
    private String isbn;
    private String editorial;
    private int anioEdicion;
    private Autor autor;

    public Libro() {
    }

    public Libro(String titulo, String isbn, String editorial, int anioEdicion, Autor autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.anioEdicion = anioEdicion;
        this.autor = autor;
    }

    public Libro(String titulo, String isbn, String editorial, int anioEdicion, String dni) {
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnioEdicion() {
        return anioEdicion;
    }

    public void setAnioEdicion(int anioEdicion) {
        this.anioEdicion = anioEdicion;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", editorial='" + editorial + '\'' +
                ", anioEdicion=" + anioEdicion +
                ", autor=" + autor +
                '}';
    }
}
