package UpdatedTestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.PointerEventProperties;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class DashboardItems extends BaseTest {

	@SuppressWarnings("deprecation")
	@Test(dataProvider = "MROData", dataProviderClass = TesData.class)
	public void DashboardItemsMethod(String username, String password) throws InterruptedException, IOException {

		AppiumDriver driver = DriverManager.getDriver();
		waitForTime(2000);

		test.info("Step 1: Open the login page");
		test.info("Step 2: Enable Bluetooth and connect ");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// bluetoothOn(); InternetUP();

		try {
			test.info("Step 3: Enter username and password");
			driver.findElement(AppiumBy.xpath(
					"//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_email\"]"))
					.click();
			test.info("Step 4: Enter username ");
			driver.findElement(AppiumBy.xpath(
					"//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_email\"]"))
					.sendKeys(username);
			waitForTime(1000);
			driver.findElement(AppiumBy.xpath(
					"//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_login_password\"]"))
					.click();
			test.info("Step 5: Enter Password");
			driver.findElement(AppiumBy.xpath(
					"//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_login_password\"]"))
					.sendKeys(password);
			driver.navigate().back();
			waitForTime(1000);
			test.info("Step 6: Click on Login");

			driver.findElement(AppiumBy.xpath(
					"//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/btn_login\"]"))
					.click();
			// longPress(driver.findElement(AppiumBy.xpath(
			// "//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/btn_login\"]")));
			waitForTime(10000);

			// To Include what ever element comes next
			/*
			 * String ExpectedTittle = "Welcome, Akshay QATest "; String ActualTittle =
			 * driver.findElement(By.id(
			 * "com.geotoll.egpsflex_android.dev.uat:id/txt_welcome_label")) .getText();
			 * System.out.println(ActualTittle); Assert.assertEquals(ActualTittle,
			 * ExpectedTittle, "ActualTittle is passed");
			 */

			driver.findElement(AppiumBy.xpath(
					"//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_close\"]"))
					.click();
			waitForTime(2000);
			test.pass("Login Test Passed");
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "LoginPass"));
		}

		catch (Exception e) {

			test.fail(e);
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Unable to Login"));
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

//-----------------------------------------------------------------------------------------Login Done -----------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------Odometer History-------------------------------------------------------------------------------------------

		
		  try {
		  
		  driver.findElement(AppiumBy.id(
		  "com.geotoll.egpsflex_android.dev.uat:id/txt_odometer_title")).click();
		  waitForTime(4000); test.info(" Clicked on Odometer History");
		  test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,
		  "Odometer History")); test.pass("Odometer History  Passed");
		  
		  test.info("Press Back Button"); WebElement BackButton = wait.until(
		  ExpectedConditions.elementToBeClickable(By.id(
		  "com.geotoll.egpsflex_android.dev.uat:id/img_back"))); BackButton.click();
		  waitForTime(3000); }
		  catch(Exception e) {
		  test.fail("Odometer History Test Failed" + e);
		  
		  }
		  
//----------------------------------------------------------------------------------------MileageTransaction------------------------------------------------------------------ ----------------------
		  
		  try {
		  
		  driver.findElement(AppiumBy.id(
		  "com.geotoll.egpsflex_android.dev.uat:id/txt_ruc_mileage_transaction_title"))
		  .click(); waitForTime(3000); test.info(" Clicked on Mileage Transaction");
		  test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,
		  "Mileage Transaction")); test.pass("Mileage Transaction");
		  
		  test.info("Press Back Button"); WebElement BackButton = wait.until(
		  ExpectedConditions.elementToBeClickable(By.id(
		  "com.geotoll.egpsflex_android.dev.uat:id/img_back"))); BackButton.click();
		  waitForTime(3000);
		  
		  } catch(Exception e) { test.fail("Odometer History Test Failed" + e);
		  
		  }
		  
		  
		  
		  
 //----------------------------------------------------------------------------------------Statement------------------------------------------------------------------------------------------------
		  
		  try {
		  
		  driver.findElement(AppiumBy.xpath(
		  "(//android.widget.ImageView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/navigation_bar_item_icon_view\"])[2]"
		  )).click(); waitForTime(3000); test.info(" Clicked on Statement");
		  
		  driver.findElement(AppiumBy.id(
		  "com.geotoll.egpsflex_android.dev.uat:id/img_account_statement_arrow")).click
		  (); test.info(" Clicked on First Statement icon"); waitForTime(3000);
		  test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,
		  "First Statement Details")); scroll("UP", 0.5); waitForTime(1000);
		  test.info("Press Home Button"); WebElement HomeButton = wait.until(
		  ExpectedConditions.elementToBeClickable(By.xpath(
		  "(//android.widget.ImageView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/navigation_bar_item_icon_view\"])[1]"
		  ))); HomeButton.click(); waitForTime(3000); test.pass("Statement"); }
		  catch(Exception e) { test.fail("Statement Test Failed" + e);
		  
		  }
		  
//----------------------------------------------------------------------------------------Payment------------------------------------------------------------------------------------------------
		  
		  
		  try {
		  
		  driver.findElement(AppiumBy.xpath(
		  "(//android.widget.ImageView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/navigation_bar_item_icon_view\"])[3]"
		  )).click(); waitForTime(3000); test.info(" Clicked on Payment");
		  driver.findElement(AppiumBy.id(
		  "com.geotoll.egpsflex_android.dev.uat:id/btn_view_transaction_history")).
		  click(); test.info(" Clicked on View Payment transaction");
		  waitForTime(1000); driver.findElement(AppiumBy.id(
		  "com.geotoll.egpsflex_android.dev.uat:id/img_account_statement_arrow")).click
		  (); test.info(" Clicked on First transaction"); waitForTime(3000);
		  test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,
		  "First Transaction Details")); scroll("UP", 0.5); waitForTime(1000);
		  test.info("Press Back Button"); WebElement BackButton = wait.until(
		  ExpectedConditions.elementToBeClickable(By.id(
		  "com.geotoll.egpsflex_android.dev.uat:id/img_back"))); BackButton.click();
		  waitForTime(1000); WebElement HomeButton = wait.until(
		  ExpectedConditions.elementToBeClickable(By.xpath(
		  "(//android.widget.ImageView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/navigation_bar_item_icon_view\"])[1]"
		  ))); HomeButton.click();
		  test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,
		  "Home Screen Screenshot")); test.pass("Payment"); } catch(Exception e) {
		  test.fail("Payment Test Failed" + e);
		  
		  }
		 
// ----------------------------------------------------------------------------------------Add Payment Method------------------------------------------------------------------------------------------------

		

		try {
			waitForTime(1000);
			WebElement PaymentIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"(//android.widget.ImageView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/navigation_bar_item_icon_view\"])[3]")));
			PaymentIcon.click();
			test.info(" Clicked on Payment");
			waitForTime(2000);

			WebElement AddPayment = wait.until(ExpectedConditions.elementToBeClickable(
					By.id("com.geotoll.egpsflex_android.dev.uat:id/btn_add_new_payment_method_secondary")));
			AddPayment.click();
			test.info(" Clicked on AddPayment");
			waitForTime(1000);
			scroll("DOWN", 0.5);
			scroll("DOWN", 0.5);
			test.info(" Scroll Down");
			waitForTime(1000);

			WebElement SelectCardTypedropdown1 = driver
					.findElement(By.id("com.geotoll.egpsflex_android.dev.uat:id/ac_txt_credit_card_type"));
			SelectCardTypedropdown1.click();

			TapByCordinates(223, 844);
			test.info(" Card Type Picked");
			waitForTime(1000);

			WebElement FirstName = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/edt_first_name")));
			FirstName.click();
			FirstName.sendKeys("Amir");

			WebElement MiddleIni = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/edt_middle_name")));
			MiddleIni.click();
			MiddleIni.sendKeys("John");

			WebElement LastName = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/edt_last_name")));
			LastName.click();
			LastName.sendKeys("Sabastion");
			waitForTime(1000);
			Back();
			test.info(" Entered First, Middle and Last Name");
			WebElement CreditCardNum = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/edt_credit_card_number")));
			CreditCardNum.click();
			CreditCardNum.sendKeys("5424000000000015");
			Back();
			waitForTime(1000);
			test.info(" Entered Card Number");
			WebElement Expiration = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/edt_credit_card_expiration")));
			Expiration.click();
			WebElement Apply = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/btn_delete")));
			Apply.click();

			WebElement CVV = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/edt_credit_card_cvv")));
			CVV.click();
			CVV.sendKeys("900");
			Back();
			waitForTime(1000);
			test.info(" Entered Card Expiration and CVV Details");
			WebElement NextPage = wait.until(
					ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/btn_next")));
			NextPage.click();
			waitForTime(1000);

			test.info(" Next to Address Page");
			WebElement BANextPage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/btn_next\"]")));
			BANextPage.click();

			waitForTime(1000);

			// Next Page-Amount

			scroll("DOWN", 0.5);

			WebElement ReplenishmentAmount = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/edt_replenishment_amount")));
			ReplenishmentAmount.click();
			ReplenishmentAmount.clear();
			ReplenishmentAmount.sendKeys("15.0");
			Back();
			waitForTime(1000);
			test.info(" On the Submit Page");
			WebElement ReplenishmentAmountThreshold = wait.until(ExpectedConditions.elementToBeClickable(
					By.id("com.geotoll.egpsflex_android.dev.uat:id/edt_replenishment_threshold_amount")));
			ReplenishmentAmountThreshold.click();
			ReplenishmentAmountThreshold.clear();
			ReplenishmentAmountThreshold.sendKeys("20.0");
			Back();
			waitForTime(1000);
			test.info(" Entered both Replenishment Value ");
			WebElement checkboxconfirmation = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/chk_confirmation_message")));
			checkboxconfirmation.click();
			waitForTime(1000);

			WebElement Submit = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/btn_submit")));
			Submit.click();
			waitForTime(3000);
			test.info(" Clicked Submit ");
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Credit Card Screenshot"));
			test.pass("Add Payment Method");
		} 
		
		catch (Exception e) {
			test.fail("Add Payment Method Test Failed" + e);
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Add Payment Failed Screenshot"));

		}
	}

// --------------------------------------------- ------------------------------------------Test Complete---------------------------------------------------------------------------------------------	

//-----------------------------------------------------------------------------------------Other Function---------------------------------------------------------------------------------------------

	// Swipe Required to create
	public static void longPress(WebElement ele) {
		Point location = ele.getLocation();
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence sequence = new Sequence(input, 0);
		sequence.addAction(
				input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location.x, location.y));
		sequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		sequence.addAction(
				input.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), location.x, location.y));
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

	public void bluetoothOn() {
		try {

			Runtime.getRuntime().exec("adb shell am broadcast -a io.appium.settings.bluetooth --es setstatus enable");
			test.info("BluetoothOn");
			waitForTime(1000);
			System.out.println("BluetoothOn");
		} catch (Exception e) {
			e.printStackTrace();
			test.info(e);
			test.info("Bluetooth Not Working");
		}
	}

	public void bluetoothOff() {
		try {

			Runtime.getRuntime().exec("adb shell am broadcast -a io.appium.settings.bluetooth --es setstatus disable");
			test.info("BluetoothOff");
			waitForTime(1000);
			System.out.println("BluetoothOff");
		} catch (Exception e) {
			e.printStackTrace();
			test.info(e);
			test.info("Bluetooth Not Working");
		}
	}

	public void InternetUP() {
		try {

			Runtime.getRuntime().exec("adb shell svc wifi enable");
			Runtime.getRuntime().exec("adb shell svc data enable");
			test.info("Data/WiFi Enabled");
			waitForTime(1000);
			System.out.println("Mobile Data & WiFI has been Enabled");
		} catch (Exception e) {
			System.out.println("Issue exit in WiFi /Mobile Data");
			e.printStackTrace();
			test.info(e);
		}
	}

	public void InternetDown() {
		try {

			Runtime.getRuntime().exec("adb shell svc data disable");
			Runtime.getRuntime().exec("adb shell svc wifi disable");
			test.info("Data/WiFi Disabled");
			waitForTime(1000);
			System.out.println("Mobile Data & WiFI has been Disabled");
		} catch (Exception e) {
			System.out.println("Issue exit in WiFi /Mobile Data");
			e.printStackTrace();
			test.info(e);
		}

	}

	public void NativeswipeUp() {
		try {

			Runtime.getRuntime().exec("adb shell input swipe 500 1000 500 0");
			waitForTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void NativeswipeDown() {
		try {

			Runtime.getRuntime().exec("adb shell input swipe 500 0 500 1000");
			waitForTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Back() {
		try {

			Runtime.getRuntime().exec("adb shell input keyevent 4");
			waitForTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void HomeButton() {
		try {

			Runtime.getRuntime().exec("adb shell input keyevent 3");
			waitForTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void LaunchApp() {
		try {

			Runtime.getRuntime().exec(
					"adb shell am start -n com.geotoll.egpsflex_android.dev.uat/com.geotoll.egpsflex_android.activities.SplashActivity");
			waitForTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void ImplicitWait() {
		try {
			AppiumDriver driver = DriverManager.getDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void TapByCordinates(int x, int y) {

		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence swipe = new Sequence(input, 0);
		swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
		swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(input.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), x, y));
		swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		DriverManager.getDriver().perform(ImmutableList.of(swipe));
	}

	public static void swipe(Point start, Point end, Duration duration) {
		AppiumDriver driver = DriverManager.getDriver();
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence swipe = new Sequence(input, 0);
		swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
		swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
		swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(ImmutableList.of(swipe));
	}

	public static void scroll(String pageDirection, double scrollRatio) {
		AppiumDriver driver = DriverManager.getDriver();
		Duration SCROLL_DUR = Duration.ofMillis(300);
		if (scrollRatio < 0 || scrollRatio > 1) {
			throw new Error("Scroll distance must be between 0 and 1");
		}

		Dimension size = driver.manage().window().getSize();
		System.out.println("Screen Size = " + size);
		System.out.println("");

		Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));

		int a = (int) (midPoint.x * scrollRatio);
		int b = (int) (midPoint.y * scrollRatio);

		int bottom = midPoint.y + (int) (midPoint.y * scrollRatio); // 50 + 25 B
		int top = midPoint.y - (int) (midPoint.y * scrollRatio); // 50 - 25 A
		int left = midPoint.x - (int) (midPoint.x * scrollRatio); // 25 - 12.5 M
		int right = midPoint.x + (int) (midPoint.x * scrollRatio); // 25 + 12.5 N

		System.out.println("Midpoint: " + midPoint);

		System.out.println("Midpoint x: " + midPoint.x);
		System.out.println("a: " + a);

		System.out.println("Midpoint y: " + midPoint.y);
		System.out.println("b: " + b);

		System.out.println("");
		System.out.println("Bottom: " + bottom);
		System.out.println("Top: " + top);
		System.out.println("Right: " + right);
		System.out.println("Left: " + left);
		System.out.println("--------------------");

		if (pageDirection == "UP") {
			// Swipe Top to bottom, Page will go UP
			swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
		} else if (pageDirection == "DOWN") {
			swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
		} else if (pageDirection == "LEFT") {
			swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
		} else {
			// RIGHT
			swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
		}
	}

}
