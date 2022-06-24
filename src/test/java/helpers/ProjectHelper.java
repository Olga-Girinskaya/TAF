package helpers;

import configuration.Endpoints;
import io.restassured.response.Response;
import models.Project;
import models.ProjectType;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<Project> getAllProjects() {
        Response response = given()
                .get(Endpoints.GET_PROJECTS);

        return response.getBody().jsonPath().getList("projects", Project.class);
    }

    public Project addProject(Map<String, Object> jsonAsMap){
        return given()
                .body(jsonAsMap)
                .post(Endpoints.ADD_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class);
    }

    public void deleteProject(int projectId) {
        given()
                .pathParam("project_id", projectId)
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
