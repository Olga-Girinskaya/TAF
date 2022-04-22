import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTest4 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserService browserService = new BrowserService();
        driver = browserService.getDriver();
    }

    @Test
    public void calculator() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");

        WebElement lengthRoom = driver.findElement(By.id("ln_room_id"));
        WebElement wightRoom = driver.findElement(By.id("wd_room_id"));
        WebElement lengthPanel = driver.findElement(By.id("ln_lam_id"));
        WebElement wightPanel = driver.findElement(By.id("wd_lam_id"));
        WebElement metodLaminate = driver.findElement(By.id("direction-laminate-id1"));

        lengthRoom.clear();
        lengthRoom.sendKeys("500");
        wightRoom.clear();
        wightRoom.sendKeys("400");
        lengthPanel.clear();
        lengthPanel.sendKeys("2000");
        wightPanel.clear();
        wightPanel.sendKeys("200");
        metodLaminate.click();
        Thread.sleep(5000);
        WebElement result = driver.findElement(By.cssSelector(".calc-btn-div>.calc-btn"));
        result.click();
        //  ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);"); // скролл до конца страницы
        //  ((JavascriptExecutor) driver).executeScript("arguments [0].scrollIntoView();", result); // скрол элемена result
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        Thread.sleep(2000);
        WebElement countBoard = driver.findElement(By.cssSelector(".calc-result>div:nth-child(1)"));
        Assert.assertEquals(countBoard.getText(), "Требуемое количество досок ламината: 53");
        WebElement countPackages = driver.findElement(By.cssSelector(".calc-result>div:nth-child(2)"));
        Assert.assertEquals(countPackages.getText(), "Количество упаковок ламината: 7");
        // Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDow() {
        driver.quit();
    }

}

