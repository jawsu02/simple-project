package com.myo2.automation.pages.web;

import com.myo2.automation.strategy.PageStrategy;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

@Component("WEB")
public class WebPageStrategy implements PageStrategy {
    @Autowired
    @Lazy
    WebHomePage webHomePage;

    @Autowired
    @Lazy
    WebLoginPage webLoginPage;

    @Autowired
    @Lazy
    WebAccountPage webAccountPage;

    @Autowired
    @Lazy
    WebForgottenDetailsPage webForgottenDetailsPage;

    @Autowired
    @Lazy
    WebRegisterWithPriorityPassPage webRegisterWithPriorityPassPage;

    @Autowired
    @Lazy
    WebJoinPriorityPassPage webJoinPriorityPassPage;

    @Override
    public void waitUntilAppIsReady() {
        webHomePage.waitUntilQuickSearchIsDisplayed();
    }

    @Override
    public void navigateToLogin() {
        webHomePage.tapLoginButton();
        webLoginPage.clickLoginUsingUserName();
    }

    @Override
    public void navigateToForgotDetails() {
        webLoginPage.tapOnForgotDetails();
    }

    @Override
    public void navigateToRegisterWithPP() {
        webLoginPage.tapOnRegisterHere();
    }

    @Override
    public void navigateToJoinPP() {
        webLoginPage.tapOnJoinPP();
    }

    @Override
    public void login(String userName, String password) {

    }

    @Override
    public void loginErrorShouldBeDisplayed() {
        webLoginPage.waitForJSandJQueryToLoad();
        assertTrue("Error relating to Login is not displayed", webLoginPage.isTextDisplayed("There was a problem accessing your account. Please check your username and password."));
    }

    @Override
    public void userShouldBeLoggedIn() {
        webLoginPage.waitForJSandJQueryToLoad();
        assertTrue("User is not logged in where expected to login", webHomePage.isTextDisplayed("Welcome to your account,"));
    }

    @Override
    public void userShouldBeLoggedInFromAccount() {

    }

    @Override
    public void tapToRevealPassword() {

    }

    @Override
    public void inputDataIntoPasswordField(String textToInput) {

    }

    @Override
    public void verifyValueInPasswordFieldIs(String valueToCompare) {

    }

    @Override
    public void loginFromHome(String userName, String password) {
        webHomePage.tapLoginButton();
        webLoginPage.clickLoginUsingUserName();
        webLoginPage.login(userName, password);
    }

    @Override
    public void navigateToQuickSearch() {

    }

    @Override
    public void addToWallet() {

    }

    @Override
    public void dmcQrCodeShouldBeDisplayed() {

    }

    @Override
    public void loginFromAccount(String userName, String password) {

    }

    @Override
    public void userShouldBeLoggedOutAndOnAccountScreen() {

    }

    @Override
    public void logoutUser() {

    }

    @Override
    public void navigateToTermsOfUse() {

    }

    @Override
    public void navigateToTermsAndConditions() {

    }

    @Override
    public void navigateToPrivacyPolicy() {

    }

    @Override
    public void navigateToLanguageSettings() {

    }

    @Override
    public void navigateToVisitHistory() {

    }

    @Override
    public void accountTabShouldBeCorrectlyDisplayed() {

    }

    @Override
    public void rtaShouldBeDisplayed() {

    }

    @Override
    public void rtaShouldNotBeDisplayed() {

    }

    @Override
    public void memberOnlyEntitlementsShouldBeDisplayed() {

    }

    @Override
    public void infiniteMemberEntitlementsShouldBeDisplayed() {

    }

    @Override
    public void navigateToHome() {
        webHomePage.navigateToHome();
    }

    @Override
    public void navigateToHelp() {

    }

    @Override
    public void navigateToDMC() {

    }

    @Override
    public void navigateToAccount() {

    }

    @Override
    public void accountTabShouldBeDisplayed() {

    }

    @Override
    public void helpTabShouldBeDisplayed() {

    }

    @Override
    public void homeTabShouldBeDisplayed() {

    }

    @Override
    public void cardTabShouldBeDisplayed() {

    }

    @Override
    public void cardTabShouldNotBeDisplayed() {

    }

    @Override
    public void switchToFAQ() {

    }

    @Override
    public void switchToContactUs() {

    }

    @Override
    public void areFAQSDisplayed() {

    }

    @Override
    public void contactUsShouldBeDisplayed() {

    }

    @Override
    public void termsAndConditionsShouldBeDisplayed() {

    }

    @Override
    public void privacyPolicyShouldBeDisplayed() {

    }

    @Override
    public void allLanguagesShouldBeDisplayed() {

    }

    @Override
    public void PPRegistrationShouldBeDisplayed() {
        assertTrue("PP Registration is not displayed when expected", webRegisterWithPriorityPassPage.isRegisterWithPriorityPassDisplayed());
    }

    @Override
    public void joinPPShouldBeDisplayed() {
        assertTrue("JOIN PP is not displayed when expected", webJoinPriorityPassPage.isJoinPPHeaderDisplayed());

    }

    @Override
    public void forgotDetailsShouldBeDisplayed() {
        assertTrue("Forogt Details is not displayed when expected", webForgottenDetailsPage.isForgottenDetailsDisplayed());
    }

    @Override
    public void visitHistoryShouldBeDisplayed() {

    }

    @Override
    public void tapOnVisitWithLoungeName(String loungeName) {

    }

    @Override
    public void inputTextInQuickSearch(String searchText) {

    }

    @Override
    public void searchBoxShouldBeDisplayed() {

    }

    @Override
    public void noMatchingAirportsShouldBeDisplayed() {

    }

    @Override
    public void selectAirportFromList(int airportNo) {

    }

    @Override
    public void verifyTerminalsDisplayed(int terminals) {

    }

    @Override
    public void selectTerminalFromList(int terminalNo) {

    }

    @Override
    public void onlyLoungesShouldBeDisplayed() {

    }

    @Override
    public void loungesAndOffersShouldBeDisplayed() {

    }

    @Override
    public void loungeDetailsScreenShouldBeDisplayed() {

    }

    @Override
    public void loungeInformationShouldBeDisplayed() {

    }

    @Override
    public void verifyOfferInformationIsDisplayed() {

    }

    @Override
    public void tapOnRedeemOffer() {

    }

    @Override
    public void verifyGeneratedOfferDetailsDisplayed() {

    }

    @Override
    public void offerRedemptionQRCodeShouldBeDisplayed() {

    }

    @Override
    public void tapOnViewAllLounges() {

    }

    @Override
    public void tapOnViewAllRetailOffers() {

    }

    @Override
    public void tapOnViewAllDiningOffers() {

    }

    @Override
    public void selectOfferFromList(int offerNo) {

    }

    @Override
    public void resetApp() {
        webHomePage.reset();
    }
}
