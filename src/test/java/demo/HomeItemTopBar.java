package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy.ByAccessibilityId;
import io.appium.java_client.android.AndroidDriver;

public class HomeItemTopBar {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// Desired Capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("appium:deviceName", "realme RMX2001");
		capabilities.setCapability("appium:platformName", "Android");
		capabilities.setCapability("appium:automationName", "UiAutomator2");
		capabilities.setCapability("appium:platformVersion", "11");

		capabilities.setCapability("appium:appPackage", "com.deco_tech.tallymobile");
		capabilities.setCapability("appium:appActivity", "com.deco_tech.tallymobile.MainActivity");

		capabilities.setCapability("appium:noReset", true);
		capabilities.setCapability("appium:fullReset", false);

		// URL of the Appium server

		URL url = URI.create("http://192.168.56.1:4723").toURL();

		// Initialize AndroidDriver
		AndroidDriver driver = new AndroidDriver(url, capabilities);
		Thread.sleep(5000);

		// click Items
		driver.findElement(ByAccessibilityId.accessibilityId("Go to Items Screen")).click();
		Thread.sleep(5000);

		// click 110 mm agri pipe 4kg
		driver.findElement(ByAccessibilityId.accessibilityId("Item name: 110mm Agri Pipe 4kg 6mtr 70001838")).click();
		Thread.sleep(3000);

		// Get Screen size
		Dimension size = driver.manage().window().getSize();

		// find the position where you need to touch
		int startX = size.getWidth() / 2;
		int startY = size.getHeight() / 2;

		// position till you want to move your finger to swipe
		int endX = startX;
		int endY = (int) (size.getHeight() * 0.25);

		Thread.sleep(5000);

		// PointerInput class to create a sequence of actions
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

		// Sequence object, which is a list of actions that will be performed on the
		// device
		Sequence sequence = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(200))) // wait for some time
				.addAction(
						finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
				.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		// perform the Sequence of action
		driver.perform(Collections.singletonList(sequence));
		Thread.sleep(5000);

		// click sales
		driver.findElement(ByAccessibilityId.accessibilityId("DropDownCard_DropDown")).click();
		Thread.sleep(5000);

		// Get Screen size
		Dimension size1 = driver.manage().window().getSize();

		// find the position where you need to touch
		int startX1 = size1.getWidth() / 2;
		int startY1 = size1.getHeight() / 2;

		// position till you want to move your finger to swipe
		int endX1 = startX1;
		int endY1 = (int) (size1.getHeight() * 0.25);

		Thread.sleep(5000);

		// PointerInput class to create a sequence of actions
		PointerInput finger11 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

		// Sequence object, which is a list of actions that will be performed on the
		// device
		Sequence sequence1 = new Sequence(finger11, 1)
				.addAction(finger11.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX1, startY1))
				.addAction(finger11.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger11, Duration.ofMillis(200))) // wait for some time
				.addAction(finger11.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX1,
						endY1))
				.addAction(finger11.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		// perform the Sequence of action
		driver.perform(Collections.singletonList(sequence1));
		Thread.sleep(5000);

		// click voucher 27 aug 2024
		driver.findElement(ByAccessibilityId.accessibilityId("Item 1 of 3")).click();
		Thread.sleep(3000);

		// click download
		driver.findElement(ByAccessibilityId.accessibilityId("InvoicePage_DownloadButton")).click();
		Thread.sleep(3000);

		// click save
		driver.findElement(By.id("com.android.printspooler:id/print")).click();
		Thread.sleep(3000);

		// click save in file
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(3000);

		System.out.println("Voucher Pdf save successfully");
		Thread.sleep(4000);
		driver.quit();
	}

}