package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideMenuPage extends BasePage {
    private By sidebarLocator = By.id("sidebar");
    public By addMilestonesButtonLocator = By.xpath("//*[@id='navigation-milestones-add']");

    public SideMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return sidebarLocator;
    }

    public WebElement getAddMilestonesButtonLocator() {
        return waitsService.waitForExists(addMilestonesButtonLocator);
    }
}
