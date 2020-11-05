package com.mastercard.putRequest;

import com.mastercard.RESTUtilis.GenerateData;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class UpdateSingleAddress {

    public static HashMap map = new HashMap();

    @BeforeClass
    public void postData(){
        map.put("info_id", Integer.parseInt(GenerateData.info_id()));
        map.put("add1", GenerateData.getAdd1());
        map.put("add2", GenerateData.getAdd2());
        map.put("city", GenerateData.getCity());
        map.put("state", GenerateData.getState());
        map.put("zipCode", Integer.parseInt(GenerateData.getZipCode()));
        map.put("country", GenerateData.getCountry("canada"));

        RestAssured.baseURI = "http://localhost:9191";
        RestAssured.basePath = "/updateAddress";
        System.out.println( "Randomly Generated info_id: "+ Integer.parseInt(GenerateData.info_id()));
    }


    @Test
    public void testPut(){

        given()
                .contentType("application/json")
                .body(map)

        .when()
                .put()

        .then()

                .statusCode(200)
        .log().all();
    }
}
