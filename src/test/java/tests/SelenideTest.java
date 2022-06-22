package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @BeforeSuite
    public void setupBrowser() {
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = ReadProperties.browserName();
        Configuration.browserSize = "1960x1080";
        // Configuration.assertionMode = AssertionMode.SOFT;
        // Configuration.driverManagerEnabled = false;
        // Configuration.fastSetValue = false;  // имитация ручного ввода (медленнее)
        // Configuration.headless =  true;  // без отображения браузера
        Configuration.reportsFolder = "target/screenshots";
        // Configuration.screenshots = false ; // отключить скрины
        Configuration.pageLoadTimeout = 30000;  // 30 секунд
        Configuration.timeout = Duration.ofSeconds(10).toMillis(); // 10 секунд

        // подключаем allure
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

       /* // or for fine-tuning:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );
        */

    }

    @Test
    public void poSelenideTest() {
        open(ReadProperties.getUrl());
        LoginPage loginPage = new LoginPage();

        loginPage.username.setValue(ReadProperties.username());
        loginPage.password.setValue(ReadProperties.password()); // По умолчанию cssSelector
        loginPage.loginButton.click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects1"));
    }

}
