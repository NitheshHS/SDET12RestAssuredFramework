package com.rmg.pojo;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
/**
 * 
 * @author Nitheesha
 *
 */
@JsonPropertyOrder(value = {
		"createdBy",
		"createdOn",
		"projectId",
		"projectName",
		"status",
		"teamSize"
})
public class ProjectPojo {
	
	@JsonProperty(value = "createdBy")
	private String createdBy;
	@JsonProperty(value = "createdOn")
	private String createdOn;
	@JsonProperty(value = "projectId")
	private String projectId;
	@JsonProperty(value = "projectName")
	private String projectName;
	@JsonProperty(value = "status")
	private String status;
	@JsonProperty(value = "teamSize")
	private int teamSize;
	
	public ProjectPojo() {}

	public ProjectPojo(String createdBy, String createdOn, String projectId, String projectName, String status,
			int teamSize) {
		super();
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.projectId = projectId;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	
	

}
