package com.rmg.utility;
/**
 * 
 * @author Nitheesha
 *
 */
public interface IEndPoints {
	
	String ADDPROJECT="/addProject";
	
	String GETALLPROJECT="/projects";
	
	/**
	 * provide path parameter key as projectId
	 */
	String GETSINGLEPROJECT="/projects/{projectId}";
	
	/**
	 * provide path parameter key as projectId
	 */
	String UPDATEPROJECT="/projects/{projectId}";
	
	/**
	 * provide path parameter key as projectId
	 */
	String DELETEPROJECT="/projects/{projectId}";

}
