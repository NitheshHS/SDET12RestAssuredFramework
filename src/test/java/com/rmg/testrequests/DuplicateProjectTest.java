package com.rmg.testrequests;



import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.rmg.pojo.ProjectPojo;
import com.rmg.utility.DatabaseUtility;

import io.restassured.http.ContentType;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
public class DuplicateProjectTest {
	
	@Test
	public void duplicateProjectTest() throws Throwable {
		DatabaseUtility db = new DatabaseUtility();
		db.getConnection();
		ProjectPojo project=new ProjectPojo("deepak", "12/05/2021", "TY_PROJ_3207", "deepak_pro-3", "Completed", 10);
		
		given()
			.contentType(ContentType.JSON)
			.body(project)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(502)
		.and()
		.assertThat().time(Matchers.lessThan(300l), TimeUnit.MILLISECONDS)
		.and()
			.contentType(ContentType.JSON)
		.log().all();
		
		String ActualData=db.exceuteQuery("select * from project", "deepak_pro-3", project.getProjectName());
		Assert.assertEquals("Expected Data is not matching with any data in database!!!", ActualData);
		db.closeDBConnection();
	}

}
