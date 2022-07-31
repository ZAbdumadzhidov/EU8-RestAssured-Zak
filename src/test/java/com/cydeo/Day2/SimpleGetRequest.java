package com.cydeo.Day2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class SimpleGetRequest {

    String url = "http://54.196.212.186:8000/api/spartans";

    @Test
    public void test1(){

        //send a get request and save response inside the Request object
        Response response = RestAssured.get(url);

        //print response status code
        System.out.println(response.statusCode());

        // print response body
        response.prettyPrint();

    }



}