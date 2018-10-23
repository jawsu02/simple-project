package com.myo2.automation.config;

import com.myo2.automation.session.SessionVariablesApp;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.FactoryBean;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: ren06
 * Date: 12/05/16
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class AndroidDriverFactory implements FactoryBean<AndroidDriver> {

    private final AndroidDriver driver;

    public AndroidDriverFactory(SessionVariablesApp sessionVariablesApp) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app",
                System.getProperty("BACKEND") == null
                        ? sessionVariablesApp.getAppAndroidPath().replace("ENV", "UAT")
                        : sessionVariablesApp.getAppAndroidPath().replace("ENV", System.getProperty("BACKEND").toUpperCase()));
        capabilities.setCapability("appPackage", "com.tigerspike.prioritypass");
        capabilities.setCapability("appActivity", "com.prioritypass.app.ui.splash.SplashActivity");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "Appium");

        if (System.getProperty("REAL_DEVICE").equals("TRUE")) {
            capabilities.setCapability("deviceName", sessionVariablesApp.getAndroidDevice());
//            capabilities.setCapability("platformVersion", sessionVariablesApp.getAndroidOs());
        } else {
            capabilities.setCapability("deviceName", "Android Emulator");
            capabilities.setCapability("avd", "Nexus_6_API_26");
        }

        URL url = null;
        try {
            url = new URL("http://0.0.0.0:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        this.driver = new AndroidDriver(url, capabilities);
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AndroidDriver getObject() throws Exception {
        return driver;
    }

    @Override
    public Class<?> getObjectType() {
        return AndroidDriver.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
