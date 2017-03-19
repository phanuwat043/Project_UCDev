package GenXML;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML_Usecase {
    
    String fileName;
    File xmlFile;
    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder;
    Document doc;
    public Element eElement;
    public NodeList nList;
    public Node nNode;

    public String id,name,primay,priority,complex,goal,pre,post,flow,alternate,exception;
    public ReadXML_Usecase(String id,String name,String primay,String priority
            ,String complex,String goal,String pre,String post,String flow
            ,String alternate,String exception,String fileName){
        this.id = id;
        this.name = name;
        this.primay = primay;
        this.priority = priority;
        this.complex = complex;
        this.goal = goal;
        this.pre = pre;
        this.post = post;
        this.flow = flow;
        this.alternate = alternate;
        this.exception = exception;
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

    public Element getElement() {
        return eElement;
    }

    public NodeList getnList() {
        return nList;
    }

    public Node getnNode() {
        return nNode;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrimay() {
        return primay;
    }

    public String getPriority() {
        return priority;
    }

    public String getComplex() {
        return complex;
    }

    public String getGoal() {
        return goal;
    }

    public String getPre() {
        return pre;
    }

    public String getPost() {
        return post;
    }

    public String getFlow() {
        return flow;
    }

    public String getAlternate() {
        return alternate;
    }

    public String getException() {
        return exception;
    }
    
    public void readXML(){
        try {
            nList = doc.getElementsByTagName("use-case");

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
        ReadXML_Usecase xml = new ReadXML_Usecase("use-case-Id","","","","","","","","","","","C:\\Users\\FilmKhonDee\\Desktop\\file.xml");
        for (int temp = 0; temp < xml.nList.getLength(); temp++) {
            xml.nNode = xml.nList.item(temp);
            if (xml.nNode.getNodeType() == Node.ELEMENT_NODE) {
                xml.eElement = (Element) xml.nNode;
                //System.out.println(xml.eElement.getElementsByTagName(xml.id).item(0).getTextContent());
                //System.out.println(xml.eElement.getElementsByTagName(xml).item(0).getTextContent());
                //System.out.println(xml.eElement.getElementsByTagName(xml.fname).item(0).getTextContent());
                //String id = xml.eElement.getElementsByTagName(xml.fname).item(0).getTextContent();
                //System.out.println(id);
            }
        }
    }*/
}
