package com.rmgyantra.practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class QueryParmeterTest {
	
	@Test 
	public void queryParametrTest() {
		/*
		 * baseuri=https://reqres.in/
		 * endpoint=/api/users?page=2
		 */
		RestAssured.given()
			.contentType(ContentType.JSON)
			.queryParam("page", "2")
		.when()
			.get("https://reqres.in/api/users")
		.then()
			.log().all();
		
	}

}
