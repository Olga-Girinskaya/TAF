package steps;

import baseEntities.BaseStep;
import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MilestonesPage;
import pages.SideMenuPage;
import services.WaitsService;

import java.time.Duration;

public class MilestonesStep extends BaseStep {
    public SideMenuPage sideMenuPage;
    private WaitsService waitsService =new WaitsService(driver, Duration.ofSeconds(ReadProperties.timeout()));;

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

    // ? не получилось из Test обратиться к этим методам в Page, поэтому продублировала методы
    public WebElement getNameMilestone() {
        return waitsService.waitForExists(milestonesPage.nameMilestone);
    }

    public WebElement getReferencesMilestone() {
        return waitsService.waitForExists(milestonesPage.referencesMilestone);
    }

    public WebElement getDateEndMilestone() {
        return waitsService.waitForExists(milestonesPage.dateEndMilestone);
    }

    public WebElement getDescriptionEditor() {
        return waitsService.waitForExists(milestonesPage.descriptionEditor);
    }

}
