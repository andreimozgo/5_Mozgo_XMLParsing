package by.mozgo.xmlparsing.parser;

import by.mozgo.xmlparsing.entity.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CandiesDOMBuilder {
    private final static Logger LOGGER = LogManager.getLogger();
    private Set<Candy> candies;
    private DocumentBuilder docBuilder;

    public CandiesDOMBuilder() {
        this.candies = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.log(Level.ERROR, "Parser configuration error: {}", e);
        }
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

    private static boolean hasElement(Element element, String elementName) {
        if (element.getElementsByTagName(elementName).getLength() == 0) {
            return false;
        }
        return true;
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    public void buildSetCandies(String fileName) {
        try {
            Document doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList candiesList = root.getElementsByTagName("candy");
            for (int i = 0; i < candiesList.getLength(); i++) {
                Element candyElement = (Element) candiesList.item(i);
                Candy candy = buildStudent(candyElement);
                candies.add(candy);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }

    private Candy buildStudent(Element candyElement) {
        Candy candy = new Candy();
        candy.setId(candyElement.getAttribute("id"));
        candy.setName(getElementTextContent(candyElement, "name"));
        Integer energy = Integer.parseInt(getElementTextContent(candyElement, "energy"));
        candy.setEnergy(energy);
        candy.setType(CandyType.valueOf(getElementTextContent(candyElement, "type").toUpperCase()));
        Element sugarElement = (Element) candyElement.getElementsByTagName("sugar").item(0);
        int sugar = Integer.parseInt(sugarElement.getAttribute("weight"));
        if (hasElement(candyElement, "chocolate_ingredients")) {
            ChocolateIngredients ingredients = new ChocolateIngredients();
            ingredients.setCocoa(Integer.parseInt(getElementTextContent(candyElement, "cocoa")));
            Element powderedMilkElement = (Element) candyElement.getElementsByTagName("powdered_milk").item(0);
            ingredients.setPowderedMilk(Integer.parseInt(powderedMilkElement.getAttribute("weight")));
            ingredients.setSugar(sugar);
            candy.setIngredients(ingredients);
        } else if (hasElement(candyElement, "caramel_ingredients")) {
            CaramelIngredients ingredients = new CaramelIngredients();
            ingredients.setCocoa(Integer.parseInt(getElementTextContent(candyElement, "cocoa")));
            ingredients.setNut(Integer.parseInt(getElementTextContent(candyElement, "nut")));
            ingredients.setSugar(sugar);
            candy.setIngredients(ingredients);
        } else {
            CreamyIngredients ingredients = new CreamyIngredients();
            ingredients.setButter(Integer.parseInt(getElementTextContent(candyElement, "butter")));
            Element condensedMilkElement = (Element) candyElement.getElementsByTagName("condensed_milk").item(0);
            ingredients.setCondensedMilk(Integer.parseInt(condensedMilkElement.getAttribute("weight")));
            ingredients.setSugar(sugar);
            candy.setIngredients(ingredients);
        }
        Value value = new Value();
        value.setProtein(Double.parseDouble(getElementTextContent(candyElement, "protein")));
        value.setFat(Double.parseDouble(getElementTextContent(candyElement, "fat")));
        value.setCarbohydrate(Double.parseDouble(getElementTextContent(candyElement, "carbohydrate")));
        candy.setValue(value);
        candy.setProduction(getElementTextContent(candyElement, "production"));
        return candy;
    }
}