package org.Assignments.Day5;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Day5_commentsResponseMapping {
    @Test
    public void test() throws IOException {


        Response resp =  given().log().all().
                when().get("http://localhost:3000/comments").
                andReturn();

        CommentsResponse[] commentsResponse = given().header("Accept","application/json")
                .get("http://localhost:3000/comments")
                .as(CommentsResponse[].class);

        System.out.println(commentsResponse[0].getBody());


    }
}
