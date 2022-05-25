package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.TopMenuPage;

public class MenuTest extends BaseTest {
    User user =new  User();

    @Test
    public void validate_Dashboard_Menu_Test() {
        DashboardPage dashboardPage = loginStep.successLogin(user);
        TopMenuPage topMenuPage = dashboardPage.topMenuPage;

        Assert.assertTrue(topMenuPage.isPageOpened());
    }

    @Test
    public void validate_Projects_SideMenu_Test() {
        loginStep.successLogin(user);
        Assert.assertTrue(navigationStep.navigateToProjectsPage().sideMenuPage.isPageOpened());
    }
}
