package org.Assignments.Day3;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Day3Assignment_UsingDataProvider {

//    @DataProvider(name = "zipCodeandPlaces")
//    public static Object[][] zipCodeandPlaces(){
//        return new Object[][]{
//                {"us","90210","Beverly Hills"},
//                {"us","12345","Schenectady"},
//                {"ca","B2R","Waverley"}
//        };
//    }
//
//    @Test (dataProvider ="zipCodeandPlaces")
//    public void verifyPlaceName_Test(String cc,String zc, String pn)
//    {
//        given().log().body().
//                pathParam("cc",cc).pathParam("zc",zc).
//                when().
//                get("https://zippopotam.us/{cc}/{zc}").
//                then().
//                assertThat().
//                body("places[0].'place name'", equalTo(pn)).
//                log().body();
//    }
     @DataProvider(name = "Posts_pathParamAndResult")
    public static Object[][] Posts_pathParamAndResult(){
        return new Object[][]{
                {"posts","1","Sachin"},
                {"posts","2","Sachin F"},
                {"posts","3","Mahesh"},
                {"posts","4","Anirudha"},
        };
    }
    @Test (dataProvider ="Posts_pathParamAndResult")
    public void verifyAuthorAndPostId_Test(String pathParam1,String pathParam2, String ExpResult)
    {
        given().log().body().
                pathParam("pathParam1",pathParam1).pathParam("pathParam2",pathParam2).
                when().
                get("http://localhost:3000/{pathParam1}/{pathParam2}").
                then().
                assertThat().
                body("author", equalTo(ExpResult)).
                log().body();
    }


    @DataProvider(name = "comments_pathParamAndResult")
    public static Object[][] comments_pathParamAndResult(){
        return new Object[][]{
                {"comments","1","some comment globant 1",1},
                {"comments","2","some comment globant 2",2},
                {"comments","3","some comment globant 3",3},
                {"comments","4","some comment globant 4",4},
        };
    }
    @Test (dataProvider ="comments_pathParamAndResult")
    public void verifyBodyAndPostId_Test(String pathParam1,String pathParam2, String ExpBody, Integer ExpPostId)
    {
        given().log().body().
                pathParam("pathParam1",pathParam1).pathParam("pathParam2",pathParam2).
                when().
                get("http://localhost:3000/{pathParam1}/{pathParam2}").
                then().
                assertThat().
                body("body", equalTo(ExpBody)).
                body("postId",equalTo(ExpPostId)).
                statusCode(200).
                log().body();
    }

}

