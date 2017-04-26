package by.mozgo.xmlparsing.entity;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class Value {
    private double protein;
    private double fat;
    private double carbohydrate;

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    @Override
    public String toString() {
        return "protein=" + protein +
                ", fat=" + fat +
                ", carbohydrate=" + carbohydrate;
    }
}
