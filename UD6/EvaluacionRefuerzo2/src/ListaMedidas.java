// ListaMedidas.java

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Clase ListaMedidas:
 *   - Gestiona un ArrayList<Medida> global (para todas las medidas de todos los pacientes).
 *   - Ofrece:
 *       * addMedida(Medida): añadir una medida nueva.
 *       * getTodas(): devuelve la lista completa.
 *       * filtrarPorTipo(TipoMedida): devuelve sublista filtrada por un tipo.
 *       * filtrarTemperaturasFiebre(): devuelve lista de todas las medidas de temperatura > 37°C.
 *       * saturacionMasAltaGlobal(): obtiene la medida de saturación más alta de todas.
 *       * ordenarPulsoDescendente(): reordena la lista global para poner las de pulso de mayor a menor.
 */
public class ListaMedidas {

    private List<Medida> lista;

    public ListaMedidas() {
        this.lista = new ArrayList<>();
    }

    /**
     * Añade una medida a la lista global.
     */
    public void addMedida(Medida m) {
        lista.add(m);
    }

    /**
     * Devuelve todas las medidas almacenadas.
     */
    public List<Medida> getTodas() {
        return lista;
    }

    /**
     * Devuelve una lista de medidas cuyo tipo sea igual a t (SATURACION, PULSO, TEMPERATURA).
     */
    public List<Medida> filtrarPorTipo(TipoMedida t) {
        List<Medida> res = new ArrayList<>();
        for (Medida m : lista) {
            if (m.getTipo() == t) {
                res.add(m);
            }
        }
        return res;
    }

    /**
     * Devuelve todas las medidas de temperatura con valor > 37.0.
     */
    public List<Medida> filtrarTemperaturasFiebre() {
        List<Medida> res = new ArrayList<>();
        for (Medida m : lista) {
            if (m.getTipo() == TipoMedida.TEMPERATURA && m.getValor() > 37.0) {
                res.add(m);
            }
        }
        return res;
    }

    /**
     * Obtiene la medida de saturación más alta de TODAS las medidas de tipo SATURACION.
     * Si no hay medidas de saturación, devuelve null.
     */
    public Medida saturacionMasAltaGlobal() {
        return lista.stream()
                .filter(m -> m.getTipo() == TipoMedida.SATURACION)
                .max(Comparator.comparingDouble(Medida::getValor))
                .orElse(null);
    }

    /**
     * Ordena las medidas de pulso en la lista global de mayor a menor (por valor).
     * Después de llamar a este método, la lista interna quedará reordenada:
     * primero las medidas de tipo PULSO de mayor a menor, y luego el resto de tipos.
     */
    public void ordenarPulsoDescendente() {
        // Primero separamos las de PULSO y el resto
        List<Medida> pulso = new ArrayList<>();
        List<Medida> resto = new ArrayList<>();
        for (Medida m : lista) {
            if (m.getTipo() == TipoMedida.PULSO) {
                pulso.add(m);
            } else {
                resto.add(m);
            }
        }

        // Ordenamos la lista de pulso de mayor a menor:
        pulso.sort((m1, m2) -> Double.compare(m2.getValor(), m1.getValor()));

        // Reconstruimos la lista interna:
        lista.clear();
        lista.addAll(pulso);
        lista.addAll(resto);
    }
}
