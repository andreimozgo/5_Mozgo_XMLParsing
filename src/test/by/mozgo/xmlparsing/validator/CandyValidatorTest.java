package test.by.mozgo.xmlparsing.validator;

import by.mozgo.xmlparsing.validator.CandyValidator;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CandyValidatorTest {
    private static final String TEST_XML_PATH = "data/candies.xml";
    private static final String TEST_XSD_PATH = "data/candies.xsd";

    @Test
    public void testValidate() throws IOException, SAXException {
        File xml = new File(TEST_XML_PATH);
        File xsd = new File(TEST_XSD_PATH);
        Assert.assertTrue(CandyValidator.validateXML(xml, xsd));
    }
}
