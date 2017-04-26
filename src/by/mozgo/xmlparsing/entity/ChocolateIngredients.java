package by.mozgo.xmlparsing.entity;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class ChocolateIngredients extends AbstractIngredients {
    private int powdered_milk;
    private int cocoa;

    public void setPowdered_milk(int powdered_milk) {
        this.powdered_milk = powdered_milk;
    }

    public void setCocoa(int cocoa) {
        this.cocoa = cocoa;
    }

    @Override
    public String toString() {
        return super.toString() + " powdered_milk=" + powdered_milk +
                ", cocoa=" + cocoa;
    }
}
