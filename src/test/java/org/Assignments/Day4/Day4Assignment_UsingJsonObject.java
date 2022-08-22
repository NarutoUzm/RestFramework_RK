package org.Assignments.Day4;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Day4Assignment_UsingJsonObject {

    private static RequestSpecification reqSpec ;
    private static ResponseSpecification responseSpec ;

    @BeforeClass
    public static void createRequestSpecification(){
        JSONObject friendInfo = new JSONObject();
        friendInfo.put("firstname","Kakashi");
        friendInfo.put("lastname","Hatake");
        friendInfo.put("id","26");
        friendInfo.put("age","31");

        reqSpec = new RequestSpecBuilder().
                setBaseUri("http://localhost:3000").
                setContentType(ContentType.JSON).
                setBody(friendInfo.toString()).
                build();

        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(201).
                expectContentType(ContentType.JSON).
                build();
    }

    @Test
    public void verifyFriendAddedSimple_Test(){
        given().
                spec(reqSpec).
        when().
                post("/friends").
        then().
                spec(responseSpec);
    }
}
