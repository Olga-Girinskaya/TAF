package models;

import java.io.Serializable;

public class JsonImage implements Serializable {
    private String src;
    private String name;
    private int hOffset;
    private int vOffset;
    private String alignment;

    public JsonImage(String src, String name, int hOffset, int vOffset, String alignment) {
        this.src = src;
        this.name = name;
        this.hOffset = hOffset;
        this.vOffset = vOffset;
        this.alignment = alignment;
    }

    public String getSrc() {
        return src;
    }

    public String getName() {
        return name;
    }

    public int gethOffset() {
        return hOffset;
    }

    public int getvOffset() {
        return vOffset;
    }

    public String getAlignment() {
        return alignment;
    }

    @Override
    public String toString() {
        return "Image{" +
                "src='" + src + '\'' +
                ", name='" + name + '\'' +
                ", hOffset=" + hOffset +
                ", vOffset=" + vOffset +
                ", alignment='" + alignment + '\'' +
                '}';
    }
}
