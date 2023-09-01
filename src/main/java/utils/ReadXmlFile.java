package utils;

import constants.FrameworkConstants;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ReadXmlFile {

    private ReadXmlFile(){}

    public static Element getPageName(String page) throws DocumentException {
        try {
            File inputFile = new File(FrameworkConstants.getObjectRepoXmlPath());
            if (!inputFile.exists()) {
                throw new FileNotFoundException("Object Repository XML file not found!");
            }
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(inputFile);
            Element pageElement = null;
            if (document != null) {
                // Check if the page element exists in the document
                Element rootElement = document.getRootElement();
                if (rootElement != null) {
                    pageElement = rootElement.element(page);
                }
            }
            // You can add additional conditions or handle errors if needed.
            // For example, if pageElement is null, it means the page doesn't exist in the XML.
            return pageElement;
        } catch (FileNotFoundException e) {
            // Handle the case when the file is not found
            e.printStackTrace(); // You can log the error or handle it in another way.
            System.out.println("File not found");
        } catch (Exception e) {
            // Handle any other exceptions that may occur during file reading
            e.printStackTrace(); // You can log the error or handle it in another way.
            System.out.println("Element not found");
        }
        // Return null or some default value in case of an error or exception
        return null;
    }

    public static Map<String, String> getElementLocator(Element page, String elementName) {
        HashMap<String, String> map = new HashMap<>();
        System.out.println("object of map First in get elementlocaor "+map);
        System.out.println("What is the size of elements ??"+ page.element(elementName));
        if (page != null) {
            if (page.element(elementName).elements().size() == 1) {
                Node node = page.element(elementName).selectSingleNode("./*");
                if (node != null) {
                    System.out.println("Node name of " + elementName + " inside HomePage: " + node.getName());
                    String locator = node.getName();
                    String locatorValue = node.getText();
                    map.put(locator, locatorValue);
                    return map;
                } else {
                    System.out.println("No element with name " + elementName + " found inside HomePage.");
                }
            } else {
                System.out.println("More than 1 locator provided for the element");
            }
        } else {
            System.out.println("Page element not found in the XML.");
        }
        return Collections.emptyMap();
    }

}