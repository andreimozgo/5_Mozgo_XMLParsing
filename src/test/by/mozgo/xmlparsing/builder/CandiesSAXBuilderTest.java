package test.by.mozgo.xmlparsing.builder;

import by.mozgo.xmlparsing.builder.CandiesSAXBuilder;
import by.mozgo.xmlparsing.builder.Director;
import by.mozgo.xmlparsing.entity.Candy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CandiesSAXBuilderTest {
    @Test
    public void testSAXParser() {
        String fileName = "data/candies.xml";
        Set<Candy> candies = Director.readXML(new CandiesSAXBuilder(), fileName);
        Assert.assertEquals(16, candies.size());
    }
}
