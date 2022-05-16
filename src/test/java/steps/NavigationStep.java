package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.ProjectsPage;

public class NavigationStep extends BaseStep {

    public NavigationStep(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage navigateToProjectsPage() {
        projectsPage.openPageByUrl();
        return projectsPage;
    }

    // переход в раздел Milestones
    public ProjectsPage openMilestonesPage() {
        projectsPage.getNavigationTitleMilestones("Milestones").click();
        return projectsPage;
    }


}
