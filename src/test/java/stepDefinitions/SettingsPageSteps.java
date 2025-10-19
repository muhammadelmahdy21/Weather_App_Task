package stepDefinitions;

import io.cucumber.java.en.And;
import pages.settingPage.SettingPage;
import utilities.TestContext;

public class SettingsPageSteps {

    SettingPage settingPageObject = new SettingPage();

    @And("I change temperature unit to {string}")
    public void changeTemperatureUnit(String temperatureUnit)
    {
        settingPageObject.clickTemperatureMenu();
        settingPageObject.selectTemperatureUnit(temperatureUnit);

        TestContext.selectedTemperatureUnit = "°"+settingPageObject.validateTemperatureUnit();
    }

    @And("I change time format to {string}")
    public void changeTimeFormat(String timeFormat) {
        settingPageObject.clickTimeFormatMenu();
        settingPageObject.selectTimeFormat(timeFormat);

        TestContext.selectedTimeFormat = settingPageObject.validateTimeFormat();
    }

    @And("I click Done button")
    public void clickDone()
    {
        settingPageObject.clickDoneButton();
    }
}
