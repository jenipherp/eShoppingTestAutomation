package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

public class ApiBase {

    protected String baseUrl;

    @BeforeClass
    public void setupApi(){
        baseUrl = "https://jenipher-genii.onrender.com/";
        RestAssured.baseURI = baseUrl;
    }

    protected Response getRequest(String endpoint){
        return RestAssured
                .given()
                .when()
                .get(endpoint)
                .then()
                .extract().response();
    }

    protected Response postRequest(String endpoint, Object body){
        return RestAssured
                .given()
                .header("Content-Type","application/json")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract().response();
    }
}
