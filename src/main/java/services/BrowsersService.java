package services;

import configuration.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Locale;

public class BrowsersService {
    private WebDriver driver = null;
    private DriverManagerType driverManagerType = null;

    public BrowsersService() {
        switch (ReadProperties.browserName().toLowerCase(Locale.ROOT)) {
            case "chrome":
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup(); // настройка браузера на локальном компьютере
                driver = new ChromeDriver(getChromeOptions());
                break;

            case "firefox":
                break;

            default:
                System.out.println("Browser " + ReadProperties.browserName() + " is not supported.");
        }
    }

    public WebDriver getDriver() {
        driver.manage().window().maximize(); //отобразить на весь экран
        driver.manage().deleteAllCookies(); // удалить все куки
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
        return this.driver;
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(ReadProperties.isHeadless()); // запуск браузера без визуализации
        chromeOptions.addArguments("--disable-gpu"); //отключение графического процессора
        //chromeOptions.addArguments("--window-size=1920,1200"); // задается расширение экрана
        chromeOptions.addArguments("--ignore-certificate-errors"); // игнорирует ошибки сертификата
        chromeOptions.addArguments("--silent"); // браузер не будет задавать лишних вопросов
        chromeOptions.addArguments("--start-maximized"); // развернет браузер на весь экран
        // chromeOptions.addArguments("--incognito"); // запуск  браузера инкогнито

        return chromeOptions;
    }

}
