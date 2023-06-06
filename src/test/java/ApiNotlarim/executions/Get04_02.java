package ApiNotlarim.executions;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class Get04_02  extends JsonPlaceHolderBaseUrl {
     /*
        Given
            https://jsonplaceholder.typicode.com/todos

	 	    I send a GET request to the Url

	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos => toplam 200 todos olması gerekir
	    And
	        "quis eius est sint explicabo" should be one of the todos title => todos başlıklarından en az birinin "quis eius est sint explicabo" olması gerekir

	        2, 7, and 9 should be among the userIds => serIdu değerleri arasında 2, 7 ve 9 bulunmalıdır
    */

   @Test
    public void test02() {
        spec.pathParam("first","todos");

        Response response=given(spec).get("{first}");
        response.prettyPrint();

        response.then().contentType(ContentType.JSON).statusCode(200).
                body("",hasSize(200)).
                body("title",hasItem("quis eius est sint explicabo")).body("userId",hasItems(2,7,9));

        //hasSize:eleman sayisini assert eder.
       //hasItem:tek bir ogenin icerip icermeidgini assert eder.
       //hasItems:containsAll() gibi çoklu objelerin içerilip içrilmediğini assert eder.




    }
}
