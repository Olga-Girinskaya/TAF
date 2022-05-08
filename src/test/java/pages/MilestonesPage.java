package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {
    private final By allMilestonePageLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Add Milestone')]");

    // Блок описания селекторов для элементов
    public By nameInputLocator = By.cssSelector("#name");
    public By saveButtonLocator = By.cssSelector("#accept");
    public By nameMilestone = By.xpath("//a[text()='Test_Milestone']");
    public By referencesMilestone = By.id("reference");
    public By editMilestone = By.xpath("//a[text()='Test_Milestone']/following::div[@class='summary-links text-secondary']/descendant::a[text()='Edit']");
    public By descriptionEditor = By.cssSelector(".field-editor");
    public By dateStartMilestone = By.id("start_on");
    public By dateEndMilestone = By.id("due_on");
    public By checkboxDeleteMilestone = By.xpath("//a[text()='Test_Milestone']/preceding::input[@name='entity_milestones']");
    public By buttonCancelMilestone = By.cssSelector(".milestone-form-cancel");
    public By deleteMilestone = By.id("delete-milestones");
    public By confirmCheck = By.id("confirm-check");
    public By deleteCheck = By.cssSelector(".button-black");

    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public By getPageIdentifier() {
        return allMilestonePageLocator;
    }

    // Блок атомарных методов
    public WebElement getNameInputLocator() {
        return driver.findElement(nameInputLocator);
    }

    public WebElement getSaveButtonLocator() {
        return driver.findElement(saveButtonLocator);
    }

    public WebElement getNameMilestone() {
        return driver.findElement(nameMilestone);
    }

    public WebElement getEditMilestone() {
        return driver.findElement(editMilestone);
    }

    public WebElement getReferencesMilestone() {
        return driver.findElement(referencesMilestone);
    }

    public WebElement getDateStartMilestone(){
        return driver.findElement(dateStartMilestone);
    }

    public WebElement getDateEndMilestone() {
        return driver.findElement(dateEndMilestone);
    }

    public WebElement getCheckboxDeleteMilestone() {
        return driver.findElement(checkboxDeleteMilestone);
    }

    public WebElement getButtonCancelMilestone() {
        return driver.findElement(buttonCancelMilestone);
    }

    public WebElement getDeleteMilestone() {
        return driver.findElement(deleteMilestone);
    }

    public WebElement getConfirmCheck() {
        return driver.findElement(confirmCheck);
    }

    public WebElement getDeleteCheck() {
        return driver.findElement(deleteCheck);
    }

    public WebElement getDescriptionEditor(){
        return driver.findElement(descriptionEditor);
    }

}
