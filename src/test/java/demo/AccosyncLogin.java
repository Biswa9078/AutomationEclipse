package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumBy.ByAccessibilityId;
import io.appium.java_client.android.AndroidDriver;

public class AccosyncLogin {

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

        // login page

        WebElement usernameField = driver.findElement(ByAccessibilityId.accessibilityId("LoginEmail_emailTextInput"));
        usernameField.sendKeys("nnsahu2022@gmail.com");

        WebElement passwordField = driver
                .findElement(ByAccessibilityId.accessibilityId("LoginEmail_passwordTextInput"));
        passwordField.sendKeys("Rahulis1@");

        Thread.sleep(3000);

        // next

        driver.findElement(ByAccessibilityId.accessibilityId("LoginEmail_NextButton")).click();

        Thread.sleep(4000);

        // phone number page

        WebElement phonenumberField = driver
                .findElement(ByAccessibilityId.accessibilityId("LoginPhone_PhoneNumberTextInput"));
        phonenumberField.sendKeys("9556609926");

        WebElement submitButton11 = driver
                .findElement(ByAccessibilityId.accessibilityId("LoginPhone_VerifyPhoneNumberButton"));
        submitButton11.click();

        Thread.sleep(6000);

        // skip part

        Thread.sleep(5000);

        // WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        // WebElement skipButton =
        // wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='SKIP']")));
        // skipButton.click();

        System.out.println("Login Successfully");
        Thread.sleep(4000);
        driver.quit();

    }
}