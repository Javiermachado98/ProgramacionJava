package p02Examenes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class principals {
    private static final String USER = "consultor";
    private static final String PASS = "consultorpass";
    private static final String HOST = "localhost";
    private static final String DB = "examenes";

    private static Connection conexion;
    private static List<Examen> listaExamenes = new ArrayList<>();

    public static Connection conectar() {
        Connection con = null;
        String url = "jdbc:mysql://" + HOST + "/" + DB;
        try {
            con = DriverManager.getConnection(url, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Error conectando a BBDD: " + e.getMessage());
        }
        return con;
    }

    // 1.4.1 Cargar exámenes y sus preguntas al inicio
    public static void cargarExamenes() {
        listaExamenes.clear();
        try {
            conexion = conectar();
            if (conexion == null) return;

            Statement st = conexion.createStatement();
            ResultSet rsExamenes = st.executeQuery("SELECT * FROM examenes");

            while (rsExamenes.next()) {
                int idExamen = rsExamenes.getInt("id");
                String asignatura = rsExamenes.getString("asignatura");

                Examen examen = new Examen(idExamen, asignatura);

                // Cargar preguntas del examen
                PreparedStatement psPreguntas = conexion.prepareStatement(
                        "SELECT * FROM preguntas WHERE examen_id = ?");
                psPreguntas.setInt(1, idExamen);
                ResultSet rsPreguntas = psPreguntas.executeQuery();

               /* while (rsPreguntas.next()) {
                    int idPregunta = rsPreguntas.getInt("id");
                    String texto = rsPreguntas.getString("texto");
                    Pregunta pregunta = new Pregunta(idPregunta, texto);
                    examen.anadirPregunta(pregunta);
                }*/
                listaExamenes.add(examen);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error cargando examenes: " + e.getMessage());
        }
    }

    // 1.4.2 Alta de examen (con Statement)
    public static void altaExamen(Examen examen) {
        try {
            conexion = conectar();
            if (conexion == null) return;

            Statement st = conexion.createStatement();
            String sql = "INSERT INTO examenes (asignatura) VALUES ('" + examen.getAsignatura() + "')";
            st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = st.getGeneratedKeys();

            /*if (generatedKeys.next()) {
                int nuevoId = generatedKeys.getInt(1);
                examen.setId(nuevoId);
                listaExamenes.add(examen);
                System.out.println("Examen creado con id: " + nuevoId);
            }*/

            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error creando examen: " + e.getMessage());
        }
    }

    // 1.4.3 Alta de pregunta (con PreparedStatement)
    public static void altaPregunta(Pregunta pregunta, int idExamen) {
        try {
            conexion = conectar();
            if (conexion == null) return;

            String sql = "INSERT INTO preguntas (examen_id, texto) VALUES (?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idExamen);
            ps.setString(2, pregunta.getTexto());
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
           /* if (generatedKeys.next()) {
                int nuevoId = generatedKeys.getInt(1);
                pregunta.setId(nuevoId);
                System.out.println("Pregunta creada con id: " + nuevoId);
            }*/

            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error creando pregunta: " + e.getMessage());
        }
    }

    // 1.4.4 Mostrar asignaturas con número de preguntas (desde memoria)
   /* public static void mostrarAsignaturasPreguntasMemoria() {
        System.out.println("Asignaturas y número de preguntas (memoria):");
        for (Examen e : listaExamenes) {
            System.out.println(e.getAsignatura() + " - " + e.numeroPreguntas() + " preguntas");
        }
    }*/

    // 1.4.5 Mostrar asignaturas con número de preguntas (consultando BBDD)
    public static void mostrarAsignaturasPreguntasBBDD() {
        try {
            conexion = conectar();
            if (conexion == null) return;

            String sql = "SELECT e.asignatura, COUNT(p.id) AS num_preguntas " +
                    "FROM examenes e LEFT JOIN preguntas p ON e.id = p.examen_id " +
                    "GROUP BY e.id, e.asignatura";

            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("Asignaturas y número de preguntas (BBDD):");
            while (rs.next()) {
                String asignatura = rs.getString("asignatura");
                int numPreguntas = rs.getInt("num_preguntas");
                System.out.println(asignatura + " - " + numPreguntas + " preguntas");
            }

            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error mostrando asignaturas desde BBDD: " + e.getMessage());
        }
    }

    // Menu simple
    public static void mostrarMenu() {
        System.out.println("===== MENÚ EXÁMENES =====");
        System.out.println("1. Alta examen");
        System.out.println("2. Alta pregunta");
        System.out.println("3. Mostrar asignaturas y preguntas (memoria)");
        System.out.println("4. Mostrar asignaturas y preguntas (BBDD)");
        System.out.println("5. Salir");
        System.out.print("Opción: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cargarExamenes();

        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Introduce asignatura: ");
                    String asignatura = sc.nextLine();
                    Examen examen = new Examen(0, asignatura);
                    altaExamen(examen);
                }
                case 2 -> {
                    System.out.println("Seleccione examen para añadir pregunta:");
                    for (int i = 0; i < listaExamenes.size(); i++) {
                        System.out.printf("%d. %s%n", i + 1, listaExamenes.get(i).getAsignatura());
                    }
                    int idx = sc.nextInt() - 1;
                    sc.nextLine();
                   /* if (idx >= 0 && idx < listaExamenes.size()) {
                        System.out.print("Texto de la pregunta: ");
                        String texto = sc.nextLine();
                        Pregunta pregunta = new Pregunta(0, texto);
                        int idExamen = listaExamenes.get(idx).getId();
                        altaPregunta(pregunta, idExamen);
                        listaExamenes.get(idx).anadirPregunta(pregunta);
                    } else {
                        System.out.println("Opción no válida");
                    }*/
                }
               // case 3 -> mostrarAsignaturasPreguntasMemoria();
                case 4 -> mostrarAsignaturasPreguntasBBDD();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 5);

        sc.close();
    }
}
