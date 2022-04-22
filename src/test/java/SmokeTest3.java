import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTest3 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserService browserService = new BrowserService();
        driver = browserService.getDriver();
    }

    @Test
    public void calculator() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        WebElement width = driver.findElement(By.xpath("//input[@id = 'el_f_width']"));
        WebElement length = driver.findElement(By.xpath("//input[@id = 'el_f_lenght']"));
        WebElement room = driver.findElement(By.cssSelector("#room_type > option:nth-child(2)"));
        WebElement type = driver.findElement(By.cssSelector("#heating_type > option:nth-child(2)"));
        WebElement lossHeat = driver.findElement(By.id("el_f_losses"));

        width.sendKeys("4.5");
        length.sendKeys("5.4");
        lossHeat.sendKeys("30096");
        room.click();
        type.click();
        WebElement button = driver.findElement(By.xpath("//input[@class = 'buttHFcalc']"));

        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        Thread.sleep(2000);
        button.click();

        WebElement power = driver.findElement(By.id("floor_cable_power"));
        Assert.assertEquals(power.getAttribute("value"), "31601");
        WebElement powerDensity = driver.findElement(By.id("spec_floor_cable_power"));
        Assert.assertEquals(powerDensity.getAttribute("value"), "1300");

        //Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDow() {
        driver.quit();
    }

}

