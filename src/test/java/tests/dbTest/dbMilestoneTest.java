package tests.dbTest;

import configuration.Endpoints;
import models.Milestone;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class dbMilestoneTest extends BaseDBMilestonesTest {

    @Test
    public void firstTest() {
        logger.info("Test is started...");
        ResultSet rs = milestonesTable.getMilestones();

        try {
            while (rs.next()) {
                String milestoneId = rs.getString("ID");
                int projectId = rs.getInt("projectId");
                String name = rs.getString("name");
                String description = rs.getString("description");

                logger.info("id: " + milestoneId);
                logger.info("projectId: " + projectId);
                logger.info("name: " + name);
                logger.info("description: " + description);

                Map<String, Object> jsonAsMap = new HashMap<>();
                jsonAsMap.put("project_id", projectId);
                jsonAsMap.put("name", name);
                jsonAsMap.put("description", description);
                logger.info("Body запроса на создание Milestone получен");

                Milestone milestone = given()
                        .pathParam("project_id", projectId)
                        .body(jsonAsMap)
                        .when()
                        .post(Endpoints.ADD_MILESTONE)
                        .then()
                        .statusCode(HttpStatus.SC_OK)
                        .extract().as(Milestone.class);
                logger.info("Milestone создан");

                Assert.assertEquals(milestone.getProjectId(), jsonAsMap.get("project_id"));
                Assert.assertEquals(milestone.getName(), jsonAsMap.get("name"));
                Assert.assertEquals(milestone.getDescription(), jsonAsMap.get("description"));

            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }

        logger.info("Test is completed...");
    }
}
