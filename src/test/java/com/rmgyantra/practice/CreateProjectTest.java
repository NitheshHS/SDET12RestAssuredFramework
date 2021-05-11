package com.rmgyantra.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	
	@Test
	public void createProjectTest() {
		
		JSONObject object=new JSONObject();
		object.put("createdBy", "Nithesh");
		object.put("createdOn", "11/05/2021");
		object.put("projectId", "TY_011");
		object.put("projectName", "SDET12API");
		object.put("status", "OnGoing");
		object.put("teamSize", 15);
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(object);
		
		Response response = req.when().post("http://localhost:8084/addProject");
		
		response.prettyPrint();
	}

}
