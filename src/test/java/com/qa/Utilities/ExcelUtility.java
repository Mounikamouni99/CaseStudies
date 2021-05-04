package com.qa.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static FileInputStream filePath;
	public static XSSFWorkbook workbook;
	public static XSSFSheet workSheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String file, String sheet) throws IOException {
		filePath = new FileInputStream(file);
		workbook = new XSSFWorkbook(filePath);
		workSheet = workbook.getSheet(sheet);
		int rowCount = workSheet.getLastRowNum();
		workbook.close();
		filePath.close();
		return rowCount;

	}

	public static int getCellCount(String file, String sheet, int rowNum) throws IOException {
		filePath = new FileInputStream(file);
		workbook = new XSSFWorkbook(filePath);
		workSheet = workbook.getSheet(sheet);
		row = workSheet.getRow(rowNum);
		int cellCount = row.getLastCellNum(); 
		workbook.close();
		filePath.close();
		return cellCount;

	}

	public static String getCellData(String file, String sheet, int rowNum, int colNum) throws IOException {
		filePath = new FileInputStream(file);
		workbook = new XSSFWorkbook(filePath);
		workSheet = workbook.getSheet(sheet);
		row = workSheet.getRow(rowNum);
		cell = row.getCell(colNum);
		DataFormatter formatter = new DataFormatter();
		String cellData = formatter.formatCellValue(cell);
		workbook.close();
		filePath.close();
		return cellData;

	}

}
