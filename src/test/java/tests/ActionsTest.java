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
import java.util.List;

public class ActionsTest extends BaseTest {

    //lesson
    @Test
    public void hoverTest() {
        driver.get("http://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        List<WebElement> targetElements = wait.waitForAllVisibleElementsLocatedBy(By.cssSelector(".figure"));
        actions
                .moveToElement(targetElements.get(0), 10, 10)
                .click(wait.waitForExists(By.cssSelector("[href='/users/1']")))
                .build()  // патерн билдер - всегда должно быть (создает объект на основании  предыдущих параметров)
                .perform();  // всегда должно быть (начинаем выполнять созданный билдером объект)
    }

    //homework
    @Test
    public void contextMenuTest() {

        Actions actions = new Actions(driver);
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        driver.get("http://the-internet.herokuapp.com/context_menu");

        actions
                .contextClick(wait.waitForVisibilityLocatedBy(By.id("hot-spot")))
                .build()
                .perform();

        Alert alert = driver.switchTo().alert();
        alert.getText();
        Assert.assertEquals(alert.getText(), "You selected a context menu", "Текст алерта неверен!");
        System.out.println("Текст алерта соответствует заданному!");
        alert.accept();
    }


    @Test
    public void fileUploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
        // Добавляется "/" к пути , поэтому обрезала первый символ
        String pathToFile = ActionsTest.class.getClassLoader().getResource("download.jpeg").getPath().substring(1);
        System.out.println(pathToFile);
        fileUploadPath.sendKeys(pathToFile);
        wait.waitForExists(By.id("file-submit")).submit();
        WebElement nameFile = wait.waitForExists(By.cssSelector("#uploaded-files"));
        Assert.assertEquals(nameFile.getText(), "download.jpeg");
    }

    //доделать
    @Test
    public void dynamicControlsTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        wait.waitForExists(By.xpath("//input[@type = 'checkbox']")).click();
        wait.waitForExists(By.xpath("//button[@onclick = 'swapCheckbox()']")).click();
        Assert.assertEquals(wait.waitForExists(By.id("message")).getText(), "It's gone!");

    }
}
