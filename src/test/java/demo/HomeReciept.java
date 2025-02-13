package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy.ByAccessibilityId;
import io.appium.java_client.android.AndroidDriver;

public class HomeReciept {
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

                // click Receipt
                driver.findElement(ByAccessibilityId.accessibilityId("DashboardTile_Receipt_Item")).click();
                Thread.sleep(3000);

                // click Ledger(Akash Mohapatra)
                driver.findElement(ByAccessibilityId.accessibilityId("DashBoardView_Akash  Mohapatra")).click();
                Thread.sleep(5000);

                // click voucher
                driver.findElement(ByAccessibilityId.accessibilityId("Inner container")).click();
                Thread.sleep(5000);

                // click download
                driver.findElement(ByAccessibilityId.accessibilityId("InvoicePage_DownloadButton")).click();
                Thread.sleep(5000);

                // save
                driver.findElement(By.id("com.android.printspooler:id/print")).click();
                Thread.sleep(5000);

                // save
                driver.findElement(By.id("android:id/button1")).click();
                Thread.sleep(2000);

                System.out.println("Pdf Saved to phone Successfully");
                Thread.sleep(4000);
                driver.quit();

        }

}