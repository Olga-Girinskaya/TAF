package models;

import java.io.Serializable;

public class JsonWindow implements Serializable {
    private String title;
    private String name;
    private int width;
    private int height;

    public JsonWindow(String title, String name, int width, int height) {
        this.title = title;
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Window{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
