// ListaPacientes.java

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase ListaPacientes:
 *   - Gestiona un ArrayList<Paciente> que puede contener Paciente o Infantil.
 *   - Permite:
 *       1) anadirUsuario(): dar de alta un paciente, decidiendo si es Infantil (<10 años) o Paciente normal.
 *       2) mostrarTodos(): mostrar todos los pacientes guardados.
 *       3) buscarPorIndice(int): obtener el paciente en la posición dada.
 *       4) getInfantiles(): obtener sólo los pacientes de tipo Infantil.
 */
public class ListaPacientes {

    // Lista interna donde almacenamos Paciente (y sus subclases).
    List<Paciente> lista;

    // Formateador para parsear la fecha de nacimiento al hacer la prueba de edad.
    private static final DateTimeFormatter DT_FECHA_NAC =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Constructor: inicializa la lista vacía.
     */
    public ListaPacientes() {
        this.lista = new ArrayList<>();
    }

    /**
     * anadirUsuario():
     *   1) Pide la fecha de nacimiento para calcular la edad.
     *   2) Si la edad < 10 → crea un Infantil, llama a infantil.alta(), lo añade a la lista.
     *   3) Si la edad ≥ 10 → crea un Paciente normal, llama a paciente.alta(), lo añade a la lista.
     */
    public void anadirUsuario() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Alta de paciente (en ListaPacientes) ===");
        System.out.print("Fecha de nacimiento (dd/MM/yyyy): ");
        String fechaStr = sc.nextLine();

        // Parseamos la fecha con el formateador
        LocalDate fechaNac = LocalDate.parse(fechaStr, DT_FECHA_NAC);

        // Calculamos la edad respecto a hoy
        LocalDate hoy = LocalDate.now();
        int edad = Period.between(fechaNac, hoy).getYears();

        if (edad < 10) {
            // Si el paciente tiene menos de 10 años, creamos un Infantil
            System.out.println("Se detecta que el paciente tiene " + edad + " años (<10). Crear Infantil.");
            Infantil inf = new Infantil();
            inf.alta();  // pide: nombre, apellidos, fecha (de nuevo), código AR, padre, madre, teléfono
            lista.add(inf);
            System.out.println("Paciente Infantil creado y añadido a la lista.");
        } else {
            // Paciente “normal” (10 años o más)
            System.out.println("Se detecta que el paciente tiene " + edad + " años (>=10). Crear Paciente normal.");
            Paciente p = new Paciente();
            p.alta(); // pide: nombre, apellidos, fecha (de nuevo), código AR
            lista.add(p);
            System.out.println("Paciente creado y añadido a la lista.");
        }
    }

    /**
     * mostrarTodos(): imprime por consola todos los pacientes guardados en la lista.
     * Usa el método toString() de cada Paciente (o Infantil).
     */
    public void mostrarTodos() {
        if (lista.isEmpty()) {
            System.out.println("No hay pacientes en la lista.");
            return;
        }
        System.out.println("=== LISTADO DE PACIENTES ===");
        int idx = 1;
        for (Paciente p : lista) {
            System.out.println(idx + ". " + p.toString());
            idx++;
        }
    }

    /**
     * buscarPorIndice(int idx):
     *   - Si idx está fuera de rango, devuelve null.
     *   - En caso contrario, devuelve el Paciente en la posición idx (0-based).
     */
    public Paciente buscarPorIndice(int idx) {
        if (idx < 0 || idx >= lista.size()) {
            return null;
        }
        return lista.get(idx);
    }

    /**
     * getInfantiles(): recorre la lista y devuelve sólo aquellos pacientes
     * que sean instancias de la subclase Infantil.
     */
    public List<Infantil> getInfantiles() {
        List<Infantil> resultado = new ArrayList<>();
        for (Paciente p : lista) {
            if (p instanceof Infantil) {
                resultado.add((Infantil) p);
            }
        }
        return resultado;
    }
}
