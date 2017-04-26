package by.mozgo.xmlparsing.entity;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CreamyIngredients extends AbstractIngredients {
    private int condensedMilk;
    private int butter;

    public void setCondensedMilk(int condensedMilk) {
        this.condensedMilk = condensedMilk;
    }

    public void setButter(int butter) {
        this.butter = butter;
    }

    @Override
    public String toString() {
        return super.toString() + " condensedMilk=" + condensedMilk +
                ", butter=" + butter;
    }
}
