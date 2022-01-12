import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class JsonPlaceHolder {

    @Test
    public void getUsers_Should_Filter_Users() {
        Response response = given()
                .baseUri("https://jsonplaceholder.typicode.com/")
                .basePath("todos")

                .when()
                .get("29");
        Assert.assertEquals(200, response.statusCode());
        System.out.println(response.body().asString());


        System.out.println(response.body().asString());
        JsonPath responseJson = response.getBody().jsonPath();
       Assert.assertEquals("laborum aut in quam",responseJson.getString("title"));

    }
@Test
    public void verify_getPosts_byId(){

    Response response = given()
            .baseUri("https://jsonplaceholder.typicode.com/")
            .basePath("users")

            .when()
            .get("5");
    Assert.assertEquals(200, response.statusCode());
    System.out.println(response.body().asString());
    Assert.assertEquals("Skiles Walks",response.getBody().jsonPath().<String>get("address.street"));
    Assert.assertEquals("Chelsey Dietrich",response.getBody().jsonPath().<String>get("name"));
    Assert.assertEquals("-31.8129",response.getBody().jsonPath().<String>get("address.geo.lat"));
    Assert.assertEquals("User-centric fault-tolerant solution",response.getBody()
                                          .jsonPath().<String>get("company.catchPhrase"));


}
@Test
    public void verify_userId_title(){

    Response response = given()
            .baseUri("https://jsonplaceholder.typicode.com/")
            .basePath("posts")
            .queryParam("userId",2)
            .when()
            .get("15");
    Assert.assertEquals(200, response.statusCode());
    System.out.println(response.body().asString());
    JsonPath responseJson = response.getBody().jsonPath();
    System.out.println(responseJson.<String>get("$.title"));




}



}

