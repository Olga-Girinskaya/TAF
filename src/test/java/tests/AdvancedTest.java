package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class AdvancedTest extends BaseTest {

    @Test
    public void contextMenuTest() {

        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        actions
                .contextClick(wait.waitForVisibilityLocatedBy(By.id("hot-spot")))
                .build()
                .perform();

        Alert alert = driver.switchTo().alert();
        alert.getText();
        Assert.assertEquals(alert.getText(), "You selected a context menu", "Текст алерта неверен!");
        alert.accept();
    }

    @Test
    public void dynamicControlsTest() {

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement checkboxLocator = wait.waitForExists(By.cssSelector("[type='checkbox']"));
        checkboxLocator.click();
        wait.waitForExists(By.cssSelector("[onclick = 'swapCheckbox()']")).click();
        Assert.assertEquals(wait.waitForExists(By.id("message")).getText(), "It's gone!");
        Assert.assertTrue(wait.waitForElementInvisible(checkboxLocator));
        Assert.assertTrue(wait.waitForExists(By.cssSelector("[type = 'text']")).isDisplayed());
        wait.waitForExists(By.cssSelector("[onclick = 'swapInput()']")).click();
        Assert.assertEquals(wait.waitForExists(By.id("message")).getText(), "It's enabled!");
        Assert.assertTrue(wait.waitForExists(By.cssSelector("[type = 'text']")).isEnabled());
    }

    @Test
    public void fileUploadTest() {

        driver.get("http://the-internet.herokuapp.com/upload");
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
        String pathToFile = ActionsTest.class.getClassLoader().getResource("download.jpeg").getPath().substring(1);
        fileUploadPath.sendKeys(pathToFile);
        wait.waitForExists(By.id("file-submit")).submit();
        WebElement nameFile = wait.waitForExists(By.cssSelector("#uploaded-files"));
        Assert.assertEquals(nameFile.getText(), "download.jpeg");
    }

    @Test
    public void framesTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        driver.switchTo().frame("mce_0_ifr");
        Assert.assertEquals(wait.waitForExists(By.id("tinymce")).getText(), "Your content goes here.");
    }
}
