package by.mozgo.xmlparsing.builder;

import by.mozgo.xmlparsing.entity.Candy;

import java.util.List;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class Director {
    public static List<Candy> readXML(CandyBaseBuilder builder, String fileName) {
        builder.buildSetCandies(fileName);
        return builder.getCandies();
    }
}