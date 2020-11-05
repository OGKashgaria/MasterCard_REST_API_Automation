package com.mastercard.getRequest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class getSingleAddress {

    @Test
    public void getAllAddress(){
        given()
                .when()
                .get("http://localhost:9191/addressById/1")

                .then()
                .statusCode(200)
                .contentType("application/json")
                .assertThat().body("city", equalTo("Brentwood"))
                .log().all();


    }
}
