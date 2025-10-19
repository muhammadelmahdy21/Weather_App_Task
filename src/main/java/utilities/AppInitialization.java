package utilities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class AppInitialization {

    public static AndroidDriver driver;

    public static void openApp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", ConfigReader.getProperty("platform.name"));
        caps.setCapability("appium:deviceName", ConfigReader.getProperty("device.name"));
        caps.setCapability("appium:automationName", ConfigReader.getProperty("automation.name"));
        caps.setCapability("appium:appPackage", ConfigReader.getProperty("app.package"));
        caps.setCapability("appium:appActivity", ConfigReader.getProperty("app.activity"));
        caps.setCapability("appium:noReset",ConfigReader.getProperty("no.reset"));
        caps.setCapability("appium:ignoreHiddenApiPolicyError", ConfigReader.getProperty("ignore.api.policy.error"));
//        caps.setCapability("appium:app", ConfigReader.getProperty("app.path"));

        driver = new AndroidDriver(new URL(ConfigReader.getProperty("appium.server.url")), caps);
    }

    public static void backToPreviousPage()
    {
        driver.navigate().back();
    }

    public static void refresh()
    {
        driver.navigate().refresh();
    }

    public static void closeApp()
    {
        if (driver != null) {
            driver.quit();
        }
    }
}
