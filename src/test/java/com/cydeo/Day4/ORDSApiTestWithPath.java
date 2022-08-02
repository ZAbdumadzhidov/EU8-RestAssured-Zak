package com.cydeo.Day4;

import com.cydeo.utilities.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiTestWithPath extends HRTestBase {

      @DisplayName("Get request to countries with Path method")
      @Test
      public void test1(){
          Response response = given().accept(ContentType.JSON).and()
                  .queryParam("q","{\"region_id\":2}").when().get("/countries");

          assertEquals(200,response.statusCode());

          System.out.println("response.path(\"limit\") = " + response.path("limit"));
          System.out.println("response.path(\"hasMore\") = " + response.path("hasMore"));

          //print country_id
          String firstCountryId = response.path("items[0].country_id");
          System.out.println("firstCountryId = " + firstCountryId);

          String secondCountryId = response.path("items[1].country_id");
          System.out.println("secondCountryId = " + secondCountryId);

          //get the website
          String thirdHref = response.path("items[2].links[0].href");
          System.out.println("thirdHref = " + thirdHref);

          List<String> countryNames = response.path("items.country_name");
          System.out.println("countryNames = " + countryNames);

          // assert that all region ids are equal to 2

          List<Integer> allRegionsIDs = response.path("items.region_id");
          for (Integer regionsID : allRegionsIDs) {
              System.out.println("regionsID = " + regionsID);
              assertEquals(2,regionsID);

          }



      }




    }



