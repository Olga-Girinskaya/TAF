import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AdvancedDriver {
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "\\QA18\\AQA\\TAF1\\src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(getChromeOptions());
        return driver;
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(ReadProperties.isHeadless()); // запуск браузера без визуализации
        chromeOptions.addArguments("--disable-gpu"); //отключение графического процессора
        //chromeOptions.addArguments("--window-size=1920,1200"); // задаетс расширение экрана
        chromeOptions.addArguments("--ignore-certificate-errors"); // игнорирует ошибки сертификата
        chromeOptions.addArguments("--silent"); // браузер не будет задаать лишних вопросов
        chromeOptions.addArguments("--start-maximized"); // развернет браузер на весь экран
        chromeOptions.addArguments("--incognito"); // запуск  браузера инкогнито

        return  chromeOptions;
    }
}
