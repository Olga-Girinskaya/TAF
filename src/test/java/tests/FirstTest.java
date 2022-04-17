package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {
    @Test
    public void browserTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "\\QA18\\AQA\\TAF1\\src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        WebElement input = driver.findElement(By.xpath("//input[@aria-label ='Найти']"));
        input.click();
        //input.sendKeys("Курсы валют"+"\n");
        input.sendKeys("Привет, мир");
        input.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.close();
    }
}
