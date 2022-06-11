package tests.api;

import configuration.Endpoints;
import io.restassured.response.Response;
import models.Project;
import models.ProjectType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CRUDProjectTest extends BaseApiTest {

    @Test(priority = 1)
    public void addProjectTest() {
        Project project = Project.builder()
                .name("Project_HW")
                .typeOfProject(ProjectType.SINGLE_SUITE_BASELINES)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("suite_mode", project.getTypeOfProject());

        Project newProject = given()
                .body(jsonAsMap)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class);

        System.out.println(newProject.toString());
    }

    @Test(priority = 2)
    public void getProjectTest() {
        given()
                .when()
                .get(Endpoints.GET_PROJECTS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class);

        //System.out.println(project.toString());
    }

    @Test(priority = 3)
    public void updateProjectTest(int project_id) {

    }

    @Test(priority = 4)
    public void deleteProjectTest() {
    }
}
