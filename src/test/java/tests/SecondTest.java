package tests;

import DTO.PetDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SecondTest {
    RequestSpecification httpRequest;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet/1";
        httpRequest = given();
        httpRequest.header("Content-Type", "application/json");
    }


    @Test(invocationCount = 1000, threadPoolSize = 30, invocationTimeOut = 500)
    public void getPetFound() {
        Response getPetResponse = httpRequest
                .get();
        PetDTO model = getPetResponse.as(PetDTO.class);
        Assert.assertEquals(model.getId(), 1);
//        Assert.assertEquals(model.getName(), "Tica");
        System.out.println(getPetResponse.getCookies());
        System.out.println(getPetResponse.getHeaders());

        given()
                .headers(getPetResponse.getHeaders())
                .cookies(getPetResponse.getCookies());
    }
}
