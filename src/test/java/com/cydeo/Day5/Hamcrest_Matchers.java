package com.cydeo.Day5;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;;
import org.hamcrest.Matcher.*;

import java.util.Arrays;
import java.util.List;

import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class Hamcrest_Matchers {

    @Test
    public void simpleTest1() {
        assertThat(5 + 5, is(10));
        assertThat(5 + 5, equalTo(10));
        //or
        assertThat(5 + 5, is(equalTo(10)));

        assertThat(5 + 5, not(9));
        assertThat(5 + 5, is(not(9)));
        assertThat(5 + 5, is(not(equalTo(10))));

        assertThat(5 + 5, is(greaterThan(9)));

    }
    @Test
    public void stringHamcrest(){

        String text = "B22 is learning Hamcrest";

        //checking for equality is same as numbers
        assertThat(text,is("B22 is learning Hamcrest"));
        assertThat(text, equalTo("B22 os learning Hamcrest"));
        assertThat(text, is(equalTo("B22 is learning Hamcrest")));

        //check if this text starts with B22
        assertThat(text,startsWith("B22"));
        //assert with equalsIgnoreCase manner
        assertThat(text, startsWithIgnoringCase("b22"));
        //endsWith
        assertThat(text,endsWith("rest"));

        // check if text contains String learning
        assertThat(text, containsString("learning"));
        assertThat(text,containsStringIgnoringCase("LEARNING"));

        String str = "   ";
        assertThat(str, blankString());
        assertThat(str.trim(), emptyString());

    }

    @DisplayName("Hamcrest for Collection")
    @Test
    public void testCollection(){
        List <Integer>listOfNumbers = Arrays.asList(1,2,3,4,5,6,7,8,88,9,86,44,33);
        // check the size
        //assertThat(listOfNumbers, hasSize(15));
        // check if item has 86
        assertThat(listOfNumbers,hasItem(88));

        //check if item has 77,54, 23
        assertThat(listOfNumbers, hasItems(1,2,3));

        // check if all nums greater than 0
        assertThat(listOfNumbers, everyItem(greaterThan(0)));


    }

}
