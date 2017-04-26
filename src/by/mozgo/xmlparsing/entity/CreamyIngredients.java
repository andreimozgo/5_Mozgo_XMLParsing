package by.mozgo.xmlparsing.entity;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CreamyIngredients extends AbstractIngredients {
    private int condensed_milk;
    private int butter;

    public void setCondensed_milk(int condensed_milk) {
        this.condensed_milk = condensed_milk;
    }

    public void setButter(int butter) {
        this.butter = butter;
    }

    @Override
    public String toString() {
        return super.toString() + " condensed_milk=" + condensed_milk +
                ", butter=" + butter;
    }
}
