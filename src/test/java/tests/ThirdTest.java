package tests;

import DTO.Category;
import DTO.PetDTO;
import DTO.TagsDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

public class ThirdTest {

    RequestSpecification httpRequest;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        httpRequest = given();
        httpRequest.header("Content-Type", "application/json");
    }

    @Test
    public void createNewPen() {
        Random random = new Random();
        int id = random.nextInt(1000);
        String name = RandomStringUtils.random(10, true, false);
        Category category = new Category(id, name);
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("ololo");
        List<TagsDTO> tags = new ArrayList<>();
        tags.add(new TagsDTO(id, name));
        String status = "available";

        httpRequest.body(new PetDTO
                (
                        id, category, name, photoUrls, tags, status
                ));

        Response postRequest = httpRequest.post();
        int statusCode = postRequest.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        System.out.println(postRequest.prettyPrint());

    }
}
