package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy.ByAccessibilityId;
import io.appium.java_client.android.AndroidDriver;

public class ResetPass {
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

                // click burger menu
                driver.findElement(ByAccessibilityId.accessibilityId("Burger Menu")).click();
                Thread.sleep(3000);

                // click setting
                driver.findElement(ByAccessibilityId.accessibilityId("Icon for Settings")).click();
                Thread.sleep(3000);

                // click Reset Password
                driver.findElement(ByAccessibilityId.accessibilityId("Item_Reset Password")).click();
                Thread.sleep(5000);

                // old pass field
                WebElement usernameField = driver.findElement(ByAccessibilityId.accessibilityId("Old Password"));
                usernameField.sendKeys("Rahulis1@");

                // new pass field
                WebElement usernameField1 = driver.findElement(ByAccessibilityId.accessibilityId("New Password Input"));
                usernameField1.sendKeys("Rahulis1@");

                // confirm pass field
                WebElement usernameField2 = driver
                                .findElement(ByAccessibilityId.accessibilityId("Confirm Password Input"));
                usernameField2.sendKeys("Rahulis1@");

                // click Submit
                driver.findElement(ByAccessibilityId.accessibilityId("Change Password")).click();
                Thread.sleep(5000);

                System.out.println("passwordset successfully");
                Thread.sleep(4000);
                driver.quit();
        }

}