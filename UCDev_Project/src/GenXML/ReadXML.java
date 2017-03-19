package GenXML;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXML {
    String fileName;
    File xmlFile;
    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder;
    Document doc;
    Element eElement;
    NodeList nList;
    Node nNode;
    
    String id,fname,lname,salary;
    
    public ReadXML(String id,String fname,String lname,String salary,String fileName){
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
        this.fileName = fileName;
        
        getFileName();
        getXmlFile();
        getDbFactory();
        getdBuilder();
        getDoc();
        readXML();
        
    }

    public String getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getSalary() {
        return salary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public void readXML(){
        try {
            nList = doc.getElementsByTagName("staff");

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
    
    public static void main(String[] args){
        ReadXML xml = new ReadXML("id","","","","C:\\staff.xml");
        for (int temp = 0; temp < xml.nList.getLength(); temp++) {
            xml.nNode = xml.nList.item(temp);
            if (xml.nNode.getNodeType() == Node.ELEMENT_NODE) {

                xml.eElement = (Element) xml.nNode;
                String id = xml.eElement.getAttribute(xml.id);
                System.out.println(id);
                
                //System.out.println(xml.eElement.getElementsByTagName(xml.fname).item(0).getTextContent());
                //String id = xml.eElement.getElementsByTagName(xml.fname).item(0).getTextContent();
                //System.out.println(id);
            }
        }
    }
}
