package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
    public void simpleSelenideTest() {
        open(ReadProperties.getUrl());

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password()); // По умолчанию cssSelector
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects1"));
    }

    @Test
    public void poSelenideTest() {
        open(ReadProperties.getUrl());
        LoginPage loginPage = new LoginPage();

        loginPage.username.setValue(ReadProperties.username());
        loginPage.password.setValue(ReadProperties.password()); // По умолчанию cssSelector
        loginPage.loginButton.click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));
    }

    @Test
    public void simpleSelenideTest1() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password()); // По умолчанию cssSelector
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects")); // Проверка то , что элемент видимый и текст у него All Projects
        $$("div.project")
                .filter(visible) //  только визибл элементы
                .shouldHave(size(26)) // проверка что на странице 26 таких элементов
                .find(text("erg")) // находим  div с текстом " erg
                .click();

        $$("div.project")
                .first(); // вернет 1 элеменнт из списка

        $$("div.project")
                .get(2); // Прочитать 2 элемент

        sleep(1000);
        refresh(); // обновляет страницу
        title(); // вернет title с нашей страницы
        //executeAsyncJavaScript("mmllmlm");
        // executeJavaScript("kjkhk");
    }

    @Test
    public void SelenideTest2() {
        open(ReadProperties.getUrl());

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password()); // По умолчанию cssSelector
        $("#button_primary").click();

        System.out.println($(byText("asdasdasdfaszc")).innerText());
        System.out.println($(byText("asdasdasdfaszc")).getText());
        System.out.println($(byText("asdasdasdfaszc")).innerHtml());
        System.out.println($(byText("asdasdasdfaszc")).data(""));
        System.out.println($(byText("asdasdasdfaszc")).val());
        System.out.println($(byText("asdasdasdfaszc")).getValue());
        $(byText("asdasdasdfaszc")).scrollTo();// Перейти к этому элементу
        $(byText("asdasdasdfaszc")).doubleClick(); // двойной клик
        $(byText("asdasdasdfaszc")).contextClick(); // клик правой кнопкой мыши
        $(byText("asdasdasdfaszc")).hover(); // Наехать на элемент
        $(byText("asdasdasdfaszc")).find(By.xpath(""));
        $(byText("asdasdasdfaszc")).closest("tr"); // найти ближайший элемент tr
        $(byText("asdasdasdfaszc")).ancestor("div"); // Оси
        $(byText("asdasdasdfaszc")).sibling(1);
        $(byText("asdasdasdfaszc")).parent(); //
        $(byText("asdasdasdfaszc")).uploadFile(new File("путь")); //вставит файл в элемент
        //$(byText("asdasdasdfaszc")).download();
    }

    @Test
    public void SelenideTest3() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password()); // По умолчанию cssSelector
        $("#button_primary").click();

        open("/index.php?/admin/projects/overview");

        $$(By.className("hoverSensitive"))
                .shouldHave(size(26))
                .find(text("erg"))
                .find(By.tagName("a"))
                .click();

        $("#announcement")
                .should(exist)
                .shouldBe(visible)
                .shouldHave(exactText("This is the description for the project1"));

        $("#announcement")
                .should(exist)
                .should(hidden).should(disappear).shouldNotBe(visible)
                .should(readonly) // только для чтения, нельзя редактировать
                .shouldHave(name("name"))
                .shouldHave(value("John"))
                .shouldHave(type("checkbox"))
                .should(empty)
                .shouldBe(focused);

        WebElement webElement = $("#announcement").toWebElement(); // переход к вебэлементам из selenide

        Condition clickable = and("can be clicked", visible, enabled);
        $$("#announcement")
                .findBy(clickable).click();

        $("#announcement").shouldBe(clickable);

        // проверка текста
        $("#announcement")
                .shouldHave(text("Expected Text"))  // contains (без учета регистра)
                .shouldHave(matchText("a-zA-Z")) // regex (регулярные выражения)
                .shouldHave(exactText("Exact Text"))// equalsIgnoreCase (полное вхождение текста без учета регистра);
                .shouldHave(textCaseSensitive("Expected Result Text")) //  contains (с учетом регистра)
                .shouldHave(exactTextCaseSensitive("Expected Result Text")); //equals (полное совпадение с пробелами и т.д с учетом регистра)
    }
}
