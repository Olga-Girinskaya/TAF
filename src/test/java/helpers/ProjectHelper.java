package helpers;

import configuration.Endpoints;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class ProjectHelper {

    //получим объект
    public Project getProject(int project_id) {
        return given()
                .pathParam("project_id", project_id)
                .get(Endpoints.GET_PROJECT)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class);
    }

    //получим респонс
    public Response getProjectResponse(int project_id) {
        return given()
                .pathParam("project_id", project_id)
                .get(Endpoints.GET_PROJECT);
    }
}
