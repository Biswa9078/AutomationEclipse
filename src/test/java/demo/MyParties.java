package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy.ByAccessibilityId;
import io.appium.java_client.android.AndroidDriver;

public class MyParties {
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
        .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    // perform the Sequence of action
    driver.perform(Collections.singletonList(sequence));

    // click MyParties
    driver.findElement(ByAccessibilityId.accessibilityId("Text_My Parties")).click();
    Thread.sleep(3000);

    System.out.println("Parties page open successfully1");
    Thread.sleep(4000);
    driver.quit();

  }
}
