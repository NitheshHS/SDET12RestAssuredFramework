package com.rmgyantra.practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProjectTest {

	@Test
	public void getSingleProjectTest() {
		//Path parameter
		RestAssured.given()
		.pathParam("projectId", "TY_PROJ_3005")
		.get("http://localhost:8084/projects/{projectId}")
		.then().log().all();
	}



}
