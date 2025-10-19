package pages.settingPage;

import org.openqa.selenium.By;
import utilities.Actions;

public class SettingPage extends Actions {

    By temperatureMenu = By.xpath("//android.widget.ImageView[@resource-id=\"com.info.weather.forecast:id/iv_temp_dropdown\"]");
    By timeFormatMenu = By.xpath("//android.widget.ImageView[@resource-id=\"com.info.weather.forecast:id/iv_timeformat_dropdown\"]");
    By doneButton = By.xpath("//android.widget.TextView[@text=\"DONE\"]");
    By temperatureSetting = By.xpath("//android.widget.TextView[contains(@text, 'C') or contains(@text, 'F')]");
    By timeFormatSetting = By.xpath("//android.widget.TextView[contains(@text, '12 Hour') or contains(@text, '24 Hour')]");
    By temperatureSelected = By.xpath("//android.widget.TextView[@resource-id=\"com.info.weather.forecast:id/tv_temp_setting\"]");
    By timeFormatSelected = By.xpath("//android.widget.TextView[@resource-id=\"com.info.weather.forecast:id/tv_timeformat_setting\"]");

    public void clickTemperatureMenu() {
        click(temperatureMenu);
    }

    public void selectTemperatureUnit(String unit) {
        selectByText(temperatureSetting, unit);
    }

    public String validateTemperatureUnit()
    {
        return getTextFromLocator(temperatureSelected);
    }

    public void clickTimeFormatMenu() {
        click(timeFormatMenu);
    }

    public void selectTimeFormat(String timeFormat)
    {
        selectByText(timeFormatSetting, timeFormat);
    }

    public String validateTimeFormat()
    {
        return getTextFromLocator(timeFormatSelected);
    }

    public void clickDoneButton() {
        click(doneButton);
    }
}