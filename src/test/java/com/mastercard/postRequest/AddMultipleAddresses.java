package com.mastercard.postRequest;

import com.mastercard.RESTUtilis.GenerateData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AddMultipleAddresses {
    public static List<HashMap> addressList = new ArrayList<HashMap>();
    public static HashMap map = new HashMap();

    @BeforeClass
    public void postData(){
        for (int i=111; i<120; i++) {
            map.put("info_id", i);
            map.put("add1", GenerateData.getAdd1());
            map.put("add2", GenerateData.getAdd2());
            map.put("city", GenerateData.getCity());
            map.put("state", GenerateData.getState());
            map.put("zipCode", Integer.parseInt(GenerateData.getZipCode()));
            map.put("country", GenerateData.getCountry("canada"));
            addressList.add(map);
        }
        RestAssured.baseURI = "http://localhost:9191";
        RestAssured.basePath = "/addAddress";
    }
    @Test
    public void testPost(){

        for (HashMap each : addressList) {

            Response response =
            given()
                .contentType("application/json")
                .body(each)
            .when()
                .post()
            .then()
                .statusCode(200)
                    .log().all()
                    .extract().response();

        }
    }
}
