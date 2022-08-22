package org.Assignments.Day5;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Day5_friendsResponseMapping {
    @Test
    public void test() throws IOException {

        Response resp =  given().log().all().
                when().get("http://localhost:3000/friends").
                andReturn();

        FriendsResponse[] friendsResponse = given().header("Accept","application/json")
                .get("http://localhost:3000/friends")
                .as(FriendsResponse[].class);

       // System.out.println(friendsResponse[0].getFirstname());

    }
}
