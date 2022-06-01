package baseEntities;

import com.google.gson.Gson;
import configuration.ReadProperties;
import models.Project;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import services.BrowsersService;
import steps.LoginStep;
import steps.NavigationStep;
import utils.Listener;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Listeners(Listener.class)
public class BaseTest {
    public WebDriver driver;
    protected LoginStep loginStep;
    protected NavigationStep navigationStep;

    protected Project mainProject;

    @BeforeTest
    public void prepareData() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("projectResult.json"));
        mainProject = new Gson().fromJson(reader, Project.class);
    }

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();

        loginStep = new LoginStep(driver);
        navigationStep = new NavigationStep(driver);

        driver.get(ReadProperties.getUrl());
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
