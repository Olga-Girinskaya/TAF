package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.MilestonesPage;
import pages.SideMenuPage;

public class MilestonesStep extends BaseStep {
    public SideMenuPage sideMenuPage;

    public String name = "Test_Milestone";
    public String reference = "Test references";
    public String description = "Test description";
    public String date = "12/15/2021";

    public MilestonesStep(WebDriver driver) {
        super(driver);
        sideMenuPage = new SideMenuPage(driver);
    }

    public MilestonesPage getPageIdentifier() {
        milestonesPage.getPageIdentifier();
        return milestonesPage;
    }

    //нажать кнопку "Add Milestone" в side menu
    public MilestonesPage addMilestoneButton() {
        sideMenuPage.getAddMilestonesButtonLocator().click();
        return milestonesPage;
    }

    //нажать кнопку "edit"
    public void editMilestone() {
        milestonesPage.getEditMilestone().click();
    }

    // создание Milestone
    public void createMilestone() {
        milestonesPage.getNameInputLocator().clear();
        milestonesPage.getNameInputLocator().sendKeys(name);
        milestonesPage.getSaveButtonLocator().click();
    }

    //удаление Milestone
    public void deleteMilestone() {
        milestonesPage.getCheckboxDeleteMilestone().click();
        milestonesPage.getDeleteMilestone().click();
        milestonesPage.getConfirmCheck().click();
        milestonesPage.getDeleteCheck().click();
    }

    // отмена редактирования
    public void cancelMilestone() {
        milestonesPage.getButtonCancelMilestone().click();
    }

    // редактирование
    public void updateMilestone() {
        milestonesPage.getReferencesMilestone().clear();
        milestonesPage.getDateEndMilestone().clear();
        milestonesPage.getReferencesMilestone().sendKeys(reference);
        milestonesPage.getDescriptionEditor().sendKeys(description);
        milestonesPage.getDateEndMilestone().sendKeys(date);
        milestonesPage.getSaveButtonLocator().click();
    }
}
