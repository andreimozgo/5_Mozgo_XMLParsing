package test.by.mozgo.xmlparsing.builder;

import by.mozgo.xmlparsing.builder.CandiesSAXBuilder;
import by.mozgo.xmlparsing.builder.Director;
import by.mozgo.xmlparsing.entity.Candy;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CandiesSAXBuilderTest {
    private static final String TEST_FILE_PATH = "data/candies.xml";
    private static final int EXPECTED_SIZE = 16;

    @Test
    public void testSAXParser() {
        List<Candy> candies = Director.readXML(new CandiesSAXBuilder(), TEST_FILE_PATH);
        Assert.assertEquals(EXPECTED_SIZE, candies.size());
    }
}
