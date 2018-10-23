package com.myo2.automation.stepDefinitions.App;

import com.myo2.automation.session.SessionVariablesApp;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class TabStep {
    @Autowired
    SessionVariablesApp sessionVariablesApp;

    @Then("^the bottom nav should have (.*) tab$")
    public void theBottomNavShouldHaveHOMETab(String tab) throws Throwable {
        switch (tab.toUpperCase()) {
            case "HOME":
                sessionVariablesApp.getDriver().homeTabShouldBeDisplayed();
                break;
            case "HELP":
                sessionVariablesApp.getDriver().helpTabShouldBeDisplayed();
                break;
            case "ACCOUNT":
                sessionVariablesApp.getDriver().accountTabShouldBeDisplayed();
                break;
            case "CARD":
                sessionVariablesApp.getDriver().cardTabShouldBeDisplayed();
                break;
        }
    }
}
