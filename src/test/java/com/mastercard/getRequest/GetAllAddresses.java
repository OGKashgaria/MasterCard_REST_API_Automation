package com.mastercard.getRequest;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

public class GetAllAddresses {

    @Test
    public void getAllAddress(){
       given()
       .when()
               .get("http://localhost:9191/addresses")

       .then()
               .statusCode(200)
               .contentType("application/json")
               .log().all();


    }
}
