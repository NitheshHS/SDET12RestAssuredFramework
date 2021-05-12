package com.rmg.testrequests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.rmg.pojo.ProjectPojo;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
public class RMG_API_06_addPRojectWithTextFromatBody {
	
	@Test
	public void addprojectWithTextFormat() {
		ProjectPojo project=new ProjectPojo("deepak", "12/05/2021", "TY_PROJ_203", "deepak_pro-3", "Completed", 10);
		given()
		.accept("application/json, text/plain, */*")
			.contentType("application/text")
			.body(project)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(502)
		.and()
			.assertThat().time(Matchers.lessThan(300L), TimeUnit.MILLISECONDS)
		.and()
			.assertThat().contentType(ContentType.JSON)
		.log().all();
		
	}

}
