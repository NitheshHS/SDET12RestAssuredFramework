package com.rmgyantra.practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteProjectTest {
	
	@Test
	public void deleteProjectTest() {
		
		RestAssured.given()
			.pathParam("projectId", "TY_PROJ_2008")
			.contentType(ContentType.JSON)
		.when()
			.delete("http://localhost:8084/projects/{projectId}")
		.then()
			.log().all();
			
			
			
		
	}

}
