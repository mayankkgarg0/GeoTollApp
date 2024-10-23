package com.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automate.driver.manager.DriverManager;
import com.automate.entity.TesData;
import com.automate.utils.screenshot.ScreenshotUtils;
import com.google.common.collect.ImmutableList;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class MRO extends BaseTest{
	
	// For MRO first your Bluetooth should be connected to Wireless Headset
	
	@SuppressWarnings("deprecation")
	@Test (dataProvider = "loginData", dataProviderClass = TesData.class)
	public void Login(String username , String password) throws InterruptedException, IOException {
		
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
		  try {  
		  test.info("Step 3: Enter username and password");
	   driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_email\"]")).click();
	   test.info("Step 4: Enter username ");
		  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_email\"]")).sendKeys(username);
		  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_login_password\"]")).click();
		  test.info("Step 5: Enter Password");
		  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_login_password\"]")).sendKeys(password);
		 driver.navigate().back();
		
		 test.info("Step 6: Click on Login");
		
			 driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev:id/btn_login\"]")).click();
			  longPress(driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev:id/btn_login\"]")));
			  waitForTime(10000);
			  
		    } catch (Exception e) {
		       // e.printStackTrace(); 
		        test.fail(e);
		        test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Unable to Login"));
		        Assert.fail("Test failed due to exception: " + e.getMessage());
		    }
		 
		
//---------------------------------Login Done -------------------------------------------------------------------------------------------------------------//		
	try {
		  
		 WebElement NewBluetoothFindStart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev:id/txt_position\" and @text=\"1\"]")));
		 NewBluetoothFindStart.click();  
		 waitForTime(2000);
		 WebElement BluetoothSelectConnect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev:id/btn_connect\"]")));
		 BluetoothSelectConnect.click(); 
		
		 waitForTime(1000);
        // For NO Popup		 WebElement BluetoothSelectPopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@resource-id=\"android:id/button2\"]")));
		 //For Yes Popup
		 WebElement BluetoothSelectPopupYes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")));
		 BluetoothSelectPopupYes.click();
		 waitForTime(7000); 
		 test.pass("Bluetooth Configuration Completed"); 
		 test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Bluetooth Configured"));
	}	 catch (Exception e) {
		       // e.printStackTrace(); 
		        test.fail(e);
		        test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Unable to Configure Bluetooth"));
		        Assert.fail("Test failed due to exception: " + e.getMessage());
		    }
//----------------Bluetooth Add Done(1st step)---------------------------------------------------------------------------------------------------------------------------------------------//		 
			
	           // Take VIN Number and Odometer Stating Reading(Randon) store in Notepad for Scanning
		 // VIN number click 
	try {	 
		 WebElement CaptureVINNumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev:id/txt_position\" and @text=\"2\"]")));
		 CaptureVINNumber.click();  
		 waitForTime(2000);
		 // CAPTURE VIN PICTURE CLICK BUTTON
		 WebElement ShutterClick = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev:id/capture")));
		 ShutterClick.click();  
		 waitForTime(7000);
		 // Gone for Mannual review
		 WebElement ConfirmVIN = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev:id/btn_confirm")));
		 ConfirmVIN.click();  
		 waitForTime(12000); 
		 // Back Script need to write
		 test.pass("Vim  Configuration Completed"); 
		 test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "VIM Configured"));
	} catch (Exception e) {
	       // e.printStackTrace(); 
        test.fail(e);
        test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Unable to Configure VIN"));
        Assert.fail("Test failed due to exception: " + e.getMessage());
    }
		 //----------------VIN Add Done(2st step)---------------------------------------------//	
	
	try {	 
		 WebElement CaptureOdometerReadingClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev:id/txt_position\" and @text=\"3\"]")));
		 CaptureOdometerReadingClick.click();  
		 waitForTime(3000); 
		 WebElement ShutterClick = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev:id/capture")));
		 ShutterClick.click();  
		 waitForTime(5000);
		// Same thing happen as VIN it stopped and gone for manual odometer processing
		 WebElement Retake = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev:id/btn_retake")));
		 Retake.click();  
		 waitForTime(3000);
		 ShutterClick.click();  
		 waitForTime(5000);
		 Retake.click(); 
		 waitForTime(3000);
		 ShutterClick.click(); 
		 waitForTime(12000);
		 test.pass("Odometer  Configuration Completed"); 
		 test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Odometer Configured"));
	}
	catch (Exception e) {
	       // e.printStackTrace(); 
     test.fail(e);
     test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Unable to Configure Odometer Reading"));
     Assert.fail("Test failed due to exception: " + e.getMessage());
 }
	
	
		//----------------Odometer Reading Done(3rd step)---------------------------------------------//
	}
	
	
	
	
	//--------------------------------Other Function----------------------------------------------------------------------------------------------------------------------------//
	
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
