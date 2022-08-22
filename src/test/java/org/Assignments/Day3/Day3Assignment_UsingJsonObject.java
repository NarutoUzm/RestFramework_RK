package org.Assignments.Day3;

import io.restassured.http.ContentType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Day3Assignment_UsingJsonObject {

    @Test
    public void verifyFriendAddedSimple_Test(){
        JSONObject friendInfo = new JSONObject();
        friendInfo.put("firstname","Sushant");
        friendInfo.put("lastname","Pulaje");
        friendInfo.put("id","20");
        friendInfo.put("age","30");

        given().
                contentType(ContentType.JSON).
                body(friendInfo.toString()).
        when().
                post("http://localhost:3000/friends").
        then().
                assertThat().
                statusCode(201);
    }


    @Test
    public void verifyFriendAddedComplex_Test(){
        JSONObject addrInfo = new JSONObject();
        addrInfo.put("houseNo","37");
        addrInfo.put("landmark","vaibhav theater");

        JSONObject friendInfo = new JSONObject();
        friendInfo.put("firstname","Prathamesh");
        friendInfo.put("lastname","Gujar");
        friendInfo.put("id","444");
        friendInfo.put("age","30");
        friendInfo.put("address",addrInfo);

        given().log().body().
                contentType(ContentType.JSON).
                body(friendInfo.toString()).
        when().
                post("http://localhost:3000/friends").
        then().
                assertThat().statusCode(201).log().body();
    }


    @Test
    public void verifyFriendAddedComplexJsonArray_Test(){
        JSONArray address = new JSONArray();

        JSONObject addr1 = new JSONObject();
        addr1.put("houseNo","37");
        addr1.put("landmark","pratham theater");

        JSONObject addr2 = new JSONObject();
        addr2.put("houseNo","38");
        addr2.put("landmark","dwitiya theater");

        address.put(0,addr1);
        address.put(1,addr2);

        JSONObject friendInfo = new JSONObject();
        friendInfo.put("firstname","Rock");
        friendInfo.put("lastname","Lee");
        friendInfo.put("id","555");
        friendInfo.put("age","24");
        friendInfo.put("address",address);

        given().log().body().
                contentType(ContentType.JSON).
                body(friendInfo.toString()).
                when().
                post("http://localhost:3000/friends").
                then().
                assertThat().statusCode(201).log().body();
    }
}
