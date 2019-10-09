package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
	
		Xls_Reader reader=new Xls_Reader("C:\\Users\\ADMIN\\eclipse-workspace\\Selenium\\Test_Data_Facebook.xlsx");
		
		if(!reader.isSheetExist("NewSheet")) {
			reader.addSheet("NewSheet");
		}
		int col=reader.getColumnCount("Sheet1");
		System.out.println(col);
	}

}
