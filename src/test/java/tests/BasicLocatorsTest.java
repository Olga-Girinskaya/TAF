package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowserService;

public class BasicLocatorsTest {
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
    public void basicLocatorsTest_1() {
        driver.get(ReadProperties.getUrl());

        //Find webElement by ID
        driver.findElement(By.id("name")).sendKeys(ReadProperties.username());

        //Find webElement by name
        driver.findElement(By.id("password")).sendKeys(ReadProperties.password());

        //Find webElement by TadName
        driver.findElement(By.tagName("button")).click();

    }

    @Test
    public void basicLocatorsTest_2() throws InterruptedException {

        driver.get(ReadProperties.getUrl());

        //Find wbElement by LinkText
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);

        //Find webElement by class
        driver.findElement(By.className("forgot_passwordpage-request-cancel")).click();
        Thread.sleep(2000);

        //Find webElement by PartialLinkText
        driver.findElement(By.partialLinkText("your password?")).click();
        Thread.sleep(2000);
    }

}
