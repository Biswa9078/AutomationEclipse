package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy.ByAccessibilityId;
import io.appium.java_client.android.AndroidDriver;

public class HomeItemSummaryCustomer {
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

    // click customer
    driver.findElement(ByAccessibilityId.accessibilityId("Customers icon")).click();
    Thread.sleep(3000);

    // click Order_Ledger
    driver
        .findElement(ByAccessibilityId
            .accessibilityId("Order_Ledger, Last Sale Date : 05 Aug 2024, Last Sale Rate :, ₹ , 915.70/Pcs, 12, Pcs"))
        .click();
    Thread.sleep(3000);

    // click Voucher
    driver.findElement(ByAccessibilityId.accessibilityId("sal-vch-48759, 5 Aug 2024 | Sales, Rate: 915.7, 12")).click();
    Thread.sleep(5000);

    // download

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