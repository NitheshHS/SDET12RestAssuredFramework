package com.rmg.utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * This method used to read data from excel sheet
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return cellValue
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName,int rownum, int cellnum) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstants.DATAFILE);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		return sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
		
	}

}
