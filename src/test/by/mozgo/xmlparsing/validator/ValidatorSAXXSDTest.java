package test.by.mozgo.xmlparsing.validator;

import by.mozgo.xmlparsing.validator.ValidatorSAXXSD;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class ValidatorSAXXSDTest {
    @Test
    public void testValidate() throws IOException, SAXException {
        File xml = new File("data/candies.xml");
        File xsd = new File("data/candies.xsd");

        Assert.assertTrue(ValidatorSAXXSD.validateXML(xml, xsd));
    }
}
