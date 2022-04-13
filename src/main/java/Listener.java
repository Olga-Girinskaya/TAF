import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    public void onTestFailure(ITestResult result) { // скриншот
        System.out.println("Make is screenshot...");
    }


}
