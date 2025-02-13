package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class ApkInstall {

    public static void main(String[] args) throws MalformedURLException {
        // Desired Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Use the appium: prefix for W3C capabilities
        capabilities.setCapability("appium:deviceName", "Phone API");
        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:platformVersion", "13");
        capabilities.setCapability("appium:app", "C:\\work\\base.apk");

        // URL of the Appium server
        URL url = URI.create("http://192.168.1.34:4723").toURL();

        // Initialize AndroidDriver
        AndroidDriver driver = new AndroidDriver(url, capabilities);
        System.out.println("Application Started");

        // Quit the driver
        driver.quit();
    }
}
