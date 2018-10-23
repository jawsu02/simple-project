package com.myo2.automation.stepDefinitions.App;

import com.myo2.automation.session.SessionVariablesApp;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class OfferStep {
    @Autowired
    SessionVariablesApp sessionVariablesApp;

    @When("^i choose to view all (.*)")
    public void iChooseToViewAllOffers(String context) throws Throwable {

        switch (context.toUpperCase()) {
            case "LOUNGES":
                sessionVariablesApp.getDriver().tapOnViewAllLounges();
                break;
            case "DINING_OFFERS":
                sessionVariablesApp.getDriver().tapOnViewAllDiningOffers();
                break;
            case "RETAIL_OFFERS":
                sessionVariablesApp.getDriver().tapOnViewAllRetailOffers();
                break;
        }
    }

    @And("^i select result (\\d+) in offers$")
    public void iSelectResultInOffers(int offerNo) throws Throwable {
        sessionVariablesApp.getDriver().selectOfferFromList(offerNo);
    }
}
