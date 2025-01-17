package com.myo2.automation.stepDefinitions.App;

import com.myo2.automation.session.SessionVariablesApp;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class VisitStep {
    @Autowired
    SessionVariablesApp sessionVariablesApp;

    @And("^i select visit containing lounge (.*)$")
    public void iSelectVisitContainingLoungeName(String loungeName) throws Throwable {
        sessionVariablesApp.getDriver().tapOnVisitWithLoungeName(loungeName);
    }
}
