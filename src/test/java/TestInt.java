import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestInt extends BaseTest {

    protected Calculator calculator = new Calculator(Calculator.class.toString());

    @Test(testName = "Деление целого числа (testName)", priority = 1)
    public void testDivisionInt() {
        Assert.assertEquals(calculator.div(6, 2), 3, "Результат деления целых чисел неверен");
    }

    @Test(expectedExceptions = ArithmeticException.class, dependsOnMethods = "testDivisionIntWithTimeout")
    public void testDivisionIntByZero() {
        Assert.assertEquals(calculator.div(6, 0), 0, "Нет исключения при делении целого числа на '0'");
    }

    @Test(timeOut = 2000, dependsOnMethods = "testDivisionIntWithPriority")
    public void testDivisionIntWithTimeout() {
        Assert.assertEquals(calculator.div(6, 2), 3, "Результат деления целых чисел неверен");
    }

    @Test(description = "Деление целого числа (description)", priority = 2)
    public void testDivisionIntWithPriority() {
        Assert.assertEquals(calculator.div(6, 2), 3, "Результат деления целых чисел неверен");
    }

    @Test(enabled = false, priority = 2)
    public void testEnabledFalseAndPriority() {
        Assert.assertEquals(calculator.div(6, 3), 2, "Результат деления целых чисел неверен");
    }

    @Test(invocationCount = 3, invocationTimeOut = 2000, threadPoolSize = 3)
    public void testDivisionIntWithInvocationCount() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.div(6, 2), 3, "Результат деления целых чисел неверен");
    }

    @Test(testName = "dataProvider", dataProvider = "dataForDivIntTest", dataProviderClass = StaticProvider.class)
    public void testDivisionIntWithDataProvider(int a, int b, int expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Результат деления целых чисел неверен");
    }
}