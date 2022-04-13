import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalcTest extends BaseTest {
    @Test
    public void  testSum(){
        Assert.assertEquals(calculator.sum(2,3),5,"Неверная сумма...");
    }
    @Test(enabled = false) //
    public void  testSum1(){
        Assert.assertEquals(calculator.sum(2,3),5,"Неверная сумма...");
    }
    @Test(description = "Тест с описанием") // меняет описание теста (нахождить в папке target)
    public void  testSum2(){
        Assert.assertEquals(calculator.sum(2,3),5,"Неверная сумма...");
    }
    @Test(testName = "Test with name") // меняет название теста
    public void  testSum3(){
        Assert.assertEquals(calculator.sum(2,3),5,"Неверная сумма...");
    }

    @Test (invocationCount = 3)  // кол-во повтора метода (например для заполнения чего-нибудь рандомными данными)
    public void  invocationCountTest(){
        Assert.assertEquals(calculator.sum(2,3),5,"Неверная сумма...");
    }
    @Test (invocationCount = 3,invocationTimeOut =1000)  // кол-во повтора метода (например для заполнения чего-нибудь рандомными данными)
    public void  invocationCountTest1() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.sum(2,3),5,"Неверная сумма...");
    }

    @Test (invocationCount = 3,invocationTimeOut =1000, threadPoolSize = 3)  // кол-во потоков threadPoolSize
    public void  invocationCountTest2() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.sum(2,3),5,"Неверная сумма...");
    }

    @Test (timeOut =1000)
    public void waitLongTimeTest() throws InterruptedException {
        Thread.sleep(1001);
}

@Test (dataProvider = "dataForSum", dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void testDataProvider(int a, int b, int expectedResult){
    Assert.assertEquals(calculator.sum(a,b),expectedResult,"Неверная сумма...");
}
@Test  (expectedExceptions = NullPointerException.class)
    public void testExceptions(){
    List List = null;
    int size = List.size();
}


}
