public class Principal {

    public static ListaViajes viajes = new ListaViajes();

    public static void main(String[] args) {

        // Añadir viajes a la lista
        viajes.anadirViaje(new Viaje("VJ001", Viaje.Tipo.AVE, "01-02-2025", "Madrid", "Barcelona", 59.90));
        viajes.anadirViaje(new Viaje("VJ002", Viaje.Tipo.AVLO, "01-02-2025",  "Valencia", "Madrid", 29.99));
        viajes.anadirViaje(new Viaje("VJ003", Viaje.Tipo.CERCANIAS, "01-03-2025",  "Monzón", "Madrid", 3.60));
        viajes.anadirViaje(new Viaje("VJ004", Viaje.Tipo.AVE, "13-02-2025",  "Sevilla", "Madrid", 65.00));
        viajes.anadirViaje(new Viaje("VJ005", Viaje.Tipo.AVLO, "15-12-2025", "Monzón", "Valencia", 24.99));
        viajes.anadirViaje(new Viaje("VJ006", Viaje.Tipo.CERCANIAS, "01-12-2025",  "Móstoles", "Madrid", 2.90));
        viajes.anadirViaje(new Viaje("VJ007", Viaje.Tipo.AVE, "11-02-2025",  "Barcelona", "Sevilla", 89.00));
        viajes.anadirViaje(new Viaje("VJ008", Viaje.Tipo.AVLO, "12-02-2025",  "Zaragoza", "Barcelona", 19.99));
        viajes.anadirViaje(new Viaje("VJ009", Viaje.Tipo.CERCANIAS, "14-02-2025",  "Lérida", "Madrid", 2.50));
        viajes.anadirViaje(new Viaje("VJ010", Viaje.Tipo.AVE, "01-06-2025", "Madrid", "Zaragoza", 39.90));

        try {
            // Exportar la lista de viajes a un fichero XML
            viajes.exportarXML();
            System.out.println("Archivo viajes.xml generado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al exportar XML: " + e.getMessage());
        }
    }
}
