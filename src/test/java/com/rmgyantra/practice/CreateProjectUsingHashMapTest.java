package com.rmgyantra.practice;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectUsingHashMapTest {
	
	@Test
	public void createProjectTest() {
		HashMap<String, Object> object=new HashMap<String, Object>();
		object.put("createdBy", "NitheshHS");
		object.put("createdOn", "11/05/2021");
		object.put("projectId", "TY_02");
		object.put("projectName", "RMG");
		object.put("status", "Completed");
		object.put("teamSize", 10);
		
		RequestSpecification requestSpecification = RestAssured.given();//precondition
		requestSpecification.body(object);
		requestSpecification.contentType(ContentType.JSON);
		//sending request
		Response response = requestSpecification.when().post("http://localhost:8084/addProject");
		//printing the logs
		response.then().log().all();//it print the header and body
	}

}
