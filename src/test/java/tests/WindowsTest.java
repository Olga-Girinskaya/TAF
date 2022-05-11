package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsTest extends BaseTest {
    @Test
    public void newTabTest() {
        driver.get("http://the-internet.herokuapp.com/windows");

        String originalWindow = driver.getWindowHandle(); // Основная страница
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandlesSet = driver.getWindowHandles();  // множество страниц
        List<String> windowHandleList = new ArrayList<>(windowHandlesSet); // создание массива страниц из множества

        driver.switchTo().window(windowHandleList.get(1)); // переключение на окно (берем 2 окно)
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "New Window");
        driver.close(); // закрываем текущую вкладку ( у нас это 2 вкладка)
        driver.switchTo().window(originalWindow); // Переключение на главную страницу
        Assert.assertTrue(driver.findElement(By.linkText("Click Here")).isDisplayed());

    }

    @Test
    public void newTabTest1() {
        driver.get("http://the-internet.herokuapp.com/windows");

        String originalWindow = driver.getWindowHandle(); // Основная страница
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandlesSet = driver.getWindowHandles();  // множество страниц
        // пример с 2 заклад ками
        for (String handle:windowHandlesSet){
            if(!originalWindow.equals(handle)){
                driver.switchTo().window(handle);
                break;
            }
        }

        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "New Window");
        driver.close(); // закрываем текущую вкладку ( у нас это 2 вкладка)
        driver.switchTo().window(originalWindow); // Переключение на главную страницу
        Assert.assertTrue(driver.findElement(By.linkText("Click Here")).isDisplayed());

    }
}