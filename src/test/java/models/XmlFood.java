package models;

public class XmlFood {

    private String name;
    private String price;
    private String description;
    private int calories;

    public XmlFood(String name, String price, String description, int calories) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "XmlFood{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }
}
