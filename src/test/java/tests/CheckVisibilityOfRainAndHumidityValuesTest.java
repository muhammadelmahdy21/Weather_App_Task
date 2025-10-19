package tests;

import assertions.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.dashboardPages.HomePage;
import pages.settingPage.SettingPage;
import utilities.AppInitialization;
import utilities.AppiumServerManager;
import java.net.MalformedURLException;

public class CheckVisibilityOfRainAndHumidityValuesTest {

    Assertions assertionsObject;
    HomePage homePageObject;
    SettingPage settingPageObject;

    @BeforeMethod
    void setUp() throws MalformedURLException {

        AppiumServerManager.startServer();
        AppInitialization.openApp();

        homePageObject = new HomePage();
        settingPageObject = new SettingPage();
        assertionsObject = new Assertions();
    }

    @Test
    void checkVisibilityOfRainAndHumidityValuesTest() {
        assertionsObject.assertElementExist(homePageObject.validateRainAndHumidityForNext6Hours());
    }

    @AfterMethod
    void tearDown() {
        AppInitialization.closeApp();
        AppiumServerManager.stopServer();
    }
}

