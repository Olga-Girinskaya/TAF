package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestonesTest extends BaseTest {

    @Test
    public void test_CRUD_Milestones() throws InterruptedException {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        Assert.assertTrue(navigationStep.navigateToProjectsPage().isPageOpened()); //Открыта страница dashboard
        Assert.assertTrue(navigationStep.openMilestonesPage().isPageOpened()); //Открыта страница с проектом на разделе Milestones
        Assert.assertTrue(milestonesStep.addMilestoneButton().isPageOpened()); //По клику на кнопку "Add Milestone" страница Milestones открыта
        Assert.assertTrue(milestonesStep.getPageIdentifier().isPageOpened()); //Открыта страница Milestone

        milestonesStep.createMilestone();
        // проверка на создание
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

        milestonesStep.deleteMilestone();
        Thread.sleep(2000);
        // проверка на удаление
        try {
            Assert.assertTrue(milestonesPage.getNameMilestone().isDisplayed());
            Assert.fail("Milestone не удален");
        } catch (NoSuchElementException e) {
            System.out.println("Milestone удален");
        }
    }
}
