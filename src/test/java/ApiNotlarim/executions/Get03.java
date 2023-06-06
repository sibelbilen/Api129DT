package ApiNotlarim.executions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get03 {
    @Test
    public void get03() {
        //Set the url
        String url="https://jsonplaceholder.typicode.com/todos/23";

       Response response= given().get(url);
       response.prettyPrint();
       response.then().statusCode(200).
               contentType("application/json").
               body("userId",equalTo(2)).
               body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
               body("completed",equalTo(false));


       //2.yol

        response.then().statusCode(200).
                contentType(ContentType.JSON).
                body("userId",equalTo(2),"title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")
                        ,"completed", equalTo(false));

    }
}
