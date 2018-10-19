package com.tcg.automation.config;

import com.tcg.automation.session.SessionVariablesApp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.FactoryBean;

public class WebDriverFactory implements FactoryBean<WebDriver> {

    private final WebDriver driver;

    public WebDriverFactory(SessionVariablesApp sessionVariablesApp) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/com/tcg/automation/builds/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to(sessionVariablesApp.getWebUrl());
    }

    @Override
    public WebDriver getObject() throws Exception {
        return driver;
    }

    @Override
    public Class<?> getObjectType() {
        return WebDriver.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
