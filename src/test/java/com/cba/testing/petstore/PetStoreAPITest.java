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

    @Test
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
    
    @Test
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
    
    
    
    @Test
    public void testGetPetNotFoundById() {
        Response response = RestAssured.given()
                .when()
                .get("/pet/6");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404);

        
        
        String responseBody = response.getBody().asString();
        
        //Get JsonResponse from response for more assertions
        JsonObject jsonResponseObject = CommonRoutines.getJsonObjectFromJsonResponse(response.asString());
        String message = jsonResponseObject.get("message").getAsString();
        
        Assert.assertEquals(message, "Pet not found");
        
    }

    
}
