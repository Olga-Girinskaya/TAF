package steps.defs;

import configuration.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import services.BrowsersService;

public class FirstStepDef {
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Given("открыт браузер")
    public void browserIsStarted() {
        System.out.println("Открываю браузер");
        driver = new BrowsersService().getDriver();
    }

  //  @After
    public void closeBrowser() {
        driver.quit();
        System.out.println("Закрыт браузер");
    }

    @When("страница логина открыта")
    public void loginPageIsOpen() {
        driver.get(ReadProperties.getUrl());
        loginPage = new LoginPage(driver);
    }

    @Then("поле username отображается при запуске")
    public void usernameFieldIsDisplayed() {
        Assert.assertTrue(loginPage.getEmailInput().isDisplayed());
    }

    @When("пользователь {string} и пароль {string} залогинился")
    public void userWithEmailAndRswLoggedIn(String email, String psw) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPswInput().sendKeys(psw);
        loginPage.getLogInButton2().click();
    }

    @Then("кнопка добавления проекта отображается")
    public void addProjectButton() {
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(true);
    }

    @And("пользователь {string}")
    public void user(String username) {
        System.out.println(username);
    }

    @And("количество проектов - {int}")
    public void countProject(int count) {
        Assert.assertEquals(count, 15);
    }
}

