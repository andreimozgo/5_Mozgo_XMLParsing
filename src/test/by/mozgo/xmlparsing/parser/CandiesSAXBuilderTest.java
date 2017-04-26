package test.by.mozgo.xmlparsing.parser;

import by.mozgo.xmlparsing.parser.CandiesSAXBuilder;
import org.junit.Test;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CandiesSAXBuilderTest {
    @Test
    public void testSAXParser() {
        CandiesSAXBuilder saxBuilder = new CandiesSAXBuilder();
        saxBuilder.buildSetCandies("data/candies.xml");

        System.out.println(saxBuilder.getCandies());
    }
}
