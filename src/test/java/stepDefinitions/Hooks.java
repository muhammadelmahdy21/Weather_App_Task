package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import utilities.AppInitialization;
import utilities.AppiumServerManager;

import java.net.MalformedURLException;

public class Hooks {

    @Before
    public void startServer() {
        AppiumServerManager.startServer();
    }

    @Given("the app is launched")
    public void appIsLaunched() throws MalformedURLException {

        AppInitialization.openApp();
    }

//    @And("the app is closed")
//    public void appIsClosed()
//    {
//        AppInitialization.closeApp();
//    }

    @After
    public void stopServer() {
        AppiumServerManager.stopServer();
    }
}
