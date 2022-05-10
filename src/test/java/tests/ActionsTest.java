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
    //этот тест не работает!
    @Test
    public void contextMenuTest(){
        driver.get("http://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement targetElements = wait.waitForVisibilityLocatedBy(By.id("hot-spot"));

        actions
                .contextClick(targetElements)
                .pause(2000)
            //    .click(wait.waitForVisibilityLocatedBy(By.cssSelector("#content > script")))
                .build()
                .perform();
        WebElement elementEdit =driver.findElement(By.cssSelector("#content > script"));
        elementEdit.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu", "Текст алерта неверен");
    }

    // работает
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
}
