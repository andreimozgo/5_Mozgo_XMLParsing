package by.mozgo.xmlparsing.parser;

import by.mozgo.xmlparsing.entity.Candy;

import java.util.Set;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class Director {
    public static Set<Candy> readXML(CandyBaseBuilder builder, String fileName) {
        builder.buildSetCandies(fileName);
        return builder.getCandies();
    }
}