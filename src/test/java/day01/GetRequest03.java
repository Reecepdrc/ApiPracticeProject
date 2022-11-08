package day01;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetRequest03 {

        /*
          Matchers ile dataları doğrulayınız
                "id": 5,
                "email": "charles.morris@reqres.in",
                "first_name": "Charles",
                "last_name": "Morris",
                "avatar": "https://reqres.in/img/faces/5-image.jpg"
         */

    @Test
    public void test03() {
        String url = "https://reqres.in/api/users";

        Response response = given().when().get(url);
        //response.prettyPeek();
        response.prettyPrint();

        /*"id": 5,
                "email": "charles.morris@reqres.in",
                "first_name": "Charles",
                "last_name": "Morris",
                "avatar": "https://reqres.in/img/faces/5-image.jpg"
         */

        // Matchers ile id : 5 olan dataları doğrulayınız

        response.then().body("data[4].email", equalTo("charles.morris@reqres.in"),
                "data[4].first_name", equalTo("Charles"), "data[4].avatar",
                equalTo("https://reqres.in/img/faces/5-image.jpg"));


    }



}