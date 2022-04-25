package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import services.BrowserService;
import tests.LoginTest;

public class LoginPage  {
    private WebDriver driver;

    // Блок описания селекторов для элементов
    private By emailInputLocator=By.id("name");
    private By pswInputLocator=By.id("password");
    private By loginButtonLocator=By.id("button_primary");

    //Блок инициализации
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Блок атомарных методов
    public WebElement getEmailInput() {
            return driver.findElement(emailInputLocator);
    }

    public WebElement getPswInput() {
      return   driver.findElement(pswInputLocator);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButtonLocator);
    }

}
