package utilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import java.io.File;

public class AppiumServerManager {
    private static AppiumDriverLocalService service;

    public static void startServer() {

        service = new AppiumServiceBuilder()
                .usingDriverExecutable(new File(ConfigReader.getProperty("node.path")))
                .withAppiumJS(new File(ConfigReader.getProperty("appium.main.js.path")))
                .withIPAddress(ConfigReader.getProperty("ipaddress"))
                .usingPort(Integer.parseInt(ConfigReader.getProperty("port")))
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                .build();

        service.start();
        System.out.println("✅ Appium Server Started on: " + service.getUrl());
    }

    public static void stopServer() {
        if (service != null) {
            service.stop();
            System.out.println("🛑 Appium Server Stopped");
        }
    }

    public static boolean isServerRunning() {
        return service != null && service.isRunning();
    }
}