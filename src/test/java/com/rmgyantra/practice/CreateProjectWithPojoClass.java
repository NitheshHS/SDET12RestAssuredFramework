package com.rmgyantra.practice;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.rmg.pojo.ProjectPojo;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateProjectWithPojoClass {
	
	@Test
	public void createProject() {
		ProjectPojo object=new ProjectPojo("NitheshHS", "12/05/2021", "TY_01", "SDET12", "Ongoing", 15);
		
		given()
			.contentType(ContentType.JSON)
			.body(object)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
		.and()
			.assertThat().contentType(ContentType.JSON)
		.and()
			.assertThat().time(Matchers.lessThan(300L), TimeUnit.MILLISECONDS)
		.and()
			.assertThat().body("msg", Matchers.equalTo("Successfully Added"))
		.and()
			.assertThat().header("Content-Type", "application/json")
			.log().all();
		
	}

}
