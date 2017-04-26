package test.by.mozgo.xmlparsing.parser;

import by.mozgo.xmlparsing.parser.CandiesStAXBuilder;
import org.junit.Test;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CandiesStAXBuilderTest {
    @Test
    public void testStAXParser() {
        CandiesStAXBuilder staxBuilder = new CandiesStAXBuilder();
        staxBuilder.buildSetCandies("data/candies.xml");
        System.out.println(staxBuilder.getCandies());
    }
}
