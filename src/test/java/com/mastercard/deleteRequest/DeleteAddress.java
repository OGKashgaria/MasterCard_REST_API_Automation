package com.mastercard.deleteRequest;

import com.mastercard.RESTUtilis.GenerateData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteAddress {
    @Test
    public void getAllAddress(){

        RestAssured.baseURI = "http://localhost:9191";
//        RestAssured.basePath = "/deleteAddress/" + Integer.parseInt(GenerateData.info_id());
//        System.out.println( "Randomly Generated info_id: "+(1 + Integer.parseInt(GenerateData.info_id()))) ;

        RestAssured.basePath = "/deleteAddress/" + 2;


        Response response =
        given()
                .when()
                .delete()

                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        String jsonAsString = response.asString();
        Assert.assertEquals(jsonAsString.contains("You are good! Successfully deleted address on info_if: "), true);


    }
}
