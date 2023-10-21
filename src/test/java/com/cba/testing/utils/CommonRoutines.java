package com.cba.testing.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CommonRoutines {
	
	public static String ReadJsonFileAsString(String jsonFilePath) {
		// Specify the path to your JSON file
		StringBuilder jsonString = new StringBuilder();
		String jsonContent = null;
		BufferedReader reader = null;
		try{
		reader = new BufferedReader(new FileReader(jsonFilePath));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		
            try{
            jsonString = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }

            jsonContent = jsonString.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonContent;
	}
	
	
	

	public static JsonObject getJsonObjectFromJsonResponse(String jsonResponse) {

	    // Create a Gson object
        Gson gson = new Gson();

        // Parse the JSON response string
        JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);

        return jsonObject;
	    
	 }
	

}
	