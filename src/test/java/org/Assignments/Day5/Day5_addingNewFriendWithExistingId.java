package org.Assignments.Day5;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Day5_addingNewFriendWithExistingId {
    @Test
    public void postFriendObject(){
        Friend friend = Friend.builder().
                firstname("abc").
                lastname("xyz").
                id(2).
                age(25).build();

        Response resp = given().header("Content-Type","application/json ").
                body(friend).
                post("http://localhost:3000/friends").andReturn();

        System.out.println(resp.asPrettyString());
        Assert.assertEquals(resp.statusCode(),201);
}}
