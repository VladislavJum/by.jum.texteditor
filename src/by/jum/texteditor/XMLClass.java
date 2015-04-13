package by.jum.texteditor;

import by.jum.texteditor.windows.symbol.Symbol;
import by.jum.texteditor.windows.symbol.SymbolStorage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Created by Vlad on 11.04.2015.
 */
public class XMLClass {
    Element rootElement;
    private SymbolStorage symbolStorage;
    private List<Symbol> list;

    public XMLClass(SymbolStorage symbolStorage) {
        this.symbolStorage = symbolStorage;
        list = symbolStorage.getSymbolList();
    }

    public void a() throws IOException, TransformerException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document document = builder.newDocument();

        rootElement = document.createElement("symbols");
        document.appendChild(rootElement);

        for (Symbol s : list) {
            Element symbol = document.createElement("symbol");
            rootElement.appendChild(symbol);
            symbol.setAttribute("nameSymbol", s.getSymbol());

            Element nameStyle = document.createElement("nameStyle");
            nameStyle.appendChild(document.createTextNode(s.getDocument().getFamily()));
            symbol.appendChild(nameStyle);

            Element sizeStyle = document.createElement("sizeStyle");
            sizeStyle.appendChild(document.createTextNode(String.valueOf(s.getDocument().getSize())));
            symbol.appendChild(sizeStyle);

            Element fontStyle = document.createElement("fontStyle");
            fontStyle.appendChild(document.createTextNode(String.valueOf(s.getDocument().getStyle())));
            symbol.appendChild(fontStyle);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            Properties outFormat = new Properties();
            outFormat.setProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperties(outFormat);
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("foo2.xml"));
            transformer.transform(source, result);

        }
        c();
    }


    void c() {
        try {
            File xmlFile = new File("foo2.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();

            System.out.println("Корневой элемент: " + document.getDocumentElement().getNodeName());
            NodeList nodeList = document.getElementsByTagName("symbol");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {

                Node nNode = nodeList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("nameSymbol : " + eElement.getAttribute("nameSymbol"));
                    System.out.println("nameStyle : " + eElement.getElementsByTagName("nameStyle").item(0).getTextContent());
                    System.out.println("sizeStyle : " + eElement.getElementsByTagName("sizeStyle").item(0).getTextContent());
                    System.out.println("fontStyle : " + eElement.getElementsByTagName("fontStyle").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
