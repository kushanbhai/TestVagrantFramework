package com.Automation.Utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDataProvider {

	HSSFWorkbook wb;

	public ExcelDataProvider() {
		try {
			File src = new File("./TestData/Data.xls");
			FileInputStream fis = new FileInputStream(src);
			wb = new HSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read excel file " + e.getMessage());
		}
	}

	public String getStringData(String sheetname, int rowno, int colno) {
		return wb.getSheet(sheetname).getRow(rowno).getCell(colno).getStringCellValue();
	}

	public double getNumericData(String sheetname, int rowno, int colno) {
		return wb.getSheet(sheetname).getRow(rowno).getCell(colno).getNumericCellValue();
	}
	

	public String getStringData(int sheetIndex, int rowno, int colno) {
		return wb.getSheetAt(sheetIndex).getRow(rowno).getCell(colno).getStringCellValue();
	}
}
