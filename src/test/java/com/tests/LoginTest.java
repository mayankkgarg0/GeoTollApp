package com.tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;


import com.automate.driver.manager.DriverManager;
import com.automate.entity.TesData;
import com.automate.reports.ExtentManager;
import com.automate.utils.screenshot.ScreenshotUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.Point;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;


public final class LoginTest extends BaseTest implements ITestListener {
	
	@SuppressWarnings("deprecation")
	@Test (dataProvider = "loginData", dataProviderClass = TesData.class)
	public void LoginLogout(String username , String password) throws InterruptedException, IOException {
		
		  AppiumDriver  driver = DriverManager.getDriver();
		  waitForTime(2000);
		
		 
			 test.info("Step 1: Open the login page");
			  test.info("Step 2: Enable Bluetooth and connect ");
		 
		 
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  try {
	           // Enable Bluetooth using adb command
	           Runtime.getRuntime().exec("adb shell am broadcast -a io.appium.settings.bluetooth --es setstatus enable"); // For enabling Bluetooth
	           System.out.println("Bluetooth has been enabled.");
	       } catch (Exception e) {
	           e.printStackTrace(); 
	       } 
		  test.info("Step 3: Enter username and password");
	   driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_email\"]")).click();
	   test.info("Step 4: Enter username ");
		  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_email\"]")).sendKeys(username);
		  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_login_password\"]")).click();
		  test.info("Step 5: Enter Password");
		  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_login_password\"]")).sendKeys(password);
		 driver.navigate().back();
		
		 test.info("Step 6: Click on Login");
		 try {
			 driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev:id/btn_login\"]")).click();
			  longPress(driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev:id/btn_login\"]")));
			  waitForTime(10000);
			  
			  String ExpectedTittle = "Welcome, Akshay QATest ";	
				String ActualTittle = 	 driver.findElement(By.id("com.geotoll.egpsflex_android.dev:id/txt_welcome_label")).getText();
				System.out.println(ActualTittle);
		       Assert.assertEquals(ActualTittle, ExpectedTittle, "ActualTittle is passed");
					 
				    
		    } catch (Exception e) {
		       // e.printStackTrace(); 
		        test.fail(e);
		        test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Invalid Login"));
		        Assert.fail("Test failed due to exception: " + e.getMessage());
		    }
	//------------------------------------------------------------------------------Login Done ------------------------------------------------------------------------------// 
	
	      //  assert successElement.isDisplayed() : "Login failed!";
		 
	
		try {  
		 driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev:id/img_close\"]")).click();
		 waitForTime(6000);
		 
		 test.pass("Login Test Passed"); 
		 test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "LoginPASS"));
		
		 
		 
		}
		catch (Exception e) {
			test.fail(e);
		
	      //  e.printStackTrace(); 
	        test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "LoginFail")); 
	        Assert.fail("Test failed due to exception: " + e.getMessage());
	    }
	
	
	  test.info("Step 7 : Skip Tour");
	
	test.info("Step 8 : Start Logout");
		 // Logout Script
		 driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev:id/img_hamburger\"]")).click();
		 waitForTime(1000);
		 driver.findElement(By.id("com.geotoll.egpsflex_android.dev:id/layout_logout_tab")).click();
		 waitForTime(3000);
		 
		 driver.findElement(By.id("android:id/button1")).click();
		 waitForTime(5000);
		 test.pass("Logout Test Passed"); 
		 test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "LogoutPass"));
	}			   
	   
	
	 

	public static void longPress(WebElement ele) {
	      Point location = ele.getLocation();
	      PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	      Sequence sequence = new Sequence(input, 0);
	      sequence.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location.x, location.y));
	      sequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	      sequence.addAction(input.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), location.x, location.y));
	      sequence.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	      DriverManager.getDriver().perform(ImmutableList.of(sequence));
	  } 
	   
 
	 private void waitForTime(long milliseconds) {
	     try {
	         Thread.sleep(milliseconds);
	     } catch (InterruptedException e) {
	         e.printStackTrace();
	     }
	 }
}