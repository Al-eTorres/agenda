import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {

    public Agenda() {
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Interfaz interfaz = new Interfaz();

        interfaz.setVisible(true);
        interfaz.eventoAgregar();
        interfaz.eventoGuardar();
        interfaz.eventoBuscar();

    }

    private static void leyendoXml(ArrayList<Contacto> array) {


        try {
            DocumentBuilderFactory docBuilFact = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder docBuild = docBuilFact.newDocumentBuilder();
            Document documento = docBuild.parse("contactosAgendados.xml");


          /*for(int i = 0;i < contactosEnLista.getLength(); i++){

                Node contacto = contactosEnLista.item(i);

                if (contacto.getNodeType() == Node.ELEMENT_NODE){

                    Element elemContacto = (Element) contacto;
                    NodeList datosContacto = elemContacto.getChildNodes();

                    for (int j = 0;j < datosContacto.getLength(); j++){

                        Node cadaDatoDelContacto = datosContacto.item(j);

                        if (cadaDatoDelContacto.getNodeType() == Node.ELEMENT_NODE){

                            Element elemDato = (Element) cadaDatoDelContacto;
                            System.out.println(cadaDatoDelContacto.getNodeName()+": "+cadaDatoDelContacto.getTextContent());

                        }
                    }
                }
            }

           */
            for (int i = 0;i < array.size();i++) {
                NodeList contactosEnLista = documento.getElementsByTagName("contacto");
                Node contacto = contactosEnLista.item(i);

                if (contacto.getNodeType() == Node.ELEMENT_NODE){

                    Element elemContacto = (Element) contacto;
                    NodeList datosContacto = elemContacto.getChildNodes();

                    for (int j = 0;j < datosContacto.getLength(); j++){

                        Node cadaDatoDelContacto = datosContacto.item(j);

                        if (cadaDatoDelContacto.getNodeType() == Node.ELEMENT_NODE){

                            System.out.println(cadaDatoDelContacto.getNodeName()+": "+cadaDatoDelContacto.getTextContent());

                        }
                    }
                }
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }

    }

    public static void escribiendoXml(ArrayList<Contacto> array) {

            DocumentBuilderFactory docBuilFact = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder docBuild = null;
            try {
                docBuild = docBuilFact.newDocumentBuilder();

            } catch (ParserConfigurationException e) {
                throw new RuntimeException(e);
            }

            DOMImplementation implementation = docBuild.getDOMImplementation();

            Document documento = implementation.createDocument(null,"agenda",null);
            documento.setXmlVersion("1.0");
            Element lista_contactos = documento.createElement("lista_contactos");

            for (Contacto c: array) {

                Element contacto = documento.createElement("contacto");
                lista_contactos.appendChild(contacto);

                Element nombre = documento.createElement("nombre");
                Text textNombre = documento.createTextNode(c.getNombre());
                nombre.appendChild(textNombre);
                contacto.appendChild(nombre);


                Element apellido = documento.createElement("apellido");
                Text textApellido = documento.createTextNode(c.getApellido());
                apellido.appendChild(textApellido);
                contacto.appendChild(apellido);


                Element telefono = documento.createElement("telefono");
                Text textTelefono = documento.createTextNode(c.getTelefono());
                telefono.appendChild(textTelefono);
                contacto.appendChild(telefono);

                lista_contactos.appendChild(contacto);
            }
            documento.getDocumentElement().appendChild(lista_contactos);

            Source source = new DOMSource(documento);
            Result result = new StreamResult(new File("contactosAgendados.xml"));

            Transformer transform = null;
            try {
                transform = TransformerFactory.newDefaultInstance().newTransformer();
            } catch (TransformerConfigurationException e) {
                throw new RuntimeException(e);
            }
            try {
                transform.transform(source,result);
            } catch (TransformerException e) {
                throw new RuntimeException(e);
            }

        }




}









