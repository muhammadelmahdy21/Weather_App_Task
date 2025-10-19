package utilities;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Actions extends AppInitialization {
    static final int DEFAULT_TIMEOUT = 10;

    public void click(By locator)
    {
        waitFor(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void click(By locator, String index)
    {
        waitFor(ExpectedConditions.elementToBeClickable(locator));
        driver.findElements(locator).get(Integer.parseInt(index)).click();
    }

    public void sendData(By locator, String data)
    {
        waitFor(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(data);
    }


    public void swipeLeft(double startRatio, double endRatio, double heightRatio) {
        Dimension size = driver.manage().window().getSize();

        int startX = (int) (size.width * startRatio);
        int endX = (int) (size.width * endRatio);
        int y = (int) (size.height * heightRatio);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, y))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipe));
    }

    public void swipeRight(double startRatio, double endRatio, double heightRatio) {
        Dimension size = driver.manage().window().getSize();

        int startX = (int) (size.width * startRatio);
        int endX = (int) (size.width * endRatio);
        int y = (int) (size.height * heightRatio);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, y))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipe));
    }

    public void scrollHorizontallyUntilElementVisible(String resourceId, int targetInstanceIndex) {
        String uiScrollableCommand = String.format(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".setAsHorizontalList()" + ".scrollForward()" +
                        ".scrollIntoView(new UiSelector().resourceId(\"%s\").instance(%d));",
                resourceId, targetInstanceIndex
        );

        driver.findElement(new AppiumBy.ByAndroidUIAutomator(uiScrollableCommand));
    }

    public void scrollVerticallyUntilElementVisible(String resourceId, int targetInstanceIndex) {
        String uiScrollableCommand = String.format(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceId(\"%s\").instance(%d));",
                resourceId, targetInstanceIndex
        );

        driver.findElement(new AppiumBy.ByAndroidUIAutomator(uiScrollableCommand));
    }

    public void selectByText(By locator, String text)
    {
        waitFor(ExpectedConditions.elementToBeClickable(locator));
        List<WebElement> elements = driver.findElements(locator);

        for(WebElement element : elements)
        {
            if(element.getText().contains(text))
            {
                element.click();
                return;
            }
        }
    }

    public void select(WebElement element, Object option)
    {
        waitFor(ExpectedConditions.elementToBeClickable(element));
        Select select = new Select(element);    //Works for Selenium <select> tag used for websites not for mobile apps

        if(option instanceof String)
        {
            select.selectByVisibleText((String) option);
        }
        else if(option instanceof Integer)
        {
            select.selectByIndex((Integer) option);
        }
    }

    public boolean validateElementExistence(By locator, String text)
    {
        waitFor(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);

        return element.getText().contains(text);
    }

    public boolean validateElementExistence(By locator)
    {
        waitFor(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator).isDisplayed();
    }

    public boolean validateElementsExistence(By locator)
    {
        waitFor(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> elements = driver.findElements(locator);

        for(WebElement element : elements)
        {
            if(!(element.isDisplayed()))
            {
                return false;
            }
        }
        return true;
    }

    public boolean validateElementExistenceInList(By locator, String text)
    {
        waitFor(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> elements = driver.findElements(locator);

        for(WebElement element : elements)
        {
            if(element.getText().equals(text))
            {
                return element.getText().equals(text);
            }
        }

        return false;
    }

    public String getTextFromLocator(By locator)
    {
        waitFor(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public String getString(By locator, String regex)
    {
        waitFor(ExpectedConditions.elementToBeClickable(locator));
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(driver.findElement(locator).getText());

        if(matcher.find())
        {
            return matcher.group(1);
        }
        return null;
    }

    public <T> void waitFor(ExpectedCondition<T> condition) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(condition);
    }
}
