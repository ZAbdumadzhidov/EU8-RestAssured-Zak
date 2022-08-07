package com.cydeo.Day5;

import com.cydeo.utilities.DBUtils;
import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SpartanAPiVsDB extends SpartanTestBase {
    @DisplayName("GET one spartan from api and database")
            @Test
            public void testDB() {



        String query = "select * FROM spartans\n" +
                "where spartan_id = 101";
        Map<String, Object> dbMap = DBUtils.getRowMap(query);
        System.out.println(dbMap);

        Response response =given().accept(ContentType.JSON).pathParam("id",101)
                .when()
                .get("api/spartans/{id}")
                .then()
                .statusCode(200)
                .and().contentType("application/json")
                .extract().response();

       Map<String,Object> apiMap = response.as(Map.class);

       assertThat(apiMap.get("id"), is(dbMap.get("SPARTAN_ID")));
       assertThat(apiMap.get("name"), is(dbMap.get("NAME")));
       assertThat(apiMap.get("gender"),is(dbMap.get("GENDER")));
       assertThat(apiMap.get("phone").toString(),is(dbMap.get("PHONE")));



    }

}
