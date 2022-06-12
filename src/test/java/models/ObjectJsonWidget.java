package models;

import java.io.Reader;
import java.io.Serializable;

public class ObjectJsonWidget implements Serializable {
    private String debug;
    public JsonWindow window;
    public JsonImage image;
    public JsonText text;

    public ObjectJsonWidget(){
        super();
    }
    public ObjectJsonWidget(Reader reader){
        super();
    }

    public ObjectJsonWidget(String debug, JsonWindow window, JsonImage image, JsonText text) {
        this.debug = debug;
        this.window = window;
        this.image = image;
        this.text = text;
    }

    public String getDebug() {
        return debug;
    }

    public JsonWindow getWindow() {
        return window;
    }

    public JsonImage getImage() {
        return image;
    }

    public JsonText getText() {
        return text;
    }


    @Override
    public String toString() {
        return "Widget{" +
                "debug='" + debug + '\'' +
                ", window=" + window +
                ", image=" + image +
                ", text=" + text +
                '}';
    }
}
