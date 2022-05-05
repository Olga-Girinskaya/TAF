import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDouble extends BaseTest {

    protected Calculator calculator = new Calculator(Calculator.class.toString());

    @Test(testName = "Деление double числа (testName)", priority = 1)
    public void testDivisionDouble() {
        Assert.assertEquals(calculator.div(4.5, 3), 1.5, "Результат деления дробных чисел неверен");
    }

    @Test(dependsOnMethods = "testDivisionDoubleWithTimeout")
    public void testDivisionDoubleByZero() {
        Assert.assertEquals(calculator.div(12.5, 0), Double.POSITIVE_INFINITY, "Результат деления дробных чисел на '0' неверен");
    }

    @Test(timeOut = 2000, dependsOnMethods = "testDivisionDoublePriority")
    public void testDivisionDoubleWithTimeout() {
        Assert.assertEquals(calculator.div(4.5, 3), 1.5, "Результат деления дробных чисел неверен");
    }

    @Test(description = "Деление double числа (description)", priority = 2)
    public void testDivisionDoublePriority() {
        Assert.assertEquals(calculator.div(4.5, 3), 1.5, "Результат деления дробных чисел неверен");
    }

    @Test(enabled = false, priority = 2)
    public void testEnabledFalseAndPriority() {
        Assert.assertEquals(calculator.div(4.5, 3), 1.5, "Результат деления дробных чисел неверен");
    }

    @Test(invocationCount = 3, invocationTimeOut = 2000, threadPoolSize = 3)
    public void testInvocationCount() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.div(4.5, 3), 1.5, "Результат деления дробных чисел неверен");
    }

    @Test(testName = "dataProvider", dataProvider = "Double", dataProviderClass = StaticProvider.class)
    public void testDataProvider(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Результат деления дробных чисел неверен");
    }
}