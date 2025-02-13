package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy.ByAccessibilityId;
import io.appium.java_client.android.AndroidDriver;

public class LogOutFromCompanyPage {
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

                // click acvtive company
                driver.findElement(ByAccessibilityId
                                .accessibilityId("Navigate to Tally Companies and clear previously selected company"))
                                .click();
                Thread.sleep(3000);

                // click topbar logout
                driver.findElement(ByAccessibilityId.accessibilityId("Logout Button")).click();
                Thread.sleep(5000);

                System.out.println("Logout successfully");
                Thread.sleep(4000);
                driver.quit();
        }

}