package tests;

import com.google.gson.Gson;
import models.Project;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerializationTest {

    //сериализация
    @Test
    public void objectToJsonTest() throws IOException {
        Gson gson = new Gson();
        Project project = new Project("Test Project" ,"Big test data...", false, 2);

        String objectJson = gson.toJson(project);
        System.out.println(objectJson);

        //запись json в файл
        FileWriter file = new FileWriter("projectResult.json");
        gson.toJson(project, file);
        file.close();
    }

    //десериализация
    @Test
    public void jsonToObjectTest() throws IOException {
        Gson gson= new Gson();

        //1 вариант
      /*  String json = "{\n" +
                "  \"name\": \"Test Project\",\n" +
                "  \"announcement\": \"Big test data...\",\n" +
                "  \"show_announcement\": false,\n" +
                "  \"type\": 2\n" +
                "}";

        Project projectFromString = gson.fromJson(json, Project.class);
        System.out.println(projectFromString.toString());
        System.out.println(projectFromString.getName());
       */

        //2 вариант
        Reader reader = Files.newBufferedReader(Paths.get("projectResult.json"));
        Project projectFromFile= gson.fromJson(reader, Project.class);
        System.out.println(projectFromFile.toString());
        System.out.println(projectFromFile.getName());

    }

}
