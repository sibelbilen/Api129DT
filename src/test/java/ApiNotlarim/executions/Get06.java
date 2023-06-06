package ApiNotlarim.executions;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

/*
 Given
     https://restful-booker.herokuapp.com/booking/23
 When
     User send a GET request to the URL
 Then
     HTTP Status Code should be 200
 And
     Response content type is "application/json"
 And
     Response body should be like;
          {
             "firstname": "Josh",
             "lastname": "Allen",
             "totalprice": 111,
             "depositpaid": true,
             "bookingdates": {
                 "checkin": "2018-01-01",
                 "checkout": "2019-01-01"
             },
             "additionalneeds": "midnight snack"
          }
*/
public class Get06  extends HerOkuAppBaseUrl {

    @Test
    public void get06() {
     spec.pathParams("first","booking","second",23);

     Response response=given(spec).get("{first}/{second}");
     response.prettyPrint();
        //Do assertion
        //1. Yol
        response.then().body("firstname",equalTo("John")).
                body("lastname",equalTo("Smith")).
                body("totalprice",equalTo(111))
                .body("depositpaid",equalTo(true)).
                body( "bookingdates.checkin", equalTo("2018-01-01"),
                        "bookingdates.checkout", equalTo("2019-01-01"),
                        "additionalneeds", equalTo("Breakfast"));


        //   //2. Yol: Json Path

        JsonPath jsonPath=response.jsonPath();
        //jsonPath() methodu ile response'i jsonPath objesine cevirdik

        //jsonPath pbjesi ile dataya spesifik olarak ulasabiliriz.
      assertEquals("John",jsonPath.getString("firstname"));
      assertEquals("Smith",jsonPath.getString("lastname"));
      assertEquals(111,jsonPath.getInt("totalprice"));
      assertEquals(true,jsonPath.getBoolean("depositpaid"));
      assertEquals("2018-01-01",jsonPath.getString("bookingdates.checkin"));
      assertEquals("2019-01-01",jsonPath.getString("bookingdates.checkout"));
        assertEquals("Breakfast", jsonPath.getString("additionalneeds"));

    }
}
