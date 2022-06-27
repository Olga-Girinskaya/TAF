package tests.api;

import configuration.Endpoints;
import models.Project;
import models.ProjectType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProjectApiTest extends BaseApiTest {

    private int projectID=2;

    @Test
    public void addProjectTest() {
        Project project = Project.builder()
                .name("Project_HW")
                .typeOfProject(ProjectType.SINGLE_SUITE_BASELINES)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("suite_mode", project.getTypeOfProject());

        given()
                .body(jsonAsMap)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class);
    }

    @Test (dependsOnMethods = "addProjectTest")
    public void getProjectTest() {
        given()
                .when()
                .pathParams("project_id",projectID)
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class);
    }

    @Test (dependsOnMethods = "getProjectTest")
    public void updateProjectTest() {
        Project project = Project.builder()
                .announcement("hfjgvjkghjjjjj")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("announcement", project.getAnnouncement());

         given()
                .body(jsonAsMap)
                .when()
                .pathParams("project_id",projectID)
                .post(Endpoints.UPDATE_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class);

    }

    @Test (dependsOnMethods = "updateProjectTest")
    public void deleteProjectTest() {
        given()
                .when()
                .pathParams("project_id",projectID)
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
}
