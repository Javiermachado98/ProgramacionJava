// Principal.java

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase Principal con método main(): muestra un menú iterativo con opciones para:
 *   1. Alta de paciente
 *   2. Mostrar pacientes
 *   3. Alta de medida
 *   4. Mostrar pacientes infantiles
 *   5. Mostrar medidas de pulso
 *   6. Mostrar pacientes con fiebre
 *   7. Mostrar saturación más alta
 *   8. Ordenar medidas de pulso
 *   9. Salir
 *
 * - Se apoya en ListaPacientes para gestionar los pacientes.
 * - Se apoya en ListaMedidas para gestionar todas las medidas globales.
 * - Cada Paciente (y su subclase Infantil) mantiene internamente su propia lista de Medida.
 */
public class Principal {

    private static final int MENU_ALTA_PACIENTE = 1;
    private static final int MENU_MOSTRAR_PACIENTE = 2;
    private static final int MENU_ALTA_DE_MEDIDA = 3;
    private static final int MENU_MOSTRAR_PACIENTES_INFANTILES = 4;
    private static final int MENU_MOSTRAR_MEDIDAS_DE_PULSO = 5;
    private static final int MENU_MOSTRAR_PACIENTES_CON_FIEBRE = 6;
    private static final int MENU_MOSTRAR_SATURACION_MAS_ALTA = 7;
    private static final int MENU_ORDENAR_MEDIDAS_DE_PULSO = 8;
    private static final int MENU_SALIR = 9;

    /**
     * Muestra en pantalla el menú de opciones.
     */
    public static void mostrarMenu() {
        System.out.println("=================================");
        System.out.println("  Medidas constantes vitales     ");
        System.out.println("=================================");
        System.out.println("1.- Alta de paciente");
        System.out.println("2.- Mostrar pacientes");
        System.out.println("3.- Alta de medida");
        System.out.println("4.- Mostrar pacientes infantiles");
        System.out.println("5.- Mostrar medidas de pulso");
        System.out.println("6.- Mostrar pacientes con fiebre");
        System.out.println("7.- Mostrar saturación más alta");
        System.out.println("8.- Ordenar medidas de pulso");
        System.out.println("9.- Salir");
        System.out.print("Elige una opción: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        ListaPacientes miListaPacientes = new ListaPacientes();
        ListaMedidas miListaMedidas = new ListaMedidas();

        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(sc.nextLine()); // Leemos la opción completa

            switch (opcion) {
                case MENU_ALTA_PACIENTE:
                    // *** Opción 1: Alta de paciente ***
                    miListaPacientes.anadirUsuario();
                    break;

                case MENU_MOSTRAR_PACIENTE:
                    // *** Opción 2: Mostrar todos los pacientes ***
                    miListaPacientes.mostrarTodos();
                    break;

                case MENU_ALTA_DE_MEDIDA:
                    // *** Opción 3: Alta de medida para un paciente específico ***

                    // Primero mostramos la lista de pacientes con índices
                    System.out.println("=== Seleccionar paciente para dar de alta medida ===");
                    miListaPacientes.mostrarTodos();
                    System.out.print("Introduce el índice del paciente (1.." +
                            miListaPacientes.lista.size() + "): ");
                    // Observa que usamos directamente miListaPacientes.lista.size()
                    // porque lista es package-private (default). Podrías agregar un getter si prefieres.

                    int idx = Integer.parseInt(sc.nextLine()) - 1;
                    Paciente seleccionado = miListaPacientes.buscarPorIndice(idx);
                    if (seleccionado == null) {
                        System.out.println("Índice de paciente inválido.");
                    } else {
                        // Llamamos a Medida.alta para que pida datos y la añada al paciente
                        Medida.alta(seleccionado);

                        // Recuperamos la última medida que se acaba de añadir (es la última de getMedidas())
                        List<Medida> listaDeEstePaciente = seleccionado.getMedidas();
                        Medida ultima = listaDeEstePaciente.get(listaDeEstePaciente.size() - 1);

                        // La añadimos también a la lista global de medidas
                        miListaMedidas.addMedida(ultima);
                    }
                    break;

                case MENU_MOSTRAR_PACIENTES_INFANTILES:
                    // *** Opción 4: Mostrar pacientes infantiles y sus datos familiares ***
                    System.out.println("=== Pacientes Infantiles ===");
                    List<Infantil> listaInf = miListaPacientes.getInfantiles();
                    if (listaInf.isEmpty()) {
                        System.out.println("No hay pacientes infantiles.");
                    } else {
                        int c = 1;
                        for (Infantil inf : listaInf) {
                            System.out.println(c + ". " + inf.toString());
                            System.out.println("    Padre: " + inf.getNombrePadre() +
                                    ", Madre: " + inf.getNombreMadre() +
                                    ", Teléfono: " + inf.getTelefonoContacto());
                            c++;
                        }
                    }
                    break;

                case MENU_MOSTRAR_MEDIDAS_DE_PULSO:
                    // *** Opción 5: Mostrar todas las medidas de pulso ***
                    System.out.println("=== MEDIDAS DE PULSO ===");
                    List<Medida> pulsos = miListaMedidas.filtrarPorTipo(TipoMedida.PULSO);
                    if (pulsos.isEmpty()) {
                        System.out.println("No hay medidas de pulso registradas.");
                    } else {
                        for (Medida m : pulsos) {
                            System.out.println(m.toString());
                        }
                    }
                    break;

                case MENU_MOSTRAR_PACIENTES_CON_FIEBRE:
                    // *** Opción 6: Mostrar pacientes que tienen alguna temperatura > 37°C ***
                    System.out.println("=== PACIENTES CON FIEBRE (>37°C) ===");
                    boolean algunoConFiebre = false;

                    // Recorremos TODOS los pacientes (infantiles y no infantiles)
                    for (Paciente p : miListaPacientes.lista) {
                        // Obtenemos la lista de medidas de este paciente
                        List<Medida> medidasPaciente = p.getMedidas();
                        for (Medida m : medidasPaciente) {
                            if (m.getTipo() == TipoMedida.TEMPERATURA
                                    && m.getValor() > 37.0) {
                                // Lo imprimimos solo la primera vez que encontramos fiebre para este paciente
                                System.out.println(p.toString());
                                algunoConFiebre = true;
                                break;  // detenemos el bucle interno para no repetir el mismo paciente
                            }
                        }
                    }
                    if (!algunoConFiebre) {
                        System.out.println("No hay pacientes con fiebre en este momento.");
                    }
                    break;

                case MENU_MOSTRAR_SATURACION_MAS_ALTA:
                    // *** Opción 7: Para cada paciente, mostrar su SATURACION más alta ***
                    System.out.println("=== SATURACIÓN MÁS ALTA POR PACIENTE ===");
                    for (Paciente p : miListaPacientes.lista) {
                        List<Medida> medidasPaciente = p.getMedidas();
                        double maxSat = -1;
                        Medida mejorSat = null;
                        for (Medida m : medidasPaciente) {
                            if (m.getTipo() == TipoMedida.SATURACION) {
                                if (m.getValor() > maxSat) {
                                    maxSat = m.getValor();
                                    mejorSat = m;
                                }
                            }
                        }
                        if (mejorSat != null) {
                            // Mostramos nombre, valor máximo, fecha y hora
                            System.out.println("Paciente: " + p.nombre +
                                    " → SATURACIÓN MÁXIMA: " + maxSat +
                                    " (Fecha: " + mejorSat.getFecha() +
                                    ", Hora: " + mejorSat.getHora() + ")");
                        } else {
                            System.out.println("Paciente: " + p.nombre +
                                    " → No tiene medidas de saturación.");
                        }
                    }
                    break;

                case MENU_ORDENAR_MEDIDAS_DE_PULSO:
                    // *** Opción 8: Para cada paciente, ordenar medidas de pulso de mayor a menor ***
                    System.out.println("=== ORDENAR MEDIDAS DE PULSO POR PACIENTE ===");
                    for (Paciente p : miListaPacientes.lista) {
                        List<Medida> medidasPaciente = p.getMedidas();
                        // Filtramos solo las medidas de tipo PULSO:
                        List<Medida> soloPulso = new java.util.ArrayList<>();
                        for (Medida m : medidasPaciente) {
                            if (m.getTipo() == TipoMedida.PULSO) {
                                soloPulso.add(m);
                            }
                        }
                        // Ordenamos de mayor a menor por valor:
                        soloPulso.sort((m1, m2) ->
                                Double.compare(m2.getValor(), m1.getValor()));

                        // Mostramos el resultado
                        System.out.println("Paciente: " + p.nombre);
                        if (soloPulso.isEmpty()) {
                            System.out.println("   No tiene medidas de pulso.");
                        } else {
                            for (Medida mp : soloPulso) {
                                System.out.println("   " + mp.toString());
                            }
                        }
                    }
                    break;

                case MENU_SALIR:
                    // *** Opción 9: Salir del programa ***
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
                    break;
            }

            System.out.println(); // Línea en blanco para separar iteraciones
        } while (opcion != MENU_SALIR);

        sc.close();
    }
}
