package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy.ByAccessibilityId;
import io.appium.java_client.android.AndroidDriver;

public class ReportExpen {
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

      // Expenses
      driver.findElement(ByAccessibilityId.accessibilityId("Text_Expenses")).click();
      Thread.sleep(3000);

      // Indirect Expenses
      driver.findElement(ByAccessibilityId.accessibilityId("Expenses_IndirectExpenses")).click();
      Thread.sleep(5000);

      // Bank Charges
      driver.findElement(ByAccessibilityId.accessibilityId("Expenses_Bank Charges_Item")).click();
      Thread.sleep(5000);

      // sales dropdown
      driver.findElement(ByAccessibilityId.accessibilityId("DropDownCard_DropDown")).click();
      Thread.sleep(5000);

      // view more
      driver.findElement(ByAccessibilityId.accessibilityId("DropDownCard_ViewMoreButton")).click();
      Thread.sleep(5000);

      // click on voucher
      driver.findElement(ByAccessibilityId.accessibilityId("13 Jun 2024, sal-vJK5020E, ₹ , 21, 546")).click();
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
