package io.swagger.petstore.crudtest;

import io.restassured.response.Response;
import io.swagger.petstore.model.PetsPojo;
import io.swagger.petstore.testbase.TestBase;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetsCRUDTest extends TestBase {

    @Test
    public void addNewPet(){
        PetsPojo petsPojo = new PetsPojo();
        petsPojo.setId(123);
        HashMap<String,String> categories = new HashMap<String, String>();
        categories.put("id","55");
        categories.put("name","Cat");

        petsPojo.setCategory(categories);
        petsPojo.setName("Miaoo");

        List<String> url = new ArrayList<String>();
        url.add("Pagal Miaoo");
        petsPojo.setPhotoUrl(url);

        HashMap<String,String> tag = new HashMap<String, String>();
        tag.put("id","555");
        tag.put("name","Cat Drinking milk");

        List<HashMap<?,?>> tags = new ArrayList<HashMap<?, ?>>();
        tags.add(tag);

        petsPojo.setTags(tags);
        petsPojo.setStatus("available");

        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .when()
                .body(petsPojo)
                .post("/pet");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void findPetById(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .when()
                .get("/pet/123");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void updateExistingPetDetails(){
        PetsPojo petsPojo = new PetsPojo();
        petsPojo.setId(123);
        HashMap<String,String> categories = new HashMap<String, String>();
        categories.put("id","55");
        categories.put("name","Cat");

        petsPojo.setCategory(categories);
        petsPojo.setName("Miaoo");

        List<String> url = new ArrayList<String>();
        url.add("Pagal Miaoo");
        petsPojo.setPhotoUrl(url);

        HashMap<String,String> tag = new HashMap<String, String>();
        tag.put("id","555");
        tag.put("name","Cat Drinking water");

        List<HashMap<?,?>> tags = new ArrayList<HashMap<?, ?>>();
        tags.add(tag);

        petsPojo.setTags(tags);
        petsPojo.setStatus("available");

        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .when()
                .body(petsPojo)
                .put("/pet");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void deletePet(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .when()
                .delete("/pet/123");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
