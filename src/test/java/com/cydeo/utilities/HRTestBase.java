package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class HRTestBase {
    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://54.196.212.186:1000/ords/hr";
    }

}
