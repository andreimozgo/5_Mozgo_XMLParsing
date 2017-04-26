package test.by.mozgo.xmlparsing.parser;

import by.mozgo.xmlparsing.parser.CandiesDOMBuilder;
import org.junit.Test;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CandiesDOMBuilderTest {
    @Test
    public void testSaxParser() {
        CandiesDOMBuilder domBuilder = new CandiesDOMBuilder();
        domBuilder.buildSetCandies("data/candies.xml");
        System.out.println(domBuilder.getCandies());
    }
}


