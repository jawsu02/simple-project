package com.myo2.automation.stepDefinitions.App;

import com.myo2.automation.session.SessionVariablesApp;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;


public class AccountStep {
    @Autowired
    SessionVariablesApp sessionVariablesApp;

    @Then("^RTA should not be displayed$")
    public void rtaShouldNotBeDisplayed() throws Throwable {
        sessionVariablesApp.getDriver().rtaShouldNotBeDisplayed();
    }


    @Then("^(.*) entitlements should be displayed$")
    public void entitlementShouldBe(String entitlementType) throws Throwable {
        switch (entitlementType.toUpperCase()) {
            case "RTA_BOTH":
                sessionVariablesApp.getDriver().rtaShouldBeDisplayed();
                break;
            case "RTA_MEMBER_ONLY":
                sessionVariablesApp.getDriver().memberOnlyEntitlementsShouldBeDisplayed();
                break;
            case "RTA_INFINITE_MEMBER":
                sessionVariablesApp.getDriver().infiniteMemberEntitlementsShouldBeDisplayed();
                break;
        }
    }
}
