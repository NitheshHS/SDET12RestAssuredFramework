package com.rmg.authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class LoginTest {
	
	@Test
	public void loginTest() {
		
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		.when()
		.get("http://localhost:8084/login")
		.then()
			.log().all();
	}

}
