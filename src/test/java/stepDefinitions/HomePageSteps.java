package stepDefinitions;

import assertions.Assertions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.dashboardPages.HomePage;
import utilities.TestContext;
public class HomePageSteps {

    HomePage homePageObject = new HomePage();
    Assertions assertionsObject = new Assertions();

    @When("I click Menu")
    public void clickMenu()
    {
        homePageObject.clickHamburgerMenu();
    }

    @And("I click Unit setting")
    public void clickSetting()
    {
        homePageObject.clickUnitSetting();
    }

    @Then("the temperature should be displayed")
    public void verifyTemperatureUnitIsDisplayed()
    {
        assertionsObject.assertCompare(homePageObject.validateTemperatureUnit(), TestContext.selectedTemperatureUnit);
    }

    @Then("the time should be displayed")
    public void verifyTimeFormatIsDisplayed() {
        assertionsObject.assertCompare(homePageObject.validateTimeFormat(), TestContext.selectedTimeFormat);
    }

    @Then("the rain and humidity values are displayed for the next 6 hours")
    public void verifyRainAndHumidityValuesAreDisplayed() {
        assertionsObject.assertElementExist(homePageObject.validateRainAndHumidityForNext6Hours());
    }
}
