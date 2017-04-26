package by.mozgo.xmlparsing.builder;

import by.mozgo.xmlparsing.entity.Candy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei Mozgo. 2017.
 */
public abstract class CandyBaseBuilder {
    protected List<Candy> candies;

    public CandyBaseBuilder() {
        candies = new ArrayList<>();
    }

    public List<Candy> getCandies() {
        return candies;
    }

    abstract public void buildSetCandies(String fileName);
}
