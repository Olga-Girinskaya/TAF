package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Allure example")
@Feature("TestNG support")
 public class EpicTest {

    @Test
    @Story("Base support function_1")
    public void testName3() {
        Assert.assertTrue(true);
    }


}
