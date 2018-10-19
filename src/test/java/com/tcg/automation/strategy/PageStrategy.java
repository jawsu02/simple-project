package com.tcg.automation.strategy;

import org.springframework.stereotype.Component;

/**
 * Created by rajkumar.engu on 01/02/18.
 */
@Component
public interface PageStrategy {

    // LAUNCH
    public void waitUntilAppIsReady();

    //    LOGIN
    public void navigateToLogin();

    public void navigateToForgotDetails();

    public void navigateToRegisterWithPP();

    public void navigateToJoinPP();

    public void login(String userName, String password);

    public void loginErrorShouldBeDisplayed();

    public void userShouldBeLoggedIn();

    public void userShouldBeLoggedInFromAccount();

    public void tapToRevealPassword();

    public void inputDataIntoPasswordField(String textToInput);

    public void verifyValueInPasswordFieldIs(String valueToCompare);

    //    HOME
    public void loginFromHome(String userName, String password);

    public void navigateToQuickSearch();

    //    DMC
    public void addToWallet();

    public void dmcQrCodeShouldBeDisplayed();

    //    ACCOUNT
    public void loginFromAccount(String userName, String password);

    public void userShouldBeLoggedOutAndOnAccountScreen();

    public void logoutUser();

    public void navigateToTermsOfUse();

    public void navigateToTermsAndConditions();

    public void navigateToPrivacyPolicy();

    public void navigateToLanguageSettings();

    public void navigateToVisitHistory();

    public void accountTabShouldBeCorrectlyDisplayed();

    // RTA
    public void rtaShouldBeDisplayed();

    public void rtaShouldNotBeDisplayed();

    public void memberOnlyEntitlementsShouldBeDisplayed();

    public void infiniteMemberEntitlementsShouldBeDisplayed();

    //    TAB
    public void navigateToHome();

    public void navigateToHelp();

    public void navigateToDMC();

    public void navigateToAccount();

    public void accountTabShouldBeDisplayed();

    public void helpTabShouldBeDisplayed();

    public void homeTabShouldBeDisplayed();

    public void cardTabShouldBeDisplayed();

    public void cardTabShouldNotBeDisplayed();

    //    HELP
    public void switchToFAQ();

    public void switchToContactUs();

    public void areFAQSDisplayed();

    public void contactUsShouldBeDisplayed();

    // TERMS OF USE
    public void termsAndConditionsShouldBeDisplayed();

    // PRIVACY POLICY
    public void privacyPolicyShouldBeDisplayed();

    // CHANGE LANGUAGE
    public void allLanguagesShouldBeDisplayed();

    // PP Registration
    public void PPRegistrationShouldBeDisplayed();

    // JOIN PP
    public void joinPPShouldBeDisplayed();

    // FORGOT DETAILS
    public void forgotDetailsShouldBeDisplayed();

    // VISIT HISTORY
    public void visitHistoryShouldBeDisplayed();

    public void tapOnVisitWithLoungeName(String loungeName);

    // QUICK SEARCH
    public void inputTextInQuickSearch(String searchText);

    public void searchBoxShouldBeDisplayed();

    public void noMatchingAirportsShouldBeDisplayed();

    // AIRPORT LIST
    public void selectAirportFromList(int airportNo);

    // TERMINAL LIST
    public void verifyTerminalsDisplayed(int terminals);

    public void selectTerminalFromList(int terminalNo);

    // Lounge And Offers List
    public void onlyLoungesShouldBeDisplayed();

    public void loungesAndOffersShouldBeDisplayed();

    // Lounge Details
    public void loungeDetailsScreenShouldBeDisplayed();

    public void loungeInformationShouldBeDisplayed();

    // Offer Details
    public void verifyOfferInformationIsDisplayed();

    public void tapOnRedeemOffer();

    public void verifyGeneratedOfferDetailsDisplayed();

    public void offerRedemptionQRCodeShouldBeDisplayed();

    public void tapOnViewAllLounges();

    public void tapOnViewAllRetailOffers();

    public void tapOnViewAllDiningOffers();

    public void selectOfferFromList(int offerNo);

    public void resetApp();
}
