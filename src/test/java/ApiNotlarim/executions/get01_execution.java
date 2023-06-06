package ApiNotlarim.executions;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;


public class get01_execution {
      /*
   Given
       https://restful-booker.herokuapp.com/booking/55
   When
       User sends a GET Request to the url
   Then
       HTTP Status Code should be 200
   And
       Content Type should be "application/json"
   And
       Status Line should be HTTP/1.1 200 OK
*/

    @Test
    public void get01() {
        //set the url
        String url="https://restful-booker.herokuapp.com/booking/55";


        //set the expected data =bu kisim post ve put gibi body gerektiren ileriki testlerle yapilacak
        //send the request and get the response
        Response response=given().get(url);
        response.prettyPrint();


        //do assertion

        response.then().//then methodu ile response'i dogrula
        statusCode(200).contentType("application/json").
                statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void name02() {
          /*
   Given
       https://restful-booker.herokuapp.com/booking/0
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Response body contains "Not Found"
   And
       Response body does not contain "TechProEd"
   And
       Server is "Cowboy"
*/


        String url="https://restful-booker.herokuapp.com/booking/0";

        Response response= given().get(url);
        response.prettyPrint();

        //Do assertion
        response.then().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
        assertTrue(response.asString().contains("Not Found"));
        assertFalse(response.asString().contains("TechProEd"));

        String server=response.header("Server");
        assertEquals("Cowboy",server);
    }

    @Test
    public void get03() {


    }
}
