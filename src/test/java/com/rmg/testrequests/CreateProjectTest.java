package com.rmg.testrequests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.rmg.base.BaseClass;
import com.rmg.pojo.ProjectPojo;
import com.rmg.utility.DatabaseUtility;
import com.rmg.utility.IEndPoints;

import io.restassured.http.ContentType;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
public class CreateProjectTest extends BaseClass{

	@Test
	public void createProjectTest() throws Throwable {
		
		
		ProjectPojo project = new ProjectPojo("Nithesh", "12/05/2021", "TY_proj_01", "RMG_Yantra", "onGoing", 10);
		
		given()
			.contentType(ContentType.JSON)
			.body(project)
		.when()
			.post(IEndPoints.ADDPROJECT)
		.then()
			.assertThat().statusCode(201)
		.and()
			.assertThat().body("projectName", Matchers.equalTo(project.getProjectName()))
		.and()
			.assertThat().body("msg", Matchers.equalTo("Successfully Added"))
		.log().all();
		
		String ActualData = databaseUtil.exceuteQuery("Select * from project;", "status", project.getStatus());
		Assert.assertEquals(project.getStatus(), ActualData);
		
	}
}
