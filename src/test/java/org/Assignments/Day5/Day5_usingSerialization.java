package org.Assignments.Day5;

import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class Day5_usingSerialization {

    Map<String, Object> map =new HashMap<String, Object>(){
        {
            put("firstName","abc");
            put("lastName","xyz");
            put("id",361);
            put("age",20);
        }
    };

    @Test
    public void test(){
                given().header("Accept","application/json").
                when().body(map).
                post("http://localhost:3000/posts").
                then(). assertThat().statusCode(201);
       // System.out.println(response.toString());
    }
}
