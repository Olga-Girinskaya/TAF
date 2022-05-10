package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class MilestonesTest extends BaseTest {

    @Test
    public void test_CRUD_Milestones() {
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(5));

        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        Assert.assertTrue(navigationStep.navigateToProjectsPage().isPageOpened()); //Открыта страница dashboard
        Assert.assertTrue(navigationStep.openMilestonesPage().isPageOpened()); //Открыта страница с проектом на разделе Milestones
        Assert.assertTrue(milestonesStep.addMilestoneButton().isPageOpened()); //По клику на кнопку "Add Milestone" страница Milestones открыта
        Assert.assertTrue(milestonesStep.getPageIdentifier().isPageOpened()); //Открыта страница Milestone

        milestonesStep.createMilestone();
        // проверка на содание
        Assert.assertEquals(milestonesPage.getNameMilestone().getText(), milestonesStep.name, "Milestone не создана");
        System.out.println("Milestone создан");

        milestonesStep.editMilestone();
        milestonesStep.updateMilestone();

        milestonesStep.editMilestone();
        // проверка на редактирование и чтение
        Assert.assertEquals(milestonesPage.getReferencesMilestone().getAttribute("value"), milestonesStep.reference, "Reference не соответствует");
        Assert.assertEquals(milestonesPage.getDescriptionEditor().getText(), milestonesStep.description, "Description не соответствует");
        Assert.assertEquals(milestonesPage.getDateEndMilestone().getAttribute("value"), milestonesStep.date, "Дата окончания не соответствует");
        System.out.println("Milestone прочитан");
        System.out.println("Milestone изменен");
        milestonesStep.cancelMilestone();

        WebElement name = wait.waitForVisibility(milestonesPage.getNameMilestone());
        milestonesStep.deleteMilestone();
        // проверка на удаление
        try {
            Assert.assertTrue(wait.waitForElementInvisible(name), "Milestone не удален");
            System.out.println("Milestone удален");
        } catch (TimeoutException e) {
            Assert.fail("Milestone не удален");
        }
    }
}
