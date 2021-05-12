package com.rmgyantra.practice;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class DeleteProjectTest {
	
	@Test
	public void deleteProjectTest() {
		
		given()
			.pathParam("projectId", "TY_PROJ_1402")
			.contentType(ContentType.JSON)
		.when()
			.delete("http://localhost:8084/projects/{projectId}")
		.then()
			.assertThat().statusCode(204)
		.and()
			.assertThat().contentType(ContentType.JSON)
		.log().all();
			
		
			
		
	}

}
