package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Allure example")
@Feature("TestNG support")
public class AllureTest {

    @Test(description = "Main Test")
    public void testName() {
        Assert.assertTrue(true);
    }

    @Test
    @Description("Some details for this test")
    public void testName1() {
        Assert.assertTrue(true);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void testName2() {
        Assert.assertTrue(true);
    }

    @Test
    @Story("Base support function")
    public void testName3() {
        Assert.assertTrue(true);
    }

    @Test
    public void testName4() {
        step1("Admin");
        Assert.assertTrue(true);
    }

    @Step("Username {user}")
    private void step1(String user) {
        System.out.println(user);
    }

    @Test
    @Issue("ID-123")
    public void testIssue() {
        Assert.assertTrue(true);
    }

    @Test
    @TmsLink("IC-532")
    public void testTms() {
        Assert.assertTrue(true);
    }

    @Test
    @Link("https://example.org")
    @Link(name="allureLink",type="muLink",url="https://onliner.by")
    public void testLink() {
        Assert.assertTrue(true);
    }

}
