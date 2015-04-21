package by.jum.texteditor.file;

import by.jum.texteditor.constants.XMLTag;
import by.jum.texteditor.windows.TextPane;
import by.jum.texteditor.windows.symbol.Symbol;
import by.jum.texteditor.windows.symbol.SymbolCreator;
import by.jum.texteditor.windows.symbol.SymbolStorage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
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

public class XMLFile {
    private Element rootElement;
    private SymbolStorage symbolStorage;
    private List<Symbol> list;
    private String nameFile;
    private TextPane textPane;
    private JFrame frame;

    public XMLFile(String nameFile, JTabbedPane tabbedPane, JFrame frame) {
        this.nameFile = nameFile;
        this.frame = frame;
        textPane = (TextPane) tabbedPane.getSelectedComponent();
        symbolStorage = textPane.getSymbolStorage();
        list = symbolStorage.getSymbolList();
    }

    public void writeFile() throws IOException, TransformerException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document document = builder.newDocument();

        rootElement = document.createElement(XMLTag.SYMBOLS);
        document.appendChild(rootElement);

        for (Symbol s : list) {
            Element symbol = document.createElement(XMLTag.SYMBOL);
            rootElement.appendChild(symbol);
            symbol.setAttribute(XMLTag.SYMBOLNAME, s.getSymbol());

            Element style = document.createElement(XMLTag.STYLE);
            symbol.appendChild(style);

            Element nameStyle = document.createElement(XMLTag.FONTNAME);
            nameStyle.appendChild(document.createTextNode(s.getDocument().getFamily()));
            style.appendChild(nameStyle);

            Element sizeStyle = document.createElement(XMLTag.FONTSIZE);
            sizeStyle.appendChild(document.createTextNode(String.valueOf(s.getDocument().getSize())));
            style.appendChild(sizeStyle);

            Element fontStyle = document.createElement(XMLTag.FONTTYPE);
            fontStyle.appendChild(document.createTextNode(String.valueOf(s.getDocument().getStyle())));
            style.appendChild(fontStyle);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            Properties outFormat = new Properties();
            outFormat.setProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperties(outFormat);
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(nameFile));
            transformer.transform(source, result);
        }
    }


    public void readFile(by.jum.texteditor.document.Document documentStyle) {
        try {
            File xmlFile = new File(nameFile);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName(XMLTag.SYMBOL);
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node nNode = nodeList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    documentStyle.setNameStyleSymbol(eElement.getElementsByTagName(XMLTag.FONTNAME).item(0).getTextContent());
                    documentStyle.setSizeSymbol(Integer.parseInt(eElement.getElementsByTagName(XMLTag.FONTSIZE).item(0).getTextContent()));
                    documentStyle.setStyleSymbol(Integer.parseInt(eElement.getElementsByTagName(XMLTag.FONTTYPE).item(0).getTextContent()));
                    new SymbolCreator(textPane, documentStyle,
                            symbolStorage, frame).createSymbol(eElement.getAttribute(XMLTag.SYMBOLNAME));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
