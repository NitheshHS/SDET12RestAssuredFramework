package com.rmg.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.rmg.utility.DatabaseUtility;
import com.rmg.utility.ExcelUtility;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;
/**
 * 
 * @author Nitheesha
 *
 */
public class BaseClass {
	protected DatabaseUtility databaseUtil;
	protected ExcelUtility eUtil;
	@BeforeSuite
	public void configBS() throws Throwable {
		databaseUtil=new DatabaseUtility();
		databaseUtil.getConnection();
		eUtil=new ExcelUtility();
		
		baseURI="http://localhost";
		port=8084;
	}
	
	@AfterSuite
	public void configAS() throws SQLException {
		databaseUtil.closeDBConnection();
	}
}
