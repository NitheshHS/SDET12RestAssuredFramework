package com.rmgyantra.practice;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAllProjectTest {
	
	@Test
	public void getAllProjectTest() {
		
		given().get("http://localhost:8084/projects")
		.then()
			.assertThat().statusCode(200)
		.and()
			.assertThat().contentType(ContentType.JSON)
		.and()
			.assertThat().time(Matchers.lessThan(300L), TimeUnit.SECONDS)
		
		.log().all();
	
	}

}
