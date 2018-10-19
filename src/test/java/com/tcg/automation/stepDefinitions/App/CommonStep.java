package com.tcg.automation.stepDefinitions.App;

import com.tcg.automation.session.SessionVariablesApp;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonStep {
    @Autowired
    private SessionVariablesApp sessionVariablesApp;

    @Given("^i am on (.*) screen$")
    public void presentOnScreen(String screenName) throws Throwable {

        switch (screenName.toUpperCase()) {
            case "LOGIN":
                sessionVariablesApp.getDriver().navigateToLogin();
                break;
            case "HOME":
                sessionVariablesApp.getDriver().navigateToHome();
                break;
            case "QUICK_SEARCH":
                sessionVariablesApp.getDriver().navigateToQuickSearch();
                break;
        }
    }

    @Given("^i launch the app$")
    public void iLaunchTheApp() throws Throwable {
        sessionVariablesApp.getDriver().waitUntilAppIsReady();
    }


    @When("^i navigate to (.*) tab$")
    public void navigateToTab(String tab) throws Throwable {
        switch (tab.toUpperCase()) {
            case "DMC":
                sessionVariablesApp.getDriver().navigateToDMC();
                break;
            case "ACCOUNT":
                sessionVariablesApp.getDriver().navigateToAccount();
                break;
            case "HELP":
                sessionVariablesApp.getDriver().navigateToHelp();
                break;
            case "HOME":
                sessionVariablesApp.getDriver().navigateToHome();
                break;
        }
    }

    @And("^(.*) tab should not be displayed$")
    public void tabNotDisplayed(String tab) throws Throwable {

        switch (tab.toUpperCase()) {
            case "DMC":
                sessionVariablesApp.getDriver().cardTabShouldNotBeDisplayed();
                break;
        }
    }

    @And("^i switch to (.*)$")
    public void switchTo(String context) throws Throwable {
        switch (context.toUpperCase()) {
            case "CONTACTUS":
                sessionVariablesApp.getDriver().switchToContactUs();
                break;
            case "FAQS":
            case "FAQ":
                sessionVariablesApp.getDriver().switchToFAQ();
                break;
        }
    }

    @Then("^(.*) should be correctly displayed$")
    public void helpShouldBeCorrectlyDisplayed(String tab) throws Throwable {
        switch (tab.toUpperCase()) {
            case "CONTACTUS":
                sessionVariablesApp.getDriver().contactUsShouldBeDisplayed();
                break;
            case "FAQS":
                sessionVariablesApp.getDriver().areFAQSDisplayed();
                break;
            case "ACCOUNT":
                sessionVariablesApp.getDriver().accountTabShouldBeCorrectlyDisplayed();
                break;
            case "VISITHISTORY":
                sessionVariablesApp.getDriver().visitHistoryShouldBeDisplayed();
                break;
            case "LANGUAGESETTINGS":
                sessionVariablesApp.getDriver().allLanguagesShouldBeDisplayed();
                break;
            case "PRIVACYPOLICY":
                sessionVariablesApp.getDriver().privacyPolicyShouldBeDisplayed();
                break;
            case "TERMSANDCONDITIONS":
                sessionVariablesApp.getDriver().termsAndConditionsShouldBeDisplayed();
                break;
            case "PP_REGISTRATION":
                sessionVariablesApp.getDriver().PPRegistrationShouldBeDisplayed();
                break;
            case "JOIN_PP":
                sessionVariablesApp.getDriver().joinPPShouldBeDisplayed();
                break;
            case "FORGOTDETAILS":
                sessionVariablesApp.getDriver().forgotDetailsShouldBeDisplayed();
                break;
            case "LOUNGE_INFORMATION":
                sessionVariablesApp.getDriver().loungeInformationShouldBeDisplayed();
                break;
            case "RTA":
                sessionVariablesApp.getDriver().rtaShouldBeDisplayed();
                break;
        }
    }

    @When("^i tap on (.*)")
    public void tapOnElement(String link) throws Throwable {
        switch (link.toUpperCase()) {
            case "QUICK_SEARCH":
                sessionVariablesApp.getDriver().navigateToQuickSearch();
                break;
            case "TERMSANDCONDITIONS":
                sessionVariablesApp.getDriver().navigateToTermsAndConditions();
                break;
            case "PRIVACYPOLICY":
                sessionVariablesApp.getDriver().navigateToPrivacyPolicy();
                break;
            case "LANGUAGESETTINGS":
                sessionVariablesApp.getDriver().navigateToLanguageSettings();
                break;
            case "VISITHISTORY":
                sessionVariablesApp.getDriver().navigateToVisitHistory();
                break;
            case "LOGOUT":
                sessionVariablesApp.getDriver().logoutUser();
                break;
            case "REGISTER":
                sessionVariablesApp.getDriver().navigateToRegisterWithPP();
                break;
            case "JOINPRIORITYPASS":
                sessionVariablesApp.getDriver().navigateToJoinPP();
                break;
            case "FORGOTDETAILS":
                sessionVariablesApp.getDriver().navigateToForgotDetails();
                break;
            case "REVEALPASSWORD":
                sessionVariablesApp.getDriver().tapToRevealPassword();
                break;
            case "REDEEM":
                sessionVariablesApp.getDriver().tapOnRedeemOffer();
                break;
        }
    }

    @Then("^(.*) screen should be displayed$")
    public void screenShouldBeDisplayed(String page) throws Throwable {
        switch (page) {
            case "LOUNGE_DETAILS":
                sessionVariablesApp.getDriver().loungeDetailsScreenShouldBeDisplayed();
                break;
            case "FIND_A_LOUNGE":
                sessionVariablesApp.getDriver().searchBoxShouldBeDisplayed();
                break;
        }
    }

    @Then("^i should see (.*)$")
    public void iShouldSee(String condition) throws Throwable {
        switch (condition.toUpperCase()) {
            case "LOUNGES_AND_OFFERS":
                sessionVariablesApp.getDriver().loungesAndOffersShouldBeDisplayed();
                break;
            case "LOUNGES_ONLY":
                sessionVariablesApp.getDriver().onlyLoungesShouldBeDisplayed();
                break;
            case "OFFER_INFORMATION":
                sessionVariablesApp.getDriver().verifyOfferInformationIsDisplayed();
                break;
            case "GENERATED_OFFER_DETAILS":
                sessionVariablesApp.getDriver().verifyGeneratedOfferDetailsDisplayed();
                break;
            case "QR_CODE":
                sessionVariablesApp.getDriver().offerRedemptionQRCodeShouldBeDisplayed();
                break;
            case "NO_MATCHING_AIRPORTS":
                sessionVariablesApp.getDriver().noMatchingAirportsShouldBeDisplayed();
                break;
        }
    }
}
