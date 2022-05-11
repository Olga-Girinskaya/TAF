package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {
    @Test
    public void infoAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();

        Alert alert = driver.switchTo().alert(); //переключение на объект алерт

        alert.getText();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept(); // принять (закрыть алерт)

    }

    @Test
    public void confirmationDeclineAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick = 'jsConfirm()']")).click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS Confirm");

        alert.dismiss();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");
    }

    @Test
    public void confirmationAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick = 'jsConfirm()']")).click();
        Alert alert = driver.switchTo().alert(); //переключение на объект алерт

        Assert.assertEquals(alert.getText(), "I am a JS Confirm");
        // alert.accept(); // принять (закрыть алерт) кнопка "OK"
        // Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You clicked: Ok");

        alert.dismiss();  // нажать кнопку cancel
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");
    }

    @Test
    public void promptAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick = 'jsPrompt()']")).click();

        Alert alert = driver.switchTo().alert();

        alert.sendKeys("Test message!!!");
        alert.accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: Test message!!!");
    }
}