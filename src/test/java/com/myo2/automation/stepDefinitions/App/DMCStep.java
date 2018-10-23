package com.myo2.automation.stepDefinitions.App;

import com.myo2.automation.session.SessionVariablesApp;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class DMCStep {
    @Autowired
    SessionVariablesApp sessionVariablesApp;

    @Then("^i can view my DMC$")
    public void iCanViewMyDMC() throws Throwable {
        sessionVariablesApp.getDriver().dmcQrCodeShouldBeDisplayed();
    }
}
