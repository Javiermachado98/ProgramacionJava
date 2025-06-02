import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaPacientes {

    ArrayList<Paciente> arrayListPaciente = new ArrayList();
    public ListaPacientes(){
    }

    public int numPacientes(){
        return arrayListPaciente.size();
    }

    /**
     * Este método se encarga de:
     * 1) Preguntar por los datos del paciente (pidiendo nombre, fecha, etc.)
     * 2) Calcular la edad para decidir si es Infantil (<10 años) o Paciente normal.
     * 3) Crear la instancia adecuada (Infantil o Paciente), llamar a su alta() y añadirla a la lista.
     */
    public void anadirUsuario() {
        Scanner sc = new Scanner(System.in);

        // Para decidir si es o no Infantil, primero pedimos la fecha de nacimiento
        System.out.println("=== Alta de paciente (en ListaPacientes) ===");
        System.out.print("Fecha de nacimiento (dd/MM/yyyy): ");
        String fechaStr = sc.nextLine();
        // Lo parseamos usando el mismo formateador que en Paciente:
        LocalDate fechaNac = LocalDate.parse(fechaStr,
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        // Calculamos la edad con Period entre fechaNac y hoy:
        LocalDate hoy = LocalDate.now();
        int edad = Period.between(fechaNac, hoy).getYears();

        // Si es menor de 10 años, creamos un Infantil; en otro caso, un Paciente normal.
        if (edad < 10) {
            Infantil myinfantil = new Infantil();
            // Como ya sabíamos la fecha de nacimiento, podríamos inyectarla en su campo antes de llamar a alta().
            // Pero nuestro alta() pide todo de nuevo, así que simplemente dejamos que alta() pregunte otra vez.
            System.out.println("Se detecta que el paciente tiene " + edad + " años (<10). Debe ser Infantil.");
            myinfantil.alta();               // pide nombre, apellidos, fecha (de nuevo), código AR, padre, madre, teléfono
            arrayListPaciente.add(myinfantil);
            System.out.println("Paciente Infantil creado y añadido a la lista.");
        } else {
            Paciente mypaciente = new Paciente();
            mypaciente.altaPaciente();                 // pide todos los datos de Paciente (incluida fecha otra vez)
            arrayListPaciente.add(mypaciente);
            System.out.println("Paciente creado y añadido a la lista.");
        }
    }


    public void anadirUsuario2(Paciente p){
        arrayListPaciente.add(p);
    }
    public Paciente PacientePosicion (int posicion) {
        return arrayListPaciente.get(posicion-1);
    }

    public void mostrarLista(){
        int contador = 1;
        for (int i = 0; i < arrayListPaciente.size(); i++){
            System.out.println(contador + " " + arrayListPaciente.get(i));
            contador++;
        }
    }


}
