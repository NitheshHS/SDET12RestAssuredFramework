package com.rmgyantra.practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjectTest {
	
	@Test
	public void getAllProjectTest() {
		
		Response response = RestAssured.get("http://localhost:8084/projects");
		response.prettyPrint();//print only response body
	
	}

}
