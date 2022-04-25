package tests;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import services.BrowserService;

public class LoginTest  {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new BrowserService().getDriver();
        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown(){
       driver.quit();
    }

    @Test
    public void successLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPswInput().sendKeys(ReadProperties.password());
        loginPage.getLoginButton().click();
    }

    @Test
    public void incorrectEmailLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPswInput().sendKeys(ReadProperties.password());
        loginPage.getLoginButton().click();
    }

    @Test
    public void incorrectPswLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPswInput().sendKeys(ReadProperties.password());
        loginPage.getLoginButton().click();
    }
}
