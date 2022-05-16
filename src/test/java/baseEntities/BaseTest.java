package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.MilestonesPage;
import services.BrowsersService;
import steps.LoginStep;
import steps.MilestonesStep;
import steps.NavigationStep;

public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;
    protected NavigationStep navigationStep;
    protected MilestonesStep milestonesStep;
    protected MilestonesPage milestonesPage;

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();
        loginStep = new LoginStep(driver);
        navigationStep = new NavigationStep(driver);
        milestonesStep = new MilestonesStep(driver);
        milestonesPage = new MilestonesPage(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
