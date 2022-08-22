package org.Assignments.Day3;


import org.testng.annotations.Test;
import utilities.ExcelUtility;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Day3Assignment_UsingExcelFile {


    @Test(dataProvider = "getApiEndPointData",dataProviderClass = ExcelUtility.class)
    public void verifyExcelDataProvider_BookTest
            (String methodeName,
             String serviceEndpoint,
             Map<String,String> headerMap,
             Map<String,String> queryParamMap,
             Map<String,Object> pathParamMap,
             int statusCode,String responseMessage){

         given().log().body().
                 pathParams(pathParamMap).
                 when().
                 get(serviceEndpoint).
                 then().
                 assertThat().
                 statusCode(statusCode).
                 body("places[0].'place name'", equalTo(responseMessage)).
                 log().body();
    }

   @Test(dataProvider = "getApiEndPointData",dataProviderClass = ExcelUtility.class)
   public void verifyExcelDataProvider_PostsTest(String methodeName,
                                      String serviceEndpoint,
                                      Map<String,String> headerMap,
                                      Map<String,String> queryParamMap,
                                      Map<String,Object> pathParamMap,
                                      int statusCode,String responseMessage){
         given().log().body().
                 pathParams(pathParamMap).
                 when().
                 get(serviceEndpoint).
                 then().
                 assertThat().
                 statusCode(statusCode).
                 body("author",equalTo(responseMessage)).
                 log().body();
   }


    @Test(dataProvider = "getApiEndPointData",dataProviderClass = ExcelUtility.class)
    public void verifyExcelDataProvider_CommentsTest(String methodeName,
                                                  String serviceEndpoint,
                                                  Map<String,String> headerMap,
                                                  Map<String,String> queryParamMap,
                                                  Map<String,Object> pathParamMap,
                                                  int statusCode,String responseMessage){
        given().log().body().
                pathParams(pathParamMap).
                when().
                get(serviceEndpoint).
                then().
                assertThat().
                statusCode(statusCode).
                body("body",equalTo(responseMessage)).
                log().body();
    }

}

