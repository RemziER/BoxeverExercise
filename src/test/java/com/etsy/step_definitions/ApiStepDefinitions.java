package com.etsy.step_definitions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class ApiStepDefinitions {

    String id;
    String accessToken = "Bearer a9434f6e732870ddba4fe8ed9c8811d71238db45";

    @BeforeClass
    public void before(){
        baseURI = "https://api.github.com";
    }

    @Test(priority = 1)
    public void POSTGist() {

        String jsonBody = "{\n" +
                "    \"description\":\"Boxever Project Exercise\",\n" +
                "    \"files\":{\n" +
                "        \"boxever.txt\":{\n" +
                "            \"filename\": \"boxever.txt\",\n" +
                "            \"content\": \"This gist file has been created for the purpose of Boxever project\"}\n" +
                "            },\n" +
                "    \"public\": true\n" +
                "}";

        Response response = given()
                .header("Accept", "application/vnd.github.v3+json")
                .header("Authorization", accessToken)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(jsonBody)
                .when()
                .post("/gists");

        id = response.path("id");
        System.out.println(id);

        assertEquals(response.statusCode(), 201);
    }
        @Test(priority = 2)
        public void GETGist() {
            Response response = given().accept(ContentType.JSON).
                    and().pathParam("id", id).
                    when().get("gists/{id}");

            assertEquals(response.statusCode(), 200);
            response.prettyPrint();
        }

        @Test(priority = 3)
        public void DELETEGist() {
            Response response = given()
                    .header("Accept", "application/vnd.github.v3+json")
                    .header("Authorization", accessToken)
                    .pathParam("id", id)
                    .delete("/gists/{id}");

            assertEquals(response.statusCode(), 204);

       }

}
