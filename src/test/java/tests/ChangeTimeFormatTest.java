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

public class ChangeTimeFormatTest {

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
    void changeTimeFormatToTwelveHours() {
        homePageObject.clickHamburgerMenu();
        homePageObject.clickUnitSetting();
        settingPageObject.clickTimeFormatMenu();
        settingPageObject.selectTimeFormat("24 Hour");
        String selectedTimeFormat = settingPageObject.validateTimeFormat();
        settingPageObject.clickDoneButton();
        assertionsObject.assertCompare(homePageObject.validateTimeFormat(), selectedTimeFormat);
    }

    @AfterMethod
    void tearDown(){
        AppInitialization.closeApp();
        AppiumServerManager.stopServer();
    }
}
