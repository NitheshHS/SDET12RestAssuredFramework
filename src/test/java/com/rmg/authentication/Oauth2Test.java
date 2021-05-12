package com.rmg.authentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Oauth2Test {
	
	@Test
	public void oauth2Test() {
		Response response = given()
			.formParam("client_id", "Nithesh")
			.formParam("client_secret", "9669727870f8fb28a217e9603beaa589")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "http://nithesh.com")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		
		String accessToken=response.jsonPath().get("access_token");
		System.out.println(accessToken);
//		response.then()
//			.log().all();
		
		given()
			.auth().oauth2(accessToken)
			.contentType(ContentType.JSON)
			.pathParam("userId", "1301")
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{userId}/chickens-feed")
		.then()
			.log().all();
		
	}

}
