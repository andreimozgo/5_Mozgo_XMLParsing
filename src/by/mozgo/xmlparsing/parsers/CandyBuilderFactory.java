package by.mozgo.xmlparsing.parsers;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CandyBuilderFactory {
    public AbstractCandyBuilder createCandyBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
/*            case DOM:
                return new CandyDOMBuilder();
            case STAX:
                return new CandyStAXBuilder();*/
            case SAX:
                return new CandySAXBuilder();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }

    private enum TypeParser {SAX, STAX, DOM}
}
