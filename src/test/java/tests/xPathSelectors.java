package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowserService;

public class xPathSelectors {

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
    public void basicXPathSelectors() {
        driver.get(ReadProperties.getUrl());
        //Все элементы на сранице начиная с html

        //Аналог поиска по tagName
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());


        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div[2]/div/input")).isDisplayed());

        driver.findElement(By.xpath("//*"));

        //поиск родиельского div с на 1 уровень ниже h1
        Assert.assertTrue(driver.findElement(By.xpath("//div/h1")).isDisplayed());

        //поиск родиельского div с на любом уровне ниже div
        Assert.assertTrue(driver.findElement(By.xpath("//div//div")).isDisplayed());

        //поиск элемента с тэгом div, у которого есть id
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='top']")).isDisplayed());

        //поиск элемента с , у которого есть id со значением 'top'
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='top']")).isDisplayed());

        //поиск элемена у которого есь атрибуты со значениями method='post' и target='_blank'
        Assert.assertTrue(driver.findElement(By.xpath("//*[@method='post'] and [@target='_blank']")).isDisplayed());

        // у которого начало подстроки 'top'
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@id,'top')]")).isDisplayed());

//   у которого значение ариьуа содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id,'Template')]")).isDisplayed());

        // ...  у котторого тексвовое значение содержи равно
Assert.assertTrue(driver.findElement(By.xpath("//div[text()='All Projects']")).isDisplayed());
Assert.assertTrue(driver.findElement(By.xpath("//div[.='All Projects']")).isDisplayed());

 // у которого текастовое значение содержи подстроку
Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'All Projects')]")).isDisplayed());

//
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'All Projects')]")).isDisplayed());


    }

    public void axesXPathTest(){
        driver.get(ReadProperties.getUrl());

        //поиск родителя у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/..")).isDisplayed());
        //аналог
        Assert.assertTrue(driver.findElement(By.xpath("//h1/parent::div")).isDisplayed());

        // поиск всех предков с тэгом div у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/ancestor::div")).isDisplayed());

        // Использование child - все дочерние элементы с тэгом a о div
        Assert.assertTrue(driver.findElement(By.xpath("//div/child::a[]")).isDisplayed());

        // Использование following - выбирает все в документе после закрытия тэга с классом 'dialog-title' текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following::form")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following-sibling::form")).isDisplayed());

        // Использование preceding - выбирает все в документе до закрытия тэга с классом 'dialog-title' текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/preceding::form")).isDisplayed());

        //
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following-sibling::form")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following-sibling::form")).isDisplayed());


        //
        Assert.assertTrue(driver.findElement(By.xpath("")).isDisplayed());


    }
}
