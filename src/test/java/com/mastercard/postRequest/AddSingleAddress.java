package com.mastercard.postRequest;

import static org.hamcrest.Matchers.*;
import com.mastercard.RESTUtilis.GenerateData;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;


import static io.restassured.RestAssured.*;


public class AddSingleAddress {


    public static HashMap map = new HashMap();

    @BeforeClass
    public void postData(){

            map.put("add1", GenerateData.getAdd1());
            map.put("add2", GenerateData.getAdd2());
            map.put("city", GenerateData.getCity());
            map.put("state", GenerateData.getState());
            map.put("zipCode", Integer.parseInt(GenerateData.getZipCode()));
            map.put("country", GenerateData.getCountry("usa"));

        RestAssured.baseURI = "http://localhost:9191";
        RestAssured.basePath = "/addAddress";

    }


    @Test
    public void testPost(){

        given()
                .contentType("application/json")
                .body(map)

        .when()
                .post()

        .then()

            .statusCode(200)
                .log().all();
    }
}
