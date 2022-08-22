package org.Assignments.Day2;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Day2Assignment {

    // first question
//    @Test
//    public void verifyStatusCodeBookerherokuapp(){
//        given().log().all().
//                when().get("https://restful-booker.herokuapp.com/booking").
//                then().
//                assertThat().statusCode(200).
//                log().body();
//    }
//
//    @Test
//    public void printBookingId(){
//                Response response = given().log().body().
//                when().
//                        get("https://restful-booker.herokuapp.com/booking");
//                JsonPath jsonpath = response.jsonPath();
//                List<Integer> allBookingId = jsonpath.getList("bookingid");
//
//                for(Integer bookingid:allBookingId){
//                    System.out.println(bookingid);
//                }
//    }
//
//    @Test
//    public void verifyBookingId(){
//        given().log().body().
//                when().
//                get("https://restful-booker.herokuapp.com/booking").
//                then().
//                assertThat().
//                body("bookingid[0]",equalTo(18)).
//                body("bookingid[1]",equalTo(2)).
//                body("bookingid[2]",equalTo(7)).
//                body("bookingid[3]",equalTo(11)).log().body();
//    }


    // 2nd question

    @Test
    public void verifyStatusCodeForSpecificBookingID(){
             given().log().body()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("booking")
                .pathParam("id", 3)
                .when()
                .get("/{id}").
                        then().
                        assertThat().statusCode(200).
                        log().body();
    }



    @Test
    public void getAllItemsUsingJsonPath() {
        Response response = given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("booking")
                .pathParam("id", 3)
                .when()
                .get("/{id}");

        JsonPath jsonpath = response.jsonPath();
        String firstname = jsonpath.getString("firstname");
        System.out.println(firstname);

        String lastname = jsonpath.getString("lastname");
        System.out.println(lastname);

        String totalprice = jsonpath.getString("totalprice");
        System.out.println(totalprice);

    }
    @Test
    public void VerifyVaulesFromRespose() {
        given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("booking")
                .pathParam("id", 3)
                .when()
                .get("/{id}")
                .then()
                .assertThat()
                .body("firstname",equalTo("Mary"))
                .body("lastname",equalTo("Ericsson"))
                .body("totalprice",equalTo(770)) .log().body();

    }


}