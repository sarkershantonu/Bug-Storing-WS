package org.automation.bug.ws.e2e;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class IntegrationTests {

    @BeforeAll
    public static void initTest(){}
    private static void configRestAssured(){
        RestAssured.baseURI="http://localhost:9100";

    }
}
