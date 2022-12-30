package io.swagger.petstore.crudtest;

import io.restassured.response.Response;
import io.swagger.petstore.model.UserPojo;
import io.swagger.petstore.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class UserCRUDTest extends TestBase {

    @Test
    public void createUser(){

        UserPojo userPojo = new UserPojo();
        userPojo.setId(22);
        userPojo.setUserName("xyz987");
        userPojo.setFirstName("Pet123");
        userPojo.setLastName("pet654");
        userPojo.setEmail("xyz123@yahoo.com");
        userPojo.setPassword("pet987");
        userPojo.setPhone("0434288274");
        userPojo.setUserStatus("active");

        Response response =  given().log().all()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .when()
                .body(userPojo)
                .post("/user/createWithList");
        response.prettyPrint();
        response.then().log().all().statusCode(200);

    }

    @Test
    public void getUserByName(){
        Response response =  given().log().all()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .when()
                .get("/user/xyz987");
        response.prettyPrint();
        response.then().log().all().statusCode(200);

    }
    @Test
    public void updateUserByName(){
        UserPojo userPojo = new UserPojo();
        userPojo.setId(22);
        userPojo.setUserName("xyz987");
        userPojo.setFirstName("Pet123");
        userPojo.setLastName("pet654");
        userPojo.setEmail("xyz123@yahoo.com");
        userPojo.setPassword("pet987");
        userPojo.setPhone("0434288274");
        userPojo.setUserStatus("inactive");

        Response response =  given().log().all()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .when()
                .body(userPojo)
                .put("/user/xyz987");
        response.prettyPrint();
        response.then().log().all().statusCode(200);
    }

    @Test
    public void deleteUserByName(){
        Response response =  given().log().all()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .when()
                .get("/user/xyz987");
        response.prettyPrint();
        response.then().log().all().statusCode(200);
    }
}
