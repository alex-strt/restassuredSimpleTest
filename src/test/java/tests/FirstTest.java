package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void getPetNotFound() {
        String url = "https://petstore.swagger.io/v2/pet/";
        String id = "12354";
        Response getPetResponse =
                RestAssured
                    .given()
                    .when()
                    .get(url + id);

        int statusCode = getPetResponse.statusCode();
        Assert.assertEquals(statusCode, 404);
    }

    @Test
    public void getPetFound() {
        String url = "https://petstore.swagger.io/v2/pet/";
        String id = "123";
        Response getPetResponse =
                RestAssured
                    .given()
                    .when()
                    .get(url + id);

        int statusCode = getPetResponse.statusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
