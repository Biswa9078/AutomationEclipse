package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumBy.ByAccessibilityId;
import io.appium.java_client.android.AndroidDriver;

public class AddItem {

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

        // click + icon
        driver.findElement(ByAccessibilityId.accessibilityId("Home_ClickPlusIcon")).click();
        Thread.sleep(5000);

        // click Add Item
        driver.findElement(ByAccessibilityId.accessibilityId("Add Item")).click();
        Thread.sleep(5000);

        // Click Stock Name
        WebElement usernameField1 = driver.findElement(ByAccessibilityId.accessibilityId("Stock Item Name1"));
        System.out.println(usernameField1.getTagName());
        usernameField1.sendKeys("Brick");

        // click Unit
        driver.findElement(ByAccessibilityId.accessibilityId("unit")).click();
        Thread.sleep(5000);

        // click Pcs
        driver.findElement(ByAccessibilityId.accessibilityId("Item Text: Pcs")).click();
        Thread.sleep(5000);

        // click Group
        driver.findElement(ByAccessibilityId.accessibilityId("Group")).click();
        Thread.sleep(5000);

        // click Alankar
        driver.findElement(ByAccessibilityId.accessibilityId("Item Text: Alankar")).click();
        Thread.sleep(5000);

        // Click Description
        WebElement usernameField11 = driver.findElement(ByAccessibilityId.accessibilityId("Description"));
        System.out.println(usernameField11.getTagName());
        usernameField11.sendKeys("Pack Carefully");

        // click Create item
        driver.findElement(ByAccessibilityId.accessibilityId("Create Item")).click();
        Thread.sleep(5000);

        System.out.println("Itemm Add Successfully");
        Thread.sleep(5000);
        driver.quit();

    }
}