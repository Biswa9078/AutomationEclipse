package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy.ByAccessibilityId;
import io.appium.java_client.android.AndroidDriver;

public class HomeLedgerTopbarAddParty {
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

    // click Ledger
    driver.findElement(ByAccessibilityId.accessibilityId("Go to Ledgers Screen")).click();
    Thread.sleep(3000);

    // click create party button
    driver.findElement(ByAccessibilityId.accessibilityId("Parties_CreateParty")).click();
    Thread.sleep(3000);

    // gst number
    WebElement usernameField = driver.findElement(ByAccessibilityId.accessibilityId("GST Number input field"));
    usernameField.sendKeys("27ABABA0000B1Z5");
    Thread.sleep(2000);

    // name
    WebElement usernameField1 = driver.findElement(ByAccessibilityId.accessibilityId("Ledger Name"));
    usernameField1.sendKeys("Acoosy pvtLtd");
    Thread.sleep(2000);

    // select ledger group
    driver.findElement(ByAccessibilityId.accessibilityId("Dropdown to select ledger group")).click();
    Thread.sleep(2000);

    // sundary creditor
    driver.findElement(ByAccessibilityId.accessibilityId("Item Text: Sundry Creditors")).click();
    Thread.sleep(2000);

    // contact person name
    WebElement usernameField11 = driver.findElement(ByAccessibilityId.accessibilityId("Contact Person Name"));
    usernameField11.sendKeys("Rudrabhabani");
    Thread.sleep(2000);

    // adress
    WebElement usernameField111 = driver.findElement(ByAccessibilityId.accessibilityId("Address input field"));
    usernameField111.sendKeys("mig-16 cs pur");
    Thread.sleep(2000);

    // pincode
    WebElement usernameField1111 = driver.findElement(ByAccessibilityId.accessibilityId("Pincode input field"));
    usernameField1111.sendKeys("751307");
    Thread.sleep(2000);

    // country
    driver.findElement(ByAccessibilityId.accessibilityId("Dropdown to select country")).click();
    Thread.sleep(5000);

    // india
    driver.findElement(ByAccessibilityId.accessibilityId("Item Text: India")).click();
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
    Thread.sleep(5000);

    // state
    driver.findElement(ByAccessibilityId.accessibilityId("Dropdown to select state")).click();
    Thread.sleep(5000);

    // CG
    driver.findElement(ByAccessibilityId.accessibilityId("Item Text: Chandigarh")).click();
    Thread.sleep(2000);

    // Registration type
    driver.findElement(ByAccessibilityId.accessibilityId("Select a registration type from the list")).click();
    Thread.sleep(2000);

    // Regular
    driver.findElement(ByAccessibilityId.accessibilityId("Item Text: Regular")).click();
    Thread.sleep(2000);

    // credit limit
    WebElement usernameField11111 = driver.findElement(ByAccessibilityId.accessibilityId("Credit Limit Input"));
    usernameField11111.sendKeys("3000");
    Thread.sleep(5000);

    // creditperiod
    WebElement usernameField111111 = driver.findElement(ByAccessibilityId.accessibilityId("Credit Period Input"));
    usernameField111111.sendKeys("16");
    Thread.sleep(5000);

    // click create ledger button
    driver.findElement(ByAccessibilityId.accessibilityId("Create Ledger Button")).click();
    Thread.sleep(5000);

    System.out.println("Create Ledger successfully");
    Thread.sleep(4000);
    driver.quit();
  }

}