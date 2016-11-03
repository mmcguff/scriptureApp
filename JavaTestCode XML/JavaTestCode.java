/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatestcode;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author Julian
 */
public class JavaTestCode {

    public static void main(String[] args) {

    try 
    {

	File file = new File("scriptures.xml");

	DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                             .newDocumentBuilder();

	Document doc = dBuilder.parse(file);
        
	System.out.println(doc.getDocumentElement().getNodeName().substring(0,1).toUpperCase()+doc.getDocumentElement().getNodeName().substring(1));
        System.out.println("-----------------------");
	if (doc.hasChildNodes()) {

		printNote(doc.getChildNodes());

	}

    } catch (Exception e) {
	System.out.println(e.getMessage());
    }

  }

private static void printNote(NodeList nodeList) {
    String[] ScriptList = new String[4];
    String scripture;
    for (int count = 0; count < nodeList.getLength(); count++) {

	Node tempNode = nodeList.item(count);

	// make sure it's element node.
	if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

            if (tempNode.hasAttributes()) {

                // get attributes names and values
                NamedNodeMap nodeMap = tempNode.getAttributes();

                for (int i = 0; i < nodeMap.getLength(); i++) {

                        Node node = nodeMap.item(i);
                        //System.out.println("attr name : " + node.getNodeName());

                //This is where I am running into issue.  Can't seem to return the element name
                String elementName = "not set";
                String AtValue = node.getNodeValue();

                if(AtValue.contains("Book of Mormon")){
                 elementName = "Scripture"; 
                }

                if(AtValue.contains("1 Nephi")||
                   AtValue.contains("2 Nephi")||
                   AtValue.contains("James")||
                   AtValue.contains("Moroni")){
                    elementName = "Book";
                    ScriptList[i] = AtValue;
                }
                
                if(AtValue.contains("Ch.")){
                 elementName = "Chapter"; 
                }
                
                if(AtValue.contains("V.")){
                 elementName = "Verse"; 
                }
                
                if(elementName.equals("not set")){
                  elementName = "Content";
                }

                System.out.println(elementName + " " + node.getNodeName() + ": " + node.getNodeValue());

                }

            }

            if (tempNode.hasChildNodes()) {

                // loop again if has child nodes
                printNote(tempNode.getChildNodes());
            }
        }

    }
    
        testXML1();
		
        for (int i = 0; i < 4; i++)
        {
            scripture = ScriptList[i];
            testXML2(scripture);
        }
        int random = (int)(Math.random() * 4);
        assert(4 >= random);
        assert(random >= 0);
        scripture = ScriptList[random];
        System.out.println(scripture);
    }
	public static void testXML1()
	{
		int random;
		for (int i = 0; i < 10; i++)
		{
			random = (int)(Math.random() * 10);
			assert(5 >= random);
			assert(random >= 0);
		}
		System.out.println("\nTest 1 complete");
	}
	public static void testXML2(String scripture)
	{
		assert (scripture instanceof String);
		System.out.println(scripture + "\tPass.");
	}
}
        

   

    

