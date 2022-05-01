package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class Task_6 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(testName = "Добавление товара в корзину")
    public void login() throws InterruptedException {
        driver.get(ReadProperties.getUrl());

        //login
        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());
        driver.findElement(By.id("password")).sendKeys(ReadProperties.password());
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Добавление товара в корзину
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt")).click();

        //Переход в корзину
        driver.findElement(By.cssSelector("#shopping_cart_container")).click();

        //Проверка (assertEquals) стоимости товара и его имени в корзине
        Assert.assertEquals(driver.findElement(By.cssSelector(".inventory_item_name")).getText(), "Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(driver.findElement(By.cssSelector(".inventory_item_price")).getText(), "$15.99");
        Thread.sleep(2000);
    }

    //Поиск локаторов по критериям
    @Test(testName = "Поиск локаторов")
    public void locatorsTests() throws InterruptedException {
        driver.get(ReadProperties.getUrl());

        //login
        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());
        driver.findElement(By.id("password")).sendKeys(ReadProperties.password());
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Поиск по id
        Assert.assertTrue(driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).isDisplayed());
        //Поиск по name
        Assert.assertTrue(driver.findElement(By.name("add-to-cart-sauce-labs-onesie")).isDisplayed());
        //Поиск по className
        Assert.assertTrue(driver.findElement(By.className("footer")).isDisplayed());
        //Поиск по tagName
        Assert.assertTrue(driver.findElement(By.tagName("div")).isDisplayed());
        //Поиск по linkText
        Assert.assertTrue(driver.findElement(By.linkText("Sauce Labs Onesie")).isDisplayed());
        //Поиск по partialLinkText
        Assert.assertTrue(driver.findElement(By.partialLinkText("Onesie")).isDisplayed());

        //cssSelector
        //Поиск по .class
        Assert.assertTrue(driver.findElement(By.cssSelector(".shopping_cart_link")).isDisplayed());
        //Поиск по .class.class
        Assert.assertTrue(driver.findElement(By.cssSelector(".btn.btn_primary")).isDisplayed());
        //Поиск по .class .class
        Assert.assertTrue(driver.findElement(By.cssSelector(".pricebar .inventory_item_price")).isDisplayed());
        //Поиск по id
        Assert.assertTrue(driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).isDisplayed());
        //Поиск по taNname
        Assert.assertTrue(driver.findElement(By.cssSelector("div")).isDisplayed());
        //Поиск по tagName.class
        Assert.assertTrue(driver.findElement(By.cssSelector("div.inventory_item_price")).isDisplayed());
        //Поиск по [attribute=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[alt='Sauce Labs Fleece Jacket']")).isDisplayed());
        //Поиск по [attribute~=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[alt~=Fleece]")).isDisplayed());
        //Поиск по [attribute^=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[alt^=Sauce]")).isDisplayed());
        //Поиск по [attribute$=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[alt$=Jacket]")).isDisplayed());
        //Поиск по [attribute*=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[alt*=auce]")).isDisplayed());

        //XPath
        //Поиск по атрибуту
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='pricebar']")).isDisplayed());
        //Поиск по тексту
        Assert.assertTrue(driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']")).isDisplayed());
        //Поиск по частичному совпадению атрибута
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'price')]")).isDisplayed());
        //Поиск по частичному совпадению текста
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Labs')]")).isDisplayed());
        //ancestor
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='menu_button_container']/ancestor::div")).isDisplayed());
        //descendant
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='menu_button_container']/descendant::div")).isDisplayed());
        //following
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='menu_button_container']/following::span")).isDisplayed());
        //parent
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='shopping_cart_container']/parent::div")).isDisplayed());
        //preceding
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='shopping_cart_container']/preceding::div")).isDisplayed());
        //Поиск элемента с условием AND
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class = 'btn btn_primary btn_small btn_inventory' and @name ='add-to-cart-sauce-labs-backpack']")).isDisplayed());
    }
}
