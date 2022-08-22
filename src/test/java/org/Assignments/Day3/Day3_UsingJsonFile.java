package org.Assignments.Day3;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Day3_UsingJsonFile {

    @Test
    public void verifyPostsAddedSimpleJsonFile_Test() {
        File file = new File("lib/postsSimple.json");

        given().
                contentType(ContentType.JSON).
                body(file).
                when().
                post("http://localhost:3000/posts").
                then().
                assertThat().
                statusCode(201);
    }

    @Test
    public void verifyAddedResourceForSimple(){
        given().log().body().
                when().
                get("http://localhost:3000/posts").
                then().
                assertThat().
                body("[1].title[0]",equalTo("Kimayagar")).
                statusCode(200).
                log().body();
    }


    @Test
    public void verifyPostsAddedMediumJsonFile_Test() {
        File file = new File("lib/postsMedium.json");

        given().
                contentType(ContentType.JSON).
                body(file).
                when().
                post("http://localhost:3000/posts").
                then().
                assertThat().
                statusCode(201);
    }

    @Test
    public void verifyAddedResourceForMedium(){
        given().log().body().
                when().
                get("http://localhost:3000/posts").
                then().
                assertThat().
                body("[5].firstname",equalTo("Albert")).
                body("[5].theories.'theory name1'",equalTo("special relativity")).
                statusCode(200).
                log().body();
    }

    @Test
    public void verifyPostsAddedComplexJsonFile_Test() {
        File file = new File("lib/friendsComplex.json");

        given().
                contentType(ContentType.JSON).
                body(file).
                when().
                post("http://localhost:3000/friends").
                then().
                assertThat().
                statusCode(201);
    }

    @Test
    public void verifyAddedResourceForComplex(){
        given().log().body().
                when().
                get("http://localhost:3000/friends").
                then().
                assertThat().
                body("[5].firstname",equalTo("Smita")).
                body("[5].address[0].streetName",equalTo("satara road")).
                statusCode(200).
                log().body();
    }
}
