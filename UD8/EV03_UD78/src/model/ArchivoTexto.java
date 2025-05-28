package model;

public class ArchivoTexto {

    public static void guardarReservasEnTexto(Connection conexion, String nombreArchivo) {
        String sql = "SELECT * FROM Reservas";

        try (
                PreparedStatement ps = conexion.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))
        ) {
            while (rs.next()) {
                String dni = rs.getString("dni");
                int idParcela = rs.getInt("idParcela");
                Date fecha = rs.getDate("fecha");
                int personas = rs.getInt("numPersonas");
                int dias = rs.getInt("numDias");

                String linea = String.format("DNI: %s | Parcela: %d | Fecha: %s | Nº de personas: %d | Dias: %d",
                        dni, idParcela, fecha.toString(), personas, dias);

                writer.write(linea);
                writer.newLine();
            }

            System.out.println("Reservas guardadas correctamente en " + nombreArchivo);

        } catch (IOException | SQLException e) {
            System.err.println("Error al guardar reservas: " + e.getMessage());
        }
    }
}

