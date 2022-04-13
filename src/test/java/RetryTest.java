import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTest extends BaseTest{
    private int attempt = 1;

    @Test (retryAnalyzer = Retry.class) // обращение у классу Retry
    public void flakyTest() {
        if (attempt == 6)
            Assert.assertTrue(true);
        else {
            attempt++;
            System.out.println("Attempt is: " + attempt);
            throw new NullPointerException();
        }
    }
}