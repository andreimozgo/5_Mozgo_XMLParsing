package by.mozgo.xmlparsing.parsers;

import by.mozgo.xmlparsing.entity.Candy;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CandyHandler extends DefaultHandler {
    private Set<Candy> candies;
    private Candy current = null;

    public CandyHandler() {
        candies = new HashSet<>();
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("student".equals(localName)) {
            current = new Student();
            current.setLogin(attrs.getValue(0));
            if (attrs.getLength() == 2) {
                current.setFaculty(attrs.getValue(1));
            }
        } else {
            StudentEnum temp = StudentEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }
}
