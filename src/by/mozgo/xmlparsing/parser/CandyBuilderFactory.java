package by.mozgo.xmlparsing.parser;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CandyBuilderFactory {
    public AbstractCandyBuilder createCandyBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new CandiesSAXBuilder();
 /*            case STAX:
                return new CandiesStAXBuilder();*/
            case SAX:
                return new CandiesSAXBuilder();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }

    private enum TypeParser {SAX, STAX, DOM}
}