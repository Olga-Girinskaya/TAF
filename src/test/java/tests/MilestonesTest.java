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
        navigationStep.navigateToProjectsPage();
        navigationStep.openMilestonesPage();
        milestonesStep.addMilestoneButton();
        milestonesStep.getPageIdentifier();
        milestonesStep.createMilestone();
        // проверка на создание
        Assert.assertEquals(milestonesPage.getNameMilestone().getText(), milestonesStep.name, "Milestone не создан");
        milestonesStep.editMilestone();
        milestonesStep.updateMilestone();

        // проверка на редактирование и чтение
        milestonesStep.editMilestone();
        Assert.assertEquals(milestonesPage.getReferencesMilestone().getAttribute("value"), milestonesStep.reference, "Reference не соответствует");
        Assert.assertEquals(milestonesPage.getDescriptionEditor().getText(), milestonesStep.description, "Description не соответствует");
        Assert.assertEquals(milestonesPage.getDateEndMilestone().getAttribute("value"), milestonesStep.date, "Дата окончания не соответствует");
        milestonesStep.cancelMilestone();

        WebElement name = wait.waitForVisibility(milestonesPage.getNameMilestone());
        milestonesStep.deleteMilestone();
        // проверка на удаление
        try {
            Assert.assertTrue(wait.waitForElementInvisible(name), "Milestone не удален");
        } catch (TimeoutException e) {
            Assert.fail("Milestone не удален");
        }
    }
}
