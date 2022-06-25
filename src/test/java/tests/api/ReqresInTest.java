package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqresInTest {

    @Test
    public void simpleStepBySteepApiTest(){
        // Setup RestAssured
        RestAssured.baseURI = "https://reqres.in";

        // Setup endpoint
        int userID = 2;
        String endpoint = "/api/users/" + userID;

        // Setup request Object
        RequestSpecification httpRequest = given(); // соединяет бзовый урл и эндпоинт

        // Setup Response Object
        Response response = httpRequest.request(Method.GET, endpoint);

        // Get Response Status
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);

        // Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println("Response: " + responseBody);
    }

    @Test
    public void simpleShotTest(){
        // Setup RestAssured
        RestAssured.baseURI = "https://reqres.in";

        // Setup endpoint
        int userID = 2;
        String endpoint = "/api/users/" + userID;

        given()
                .when()  // когда мы получаем
                .get(endpoint) // респонт
                .then() // то
                .statusCode(HttpStatus.SC_OK) // проверяем статус код
                .log().body(); // выводим в лог
    }


}
