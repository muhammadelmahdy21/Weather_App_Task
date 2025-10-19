package tests;

import assertions.Assertions;
import org.testng.annotations.*;
import pages.dashboardPages.HomePage;
import pages.settingPage.SettingPage;
import utilities.AppInitialization;
import utilities.AppiumServerManager;

import java.net.MalformedURLException;

public class ChangeTemperatureUnitTest {

    Assertions assertionsObject;
    HomePage homePageObject;
    SettingPage settingPageObject;

    @BeforeTest
    void setUp() throws MalformedURLException {

        AppiumServerManager.startServer();
        AppInitialization.openApp();

        homePageObject = new HomePage();
        settingPageObject = new SettingPage();
        assertionsObject = new Assertions();
    }

    @Test
    void changeTemperatureUnitToFahrenheit() {
        homePageObject.clickHamburgerMenu();
        homePageObject.clickUnitSetting();
        settingPageObject.clickTemperatureMenu();
        settingPageObject.selectTemperatureUnit("F");
        String selectedTemperatureUnit = "°"+settingPageObject.validateTemperatureUnit();
        settingPageObject.clickDoneButton();
        assertionsObject.assertCompare(homePageObject.validateTemperatureUnit(), selectedTemperatureUnit);
    }

    @AfterTest
    void tearDown(){
        AppInitialization.closeApp();
        AppiumServerManager.stopServer();
    }
}
