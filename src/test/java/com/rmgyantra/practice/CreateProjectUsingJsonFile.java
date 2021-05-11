package com.rmgyantra.practice;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectUsingJsonFile {
	
	@Test
	public void createProjectTest() {
		File file = new File(".\\src\\test\\resources\\ProjectFiles\\Project.json");
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(file);
		
		Response res = reqSpec.when().post("http://localhost:8084/addProject");
		
		res.then().log().all();
	}

}
