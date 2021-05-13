package com.rmg.testrequests;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmg.base.BaseClass;
import com.rmg.utility.DatabaseUtility;
import com.rmg.utility.IEndPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
public class RMG_API_08_getAllProjects extends BaseClass{
	
	@Test
	public void getAllProjectTest() throws Throwable {
		DatabaseUtility db = new DatabaseUtility();
		db.getConnection();
		Response response = given()
			.contentType(ContentType.JSON)
		.when()
			.get(IEndPoints.GETALLPROJECT);
		response.then()
			.assertThat().statusCode(200)
		.and()
			.assertThat().time(Matchers.lessThanOrEqualTo(1000L), TimeUnit.MILLISECONDS)
		.and()
			.assertThat().contentType(ContentType.JSON)
		.log().all();
		ArrayList<Object> ActualProjectID=response.jsonPath().get("projectId");
		ArrayList<Object> ActualcreatedBy=response.jsonPath().get("createdBy");
		ArrayList<Object> ActualcreatedOn=response.jsonPath().get("createdOn");
		ArrayList<Object> ActualprojectName=response.jsonPath().get("projectName");
		ArrayList<Object> Actualstatus=response.jsonPath().get("status");
		ArrayList<Integer> ActualteamSize=response.jsonPath().get("teamSize");
		
		ArrayList<Object> projectIdList = db.executeQuery("select * from project", "project_id");
		ArrayList<Object> createdByList = db.executeQuery("select * from project", "created_by");
		ArrayList<Object> createdOnList = db.executeQuery("select * from project", "created_on");
		ArrayList<Object> projectNameList = db.executeQuery("select * from project", "project_name");
		ArrayList<Object> statusList = db.executeQuery("select * from project", "status");
		ArrayList<Object> teamSizeList = db.executeQuery("select * from project", "team_size");
	
		Assert.assertEquals(ActualProjectID, projectIdList);
		Assert.assertEquals(ActualcreatedBy, createdByList);
		Assert.assertEquals(ActualcreatedOn, createdOnList);
		Assert.assertEquals(ActualprojectName, projectNameList);
		Assert.assertEquals(Actualstatus, statusList);
		Assert.assertEquals(ActualteamSize, teamSizeList);
		
	}

}
