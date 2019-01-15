package main;

import java.io.IOException;
import java.text.ParseException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

    double price;

    public static void main(String[] args) throws XMLStreamException, IOException, XPathExpressionException, ParserConfigurationException, SAXException, ParseException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse("catalog.xml");
        doc.getDocumentElement();

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("book");

        System.out.println("*************************");

        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;
                Double price = Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent());
                int year = Integer.parseInt(eElement.getElementsByTagName("publish_date").item(0).getTextContent().substring(0, 4));
                if (price > 10 && year > 2005) {

                    System.out.println("Book id : " + eElement.getAttribute("id"));
                    System.out.println("Author : " + eElement.getElementsByTagName("author").item(0).getTextContent());
                    System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Genre : " + eElement.getElementsByTagName("genre").item(0).getTextContent());
                    System.out.println("Price : " + eElement.getElementsByTagName("price").item(0).getTextContent());
                    System.out.println("Publish_date : " + eElement.getElementsByTagName("publish_date").item(0).getTextContent());
                    System.out.println("Description : " + eElement.getElementsByTagName("description").item(0).getTextContent());

                    System.out.println("*************************");
                }

            }
        }
    }

}
