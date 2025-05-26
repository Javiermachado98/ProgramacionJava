import java.io.*;              // Importamos clases para manejar archivos (leer y escribir)
import java.util.ArrayList;    // Importamos ArrayList para almacenar una lista dinámica
import java.util.List;         // Importamos la interfaz List para definir la lista

public class Generadores {

    // Clase para representar un generador eléctrico con sus datos importantes
    public static class Generador {
        private String modelo;    // Nombre o modelo del generador
        private String tipo;      // Tipo de combustible o generador
        private double consumo;   // Consumo en litros por hora (L/h)
        private int autonomia;    // Autonomía en horas
        private double precio;    // Precio en euros (€)

        // Constructor para crear un objeto Generador con todos sus datos
        public Generador(String modelo, String tipo, double consumo, int autonomia, double precio) {
            this.modelo = modelo;
            this.tipo = tipo;
            this.consumo = consumo;
            this.autonomia = autonomia;
            this.precio = precio;
        }

        // Métodos "getters" para acceder a cada dato privado desde fuera de la clase
        public String getModelo() { return modelo; }
        public String getTipo() { return tipo; }
        public double getConsumo() { return consumo; }
        public int getAutonomia() { return autonomia; }
        public double getPrecio() { return precio; }

        // Método para mostrar el generador con formato legible cuando se imprime por pantalla
        @Override
        public String toString() {
            return "Modelo: " + modelo + ", Tipo: " + tipo + ", Consumo: " + consumo +
                    " L/h, Autonomía: " + autonomia + " h, Precio: " + precio + " €";
        }
    }

    // Método principal donde comienza la ejecución del programa
    public static void main(String[] args) {

        // Creamos una lista dinámica para guardar los generadores que vamos a leer del fichero
        List<Generador> generadores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/files/generadores.csv"))) {
            // BufferedReader es para leer el fichero línea a línea de manera eficiente
            // FileReader abre el fichero indicado en la ruta especificada

            String linea = br.readLine(); // Leemos la primera línea (cabecera) y la ignoramos
            // La cabecera tiene los nombres de las columnas, no datos de generadores

            // Ahora leemos línea a línea hasta que no haya más (lleguemos al final del fichero)
            while ((linea = br.readLine()) != null) {

                // Separamos la línea en partes usando el punto y coma ";" como separador
                // Esto nos da un array con cada campo como una cadena de texto (String)
                String[] datos = linea.split(";");

                // Extraemos los datos importantes según la posición en el array:
                // Modelo está en la posición 0
                String modelo = datos[0];
                // Tipo está en la posición 1
                String tipo = datos[1];
                // Consumo está en la posición 5, viene como texto y lo convertimos a número decimal (double)
                double consumo = Double.parseDouble(datos[5]);
                // Autonomía está en la posición 6, viene como texto y lo convertimos a número entero (int)
                int autonomia = Integer.parseInt(datos[6]);
                // Precio está en la posición 7, viene como texto y lo convertimos a número decimal (double)
                double precio = Double.parseDouble(datos[7]);

                // Creamos un nuevo objeto Generador con los datos leídos y convertidos
                Generador gen = new Generador(modelo, tipo, consumo, autonomia, precio);
                // Añadimos el generador a la lista para guardarlo y procesarlo luego
                generadores.add(gen);
            }

        } catch (IOException e) {
            // Si ocurre algún error al abrir o leer el fichero, mostramos un mensaje de error y salimos
            System.err.println("Error leyendo el fichero: " + e.getMessage());
            return;
        }

        // 1. Mostrar listado completo de todos los generadores con sus datos
        System.out.println("Listado de generadores:");
        for (Generador g : generadores) {
            System.out.println(g); // Esto llama automáticamente al método toString() de cada generador
        }

        // 2. Buscar el generador que tenga la mayor autonomía (más horas)
        Generador maxAutonomia = null; // Variable para guardar el generador con más autonomía
        for (Generador g : generadores) {
            // Si es el primer generador o si tiene más autonomía que el actual máximo, lo guardamos
            if (maxAutonomia == null || g.getAutonomia() > maxAutonomia.getAutonomia()) {
                maxAutonomia = g;
            }
        }

        // Si hemos encontrado al menos un generador, mostramos su modelo y autonomía
        if (maxAutonomia != null) {
            System.out.println("\nGenerador con mayor autonomía: " + maxAutonomia.getModelo() +
                    " (" + maxAutonomia.getAutonomia() + " h)");
        }

        // 3. Crear y escribir en el fichero "baratos.txt" los generadores que cuestan menos de 600 €
        try (PrintWriter pw = new PrintWriter(new FileWriter("src/files/baratos.txt"))) {
            for (Generador g : generadores) {
                // Si el precio es menor que 600, lo escribimos en el fichero con modelo y precio separados por ";"
                if (g.getPrecio() < 600) {
                    pw.println(g.getModelo() + ";" + g.getPrecio());
                }
            }
        } catch (IOException e) {
            // Si ocurre algún error al escribir el fichero, mostramos mensaje de error
            System.err.println("Error escribiendo el fichero baratos.txt: " + e.getMessage());
        }
    }
}
