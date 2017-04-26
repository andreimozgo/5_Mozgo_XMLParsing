package by.mozgo.xmlparsing.parsers;

import by.mozgo.xmlparsing.entity.Candy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrei Mozgo. 2017.
 */
public abstract class AbstractCandyBuilder {
    protected Set<Candy> candies;

    public AbstractCandyBuilder() {
        candies = new HashSet<Candy>();
    }

    public AbstractCandyBuilder(Set<Candy> candies) {
        this.candies = candies;
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    abstract public void buildSetCandies(String fileName);
}
