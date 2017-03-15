/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import Main.UCDev_Main;
/**
 *
 * @author FilmKhonDee
 */
public class ActorXMLfile {
    public void getInfo(String id, String title1, String des, String type){
        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("xuse:actors");
            doc.appendChild(rootElement);
            
            Element Actor = doc.createElement("xuse:actor");
            //Actor.appendChild(doc.createTextNode())
            rootElement.appendChild(Actor);
            
            Attr attr = doc.createAttribute("id");
            attr.setValue(id);
            Actor.setAttributeNode(attr);
            
            Element title = doc.createElement("xuse:title");
            title.appendChild(doc.createTextNode(title1));
            Actor.appendChild(title);
            
            Element description = doc.createElement("xuse:description");
            description.appendChild(doc.createTextNode(des));
            Actor.appendChild(description);
            
            Element stereotype = doc.createElement("xuse:stereotype");
            stereotype.appendChild(doc.createTextNode(type));
            Actor.appendChild(stereotype);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            //StreamResult result = new StreamResult(new File("D:\\file.xml"));
            // Output to console for testing
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

            System.out.println("File saved!");
            
        }catch(ParserConfigurationException e){
            e.printStackTrace();
        }catch(TransformerException e1){
            e1.printStackTrace();
        }
    }
}
