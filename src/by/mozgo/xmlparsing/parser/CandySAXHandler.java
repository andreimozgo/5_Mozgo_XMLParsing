package by.mozgo.xmlparsing.parser;

import by.mozgo.xmlparsing.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CandySAXHandler extends DefaultHandler {
    private Set<Candy> candies;
    private Candy current = null;
    private CandySAXEnum currentEnum = null;
    private EnumSet<CandySAXEnum> withText;
    private AbstractIngredients ingredients;
    private CaramelIngredients caramelIngredients;
    private ChocolateIngredients chocolateIngredients;
    private CreamyIngredients creamyIngredients;
    private Attributes attrs;
    private Value value;

    public CandySAXHandler() {
        candies = new HashSet<>();
        withText = EnumSet.range(CandySAXEnum.NAME, CandySAXEnum.PRODUCTION);
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {

        if ("candy".equals(localName)) {
            current = new Candy();
            current.setId(attrs.getValue(0));
        } else {
            this.attrs = attrs;
            CandySAXEnum temp = CandySAXEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("candy".equals(localName)) {
            current.setIngredients(ingredients);
            current.setValue(value);
            candies.add(current);
            caramelIngredients = null;
            chocolateIngredients = null;
            creamyIngredients = null;
        }
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    current.setName(s);
                    break;
                case ENERGY:
                    current.setEnergy(Integer.parseInt(s));
                    break;
                case TYPE:
                    current.setType(CandyType.valueOf(s.toUpperCase()));
                    break;
                case CHOCOLATE_INGREDIENTS:
                    chocolateIngredients = new ChocolateIngredients();
                    ingredients = chocolateIngredients;
                    break;
                case CARAMEL_INGREDIENTS:
                    caramelIngredients = new CaramelIngredients();
                    ingredients = caramelIngredients;
                    break;
                case CREAMY_INGREDIENTS:
                    creamyIngredients = new CreamyIngredients();
                    ingredients = creamyIngredients;
                    break;
                case SUGAR:
                    ingredients.setSugar(Integer.parseInt(attrs.getValue(0)));
                    break;
                case COCOA:
                    if (caramelIngredients != null) {
                        caramelIngredients.setCocoa(Integer.parseInt(s));
                    } else {
                        chocolateIngredients.setCocoa(Integer.parseInt(s));
                    }
                    break;
                case NUT:
                    caramelIngredients.setNut(Integer.parseInt(s));
                    break;
                case CONDENSED_MILK:
                    creamyIngredients.setCondensedMilk(Integer.parseInt(attrs.getValue(0)));
                    break;
                case POWDERED_MILK:
                    chocolateIngredients.setPowderedMilk(Integer.parseInt(attrs.getValue(0)));
                    break;
                case BUTTER:
                    creamyIngredients.setButter(Integer.parseInt(s));
                    break;
                case VALUE:
                    value = new Value();
                    break;
                case PROTEIN:
                    value.setProtein(Double.parseDouble(s));
                    break;
                case FAT:
                    value.setFat(Double.parseDouble(s));
                    break;
                case CARBOHYDRATE:
                    value.setCarbohydrate(Double.parseDouble(s));
                    break;
                case PRODUCTION:
                    current.setProduction(s);
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}

