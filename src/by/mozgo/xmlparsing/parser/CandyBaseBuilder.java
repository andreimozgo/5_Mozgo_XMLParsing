package by.mozgo.xmlparsing.parser;

import by.mozgo.xmlparsing.entity.Candy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrei Mozgo. 2017.
 */
public abstract class CandyBaseBuilder {
    protected Set<Candy> candies;

    public CandyBaseBuilder() {
        candies = new HashSet<>();
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    abstract public void buildSetCandies(String fileName);
}
