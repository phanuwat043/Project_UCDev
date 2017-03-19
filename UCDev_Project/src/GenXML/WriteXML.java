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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FilmKhonDee
 */
public class WriteXML {
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
    Element company,fnameElement,lanameElement,salaryElement;
    Attr attr;
    
    //variable of use
    String id,fname,lname,salary;
    
    public WriteXML(String id,String fname,String lname,String salary){
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
        
        getDocFactory();
        getDocBuilder();
        getDoc();
        getRootElement();
        getCompany();
        getAttr();
        getFnameElement();
        getLanameElement();
        getSalaryElement();
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
        rootElement = doc.createElement("company");
        doc.appendChild(rootElement);
        return rootElement;
    }

    public Element getCompany() {
        company = doc.createElement("staff");
        rootElement.appendChild(company);
        return company;
    }

    public Attr getAttr() {
        attr = doc.createAttribute("id");
        attr.setValue(id);
        company.setAttributeNode(attr);
        return attr;
    }

    public Element getFnameElement() {
        fnameElement = doc.createElement("firstname");
        fnameElement.appendChild(doc.createTextNode(fname));
        company.appendChild(fnameElement);
        return fnameElement;
    }

    public Element getLanameElement() {
        lanameElement = doc.createElement("lastname");
        lanameElement.appendChild(doc.createTextNode(lname));
        company.appendChild(lanameElement);
        return lanameElement;
    }

    public Element getSalaryElement() {
        salaryElement = doc.createElement("salary");
        salaryElement.appendChild(doc.createTextNode(salary));
        company.appendChild(salaryElement);
        return salaryElement;
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
        try {
            result = new StreamResult(new File("D:\\"+id+".xml"));
            //result = new StreamResult(System.out);
            transformer.transform(source, result);
            System.out.println("Save file");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public String getId() {
        Attr attr = doc.createAttribute("id");
        attr.setValue(id);
        company.setAttributeNode(attr);
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
    
    public static void main(String[] arg){
        WriteXML xml = new WriteXML("1","film","khondee","20000");
        xml.getId();
        xml.getFname();
        xml.getLname();
        xml.getSalary();
    }
}