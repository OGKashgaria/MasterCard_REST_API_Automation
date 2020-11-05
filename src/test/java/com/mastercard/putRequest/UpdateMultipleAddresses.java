package com.mastercard.putRequest;

import com.mastercard.RESTUtilis.GenerateData;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UpdateMultipleAddresses {
    public static List<HashMap> addressList = new ArrayList<>();
    public static HashMap map = new HashMap();

    @BeforeClass
    public void postData(){
        int i=1;
        while(i<=10) {
            map.put("info_id", i++);
            map.put("add1", GenerateData.getAdd1());
            map.put("add2", GenerateData.getAdd2());
            map.put("city", GenerateData.getCity());
            map.put("state", GenerateData.getState());
            map.put("zipCode", Integer.parseInt(GenerateData.getZipCode()));
            map.put("country", GenerateData.getCountry("usa"));
            addressList.add(map);

        }
        RestAssured.baseURI = "http://localhost:9191";
        RestAssured.basePath = "/updateAddress";
    }
    @Test
    public void testPost(){

        for (HashMap each : addressList) {
            given()
                    .contentType("application/json")
                    .body(each)
                    .when()
                    .put()
                    .then()
                    .statusCode(200)
                    .log().all();
            ;
        }
    }
}
