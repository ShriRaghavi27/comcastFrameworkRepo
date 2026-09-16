package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcelFile(String sheetName,int rowNum,int cellNum) throws IOException
	{
		FileInputStream file=new FileInputStream("./src/test/resources/Book.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	public int getRowCount(String sheetName) throws IOException
	{
		FileInputStream file=new FileInputStream("./src/test/resources/Book.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}
	public void getDataFromExcelFile(String sheetName,int rowNum,int cellNum,String data) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Book.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);

		FileOutputStream fos = new FileOutputStream("./testData/TestData.xlsx");
		wb.write(fos);
		wb.close();
	}

}
