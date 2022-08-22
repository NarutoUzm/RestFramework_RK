package org.Assignments.Day4;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class Day4Assignment {

   private static RequestSpecification reqSpec ;
   private static ResponseSpecification responseSpec ;


   @BeforeClass
    public static void createRequestSpecification(){
       reqSpec = new RequestSpecBuilder().
               setBaseUri("http://api.zippopotam.us").
               build();

       responseSpec = new ResponseSpecBuilder().
               expectStatusCode(200).
               expectContentType(ContentType.JSON).
               expectBody("places[0].'place name'",equalTo("Beverly Hills")).
               build();
   }
   @Test
    public void verifySuccessForZipCode(){
       given().
               spec(reqSpec).
       when().
               get("/us/90210").
       then().
              spec(responseSpec).
              and().assertThat().
               statusCode(200).
               body("places[0].'place name'",equalTo("Beverly Hills")).log().body();
   }


}
