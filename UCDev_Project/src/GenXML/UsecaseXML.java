
package GenXML;

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

public class UsecaseXML {
    
    public void getInfo(String id,String name,String primary,String piority,String complex,String pre,String post,String goal) {
        try {
            //WriteXMLfile xml = new WriteXMLfile();
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("xuse:use-case");
            doc.appendChild(rootElement);
           
            Attr attr = doc.createAttribute("id");
            attr.setValue(id);
            rootElement.setAttributeNode(attr);
            
            Attr attr1 = doc.createAttribute("name");
            attr1.setValue(name);
            rootElement.setAttributeNode(attr1);
            
            Attr attr2 = doc.createAttribute("version");
            attr2.setValue("1.0");
            rootElement.setAttributeNode(attr2);
            
            Element UcDesc = doc.createElement("xuse:description");
            UcDesc.appendChild(doc.createTextNode("describe flow to create user"));
            rootElement.appendChild(UcDesc);
            
            Element UcProp = doc.createElement("xuse:use-case-properties");
            rootElement.appendChild(UcProp);
            
            Element UcTrigger = doc.createElement("xuse:trigger");
            UcTrigger.appendChild(doc.createTextNode("Trigger"));
            UcProp.appendChild(UcTrigger);
            
            Element UcGoal = doc.createElement("xuse:goal");
            UcGoal.appendChild(doc.createTextNode(goal));
            UcProp.appendChild(UcGoal);
            
            Element UcPriActor = doc.createElement("xuse:primary-actor");
            UcProp.appendChild(UcPriActor);
            
            Attr attr4 = doc.createAttribute("refId");
            attr4.setValue(primary);
            UcPriActor.setAttributeNode(attr4);
            
            Element UcPreRequis = doc.createElement("xuse:pre-requisites");
            UcPreRequis.appendChild(doc.createTextNode(pre));
            UcProp.appendChild(UcPreRequis);
            
            Element UcSucOut = doc.createElement("xuse:success-outcome");
            UcSucOut.appendChild(doc.createTextNode(post));
            UcProp.appendChild(UcSucOut);
            
            Element UcFailOut = doc.createElement("xuse:failure-outcome");
            UcFailOut.appendChild(doc.createTextNode(name));
            UcProp.appendChild(UcFailOut);
            
            Element UcPrior = doc.createElement("xuse:priority");
            UcPrior.appendChild(doc.createTextNode(piority));
            UcProp.appendChild(UcPrior);
            
            Element UcComplex = doc.createElement("xuse:complexity");
            UcComplex.appendChild(doc.createTextNode(complex));
            UcProp.appendChild(UcComplex);
            
            Element UcTax = doc.createElement("xuse:taxonomy");
            UcTax.appendChild(doc.createTextNode(name));
            UcProp.appendChild(UcTax);
            
            Attr attr5 = doc.createAttribute("classifier");
            attr5.setValue(name);
            UcTax.setAttributeNode(attr5);
            
            Element UcMainFlow = doc.createElement("xuse:main-flow");
            rootElement.appendChild(UcMainFlow);
            
            Element Ucstep = doc.createElement("xuse:step");
            UcMainFlow.appendChild(Ucstep);
            
            Attr attr3 = doc.createAttribute("step-id");
            attr3.setValue("1.0");
            Ucstep.setAttributeNode(attr3);
            
            Element UcStepDesc = doc.createElement("xuse:description");
            UcStepDesc.appendChild(doc.createTextNode(name));
            Ucstep.appendChild(UcStepDesc);
            
            Element UcRefAlflow = doc.createElement("xuse:ref-alternate-flow");
            Ucstep.appendChild(UcRefAlflow);
            
            Attr attr6 = doc.createAttribute("refId");
            attr6.setValue(name);
            UcRefAlflow.setAttributeNode(attr6);
            
            Attr attr7 = doc.createAttribute("condition");
            attr7.setValue(name);
            UcRefAlflow.setAttributeNode(attr7);
            
            Element UcAlterflow = doc.createElement("xuse:alternate-flows");
            rootElement.appendChild(UcAlterflow);
            
            Element UcAlterflowSub = doc.createElement("xuse:alternate-flow");
            UcAlterflow.appendChild(UcAlterflowSub);
            
            Attr attr8 = doc.createAttribute("id");
            attr8.setValue(name);
            UcAlterflowSub.setAttributeNode(attr8);
            
            Attr attr9 = doc.createAttribute("title");
            attr9.setValue(name);
            UcAlterflowSub.setAttributeNode(attr9);
            
            Element Alstep = doc.createElement("xuse:step");
            UcAlterflowSub.appendChild(Alstep);
            
            Attr attr10 = doc.createAttribute("step-id");
            attr10.setValue(name);
            Alstep.setAttributeNode(attr10);
            
            Element UcDescSubAl = doc.createElement("xuse:description");
            UcDescSubAl.appendChild(doc.createTextNode(name));
            Alstep.appendChild(UcDescSubAl);
            
            Element rejoin = doc.createElement("xuse:rejoin");
            UcAlterflowSub.appendChild(rejoin);
            
            Attr attr11 = doc.createAttribute("at-step");
            attr11.setValue(name);
            rejoin.setAttributeNode(attr11);
            
            Element UcExcepflow = doc.createElement("xuse:exception-flows");
            rootElement.appendChild(UcExcepflow);
            
            Element UcExcepflowSub = doc.createElement("xuse:exception-flow");
            UcExcepflow.appendChild(UcExcepflowSub);
            
            Attr attr12 = doc.createAttribute("id");
            attr12.setValue(name);
            UcExcepflowSub.setAttributeNode(attr12);
            
            Attr attr13 = doc.createAttribute("title");
            attr13.setValue(name);
            UcExcepflowSub.setAttributeNode(attr13);
            
            Element Exstep = doc.createElement("xuse:step");
            UcExcepflowSub.appendChild(Exstep);
            
            Attr attr14 = doc.createAttribute("step-id");
            attr14.setValue(name);
            Exstep.setAttributeNode(attr14);
            
            Element UcDescSubEx = doc.createElement("xuse:description");
            UcDescSubEx.appendChild(doc.createTextNode(name));
            Exstep.appendChild(UcDescSubEx);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            
            //Save file XML
            //StreamResult result = new StreamResult(new File("C:\\file.xml"));
            
            // Output to console for testing
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (Exception e) {
            e.printStackTrace();
        }
        //return id;
    }
}
