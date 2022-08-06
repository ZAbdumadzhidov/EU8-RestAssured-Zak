package com.cydeo.Day5;


import com.cydeo.utilities.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ORDSHamcrestTest extends HRTestBase {

    @DisplayName("Get request to Employees IT_PROG endpoint and chaining")
    @Test
    public void employeeTest(){
        given().accept(ContentType.JSON)
                .and()
                .queryParam("q","{id\"job_id\":\"IT_PROG\"}")
                .when()
                .get("/employees")
                .then()
                .statusCode(200)
                .body("items.job_id", everyItem(equalTo("IT_PROG")));
             // .body("items.first_name", containsInRelativeOrder("Alexander","Bruce","David"));

    }
}
