import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTest2 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserService browserService = new BrowserService();
        driver = browserService.getDriver();
    }

    @Test
    public void validateSKF() {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");
        WebElement selectWebElement = driver.findElement(By.id("oSex"));
        Select selectSex = new Select(selectWebElement);
        //selectSex.selectByIndex(1);
        selectSex.selectByValue("1");
        // selectSex.selectByVisibleText("женский");

        WebElement cr = driver.findElement(By.id("oCr"));
        WebElement age = driver.findElement(By.id("oAge"));
        WebElement weight = driver.findElement(By.id("oWeight"));
        WebElement height = driver.findElement(By.id("oHeight"));
        WebElement button = driver.findElement(By.xpath("//input[@value = 'Рассчитать']"));

        cr.sendKeys("80");
        age.sendKeys("38");
        weight.sendKeys("55");
        height.sendKeys("163");
        button.click();
        //  Thread.sleep(2000);
        WebElement resultMDRD = driver.findElement(By.id("txtMDRD"));
        Assert.assertEquals(resultMDRD.getText(), "MDRD: 74 (мл/мин/1,73кв.м)");
        WebElement resultMDRD1 = driver.findElement(By.id("txtMDRD1"));
        Assert.assertEquals(resultMDRD1.getText(), "ХБП: 2 стадия (при наличии почечного повреждения)");
        WebElement resultCG = driver.findElement(By.id("txtCG"));
        Assert.assertEquals(resultCG.getText(), "Cockroft-Gault: 70 (мл/мин)");
        WebElement resultBSA = driver.findElement(By.id("txtBSA"));
        Assert.assertEquals(resultBSA.getText(), "Поверхность тела:1.58 (кв.м)");
    }

    @AfterMethod
    public void tearDow() {
        driver.quit();
    }

}

