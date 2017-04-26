package by.mozgo.xmlparsing.parser;

/**
 * Created by Andrei Mozgo. 2017.
 */
public enum CandySAXEnum {
    CANDIES("candies"),
    NAME("name"),
    ENERGY("energy"),
    TYPE("type"),
    CHOCOLATE_INGREDIENTS("chocolate_ingredients"),
    CARAMEL_INGREDIENTS("caramel_ingredients"),
    CREAMY_INGREDIENTS("creamy_ingredients"),
    SUGAR("sugar"),
    COCOA("cocoa"),
    NUT("nut"),
    CONDENSED_MILK("condensed_milk"),
    POWDERED_MILK("powdered_milk"),
    BUTTER("butter"),
    VALUE("value"),
    PROTEIN("protein"),
    FAT("fat"),
    CARBOHYDRATE("carbohydrate"),
    PRODUCTION("production");

    private String value;

    CandySAXEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
