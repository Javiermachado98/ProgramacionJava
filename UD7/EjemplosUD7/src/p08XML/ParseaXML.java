/*
 */
package p08XML;

/**
 *
 * @author admin
 */
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class ParseaXML {

    public static void main(String[] args) {

        // Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try ( InputStream is = readXmlFileIntoInputStream("empleados.xml")) {

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            // read from a project's resources folder
            Document doc = db.parse(is);

            System.out.println("Elemento raíz :" + doc.getDocumentElement().getNodeName());
            System.out.println("------");

            if (doc.hasChildNodes()) {
                printNote(doc.getChildNodes());
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

    private static void printNote(NodeList nodeList) {

        for (int count = 0; count < nodeList.getLength(); count++) {

            Node tempNode = nodeList.item(count);

            // make sure it's element node.
            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

                // get node name and value
                System.out.println("\nNombre de nodo =" + tempNode.getNodeName() + " [ABRIR]");
                System.out.println("Valor de nodo =" + tempNode.getTextContent());

                if (tempNode.hasAttributes()) {

                    // get attributes names and values
                    NamedNodeMap nodeMap = tempNode.getAttributes();
                    for (int i = 0; i < nodeMap.getLength(); i++) {
                        Node node = nodeMap.item(i);
                        System.out.println("Nombre de atributo : " + node.getNodeName());
                        System.out.println("Valor de atributo : " + node.getNodeValue());
                    }

                }

                if (tempNode.hasChildNodes()) {
                    // loop again if has child nodes
                    printNote(tempNode.getChildNodes());
                }

                System.out.println("Nombre de nodo =" + tempNode.getNodeName() + " [CERRAR]");

            }

        }

    }

    // read file from project resource's folder.
    private static InputStream readXmlFileIntoInputStream(final String fileName) {
        return ParseaXML.class.getClassLoader().getResourceAsStream(fileName);
    }

}
