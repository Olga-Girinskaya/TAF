package tests.api;

import configuration.Endpoints;
import helpers.MilestoneHelper;
import models.Milestone;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MilestoneApiTest extends BaseApiTest {

    public MilestoneHelper milestoneHelper;
    public Milestone milestone;

    @Test
    public void addMilestoneTest() {
        milestoneHelper = new MilestoneHelper();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", "Milestone_1");
        jsonAsMap.put("description", "Description...");
        milestone = milestoneHelper.addMilestone(jsonAsMap);

        Assert.assertEquals(milestone.getName(), jsonAsMap.get("name"));
        Assert.assertEquals(milestone.getDescription(), jsonAsMap.get("description"));
    }

    @Test(dependsOnMethods = "addMilestoneTest")
    public void updateMilestoneTest() {
        milestoneHelper = new MilestoneHelper();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", "Milestone_5");
        jsonAsMap.put("description", "Test description...");

        given()
                .body(jsonAsMap)
                .when()
                .pathParams("milestone_id", milestone.getId())
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Milestone.class);
    }

    @Test(dependsOnMethods = "updateMilestoneTest")
    public void getMilestoneTest() {
        milestoneHelper = new MilestoneHelper();

        given()
                .when()
                .pathParams("milestone_id", milestone.getId())
                .get(Endpoints.GET_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "getMilestoneTest")
    public void deleteMilestoneTest() {
        milestoneHelper = new MilestoneHelper();

        given()
                .when()
                .pathParams("milestone_id", milestone.getId())
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test(dependsOnMethods = "deleteMilestoneTest")
    public void getMilestonesTest() {
        milestoneHelper.getMilestones();
    }
}
