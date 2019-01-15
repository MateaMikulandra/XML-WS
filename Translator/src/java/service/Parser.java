package service;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

    public static String Parse(String par) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse("http://localhost:8080/Translator/translator.xml");
        doc.getDocumentElement();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        Element r = doc.getDocumentElement();
        NodeList nList = r.getElementsByTagName("rec");
        NodeList sr = r.getElementsByTagName("sr");
        NodeList esp = r.getElementsByTagName("esp");
        

        for(int i=0; i<nList.getLength();i++)
        {
            Element r1 = (Element) sr.item(i);
            Element r2 = (Element) esp.item(i);
            String r1sr = r1.getTextContent();
            String r2esp = r2.getTextContent();
           if(par.equalsIgnoreCase(r1sr))
           {
               par = r2esp;
           }else if(par.equalsIgnoreCase(r2esp)) {
               par = r1sr;
           }

        
        }
        return par;
    }
}
