/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author FilmKhonDee
 */
public class WriteXML_Usecase {
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
    
    Attr attr;
    Element idElement,nameElement,primayElement,priorityElement,complexElement
            ,goalElement,preElement,postElement,flowElement,alternateElement,exceptionElement;
    String id,name,primary,priority,complex,goal,pre,post,flow,alternate,exception;
    
    public WriteXML_Usecase(String id,String name,String primay,String priority
            ,String complex,String goal,String pre,String post,String flow
            ,String alternate,String exception){
        this.id = id;
        this.name = name;
        this.primary = primay;
        this.priority = priority;
        this.complex = complex;
        this.goal = goal;
        this.pre = pre;
        this.post = post;
        this.flow = flow;
        this.alternate = alternate;
        this.exception = exception;
        
        getDocFactory();
        getDocBuilder();
        getDoc();
        getRootElement();
        getIdElement();
        getNameElement();
        getPrimayElement();
        getPriorityElement();
        getComplexElement();
        getGoalElement();
        getPreElement();
        getPostElement();
        getFlowElement();
        getAlternateElement();
        getExceptionElement();
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
        rootElement = doc.createElement("use-case");
        doc.appendChild(rootElement);
        return rootElement;
    }

    public Element getIdElement() {
        idElement = doc.createElement("use-case-Id");
        idElement.appendChild(doc.createTextNode(id));
        rootElement.appendChild(idElement);
        return idElement;
    }

    public Element getNameElement() {
        nameElement = doc.createElement("use-case-Name");
        nameElement.appendChild(doc.createTextNode(name));
        rootElement.appendChild(nameElement);
        return nameElement;
    }

    public Element getPrimayElement() {
        primayElement = doc.createElement("primary-actor");
        primayElement.appendChild(doc.createTextNode(primary));
        rootElement.appendChild(primayElement);
        return primayElement;
    }

    public Element getPriorityElement() {
        priorityElement = doc.createElement("priority");
        priorityElement.appendChild(doc.createTextNode(priority));
        rootElement.appendChild(priorityElement);
        return priorityElement;
    }

    public Element getComplexElement() {
        complexElement = doc.createElement("complexity");
        complexElement.appendChild(doc.createTextNode(complex));
        rootElement.appendChild(complexElement);
        return complexElement;
    }

    public Element getGoalElement() {
        goalElement = doc.createElement("goal");
        goalElement.appendChild(doc.createTextNode(goal));
        rootElement.appendChild(goalElement);
        return goalElement;
    }

    public Element getPreElement() {
        preElement = doc.createElement("pre-requisites");
        preElement.appendChild(doc.createTextNode(pre));
        rootElement.appendChild(preElement);
        return preElement;
    }

    public Element getPostElement() {
        postElement = doc.createElement("success-outcome");
        postElement.appendChild(doc.createTextNode(post));
        rootElement.appendChild(postElement);
        return postElement;
    }

    public Element getFlowElement() {
        flowElement = doc.createElement("main-flow");
        flowElement.appendChild(doc.createTextNode(flow));
        rootElement.appendChild(flowElement);
        return flowElement;
    }

    public Element getAlternateElement() {
        alternateElement = doc.createElement("alternate-flows");
        alternateElement.appendChild(doc.createTextNode(alternate));
        rootElement.appendChild(alternateElement);
        return alternateElement;
    }

    public Element getExceptionElement() {
        exceptionElement = doc.createElement("exception-flows");
        exceptionElement.appendChild(doc.createTextNode(exception));
        rootElement.appendChild(exceptionElement);
        return exceptionElement;
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
            result = new StreamResult(new File("D:\\Doc\\ProjectName\\UseCase\\"+id+".xml"));
            //result = new StreamResult(System.out);
            transformer.transform(source, result);
            System.out.println("Save file");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getFileName() {
        return fileName;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrimary() {
        return primary;
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
    
    /*public static void main(String[] arg){
        WriteXML_Usecase xml = new WriteXML_Usecase("1","film","khondee","20000","1","1","1","1","1","1","1");
    }*/
}
