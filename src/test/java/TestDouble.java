import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDouble extends BaseTest {

    protected Calculator calculator = new Calculator(Calculator.class.toString());

    // protected Calculator calculator = new Calculator("Test calculator");

    @Test(testName = "Деление double числа (testName)", priority = 1)
    public void testDivDouble1() {
        Assert.assertEquals(calculator.div(4.5, 3), 1.5, "Неверный ответ....");
    }

    @Test(testName = "Деление на '0' double числа", dependsOnMethods = "testDivDouble3")
    public void testDivDouble2() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, 12.5/0);
    }

    @Test(timeOut = 2000, dependsOnMethods = "testDivDouble4")
    public void testDivDouble3() {
        Assert.assertEquals(calculator.div(4.5, 3), 1.5, "Неверный ответ....");
    }

    @Test(description = "Деление double числа (description)", priority = 2)
    public void testDivDouble4() {
        Assert.assertEquals(calculator.div(4.5, 3), 1.5, "Неверный ответ....");
    }

    @Test(enabled = false, priority = 2)
    public void testEnabled() {
        Assert.assertEquals(calculator.div(4.5, 3), 1.5, "Неверная сумма...");
    }

    @Test(invocationCount = 3, invocationTimeOut = 2000, threadPoolSize = 3)
    public void invocationCountTest2() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.div(4.5, 3), 1.5, "Неверная сумма...");
    }

    @Test(testName = "dataProvider", dataProvider = "Double", dataProviderClass = StaticProvider.class)
    public void testDataProvider(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Неверная сумма...");
    }
}