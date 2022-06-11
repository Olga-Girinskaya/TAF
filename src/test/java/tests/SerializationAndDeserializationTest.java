package tests;

import com.google.gson.Gson;
import models.Project;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerializationAndDeserializationTest {

    //сериализация
    @Test
    public void objectToJsonTest() throws IOException {
        Gson gson = new Gson();
        //Project project = new Project("Test Project" ,"Big test data...", false, 2);
        Reader project = Files.newBufferedReader(Paths.get("xmlText.xml"));

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

        Reader reader = Files.newBufferedReader(Paths.get("JsonText.json"));
        Project projectFromFile= gson.fromJson(reader, Project.class);
        System.out.println(projectFromFile.toString());
        System.out.println(projectFromFile.getName());

    }

}
