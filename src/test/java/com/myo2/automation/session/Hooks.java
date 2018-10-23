package com.myo2.automation.session;

import com.myo2.automation.strategy.PageStrategy;
import com.myo2.automation.utils.MockUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import javax.annotation.Resource;


public class Hooks {

    @Autowired
    private SessionVariablesApp sessionVariablesApp;

    @Autowired
    private MockUtils mockUtils;

    @Resource(name = "IOS")
    PageStrategy iosPageStrategy;

    @Resource(name = "ANDROID")
    PageStrategy androidPageStrategy;

    @Resource(name = "WEB")
    PageStrategy webPageStrategy;

    @Before("@App or @Web")
    public void beforeApp() {
        switch (System.getProperty("PLATFORM").toUpperCase()) {
            case "IOS":
                sessionVariablesApp.setDriver(iosPageStrategy);
                sessionVariablesApp.setMockPath(sessionVariablesApp.getIosMockHost());
                break;
            case "ANDROID":
                sessionVariablesApp.setDriver(androidPageStrategy);
                sessionVariablesApp.setMockPath(sessionVariablesApp.getAndroidMockHost());
                break;
            case "WEB":
                sessionVariablesApp.setDriver(webPageStrategy);
                break;
        }
    }

    @After("@App")
    public void afterApp() {
        if (!System.getProperty("PLATFORM").toUpperCase().contains("WEB")) {
            mockUtils.resetMappings();
            sessionVariablesApp.getDriver().resetApp();
        }
    }
}
