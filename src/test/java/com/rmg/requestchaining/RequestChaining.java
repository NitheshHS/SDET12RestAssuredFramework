package com.rmg.requestchaining;

import org.testng.annotations.Test;

import com.rmg.pojo.ProjectPojo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
public class RequestChaining {
	
	@Test
	public void requestChaining() {
		/*
		 * creating new project
		 */
		ProjectPojo object=new ProjectPojo("Nithesh", "12/05/2021", "TY_01", "API", "created", 1);
		given()
			.contentType(ContentType.JSON)
			.body(object)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.log().all();
		
		/*
		 * Get all project
		 */
		Response response = given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:8084/projects");
		
		response.then()
			.log().all();
		
		ArrayList<String> list=response.jsonPath().get("projectId");
//		for(String project:list) {
//			System.out.println(project);
//		}
		String projectID = list.get(list.size()-1);
		System.out.println(projectID);
		
		/*
		 * delete last project
		 */
		given()
			.contentType(ContentType.JSON)
			.pathParam("project_Id", projectID)
		.when()
			.delete("http://localhost:8084/projects/{project_Id}")
		.then()
			.log().all();
	}

}
