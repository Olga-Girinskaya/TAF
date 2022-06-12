package tests;

import org.json.JSONObject;
import org.json.XML;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;

public class JsonToXml {

    @Test
    public void jsonToXmlJSONObject() throws IOException {

        String jsonString = "{\"widget\": {\n" +
                "    \"debug\": \"on\",\n" +
                "    \"window\": {\n" +
                "        \"title\": \"Sample Konfabulator Widget\",\n" +
                "       \"name\": \"main_window\",\n" +
                "       \"width\": 500,\n" +
                "       \"height\": 500\n" +
                "    },\n" +
                "   \"image\": { \n" +
                "        \"src\": \"Images/Sun.png\",\n" +
                "        \"name\": \"sun1\",\n" +
                "       \"hOffset\": 250,\n" +
                "       \"vOffset\": 250,\n" +
                "       \"alignment\": \"center\"\n" +
                "    },\n" +
                "   \"text\": {\n" +
                "        \"data\": \"Click Here\",\n" +
                "        \"size\": 36,\n" +
                "        \"style\": \"bold\",\n" +
                "       \"name\": \"text1\",\n" +
                "       \"hOffset\": 250,\n" +
                "       \"vOffset\": 100,\n" +
                "       \"alignment\": \"center\",\n" +
                "        \"onMouseUp\": \"sun1.opacity = (sun1.opacity / 100) * 90;\"\n" +
                "    }\n" +
                "}}\n" +
                "\n";

        JSONObject json = new JSONObject(jsonString);
        String xml = XML.toString(json);
        System.out.println(xml);

        //запись xml в файл
        FileWriter file = new FileWriter("xmlResult.xml");
        file.write(xml);
        file.close();

    }
}