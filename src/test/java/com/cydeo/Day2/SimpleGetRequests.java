package com.cydeo.Day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleGetRequests {

    String url = "http://54.196.212.186:8000";

    /*
    Given accept type application/json
    when user send get request to api/spartans end point
    Then status code must be 200
    then response content type must be application/json
    and response body should include spartan result

    */


    @Test
    public void test1() {
        Response response = RestAssured.given().accept(ContentType.JSON)

                .when()
                .get(url + "/api/spartans/");
        //print status code
        System.out.println(response.statusCode());

        //print response content type from response object
        System.out.println(response.contentType());

        //print whole result body
        response.prettyPrint();

        //verify status code is 200
        Assertions.assertEquals(response.statusCode(), 200);

        Assertions.assertEquals(response.contentType(), "application/json");

    }

    /*
    Given accept is application/json
    When user sends a get request to /api/spartans/3
    Then status code should be 200
    And content type should be application/json
    and json body should contain Fidole

  */

    @DisplayName("get one spartan /api/spartan/3 and verify")
    @Test
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON).when().get(url+"/api/spartans/3");

        //verify status code
        Assertions.assertEquals(200,response.statusCode());

        //verify content type
        Assertions.assertEquals("application/json", response.contentType());

        //verify body
        Assertions.assertTrue(response.body().asString().contains("Fidole"));


    }
    /*
        Given no headers provided
        When Users sends GET request to /api/hello
        Then response status code should be 200
        And Content type header should be ???text/plain;charset=UTF-8???
        And header should contain date
        And Content-Length should be 17
        And body should be ???Hello from Sparta"
        */

    @DisplayName("GET request to /api/hello")
    @Test
    private void test3(){
        //send request and save response inside the response object
        Response response = RestAssured.when().get(url + "/api/hello");

        //verify status code 200
        Assertions.assertEquals(200,response.statusCode());

        //verify content type
        Assertions.assertEquals("text/plain;charset=UTF-8",response.contentType());

        //verify we have headers named date
        //we use hasHeaderWithName method to verify header exist or not - it returns boolean
        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));
        //how to get and header from response using header key ?
        //we use response.header(String headerName) method to get any header value
        System.out.println("response.header(\"Content-Length\") = " + response.header("Content-Length"));
        System.out.println(response.header("Date"));

        //verify content length is 17
        Assertions.assertEquals("17",response.header("Content-Length"));
        //verify body is "Hello from Sparta"
        Assertions.assertEquals("Hello from Sparta",response.body().asString());
    }


}






