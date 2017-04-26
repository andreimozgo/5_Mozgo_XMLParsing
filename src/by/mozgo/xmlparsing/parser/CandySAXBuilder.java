package by.mozgo.xmlparsing.parser;

import by.mozgo.xmlparsing.entity.Candy;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CandySAXBuilder extends AbstractCandyBuilder {
    private final static Logger LOGGER = LogManager.getLogger();
    private CandyHandler candyHandler;
    private XMLReader reader;

    public CandySAXBuilder() {
        candyHandler = new CandyHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(candyHandler);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        }
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    @Override
    public void buildSetCandies(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            LOGGER.log(Level.ERROR, "Sax parser eror: {}", e);
        } catch (IOException e) {
            LOGGER.log(Level.FATAL, "I/O error: {}", e);
            throw new RuntimeException("I/O error: " + e, e);
        }
        candies = candyHandler.getCandies();
    }
}
