package pages.dashboardPages;

import org.openqa.selenium.By;
import utilities.Actions;

public class HomePage extends Actions {

    By hamburgerMenu = By.xpath("//android.widget.ImageView[@resource-id=\"com.info.weather.forecast:id/iv_bt_navigation_setting\"]");
    By unitSetting = By.xpath("//android.widget.LinearLayout[@resource-id=\"com.info.weather.forecast:id/ll_item_unit_setting\"]/android.widget.LinearLayout");
    By temperatureUnit = By.xpath("//android.widget.TextView[@resource-id=\"com.info.weather.forecast:id/tv_current_temper_unit\"]");
    By timeFormat = By.xpath("//android.widget.TextView[@resource-id=\"com.info.weather.forecast:id/tv_date\"]");
    By rainValue = By.xpath("(//android.widget.TextView[@resource-id=\"com.info.weather.forecast:id/tv_rain_chance\"])");
    By humidityValue = By.xpath("(//android.widget.TextView[@resource-id=\"com.info.weather.forecast:id/tv_humidity\"])");


    public void clickHamburgerMenu() {
        click(hamburgerMenu);
    }

    public void clickUnitSetting() {
        click(unitSetting);
    }

    public String validateTemperatureUnit() {
        return getTextFromLocator(temperatureUnit);
    }

    public String validateTimeFormat() {
        if(validateElementExistence(timeFormat) && (getTextFromLocator(timeFormat).contains("AM") || getTextFromLocator(timeFormat).contains("PM")))
        {
            return "12 Hour";
        }
        else
        {
            return "24 Hour";
        }
    }

    public boolean validateRainAndHumidityForNext6Hours() {

        swipeLeft(0.7, 0.6, 0.5);

        return validateElementsExistence(rainValue) && validateElementsExistence(humidityValue);
    }
}