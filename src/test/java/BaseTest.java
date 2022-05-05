import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest: ...");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest: ...");
    }

}
