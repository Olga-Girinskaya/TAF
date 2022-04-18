import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FirstTest {
    private WebDriver driver;

    @Test
    public void browserTest() {
        SimpleDriver simpleDriver = new SimpleDriver();
        driver = simpleDriver.getDriver();
    }

    @Test
    public void advancedTests() {
        AdvancedDriver advancedDriver = new AdvancedDriver();
        driver = advancedDriver.getDriver();
    }

    @Test
    public void browserServiceTests() {
        BrowserService browserService = new BrowserService();
        driver = browserService.getDriver();
    }



       /*Thread.sleep(5000);
        driver.close();*/

}
