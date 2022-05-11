package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {
    @Test
    public void frameTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        //  driver.switchTo().frame(0); // переключение в дочерний frame (по индексу)  по айдишнику.  По индексу лучше не использовать, так как он может быть плавающий
        //   driver.switchTo().frame("mce_0_ifr");// по параметру
        driver.switchTo().frame(driver.findElement(By.cssSelector(".tox-edit-area__iframe"))); // по webElement
        Assert.assertTrue(driver.findElement(By.id("tinymce")).isDisplayed());
        driver.switchTo().parentFrame(); //переключение в родительский frame
        // driver.switchTo().defaultContent(); // переключение обратно на самую первую страницу
        Assert.assertTrue(driver.findElement(By.className("tox-editor-container")).isDisplayed());
    }
}
