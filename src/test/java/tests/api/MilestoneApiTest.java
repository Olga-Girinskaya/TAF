package tests.api;

import configuration.Endpoints;
import models.Milestone;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MilestoneApiTest extends BaseApiTest {

    private int milestoneID = 169;
    private int projectID = 80;

    @Test
    public void addMilestoneTest() {
        Milestone milestone = Milestone.builder()
                .name("Milestone_1")
                .description("Description...")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", milestone.getName());
        jsonAsMap.put("description", milestone.getDescription());

        given()
                .body(jsonAsMap)
                .when()
                .pathParams("project_id", projectID)
                .post(Endpoints.ADD_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Milestone.class);

    }

    @Test(dependsOnMethods = "addMilestoneTest")
    public void updateMilestoneTest() {
        Milestone milestone = Milestone.builder()
                .name("Milestone_5")
                .description("Test description...")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", milestone.getName());
        jsonAsMap.put("description", milestone.getDescription());

        given()
                .body(jsonAsMap)
                .when()
                .pathParams("milestone_id", milestoneID)
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Milestone.class);
    }

    @Test(dependsOnMethods = "updateMilestoneTest")
    public void getMilestoneTest() {
        given()
                .when()
                .pathParams("milestone_id", milestoneID)
                .get(Endpoints.GET_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }


    @Test(dependsOnMethods = "getMilestoneTest")
    public void deleteMilestoneTest() {
        given()
                .when()
                .pathParams("milestone_id", milestoneID)
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test(dependsOnMethods = "deleteMilestoneTest")
    public void getMilestonesTest() {
        given()
                .when()
                .pathParams("project_id", projectID)
                .get(Endpoints.GET_MILESTONES)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
