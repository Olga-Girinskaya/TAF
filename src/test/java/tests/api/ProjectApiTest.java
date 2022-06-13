package tests.api;

import helpers.ProjectHelper;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectApiTest extends BaseApiTest{
    ProjectHelper projectHelper;

    @Test
    public void positiveTest(){
        Project expectedProject = Project.builder()
                .typeOfProject(1)
                .name("WP Test")
                .announcement("Test An")
                .build();

        Project actualProject = projectHelper.getProject(1);
        Assert.assertTrue(actualProject.equals(expectedProject));
    }

    @Test
    public void negativeInvalidProjectTest(){
       Assert.assertEquals(projectHelper.getProjectResponse(500).getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    }

}
