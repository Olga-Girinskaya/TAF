package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void successLoginTest() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPsw(ReadProperties.password());

        Assert.assertTrue(
                loginStep.successLogin(user)
                        .isPageOpened()
        );
    }

    @Test
    public void incorrectEmailLoginTest() {
        User user = new User();
        user.setEmail("sdsd");
        user.setPsw(ReadProperties.password());

        Assert.assertEquals(
                loginStep.incorrectLogin(user).getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
        Assert.assertTrue(false);
    }

    @Test
    public void incorrectPswLoginTest() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPsw("123");

        Assert.assertEquals(
                loginStep.incorrectLogin(user).getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }
}
