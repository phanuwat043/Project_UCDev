package GenXML;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadActorXML {
    String fileName;
    File xmlFile;
    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder;
    Document doc;
    public Element eElement;
    public NodeList nList;
    public Node nNode;
    
    public String id,title,descrip,sterio;
    
    public ReadActorXML(String id,String title,String descrip,String sterio,String fileName){
        this.id = id;
        this.title = title;
        this.descrip = descrip;
        this.sterio = sterio;
        this.fileName = fileName;
        
        getFileName();
        getXmlFile();
        getDbFactory();
        getdBuilder();
        getDoc();
        readXML();
        
    }

    public String getFileName() {
        return fileName;
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

    public File getXmlFile() {
        xmlFile = new File(fileName);
        return xmlFile;
    }

    public DocumentBuilderFactory getDbFactory() {
        dbFactory = DocumentBuilderFactory.newInstance();
        return dbFactory;
    }

    public DocumentBuilder getdBuilder() {
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dBuilder;
    }

    public Document getDoc() {
        try {
            doc = dBuilder.parse(xmlFile);
            
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }

    public void readXML(){
        try {
            nList = doc.getElementsByTagName("actor");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                nNode = nList.item(temp);

                //System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    eElement = (Element) nNode;
                    //eElement.getAttribute(id);
                    //eElement.getElementsByTagName(fname).item(0).getTextContent();
                    //eElement.getElementsByTagName(lname).item(0).getTextContent();
                    //eElement.getElementsByTagName("nickname").item(0).getTextContent();
                    //eElement.getElementsByTagName(salary).item(0).getTextContent();
                }
            }
        } catch (Exception e) {
        }
    }
    
    /*public static void main(String[] args){
        ReadActorXML xml = new ReadActorXML("Id","title","description","stereotype","C:\\Users\\FilmKhonDee\\Desktop\\ActorFile.xml");
        for (int temp = 0; temp < xml.nList.getLength(); temp++) {
            xml.nNode = xml.nList.item(temp);
            if (xml.nNode.getNodeType() == Node.ELEMENT_NODE) {
                xml.eElement = (Element) xml.nNode;
                String id = xml.eElement.getAttribute(xml.id);
                System.out.println(xml.eElement.getElementsByTagName(xml.id).item(0).getTextContent());
                System.out.println(xml.eElement.getElementsByTagName(xml.title).item(0).getTextContent());
                //System.out.println(xml.eElement.getElementsByTagName(xml.fname).item(0).getTextContent());
                //String id = xml.eElement.getElementsByTagName(xml.fname).item(0).getTextContent();
                //System.out.println(id);
            }
        }
    }*/
}
