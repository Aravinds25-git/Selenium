package com.excel.utility;

import java.util.ArrayList;

public class TestUtil_DataProvider {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel()
	{
		
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		
		try {
		reader = new Xls_Reader("C:\\Users\\ADMIN\\eclipse-workspace\\Selenium\\Test_Data_Facebook.xlsx");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int rowNum=2; rowNum<=reader.getRowCount("Sheet1");rowNum++)
		{
			String firstname=reader.getCellData("Sheet1","Firstname",rowNum);
			//System.out.println(firstname);
			String Surname=reader.getCellData("Sheet1","Surname",rowNum);
			//System.out.println(Surname);
			String MobileNumber=reader.getCellData("Sheet1","MobileNumber",rowNum);
			//System.out.println(MobileNumber);
			String Password=reader.getCellData("Sheet1","Password",rowNum);
			//System.out.println(Password);
			
			Object ob[]= {firstname,Surname,MobileNumber,Password};
			myData.add(ob);
		}
		
		
		return myData;
		
	}
	

}
