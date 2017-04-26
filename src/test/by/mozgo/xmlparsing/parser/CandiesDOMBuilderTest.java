package test.by.mozgo.xmlparsing.parser;

import by.mozgo.xmlparsing.entity.Candy;
import by.mozgo.xmlparsing.parser.CandiesDOMBuilder;
import by.mozgo.xmlparsing.parser.Director;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CandiesDOMBuilderTest {
    @Test
    public void testDOMParser() {
        String fileName = "data/candies.xml";
        Set<Candy> candies = Director.readXML(new CandiesDOMBuilder(), fileName);
        Assert.assertEquals(16, candies.size());
    }
}


