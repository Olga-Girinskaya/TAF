package tests;

import org.json.JSONObject;
import org.json.XML;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;

public class XmlToJson {

    @Test
    public void xmlToJsonJSONObject() throws IOException {

        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<breakfast_menu>\n" +
                "\t<food>\n" +
                "\t\t<name>Бельгийские Вафли</name>\n" +
                "\t\t<price>$5.95</price>\n" +
                "\t\t<description>две известных Бельгийских Вафли с обилием настоящего кленового сиропа</description>\n" +
                "\t\t<calories>650</calories>\n" +
                "\t</food>\n" +
                "\t<food>\n" +
                "\t\t<name>Бельгийские Вафли с Земляникой</name>\n" +
                "\t\t<price>$7.95</price>\n" +
                "\t\t<description>легкие Бельгийские вафли с земляникой, покрытые взбитыми сливками</description>\n" +
                "\t\t<calories>900</calories>\n" +
                "\t</food>\n" +
                "\t<food>\n" +
                "\t\t<name>Бельгийские Вафли с Ягодами</name>\n" +
                "\t\t<price>$8.95</price>\n" +
                "\t\t<description>легкие Бельгийские вафли с различными свежими ягодами, покрытые взбитыми сливками</description>\n" +
                "\t\t<calories>900</calories>\n" +
                "\t</food>\n" +
                "\t<food>\n" +
                "\t\t<name>Французский Тост</name>\n" +
                "\t\t<price>$4.50</price>\n" +
                "\t\t<description>толстые куски, сделанные из кусочков домашнего хлеба из опары</description>\n" +
                "\t\t<calories>600</calories>\n" +
                "\t</food>\n" +
                "\t<food>\n" +
                "\t\t<name>Домашний Завтрак</name>\n" +
                "\t\t<price>$6.95</price>\n" +
                "\t\t<description>пара яиц, бекон или колбаса, тост, и наши всегда популярные картофельные оладьи</description>\n" +
                "\t\t<calories>950</calories>\n" +
                "\t</food>\n" +
                "</breakfast_menu>\n";

        JSONObject json = XML.toJSONObject(xmlString);
        System.out.println(json);

        //запись json в файл
        FileWriter file = new FileWriter("jsonResult.json");
        file.write(json.toString());
        file.close();
    }
}
