package services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitsService {
    private final WebDriverWait wait;
    private final WebDriver driver;

    public WaitsService(WebDriver driver, Duration timeout) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeout);
    }

    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForExists(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public Boolean waitForElementInvisible(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

}
