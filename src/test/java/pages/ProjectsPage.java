package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {
    private final static String pagePath = "/index.php?/projects/overview/8";

    public SideMenuPage sideMenuPage;

    private final By headerTitleLabelLocator = By.cssSelector("#navigation-projects");
    private final String tabLocator = "//li/a[.='Replace']";


    public ProjectsPage(WebDriver driver) {
        super(driver);

        sideMenuPage = new SideMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getNavigationTitleMilestones(String tabName) {
        return driver.findElement(By.xpath(tabLocator.replace("Replace", tabName)));
    }

}
