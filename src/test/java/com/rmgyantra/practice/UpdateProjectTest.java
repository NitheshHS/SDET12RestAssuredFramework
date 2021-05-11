package com.rmgyantra.practice;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateProjectTest {
	
	@Test
	public void updateProjectTest() {
		// TY_PROJ_3006 | Pavan        | 11/05/2021 | Appium         | Completed |         1
		HashMap<String, Object> object=new HashMap<String, Object>();
		object.put("createdBy", "Pavan");
		object.put("createdOn", "11/05/2021");
		object.put("projectId", "TY_PROJ_3006");
		object.put("projectName", "Appium");
		object.put("status", "OnGoing");
		object.put("teamSize", 10);
		
		RestAssured.given()
			.pathParam("projectId", "TY_PROJ_3006")
			.body(object)
			.contentType(ContentType.JSON)
		.when()
			.put("http://localhost:8084/projects/{projectId}")
		.then()
			.log().all();
		
		
	}

}
