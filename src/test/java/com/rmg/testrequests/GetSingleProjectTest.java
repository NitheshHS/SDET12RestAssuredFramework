package com.rmg.testrequests;



import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.rmg.base.BaseClass;
import com.rmg.utility.IEndPoints;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
public class GetSingleProjectTest extends BaseClass{
	
	@Test 
	public void getSingleProjectTest() throws Throwable {
		String projectID = eUtil.getExcelData("Sheet1", 1, 2);
		int statusCode=Integer.parseInt(eUtil.getExcelData("Sheet1", 1, 3));
		long responseTime=Long.parseLong(eUtil.getExcelData("Sheet1", 1, 4));
		
	given()
		.contentType(ContentType.JSON)
		.pathParam("projectId", projectID)
	.when()
		.get(IEndPoints.GETSINGLEPROJECT)
	.then()
		.assertThat().statusCode(statusCode)
	.and()
		.assertThat().time(Matchers.lessThan(responseTime), TimeUnit.MILLISECONDS)
	.and()
		.log().all();
	}

}
