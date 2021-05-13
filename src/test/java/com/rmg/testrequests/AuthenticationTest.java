package com.rmg.testrequests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class AuthenticationTest {
	
	@Test
	public void authtest() {
		given()
			.contentType(ContentType.JSON)
			.auth().basic("rmgyantra", "rmgy@9999")
		.when()
			.get("/login")
		.then()
			.assertThat().statusCode(202)
		.and()
			.log().all();
	}

}
