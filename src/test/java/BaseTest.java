import org.testng.annotations.*;

public class BaseTest {

    protected Calculator calculator = new Calculator("тестовый калькулятор");

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest: ...");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest: ...");
    }


}
