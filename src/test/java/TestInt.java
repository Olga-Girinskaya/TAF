import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestInt extends BaseTest {

    protected Calculator calculator = new Calculator(Calculator.class.toString());

    @Test(testName = "Деление целого числа (testName)",priority = 1)
    public void testDivInt1() {
        Assert.assertEquals(calculator.divInt(6, 2), 3, "Неверный ответ....");
    }

    @Test(testName = "Деление на '0' целого числа (expectedExceptions)", expectedExceptions = ArithmeticException.class, dependsOnMethods = "testDivInt3")
    public void testDivInt2() {
        Assert.assertEquals(calculator.divInt(6, 0), 0, "Неверный ответ....");
    }

    @Test(timeOut = 2000, dependsOnMethods = "testDivInt4")
    public void testDivInt3() {
        Assert.assertEquals(calculator.divInt(6, 2), 3, "Неверный ответ....");
    }

    @Test(description = "Деление целого числа (description)",priority = 2)
    public void testDivInt4() {
        Assert.assertEquals(calculator.divInt(6, 2), 3, "Неверный ответ....");
    }

    @Test(enabled = false,priority = 2) //
    public void  testEnabled(){
        Assert.assertEquals(calculator.divInt(6,3),2,"Неверная сумма...");
    }

    @Test(invocationCount = 3, invocationTimeOut = 2000, threadPoolSize = 3)
    // кол-во потоков threadPoolSize
    public void invocationCountTest2() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.divInt(6, 2), 3, "Неверная сумма...");
    }

    @Test(testName = "dataProvider", dataProvider = "dataForDivIntTest", dataProviderClass = StaticProvider.class)
    public void testDataProvider(int a, int b, int expectedResult) {
        Assert.assertEquals(calculator.divInt(a, b), expectedResult, "Неверная сумма...");
    }
}