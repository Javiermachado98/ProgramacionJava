import Base.*;
import Listas.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author admin
 * @author Abel Oriach Enjuanes 1º DAW
 */
public class Principal {

    public static final int OPCION_ALTA_USUARIO = 1;
    public static final int OPCION_MUESTRA_USUARIOS = 2;
    public static final int OPCION_ALTA_LICENCIA = 3;
    public static final int OPCION_MOSTRAR_LICENCIAS = 4;
    public static final int OPCION_ASIGNAR_LICENCIA = 5;
    public static final int OPCION_MOSTRAR_ASIGNACIONES = 6;
    public static final int OPCION_ORDENA_USUARIOS = 7;
    public static final int OPCION_MOSTRAR_USUARIOS_ALUMNOS = 8;
    public static final int OPCION_MOSTRAR_LICENCIAS_PROGRAMA = 9;
    public static final int OPCION_MOSTRAR_CUANTAS_ASIGNACIONES_CADUCAN_ESTE_AÑO = 10;
    public static final int OPCION_MOSTRAR_LICENCIAS_LIBRES = 11;
    public static final int OPCION_MOSTRAR_LICENCIAS_MASDEUNA = 12;
    public static final int OPCION_CREAR_MAPA_LICENCIAS = 13;
    public static final int OPCION_MOSTRAR_LICENCIAS_ITERADOR = 14;

    public static final int OPCION_SALIR = 15;

    /**
     */
    public static void mostrarMenu() {
        System.out.println("==================================================");
        System.out.println(" GESTIÓN DE LICENCIAS DE SOFTWARE ");
        System.out.println("==================================================");
        System.out.println(" 1.- ALTA USUARIO ");
        System.out.println(" 2.- MUESTRA USUARIOS ");
        System.out.println(" 3.- ALTA LICENCIA ");
        System.out.println(" 4.- MOSTRAR LICENCIAS ");
        System.out.println(" 5.- ASIGNAR LICENCIA ");
        System.out.println(" 6.- MOSTRAR ASIGNACIONES");
        System.out.println(" 7.- ORDENAR USUARIOS ");
        System.out.println(" 8.- MOSTRAR USUARIOS QUE SON ALUMNOS ");
        System.out.println(" 9.- MOSTRAR LICENCIAS PROGRAMA ");
        System.out.println("10.- MOSTRAR CUANTAS ASIGNACIONES CADUCAN ESTE AÑO");
        System.out.println("11.- MOSTRAR LICENCIAS LIBRES");
        System.out.println("12.- MOSTRAR LICENCIAS MAS DE UNA");
        System.out.println("13.- MOSTRAR MAPEO LICENCIAS");
        System.out.println("14.- MOSTRAR LICENCIAS ITERADOR ");
        System.out.println("15.- SALIR ");
        System.out.println("==================================================");
        System.out.print("Introduce una opción: ");
    }

    public static void introducirAlgunosDatos(ListaUsuarios lu, ListaLicenciasSoftware ls, ListaAsignacionesLicencias la) {
        // Crear usuarios
        Usuario u1 = new Usuario("Blanca", "Lorente", "11111111X", TipoUsuario.PROFESOR); lu.anadirUsuario(u1);
        Usuario u2 = new Usuario("Alberto", "Torres", "22222222Y", TipoUsuario.PROFESOR); lu.anadirUsuario(u2);
        Usuario u3 = new Usuario("José Ramón", "Manau", "33333333Y", TipoUsuario.PROFESOR); lu.anadirUsuario(u3);
        Usuario u4 = new Usuario("Mª Carmen", "Roca", "44444444Z", TipoUsuario.PROFESOR); lu.anadirUsuario(u4);
        Usuario u5 = new Usuario("Modesto", "Sierra", "55555555S", TipoUsuario.PROFESOR); lu.anadirUsuario(u5);
        Usuario u6 = new Usuario("Francisco", "Frances", "66666666L", TipoUsuario.PROFESOR); lu.anadirUsuario(u6);
        Usuario u7 = new Usuario("Ana", "Sánchez", "77777777S", TipoUsuario.ALUMNO); lu.anadirUsuario(u7);
        Usuario u8 = new Usuario("María", "Pérez", "8888888M", TipoUsuario.ALUMNO); lu.anadirUsuario(u8);
        Usuario u9 = new Usuario("Mario", "Antúnez", "99999999S", TipoUsuario.ALUMNO); lu.anadirUsuario(u9);
        Usuario u10 = new Usuario("Marta", "Martínez", "101010101", TipoUsuario.PAS); lu.anadirUsuario(u10);

        // Crear licencias de software
        LicenciaSoftware l1 = new LicenciaSoftware("IntelliJ IDEA", "2024", "IJ-32924832"); ls.anadirLicenciaSoftware(l1);
        LicenciaSoftware l2 = new LicenciaSoftware("IntelliJ IDEA", "2024", "IJ-32924834"); ls.anadirLicenciaSoftware(l2);
        LicenciaSoftware l3 = new LicenciaSoftware("IntelliJ IDEA", "2024", "IJ-32924836"); ls.anadirLicenciaSoftware(l3);
        LicenciaSoftware l4 = new LicenciaSoftware("Microsoft Visual Studio", "2024", "VS-28372732"); ls.anadirLicenciaSoftware(l4);
        LicenciaSoftware l5 = new LicenciaSoftware("IntelliJ IDEA", "2024", "IJ-32924333"); ls.anadirLicenciaSoftware(l5);
        LicenciaSoftware l6 = new LicenciaSoftware("Microsoft Visual Studio", "2023", "VS-22272732"); ls.anadirLicenciaSoftware(l6);
        LicenciaSoftware l7 = new LicenciaSoftware("Microsoft Visual Studio", "2021", "VS-28452732"); ls.anadirLicenciaSoftware(l7);
        LicenciaSoftware l8 = new LicenciaSoftware("IntelliJ IDEA", "2024", "IJ-3292664"); ls.anadirLicenciaSoftware(l8);
        LicenciaSoftware l9 = new LicenciaSoftware("AutoCAD", "2023", "AC-567333423"); ls.anadirLicenciaSoftware(l9);

        // Crear asignaciones de licencias a usuarios
        AsignacionLicencia al1 = new AsignacionLicencia(u1, l1, "01/02/2024", "01/02/2025"); la.anadirAsignacionLicencia(al1);
        AsignacionLicencia al2 = new AsignacionLicencia(u2, l2, "15/03/2024", "15/03/2025"); la.anadirAsignacionLicencia(al2);
        AsignacionLicencia al3 = new AsignacionLicencia(u3, l3, "01/02/2024", "01/02/2026"); la.anadirAsignacionLicencia(al3);
        AsignacionLicencia al4 = new AsignacionLicencia(u4, l4, "15/03/2024", "15/03/2026"); la.anadirAsignacionLicencia(al4);
        AsignacionLicencia al5 = new AsignacionLicencia(u2, l2, "15/03/2024", "15/03/2025"); la.anadirAsignacionLicencia(al5);

    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        ListaUsuarios miListaUsuarios = new ListaUsuarios();
        ListaLicenciasSoftware miListaLicenciasSoftware = new ListaLicenciasSoftware();
        ListaAsignacionesLicencias miListaAsignacionesLicencias = new ListaAsignacionesLicencias();

        introducirAlgunosDatos(miListaUsuarios, miListaLicenciasSoftware,miListaAsignacionesLicencias);

        Scanner sc;
        int opcion;
        do {
            mostrarMenu();
            sc = new Scanner(System.in);
            opcion = sc.nextInt();
            sc.nextLine(); // Para evitar problemas con los siguientes sc.nextLine()
            switch (opcion) {
                case OPCION_ALTA_USUARIO -> {
                    Usuario u = new Usuario();
                    u.alta();
                    miListaUsuarios.anadirUsuario(u);
                    System.out.println("Base.Usuario añadido con éxito");
                }
                case OPCION_MUESTRA_USUARIOS -> {
                    miListaUsuarios.mostrarLista();
                }
                case OPCION_ALTA_LICENCIA -> {
                    LicenciaSoftware ls = new LicenciaSoftware();
                    ls.alta();
                    miListaLicenciasSoftware.anadirLicenciaSoftware(ls);
                }
                case OPCION_MOSTRAR_LICENCIAS -> {
                    miListaLicenciasSoftware.mostrarLista();
                }
                case OPCION_ASIGNAR_LICENCIA -> {
                    // Crea nueva licencia, la da de alta y la añade a la lista
                    AsignacionLicencia al = new AsignacionLicencia();
                    al.alta(miListaUsuarios, miListaLicenciasSoftware);
                    miListaAsignacionesLicencias.anadirAsignacionLicencia(al);
                }
                case OPCION_MOSTRAR_ASIGNACIONES -> {
                    miListaAsignacionesLicencias.mostrarLista();
                }
                case OPCION_ORDENA_USUARIOS  -> {
                    // Ordena y muestra los usuarios
                    miListaUsuarios.ordenaLista();
                    System.out.println("Lista ordenada:");
                    miListaUsuarios.mostrarLista();

                }
                case OPCION_MOSTRAR_USUARIOS_ALUMNOS -> {
                    // Muestra los usuarios que son alumnos
                    System.out.println("Alumnos: ");
                    miListaUsuarios.mostrarAlumnos();
                }
                case OPCION_MOSTRAR_LICENCIAS_PROGRAMA -> {
                    // Pide un nombre de una aplicación y muestra las licencias de esa aplicación
                    System.out.print("Escribe el programa a consutar: ");
                    miListaLicenciasSoftware.muestraLicenciasSoftware(sc.nextLine());
                }
                case OPCION_MOSTRAR_CUANTAS_ASIGNACIONES_CADUCAN_ESTE_AÑO -> {
                    // Muestra las licencias que caducan en el año en el que estamos usando un LocalDate.now() y
                    // extrayendo el año con .getYear();
                    System.out.print("Número de licencias que caducan este año: ");
                    System.out.println(miListaAsignacionesLicencias.nLicenciasCaducanEsteAnyo(LocalDate.now().getYear()));
                }
                case OPCION_MOSTRAR_LICENCIAS_LIBRES -> {
                    // Muestra las licencias que no están asignadas a nadie
                    System.out.println("Licencias libres: ");
                    miListaLicenciasSoftware.mostrarLicenciasNoAsignadas(miListaAsignacionesLicencias);
                }
                case OPCION_MOSTRAR_LICENCIAS_MASDEUNA -> {
                    // Muestra las licencias que están asignadas más de una vez
                    System.out.println("Licencias asignadas más de una vez: ");
                    miListaLicenciasSoftware.mostrarLicenciasMasDeUna(miListaAsignacionesLicencias);
                }
                case OPCION_CREAR_MAPA_LICENCIAS -> {
                    // Hash map en el que guardaremos el número de licencia y el dni del usuario asignado
                    // Al usar un hash map, tendremos limitaciones, ya que cada licencia solo podrá estar
                    // asignada a un usuario. En este caso, perdemos una asignación.
                    HashMap<String, String> licencias = new HashMap<>();

                    for (int i = 1; i <= miListaAsignacionesLicencias.nAsignacionLicenciaes(); i++) {
                        String numLicencia = miListaAsignacionesLicencias.AsignacionLicenciaPosicion(i).getLicencia().getNumero();
                        String dniUsuario = miListaAsignacionesLicencias.AsignacionLicenciaPosicion(i).getUsuario().getDNI();

                        licencias.put(numLicencia, dniUsuario);
                    }

                    for (String nLic : licencias.keySet()) {
                        System.out.println("Licencia: " + nLic + " Usuario: " + licencias.get(nLic));
                    }
                }
                case OPCION_MOSTRAR_LICENCIAS_ITERADOR -> {
                    // Muestra las licencias usando un iterador
                    miListaLicenciasSoftware.mostrarListaIterador();
                }

                case OPCION_SALIR -> {
                }
                default -> {
                    System.out.println("Introduce una opción válida");
                }
            }
        } while (opcion != OPCION_SALIR);

    }
}
