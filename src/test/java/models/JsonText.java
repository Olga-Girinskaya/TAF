package models;

public class JsonText {
    private String data;
    private int size;
    private String style;
    private String name;
    private int hOffset;
    private int vOffset;
    private String alignment;
    private String onMouseUp;

    public JsonText(String data, int size, String style, String name, int hOffset, int vOffset, String alignment, String onMouseUp) {
        this.data = data;
        this.size = size;
        this.style = style;
        this.name = name;
        this.hOffset = hOffset;
        this.vOffset = vOffset;
        this.alignment = alignment;
        this.onMouseUp = onMouseUp;
    }

    public String getData() {
        return data;
    }

    public int getSize() {
        return size;
    }

    public String getStyle() {
        return style;
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

    public String getOnMouseUp() {
        return onMouseUp;
    }

    @Override
    public String toString() {
        return "Text{" +
                "data='" + data + '\'' +
                ", size=" + size +
                ", style='" + style + '\'' +
                ", name='" + name + '\'' +
                ", hOffset=" + hOffset +
                ", vOffset=" + vOffset +
                ", alignment='" + alignment + '\'' +
                ", onMouseUp='" + onMouseUp + '\'' +
                '}';
    }
}
