package com.dyt.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public static FileInputStream inputstream = null;
	public static XSSFWorkbook workbook = null;
	
	//get row count of a sheet
	public static int getRowCount(String filePath, String sheetName) throws IOException
	{
		int rowCount;
		File file = new File(filePath);
		inputstream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputstream);
		XSSFSheet worksheet = workbook.getSheet(sheetName);
		rowCount = worksheet.getLastRowNum()+1;		
		return rowCount;
	}	
	//----------------------------------------
	//get column count of a row
	public static int getColumnCount(String filePath, String sheetName, int rowNumber) throws IOException
	{
		int colCount;
		File file = new File(filePath);
		inputstream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputstream);
		XSSFSheet worksheet = workbook.getSheet(sheetName);
		Row row = worksheet.getRow(rowNumber-1);
		colCount = row.getLastCellNum();		
		return colCount;
	}
	//---------------------------------
	//get cell data
	public static String getCellData(String filePath, String sheetName, int rowNumber, int colNumber)
	{
		String cellText = null;
		try {			
			File file = new File(filePath);
			inputstream = new FileInputStream(file);
			workbook = new XSSFWorkbook(inputstream);
			XSSFSheet worksheet = workbook.getSheet(sheetName);
			Row row = worksheet.getRow(rowNumber-1);
			cellText = row.getCell(colNumber).getStringCellValue();			
		}
		
		catch(Exception e) {
			
		}
		
		return cellText;
	}	
	//---------------------------------
	//get row data	
	public static String[] getRowData(String filePath, String sheetName, int rowNumber) throws IOException
	{		
		String[] rowData;
		File file = new File(filePath);
		inputstream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputstream);
		XSSFSheet worksheet = workbook.getSheet(sheetName);
		Row row = worksheet.getRow(rowNumber-1);
		int colCount = row.getLastCellNum();
		rowData = new String[colCount];
		for(int iCol=0; iCol<colCount; iCol++)
		{
			rowData[iCol] = row.getCell(iCol).getStringCellValue();	
			//System.out.println(row.getCell(iCol).getStringCellValue());
		}				
		return rowData;
	}
}
