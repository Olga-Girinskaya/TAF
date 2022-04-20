package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowserService;

public class CssSelectorsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void cssSelectorsTest() throws InterruptedException {
        driver.get("D:/QA18/AQA/TAF1/src/test/resources/index.html");
        Thread.sleep(2000);

        //Поиск по id
        Assert.assertTrue(driver.findElement(By.cssSelector("#my-Address")).isDisplayed());

        //Поиск по class name
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter")).isDisplayed());

        //Поиск по нескольким значениям в аттрибуте class
        Assert.assertTrue(driver.findElement(By.cssSelector(".noSel.newsletter")).isDisplayed());

        //Поиск по tag name
        Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed());

        //Поиск по tag name значению аттрибута class (точка)
        Assert.assertTrue(driver.findElement(By.cssSelector("div.intro")).isDisplayed());

        //Поиск по tag name значению аттрибута class
        Assert.assertEquals(2, driver.findElements(By.cssSelector("#Lastname .markup")).size());

        //Поиск всех элементов с тэгом h1 или p (запятая)
        Assert.assertEquals(8, driver.findElements(By.cssSelector("h1, p")).size());

        //Поиск всех элементов с тэгом p у которых непосредсвенный родитель с тэгом div
        Assert.assertEquals(6, driver.findElements(By.cssSelector("div > p")).size());

        //Поиск всех элементов с тэгом p которые идут сразу за элементом с тегом ul, находящийся на одном уровне(являются братьями)
        Assert.assertEquals(1, driver.findElements(By.cssSelector("ul + p")).size());

        //Поиск всех элементов с тэгом p которые идут и сразу, и не сразу за элементом с тегом ul,
        // находящийся на одном уровне (являются братьями)(тильда)
        Assert.assertEquals(2, driver.findElements(By.cssSelector("p ~ div")).size());

        // Поиск всех элементов у которых присутсвует атрибут title
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title]")).size());

        // Поиск всех элементов у которых присутсвует атрибут style с конкретным значением
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style='overflow: auto;']")).size());

        // Поиск всех элементов у которых присутсвует атрибут id со значением заканчивающимся на какое-о value (ess)
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id$=ess]")).size());

        // Поиск всех элементов у которых присутсвует атрибут id со значением начинающимся на какое-то value- (ess)
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=my]")).size());

        // Поиск всех элементов у которых присутсвует атрибут id со значением начинающимся на какое-то value (L)
        Assert.assertEquals(2, driver.findElements(By.cssSelector("[id^=L]")).size());

        // Поиск всех элементов у которых присутсвует атрибут id со значением начинающимся на какое-то value (L)
        Assert.assertEquals(2, driver.findElements(By.cssSelector("[id^=L]")).size());

        // Поиск всех элементов у которых присутсвует атрибут title со значением содержащим слово целиком (тильда)
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title~=beautiful]")).size());

        // Поиск всех элементов у которых присутсвует атрибут title со значением содержащим  часть текста (звездочка)
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title*=beaut]")).size());

        // Поиск всех disabled элементов
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":disabled")).size());

        // Поиск всех enabled элементов
        Assert.assertEquals(8, driver.findElements(By.cssSelector(":enabled")).size());

        // Поиск всех enabled элементов
        Assert.assertEquals(2, driver.findElements(By.cssSelector(":checked")).size());

        // Поиск всех empty элементов с пустым телом
        Assert.assertEquals(16, driver.findElements(By.cssSelector(":empty")).size());

        // Поиск элемента с тэгом p и которым является первым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:first-child")).size());

        // Поиск элемента с тэгом p и которым является последним дочерним элементом
        Assert.assertEquals(2, driver.findElements(By.cssSelector("p:last-child")).size());

        // Поиск элемента с тэгом p и которым является последним дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:nth-child(3)")).size());

        // Поиск элемента с тэгом p ...
        Assert.assertEquals(3, driver.findElements(By.cssSelector("p:nth-child(even)")).size());

        // Поиск элемента с тэгом p ...
        Assert.assertEquals(4, driver.findElements(By.cssSelector("p:nth-child(odd)")).size());

        // Поиск элемента с тэгом b ...
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:nth-child(2)")).size());


    }
}
