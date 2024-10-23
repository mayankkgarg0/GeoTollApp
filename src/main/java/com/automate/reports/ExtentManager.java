package com.automate.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public  class ExtentManager {
	  protected static ExtentReports extent;
	    protected static ExtentTest test;

	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
	            extent = new ExtentReports();
	            extent.attachReporter(htmlReporter);
	        }
	        return extent;
	    }

	    public static ExtentTest createTest(String testName) {
	        test = getInstance().createTest(testName);
	        return test;
	    } 

	    public static void flush() {
	        if (extent != null) {
	            extent.flush();
	        }
	    }

	    public static ExtentTest getTest() {
	        return test;
	    }
} 
