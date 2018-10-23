package com.myo2.automation.stepDefinitions.App;

import com.myo2.automation.session.SessionVariablesApp;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;


public class HomeStep {
    @Autowired
    private SessionVariablesApp sessionVariablesApp;

    @Then("^the login should succeed$")
    public void loginShouldSucceed() throws Throwable {
        sessionVariablesApp.getDriver().userShouldBeLoggedIn();
    }

    @Then("^the login should fail$")
    public void theLoginShouldFail() throws Throwable {
        sessionVariablesApp.getDriver().loginErrorShouldBeDisplayed();
    }
}
