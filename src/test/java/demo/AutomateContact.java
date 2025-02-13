package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class AutomateContact {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // Desired Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Use the appium: prefix for W3C capabilities
        capabilities.setCapability("appium:deviceName", "Phone API");
        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:platformVersion", "13");

        capabilities.setCapability("appium:appPackage", "com.google.android.dialer");
        capabilities.setCapability("appium:appActivity",
                "com.google.android.dialer.extensions.GoogleDialtactsActivity");

        // URL of the Appium server
        URL url = URI.create("http://192.168.1.34:4723").toURL();

        // Initialize AndroidDriver
        AndroidDriver driver = new AndroidDriver(url, capabilities);
        Thread.sleep(5000);
        System.out.println("Application Started");

        // click dailpaid

        driver.findElement(By.id("com.google.android.dialer:id/dialpad_fab")).click();

        driver.findElement(By.id("com.google.android.dialer:id/nine")).click();
        driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
        driver.findElement(By.id("com.google.android.dialer:id/seven")).click();
        driver.findElement(By.id("com.google.android.dialer:id/eight")).click();
        driver.findElement(By.id("com.google.android.dialer:id/one")).click();
        driver.findElement(By.id("com.google.android.dialer:id/six")).click();
        driver.findElement(By.id("com.google.android.dialer:id/eight")).click();
        driver.findElement(By.id("com.google.android.dialer:id/three")).click();
        driver.findElement(By.id("com.google.android.dialer:id/three")).click();
        driver.findElement(By.id("com.google.android.dialer:id/zero")).click();

        //// android.widget.FrameLayout[@content-desc="Call"]

        driver.findElement(By.id("com.google.android.dialer:id/dialpad_voice_call_button")).click();

        // Quit the driver

        driver.quit();
    }
}