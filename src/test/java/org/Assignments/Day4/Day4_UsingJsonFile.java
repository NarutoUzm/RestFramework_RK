package org.Assignments.Day4;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Day4_UsingJsonFile {

    private static RequestSpecification reqSpec;
    private static ResponseSpecification responseSpec;


    @BeforeClass
    public static void createRequestSpecification() {
        File file = new File("lib/postsSimple.json");

        reqSpec = new RequestSpecBuilder().
                setBaseUri("http://localhost:3000/posts").
                setBody(file).
                build();
        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(201).
                expectContentType(ContentType.JSON).
                build();
    }
    @Test
    public void verifyPostsAddedSimpleJsonFile_Test() {

        given().
                spec(reqSpec).
                when().
                post().
                then().
                spec(responseSpec);
    }

}