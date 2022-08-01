package com.cydeo.Day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class hrGetRequests {

    //beforeAll is annotation equals @BeforeClass in testng, we ise static method
@BeforeAll
    public static void init(){

    RestAssured.baseURI ="http://54.196.212.186:1000/ords/hr";

}
@DisplayName("Get request to /regions")
@Test
    public void test1(){
    Response response = RestAssured.get("/regions");
    System.out.println(response.statusCode());
}

     /*
        Given accept type is application/json
        When user sends get request to /regions/2
        Then response status code must be 200
        and content type equals to application/json
        and response body contains Americas
     */

}
