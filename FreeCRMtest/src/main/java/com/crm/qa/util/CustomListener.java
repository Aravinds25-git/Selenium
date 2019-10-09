package com.crm.qa.util;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.qa.base.TestBase;

public class CustomListener extends TestBase implements ITestListener {

	 public void onTestFailure(ITestResult result)
	 {
		 failed(result.getMethod().getMethodName());
	 }
}
