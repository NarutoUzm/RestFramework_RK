package org.Assignments.Day1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import io.restassured.http.ContentType;
import org.junit.Test;

public class Day1Assignment
{
    @Test
    public void verifyPosts()
    {
        given().
                when().get("http://localhost:3000/posts").
                then().
                   assertThat().
                   contentType(ContentType.JSON);
    }


    @Test
    public void verifyBodyContentFriends()
    {
        given().log().all().
                when().get("http://localhost:3000/friends").
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200).
                body("firstname[1]", equalTo("Anirudha")).
                log().body();
    }

    @Test
    public void verifyBodyContentZippopotam()
    {
        given().log().all().
                when().get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200).
                body("places[0].'longitude'", equalTo("-118.4065")).
                log().body();
    }

    @Test
    public void negativeCaseVerifyComments()
    {
        given().log().all().
                when().get("http://localhost:3000/comments").
                then().
                assertThat().
                contentType(ContentType.XML).
                log().body();
    }

}
