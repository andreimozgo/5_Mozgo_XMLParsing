package by.mozgo.xmlparsing.entity;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class CaramelIngredients extends AbstractIngredients {
    private int cocoa;
    private int nut;

    public void setCocoa(int cocoa) {
        this.cocoa = cocoa;
    }

    public void setNut(int nut) {
        this.nut = nut;
    }

    @Override
    public String toString() {
        return super.toString() + " cocoa=" + cocoa +
                ", nut=" + nut;
    }
}
