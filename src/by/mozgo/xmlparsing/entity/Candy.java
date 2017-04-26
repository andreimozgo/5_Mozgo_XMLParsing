package by.mozgo.xmlparsing.entity;

/**
 * Created by Andrei Mozgo. 2017.
 */
public class Candy {
    private String id;
    private String name;
    private int energy;
    private CandyType type;
    private AbstractIngredients ingredients;
    private Value value;
    private String production;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public CandyType getType() {
        return type;
    }

    public void setType(CandyType type) {
        this.type = type;
    }

    public void setIngredients(AbstractIngredients ingredients) {
        this.ingredients = ingredients;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candy candy = (Candy) o;

        if (energy != candy.energy) return false;
        if (!id.equals(candy.id)) return false;
        if (!name.equals(candy.name)) return false;
        if (type != candy.type) return false;
        if (!ingredients.equals(candy.ingredients)) return false;
        if (!value.equals(candy.value)) return false;
        return production.equals(candy.production);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + energy;
        result = 31 * result + type.hashCode();
        result = 31 * result + production.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return '\n' + "Candy{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", energy=" + energy +
                ", type=" + type +
                ", ingredients: " + ingredients +
                ", value: " + value +
                ", production='" + production + '\'' +
                '}';
    }
}
