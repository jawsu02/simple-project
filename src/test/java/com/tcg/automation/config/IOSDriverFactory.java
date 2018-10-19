package com.tcg.automation.config;

import com.tcg.automation.session.SessionVariablesApp;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.FactoryBean;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by rajkumar.engu on 05/02/18.
 */

public class IOSDriverFactory implements FactoryBean<IOSDriver> {

    private final IOSDriver driver;

    public IOSDriverFactory(SessionVariablesApp sessionVariablesApp) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("realDeviceLogger", "idevicesyslog");

        if (System.getProperty("REAL_DEVICE").equals("TRUE")) {
            // DUE TO CASE SENSITIVE CONTENT-MD5 CHECK IN IOS
            capabilities.setCapability("app",
                    System.getProperty("BACKEND") == null
                            ? sessionVariablesApp.getAppIOSDevicePath().replace("ENV", "UAT")
                            : sessionVariablesApp.getAppIOSDevicePath().replace("ENV", System.getProperty("BACKEND").toUpperCase()));
            capabilities.setCapability("udid", sessionVariablesApp.getIosUdid());
            capabilities.setCapability("platformVersion", sessionVariablesApp.getIosOs());
            capabilities.setCapability("deviceName", "iPhone 7");
            capabilities.setCapability("xcodeOrgId", "9S452ZZ2W5");
            capabilities.setCapability("xcodeSigningId", "iPhone Developer");
        } else {
            // DUE TO CASE SENSITIVE CONTENT-MD5 CHECK IN IOS
            capabilities.setCapability("app",
                    System.getProperty("BACKEND") == null
                            ? sessionVariablesApp.getAppIOSSimulatorPath().replace("ENV", "UAT")
                            : sessionVariablesApp.getAppIOSSimulatorPath().replace("ENV", System.getProperty("BACKEND").toUpperCase()));
            capabilities.setCapability("platformVersion", "11.2");
            capabilities.setCapability("deviceName", "iPhone 7");
        }

        URL url = null;
        try {
            url = new URL("http://0.0.0.0:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        this.driver = new IOSDriver(url, capabilities);
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IOSDriver getObject() throws Exception {
        return driver;
    }

    @Override
    public Class<?> getObjectType() {
        return IOSDriver.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}