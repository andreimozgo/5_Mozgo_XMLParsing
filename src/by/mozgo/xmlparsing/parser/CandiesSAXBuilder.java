package by.mozgo.xmlparsing.parser;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CandiesSAXBuilder extends CandyBaseBuilder {
    private final static Logger LOGGER = LogManager.getLogger();
    private CandySAXHandler handler;
    private XMLReader reader;

    public CandiesSAXBuilder() {
        handler = new CandySAXHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            LOGGER.log(Level.ERROR, "SAX parser error: {}", e);
        }
    }

    @Override
    public void buildSetCandies(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            LOGGER.log(Level.ERROR, "SAX parser error: {}", e);
        } catch (IOException e) {
            LOGGER.log(Level.FATAL, "I/O error: {}", e);
            throw new RuntimeException("I/O error: " + e, e);
        }
        candies = handler.getCandies();
    }
}
