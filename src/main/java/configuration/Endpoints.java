package configuration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Endpoints {
    public static final String GET_PROJECTS = "index.php?/api/v2/get_projects";
    public static final String ADD_PROJECT = "index.php?/api/v2/add_project";
    public static final String UPDATE_PROJECT = "index.php?/api/v2/update_project/{project_id}";
    public static final String GET_PROJECT = "index.php?/api/v2/get_project/{project_id}";
    public static final String DElETE_PROJECT = "index.php?/api/v2/delete_project/{project_id}";


    public static final String GET_USERS = "index.php?/api/v2/get_users"; // Не работает

}
