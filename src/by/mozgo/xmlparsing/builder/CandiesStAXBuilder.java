package by.mozgo.xmlparsing.builder;

import by.mozgo.xmlparsing.entity.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CandiesStAXBuilder extends CandyBaseBuilder {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int INITIAL_VALUE = 0;
    private XMLInputFactory inputFactory;

    public CandiesStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildSetCandies(String fileName) {
        try (FileInputStream inputStream = new FileInputStream(new File(fileName))) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    String name = reader.getLocalName();
                    if (CandySAXEnum.valueOf(name.toUpperCase()) == CandySAXEnum.CANDY) {
                        Candy candy = buildCandy(reader);
                        candies.add(candy);
                    }
                }
            }
        } catch (XMLStreamException e) {
            LOGGER.log(Level.ERROR, "StAX parsing error: {}", e);
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.ERROR, "File {} not found: {}", fileName, e);
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Impossible close file {} : {}", fileName, e);
        }
    }

    private Candy buildCandy(XMLStreamReader reader) throws XMLStreamException {
        Candy candy = new Candy();
        candy.setId(reader.getAttributeValue(null, "id"));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandySAXEnum.valueOf(name.toUpperCase())) {
                        case NAME:
                            candy.setName(getXMLText(reader));
                            break;
                        case ENERGY:
                            name = getXMLText(reader);
                            candy.setEnergy(Integer.parseInt(name));
                            break;
                        case TYPE:
                            name = getXMLText(reader);
                            candy.setType(CandyType.valueOf(name.toUpperCase()));
                            break;
                        case CHOCOLATE_INGREDIENTS:
                            candy.setIngredients(getCandyIngredients(reader));
                            break;
                        case CARAMEL_INGREDIENTS:
                            candy.setIngredients(getCandyIngredients(reader));
                            break;
                        case CREAMY_INGREDIENTS:
                            candy.setIngredients(getCandyIngredients(reader));
                            break;
                        case VALUE:
                            candy.setValue(getCandyValue(reader));
                            break;
                        case PRODUCTION:
                            candy.setProduction(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandySAXEnum.valueOf(name.toUpperCase()) == CandySAXEnum.CANDY) {
                        return candy;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Candy");
    }

    private AbstractIngredients getCandyIngredients(XMLStreamReader reader) throws XMLStreamException {
        AbstractIngredients ingredients;
        int sugar = INITIAL_VALUE;
        int butter = INITIAL_VALUE;
        int nut = INITIAL_VALUE;
        int condensedMilk = INITIAL_VALUE;
        int powderedMilk = INITIAL_VALUE;
        int cocoa = INITIAL_VALUE;
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandySAXEnum.valueOf(name.toUpperCase())) {
                        case SUGAR:
                            name = reader.getAttributeValue(null, "weight");
                            sugar = Integer.parseInt(name);
                            break;
                        case COCOA:
                            name = getXMLText(reader);
                            cocoa = Integer.parseInt(name);
                            break;
                        case NUT:
                            name = getXMLText(reader);
                            nut = Integer.parseInt(name);
                            break;
                        case CONDENSED_MILK:
                            name = reader.getAttributeValue(null, "weight");
                            condensedMilk = Integer.parseInt(name);
                            break;
                        case POWDERED_MILK:
                            name = reader.getAttributeValue(null, "weight");
                            powderedMilk = Integer.parseInt(name);
                            break;
                        case BUTTER:
                            name = getXMLText(reader);
                            butter = Integer.parseInt(name);
                            break;
                        default:
                            throw new XMLStreamException("Unknown ingredient element");
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandySAXEnum.valueOf(name.toUpperCase())) {
                        case CARAMEL_INGREDIENTS:
                            CaramelIngredients caramelIngredients = new CaramelIngredients();
                            caramelIngredients.setSugar(sugar);
                            caramelIngredients.setNut(nut);
                            caramelIngredients.setCocoa(cocoa);
                            ingredients = caramelIngredients;
                            return ingredients;
                        case CHOCOLATE_INGREDIENTS:
                            ChocolateIngredients chocolateIngredients = new ChocolateIngredients();
                            chocolateIngredients.setSugar(sugar);
                            chocolateIngredients.setPowderedMilk(powderedMilk);
                            chocolateIngredients.setCocoa(cocoa);
                            ingredients = chocolateIngredients;
                            return ingredients;
                        case CREAMY_INGREDIENTS:
                            CreamyIngredients creamyIngredients = new CreamyIngredients();
                            creamyIngredients.setSugar(sugar);
                            creamyIngredients.setButter(butter);
                            creamyIngredients.setCondensedMilk(condensedMilk);
                            ingredients = creamyIngredients;
                            return ingredients;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Ingredients weren't returned");
    }

    private Value getCandyValue(XMLStreamReader reader) throws XMLStreamException {
        Value value = new Value();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandySAXEnum.valueOf(name.toUpperCase())) {
                        case PROTEIN:
                            value.setProtein(Double.parseDouble(getXMLText(reader)));
                            break;
                        case FAT:
                            value.setFat(Double.parseDouble(getXMLText(reader)));
                            break;
                        case CARBOHYDRATE:
                            value.setCarbohydrate(Double.parseDouble(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandySAXEnum.valueOf(name.toUpperCase()) == CandySAXEnum.VALUE) {
                        return value;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
