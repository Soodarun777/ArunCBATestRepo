package com.cba.testing.petstore;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cba.testing.utils.CommonRoutines;
import com.google.gson.JsonObject;

public class PetStoreAPITest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test(priority=1) // Find pet by ID
    public void testGetPetById() {
        Response response = RestAssured.given()
                .when()
                .get("/pet/8");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        String responseBody = response.getBody().asString();
        // Add more validation here
    }
    

    // Add more test methods for other endpoints
    
    @Test(priority=0) //Add a new pet to the store
    public void testCreatePetById() throws IOException {
    	
		String petFilePath = "./src/test/java/resources/createpet.json";
		String jsonFileContent = CommonRoutines.ReadJsonFileAsString(petFilePath);
		
		
        Response response = RestAssured.given()
			        .when()
			        .body(jsonFileContent).contentType("application/json")
			        .post("/pet");
		

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        String responseBody = response.getBody().asString();
        response.prettyPrint();
        // Add more validation here
    }
    
    
    @Test(priority=3) //Deletes a pet
    public void testDeletePetById() throws IOException {
    	
		
        RestAssured.given()
			        .when()
			        .post("/pet/8")
			        .then()
			        .statusCode(200);
		
    }
    
    @Test(priority=4) //404 - Updates a pet in the store with form data
    public void testUpdatePetById404() throws IOException {
    	
		
        Response response = RestAssured.given()
			        .when()
			        .param("name", "")
			        .param("status", "")
			        .post("/pet/7654321");
		

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404);

    }
    
    @Test(priority=2) //Updates a pet in the store with form data
    public void testUpdatePetById() throws IOException {
    	
		
        Response response = RestAssured.given()
			        .when()
			        .param("name", "UpdatedDoggie")
			        .param("status", "UpdatedAvailable")
			        .post("/pet/8");
		

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        String responseBody = response.getBody().asString();
        response.prettyPrint();
        // Add more validation here
    }
    
    @Test(priority=5)
    public void testGetPetById404() {
        Response response = RestAssured.given()
                .when()
                .get("/pet/7654321");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404);

        
        
        String responseBody = response.getBody().asString();
        
        //Get JsonResponse from response for more assertions
        JsonObject jsonResponseObject = CommonRoutines.getJsonObjectFromJsonResponse(response.asString());
        String message = jsonResponseObject.get("message").getAsString();
        
        Assert.assertEquals(message, "Pet not found");
        
    }

    
}
