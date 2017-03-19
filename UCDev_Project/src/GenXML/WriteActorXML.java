package GenXML;


import Main.FileBrowser;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FilmKhonDee
 */
public class WriteActorXML {
    DocumentBuilderFactory docFactory;
    DocumentBuilder docBuilder;
    Document doc;
    Element rootElement;
    
    //save file
    TransformerFactory transformerFactory;
    Transformer transformer;
    DOMSource source;
    StreamResult result;
    String fileName;
    
    //add element
    Element actor,idElement,titleElement,descriptElement,sterioElement;
    Attr attr;
    
    //variable of use
    String id,title,descrip,sterio;
    
    public WriteActorXML(String id,String title,String descrip,String sterio){
        this.id = id;
        this.title = title;
        this.descrip = descrip;
        this.sterio = sterio;
        
        getDocFactory();
        getDocBuilder();
        getDoc();
        getRootElement();
        getIdElement();
        getTitleElement();
        getDescriptElement();
        getSterioElement();
        getTransformerFactory();
        getTransformer();
        getSource();
        getResult();
    }

    public DocumentBuilderFactory getDocFactory() {
        docFactory = DocumentBuilderFactory.newInstance();
        return docFactory;
    }

    public DocumentBuilder getDocBuilder() {
        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return docBuilder;
    }

    public Document getDoc() {
        doc = docBuilder.newDocument();
        return doc;
    }

    public Element getRootElement() {
        rootElement = doc.createElement("actor");
        doc.appendChild(rootElement);
        return rootElement;
    }

    public Element getIdElement() {
        idElement = doc.createElement("Id");
        idElement.appendChild(doc.createTextNode(id));
        rootElement.appendChild(idElement);
        return idElement;
    }

    public Element getTitleElement() {
        titleElement = doc.createElement("title");
        titleElement.appendChild(doc.createTextNode(title));
        rootElement.appendChild(titleElement);
        return titleElement;
    }

    public Element getDescriptElement() {
        descriptElement = doc.createElement("description");
        descriptElement.appendChild(doc.createTextNode(descrip));
        rootElement.appendChild(descriptElement);
        return descriptElement;
    }

    public Element getSterioElement() {
        sterioElement = doc.createElement("stereotype");
        sterioElement.appendChild(doc.createTextNode(sterio));
        rootElement.appendChild(sterioElement);
        return sterioElement;
    }
    
    public TransformerFactory getTransformerFactory() {
        transformerFactory = TransformerFactory.newInstance();
        return transformerFactory;
    }

    public Transformer getTransformer() {
        try {
            transformer = transformerFactory.newTransformer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transformer;
    }

    public DOMSource getSource() {
        source = new DOMSource(doc);
        
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        return source;
    }

    public StreamResult getResult() {
        FileBrowser file = new FileBrowser();
        try {
            result = new StreamResult(new File("D:\\Doc\\ProjectName\\Actor\\"+id+".xml"));
            //result = new StreamResult(System.out);
            transformer.transform(source, result);
            System.out.println("Save file");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescrip() {
        return descrip;
    }

    public String getSterio() {
        return sterio;
    }
    
    public static void main(String[] arg){
        WriteActorXML xml = new WriteActorXML("1","film","khondee","20000");
    }
}