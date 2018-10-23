package com.myo2.automation.pages.ios;

import com.myo2.automation.strategy.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@Component("IOS")
public class IOSPageStrategy implements PageStrategy {

    @Autowired
    @Lazy
    IOSMyCardPage iosMyCardPage;

    @Autowired
    @Lazy
    IOSLoginPage iosLoginPage;

    @Autowired
    @Lazy
    IOSTab iosTab;

    @Autowired
    @Lazy
    IOSAccountPage iosAccountPage;

    @Autowired
    @Lazy
    IOSHomePage iosHomePage;

    @Autowired
    @Lazy
    IOSHelpPage iosHelpPage;

    @Autowired
    @Lazy
    IOSTermsOfUsePage iosTermsOfUsePage;

    @Autowired
    @Lazy
    IOSPrivacyPolicyPage iosPrivacyPolicyPage;

    @Autowired
    @Lazy
    IOSChangeLanguagePage iosChangeLanguagePage;

    @Autowired
    @Lazy
    IOSForgottenDetailsPage iosForgottenDetailsPage;

    @Autowired
    @Lazy
    IOSJoinPriorityPassPage iosJoinPriorityPassPage;

    @Autowired
    @Lazy
    IOSRegisterWithPriorityPassPage iosRegisterWithPriorityPassPage;

    @Autowired
    @Lazy
    IOSVisitHistoryPage iosVisitHistoryPage;

    @Autowired
    @Lazy
    IOSLoungeDetailsPage iosLoungeDetailsPage;

    @Autowired
    @Lazy
    IOSLoungesAndOffersPage iosLoungesAndOffersPage;

    @Autowired
    @Lazy
    IOSOfferCodePage iosOfferCodePage;

    @Autowired
    @Lazy
    IOSOfferDetails iosOfferDetails;

    @Autowired
    @Lazy
    IOSQuickSearchPage iosQuickSearchPage;

    @Autowired
    @Lazy
    IOSTerminalPage iosTerminalPage;


    @Override
    public void resetApp() {
        iosHomePage.resetApp();

    }

    @Override
    public void login(String userName, String password) {
        iosLoginPage.login(userName, password);
    }

    @Override
    public void loginFromHome(String userName, String password) {
        iosHomePage.tapLoginButton();
        iosLoginPage.login(userName, password);
    }

    @Override
    public void navigateToQuickSearch() {
        iosHomePage.tapQuickSearch();
    }

    @Override
    public void noMatchingAirportsShouldBeDisplayed() {
        assertTrue("No Matching airports error message is not displayed when expected", iosQuickSearchPage.isNoMatchingAirportsTextDisplayed());
    }

    @Override
    public void userShouldBeLoggedInFromAccount() {
        assertTrue("User is not logged in where expected to login", iosAccountPage.isProfileDisplayed());
    }

    @Override
    public void tapToRevealPassword() {
        iosLoginPage.tapOnRevealPassword();
    }

    @Override
    public void inputDataIntoPasswordField(String textToInput) {
        iosLoginPage.inputPassword(textToInput);
    }

    @Override
    public void verifyValueInPasswordFieldIs(String valueToCompare) {
        assertEquals("Text in password field is incorrect", valueToCompare, iosLoginPage.getPasswordFieldText());
    }

    @Override
    public void userShouldBeLoggedIn() {
        assertFalse("User is not logged in where expected to login", iosHomePage.isLoginButtonDisplayed());
    }

    @Override
    public void userShouldBeLoggedOutAndOnAccountScreen() {
        assertTrue("User is not logged in where expected to login", iosAccountPage.isLoginButtonDisplayed());

    }

    @Override
    public void loginErrorShouldBeDisplayed() {
        assertTrue("Error relating to Login is not displayed", iosLoginPage.isLoginErrorDisplayed());
    }

    @Override
    public void addToWallet() {
        iosMyCardPage.addToWallet();
    }

    @Override
    public void dmcQrCodeShouldBeDisplayed() {
        assertTrue("QR Code is not displayed when expected", iosMyCardPage.isQRCodeDisplayed());

    }

    @Override
    public void loginFromAccount(String userName, String password) {
        iosAccountPage.tapLogin();
        iosLoginPage.login(userName, password);
    }

    @Override
    public void logoutUser() {
        iosAccountPage.tapLogout();
    }

    @Override
    public void navigateToTermsOfUse() {
        iosAccountPage.tapTermsAndConditions();
    }

    @Override
    public void navigateToTermsAndConditions() {
        iosAccountPage.tapTermsAndConditions();
    }

    @Override
    public void navigateToPrivacyPolicy() {
        iosAccountPage.tapPrivacyPolicy();
    }

    @Override
    public void navigateToLanguageSettings() {
        iosAccountPage.tapChangeLanguage();
    }

    @Override
    public void navigateToVisitHistory() {
        iosAccountPage.tapVisitHistory();
    }

    @Override
    public void accountTabShouldBeCorrectlyDisplayed() {
        assertTrue("Login button is not displayed on Account Tab", iosAccountPage.isLoginButtonDisplayed());
        assertTrue("Change langugae is not displayed on Account Tab", iosAccountPage.isChangeLanguageDisplayed());
        assertTrue("Privacy Policy is not displayed on Account Tab", iosAccountPage.isPrivacyPolicyDisplayed());
        assertTrue("Terms And Conditions is not displayed on Account Tab", iosAccountPage.isTermsAndConditionsDisplayed());
    }

    @Override
    public void rtaShouldBeDisplayed() {
        assertTrue("RTA is not displayed when expected", iosAccountPage.isRTADisplayed());
    }

    @Override
    public void rtaShouldNotBeDisplayed() {
        assertFalse("RTA - Member Entitlements are displayed when not expected", iosAccountPage.areMemberEntitlementsDisplayed());
        assertFalse("RTA - Guest Entitlements are displayed when not expected", iosAccountPage.areGuestEntitlementsDisplayed());
    }

    @Override
    public void memberOnlyEntitlementsShouldBeDisplayed() {
        assertTrue("RTA - Member Entitlements are not displayed when expected", iosAccountPage.areMemberEntitlementsDisplayed());
        assertFalse("RTA - Guest Entitlements are displayed when not expected", iosAccountPage.areGuestEntitlementsDisplayed());
    }

    @Override
    public void infiniteMemberEntitlementsShouldBeDisplayed() {
        assertTrue("RTA - Infinite Member Entitlements are not displayed when expected", iosAccountPage.isInfiniteMemberEntitlementDisplayed());
    }

    @Override
    public void navigateToHome() {
        iosTab.navigateToHome();
    }

    @Override
    public void navigateToDMC() {
        iosTab.navigateToDMC();
    }

    @Override
    public void navigateToHelp() {
        iosTab.navigateToHelp();
    }

    @Override
    public void navigateToAccount() {
        iosTab.navigateToAccount();
    }

    @Override
    public void accountTabShouldBeDisplayed() {
        assertTrue("Account tab is not displayed when expected", iosTab.isAccountTabDisplayed());
    }

    @Override
    public void helpTabShouldBeDisplayed() {
        assertTrue("Help tab is not displayed when expected", iosTab.isHelpTabDisplayed());
    }

    @Override
    public void homeTabShouldBeDisplayed() {
        assertTrue("Home tab is not displayed when expected", iosTab.isHomeTabDisplayed());
    }

    @Override
    public void cardTabShouldBeDisplayed() {
        assertTrue("Card tab is not displayed when expected", iosTab.isCardTabDisplayed());
    }

    @Override
    public void cardTabShouldNotBeDisplayed() {
        assertFalse("Card tab is displayed when not expected", iosTab.isCardTabDisplayed());
    }

    @Override
    public void switchToFAQ() {
        iosHelpPage.switchToFAQ();
    }

    @Override
    public void switchToContactUs() {
        iosHelpPage.switchToContactUs();
    }

    @Override
    public void areFAQSDisplayed() {
        assertTrue("FAQ's are not displayed when expected", iosHelpPage.getFQACount() > 0);
    }

    @Override
    public void contactUsShouldBeDisplayed() {
        assertTrue("Contact Us is not displayed when expected", iosHelpPage.getContactUsContentSize() > 0);
    }

    @Override
    public void termsAndConditionsShouldBeDisplayed() {
        assertTrue("Terms And Conditions is not displayed when expected", iosTermsOfUsePage.isTermsOfUseDisplayed());
    }

    @Override
    public void privacyPolicyShouldBeDisplayed() {
        assertTrue("Privacy Policy is not displayed when expected", iosPrivacyPolicyPage.isPrivacyPolicyDisplayed());
    }

    @Override
    public void allLanguagesShouldBeDisplayed() {
        assertEquals("All languages not displayed as expected", iosChangeLanguagePage.getLanguageCount(), 9);
    }


    @Override
    public void PPRegistrationShouldBeDisplayed() {
        assertTrue("PP Registration is not displayed when expected", iosRegisterWithPriorityPassPage.isRegisterWithPriorityPassDisplayed());
    }

    @Override
    public void joinPPShouldBeDisplayed() {
        assertTrue("JOIN PP is not displayed when expected", iosJoinPriorityPassPage.isJoinPPHeaderDisplayed());
    }

    @Override
    public void forgotDetailsShouldBeDisplayed() {
        assertTrue("Forogt Details is not displayed when expected", iosForgottenDetailsPage.isForgottenDetailsDisplayed());
    }

    @Override
    public void visitHistoryShouldBeDisplayed() {
        assertTrue("Visit History is not displayed when expected", iosVisitHistoryPage.isNoteLabelDisplayed());
    }

    @Override
    public void tapOnVisitWithLoungeName(String loungeName) {
        iosVisitHistoryPage.tapOnVisitWithLoungeName(loungeName);
    }

    @Override
    public void inputTextInQuickSearch(String searchText) {
        iosQuickSearchPage.searchForAirport(searchText);
    }

    @Override
    public void searchBoxShouldBeDisplayed() {
        assertTrue("Find a lounge not displayed when expected", iosQuickSearchPage.isSearchBoxDisplayed());
    }

    @Override
    public void selectAirportFromList(int airportNo) {
        iosQuickSearchPage.tapOnAirport(airportNo);
    }

    @Override
    public void verifyTerminalsDisplayed(int terminals) {
        assertEquals("Number of terminals displayed is not as expected", terminals, iosTerminalPage.getNumberOfTerminalsDisplayed());
    }

    @Override
    public void loungeDetailsScreenShouldBeDisplayed() {
        assertTrue("Lounge details is not displayed when expected", iosLoungeDetailsPage.isLoungeTitleDisplayed());
    }

    @Override
    public void loungeInformationShouldBeDisplayed() {
        assertTrue("Lounge Title is not displayed when expected", iosLoungeDetailsPage.isLoungeTitleDisplayed());
        assertTrue("Airport Name is not displayed when expected", iosLoungeDetailsPage.isAirportDisplayed());
        assertTrue("Opening Hours are not displayed when expected", iosLoungeDetailsPage.areOpeningHoursDisplayed());
        assertTrue("Facilities are not displayed when expected", iosLoungeDetailsPage.areFacilitiesDisplayed());
        assertTrue("Lounge Conditions are not displayed when expected", iosLoungeDetailsPage.areLoungeConditionsDisplayed());
    }

    @Override
    public void verifyOfferInformationIsDisplayed() {
        assertTrue("Offer Information is not displayed when expected", iosOfferDetails.isOfferInformationDisplayed());
    }

    @Override
    public void tapOnRedeemOffer() {
        iosOfferDetails.tapOnRedeem();
    }

    @Override
    public void verifyGeneratedOfferDetailsDisplayed() {
        assertTrue("Generated Offer Details is not displayed", iosOfferCodePage.isGeneratedOfferCodeDetailsDisplayed());
    }

    @Override
    public void offerRedemptionQRCodeShouldBeDisplayed() {
        assertTrue("Offer Redemption QR Code is not displayed", iosOfferCodePage.isQRCodeGenerated());
    }

    @Override
    public void tapOnViewAllLounges() {
        iosLoungesAndOffersPage.tapOnViewAllLounges();
    }

    @Override
    public void tapOnViewAllRetailOffers() {
        iosLoungesAndOffersPage.tapOnViewAllRetailOffers();
    }

    @Override
    public void tapOnViewAllDiningOffers() {
        iosLoungesAndOffersPage.tapOnViewAllDiningOffers();
    }

    @Override
    public void selectOfferFromList(int offerNo) {
        iosLoungesAndOffersPage.tapOnOffer(offerNo);
    }

    @Override
    public void selectTerminalFromList(int terminalNo) {
        iosTerminalPage.tapOnTerminal(terminalNo);
    }

    @Override
    public void onlyLoungesShouldBeDisplayed() {
        assertFalse("Only Lounges are not displayed when expected", iosLoungesAndOffersPage.doOffersExists());
    }

    @Override
    public void loungesAndOffersShouldBeDisplayed() {
        assertTrue("Lounges and Offers are displayed when expected", iosLoungesAndOffersPage.doOffersExists());
    }

    @Override
    public void waitUntilAppIsReady() {
        iosTab.waitUntilHomeTabIsDisplayed();
    }

    @Override
    public void navigateToLogin() {
        iosTab.navigateToAccount();
        iosAccountPage.tapAccountLoginButton();
    }

    @Override
    public void navigateToForgotDetails() {
        iosLoginPage.tapOnForgotPassword();
    }

    @Override
    public void navigateToRegisterWithPP() {
        iosLoginPage.tapOnRegisterHere();

    }

    @Override
    public void navigateToJoinPP() {
        iosLoginPage.tapOnJoinPP();
    }
}

