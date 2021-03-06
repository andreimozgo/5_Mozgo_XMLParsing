package test.by.mozgo.xmlparsing.builder;

import by.mozgo.xmlparsing.builder.CandiesDOMBuilder;
import by.mozgo.xmlparsing.builder.Director;
import by.mozgo.xmlparsing.entity.Candy;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CandiesDOMBuilderTest {
    private static final String TEST_FILE_PATH = "data/candies.xml";
    private static final int EXPECTED_SIZE = 16;

    @Test
    public void testDOMParser() {
        List<Candy> candies = Director.readXML(new CandiesDOMBuilder(), TEST_FILE_PATH);
        Assert.assertEquals(EXPECTED_SIZE, candies.size());
    }
}


