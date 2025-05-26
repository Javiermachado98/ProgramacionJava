import java.util.ArrayList;

// Imports para XML
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;

public class ListaViajes {

    private ArrayList<Viaje> lista; // Lista que almacena los viajes.

    // Constructor que inicializa la lista de viajes.
    public ListaViajes() {
        lista = new ArrayList();
    }

    public ArrayList<Viaje> getlista() {
        return lista;
    }

    public void setlista(ArrayList<Viaje> lista) {
        this.lista = lista;
    }

    // Método para añadir un viaje a la lista.
    public void anadirViaje(Viaje p) {
        lista.add(p);
    }

    // Método que devuelve un viaje dada su posición
    public Viaje viajePosicion (int posicion) {
        return (lista.get(posicion));
    }

    // Método para listar todos los viajes.
    public void listarViajes() {
        for (Viaje p : lista) {
            System.out.println(p);
        }
    }

    // Método para listar los viajes con un destino determinado
    public void mostrarViajesConDestino(String destino) {
        for (Viaje p : lista) {
            if (p.getDestino().equals(destino)) {
                System.out.println(p);
            }
        }
    }

    // Método que devuelve el número de viajes en la lista.
    public int numeroViajes() {
        return lista.size();
    }

    @Override
    public String toString() {
        String s = "Lista Viajes: ";
        for (Viaje a : lista) {
            s = s + "\n " + a;
        }
        return s;
    }

    // NUEVO: Exportar a fichero XML sin modificar el resto del código
    public void exportarXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.newDocument();

            Element raiz = documento.createElement("viajes");
            documento.appendChild(raiz);

            for (Viaje v : lista) {
                Element viajeElem = documento.createElement("viaje");

                Element codigo = documento.createElement("codigo");
                codigo.appendChild(documento.createTextNode(v.getCodigo()));
                viajeElem.appendChild(codigo);

                Element tipo = documento.createElement("tipo");
                tipo.appendChild(documento.createTextNode(v.getTipo().toString()));
                viajeElem.appendChild(tipo);

                Element fecha = documento.createElement("fecha");
                fecha.appendChild(documento.createTextNode(v.getFecha()));
                viajeElem.appendChild(fecha);

                Element origen = documento.createElement("origen");
                origen.appendChild(documento.createTextNode(v.getOrigen()));
                viajeElem.appendChild(origen);

                Element destino = documento.createElement("destino");
                destino.appendChild(documento.createTextNode(v.getDestino()));
                viajeElem.appendChild(destino);

                Element importe = documento.createElement("importeBase");
                importe.appendChild(documento.createTextNode(Double.toString(v.getImporteBase())));
                viajeElem.appendChild(importe);

                raiz.appendChild(viajeElem);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(documento);

            File ficheroSalida = new File("src" + File.separator + "files" + File.separator + "viajes.xml");
            StreamResult resultado = new StreamResult(ficheroSalida);

            transformer.transform(source, resultado);

            System.out.println("Fichero viajes.xml exportado correctamente.");
        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println("Error al exportar XML: " + e.getMessage());
        }
    }
}
