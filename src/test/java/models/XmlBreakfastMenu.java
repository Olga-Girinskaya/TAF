package models;

import java.io.BufferedReader;
import java.util.List;

public class XmlBreakfastMenu {
    private String breakfast_menu;
    private List<XmlFood> xmlFoodList;

    public XmlBreakfastMenu() {
        super();
    }

    public XmlBreakfastMenu(BufferedReader reader) {
        super();
    }

    @Override
    public String toString() {
        return "XmlBreakfastMenu{" +
                "breakfast_menu='" + breakfast_menu + '\'' +
                ", xmlFoodList=" + xmlFoodList +
                '}';
    }
}
