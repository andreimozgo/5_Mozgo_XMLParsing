package test.by.mozgo.xmlparsing.parser;

import by.mozgo.xmlparsing.parser.CandySAXBuilder;
import org.junit.Test;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CandySAXBuilderTest {
    @Test
    public void testSaxParser() {
        CandySAXBuilder saxBuilder = new CandySAXBuilder();
        saxBuilder.buildSetCandies("data/candies.xml");
        System.out.println(saxBuilder.getCandies());
    }
}
