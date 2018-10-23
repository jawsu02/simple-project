package com.myo2.automation.pages.android;

import com.myo2.automation.strategy.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Component("ANDROID")
public class AndroidPageStrategy implements PageStrategy {

    @Autowired
    @Lazy
    AndroidMyCardPage androidMyCardPage;

    @Autowired
    @Lazy
    AndroidLoginPage androidLoginPage;

    @Autowired
    @Lazy
    AndroidTab androidTab;

    @Autowired
    @Lazy
    AndroidAccountPage androidAccountPage;

    @Autowired
    @Lazy
    AndroidHomePage androidHomePage;

    @Autowired
    @Lazy
    AndroidHelpPage androidHelpPage;

    @Autowired
    @Lazy
    AndroidTermsOfUsePage androidTermsOfUsePage;

    @Autowired
    @Lazy
    AndroidPrivacyPolicyPage androidPrivacyPolicyPage;

    @Autowired
    @Lazy
    AndroidChangeLanguagePage androidChangeLanguagePage;

    @Autowired
    @Lazy
    AndroidForgottenDetailsPage androidForgottenDetailsPage;

    @Autowired
    @Lazy
    AndroidJoinPriorityPassPage androidJoinPriorityPassPage;

    @Autowired
    @Lazy
    AndroidRegisterWithPriorityPassPage androidRegisterWithPriorityPassPage;

    @Autowired
    @Lazy
    AndroidVisitHistoryPage androidVisitHistoryPage;

    @Autowired
    @Lazy
    AndroidLoungeDetailsPage androidLoungeDetailsPage;

    @Autowired
    @Lazy
    AndroidLoungesAndOffersPage androidLoungesAndOffersPage;

    @Autowired
    @Lazy
    AndroidOfferCodePage androidOfferCodePage;

    @Autowired
    @Lazy
    AndroidOfferDetails androidOfferDetails;

    @Autowired
    @Lazy
    AndroidQuickSearchPage androidQuickSearchPage;

    @Autowired
    @Lazy
    AndroidTerminalPage androidTerminalPage;

    @Override
    public void resetApp() {
        androidHomePage.resetApp();
    }

    @Override
    public void login(String userName, String password) {
        androidLoginPage.login(userName, password);
    }

    @Override
    public void loginFromHome(String userName, String password) {
        androidHomePage.tapLoginButton();
        androidLoginPage.login(userName, password);
    }

    @Override
    public void navigateToQuickSearch() {
        androidHomePage.tapQuickSearch();
    }

    @Override
    public void noMatchingAirportsShouldBeDisplayed() {
        assertTrue("No Matching airports error message is not displayed when expected", androidQuickSearchPage.isNoMatchingAirportsTextDisplayed());
    }

    @Override
    public void userShouldBeLoggedInFromAccount() {
        assertTrue("User is not logged in where expected to login", androidAccountPage.isProfileDisplayed());
    }

    @Override
    public void tapToRevealPassword() {
        androidLoginPage.tapOnRevealPassword();
    }

    @Override
    public void inputDataIntoPasswordField(String textToInput) {
        androidLoginPage.inputPassword(textToInput);
    }

    @Override
    public void verifyValueInPasswordFieldIs(String valueToCompare) {
        assertEquals("Text in password field is incorrect", valueToCompare, androidLoginPage.getPasswordFieldText());
    }

    @Override
    public void userShouldBeLoggedOutAndOnAccountScreen() {
        assertTrue("User is still logged in when expected to log out", androidAccountPage.isLoginButtonDisplayed());
    }

    @Override
    public void logoutUser() {
        androidAccountPage.tapLogout();
    }

    @Override
    public void navigateToTermsOfUse() {
        androidAccountPage.tapTermsAndConditions();
    }

    @Override
    public void navigateToTermsAndConditions() {
        androidAccountPage.tapTermsAndConditions();
    }

    @Override
    public void navigateToPrivacyPolicy() {
        androidAccountPage.tapPrivacyPolicy();
    }

    @Override
    public void navigateToLanguageSettings() {
        androidAccountPage.tapChangeLanguage();
    }

    @Override
    public void navigateToVisitHistory() {
        androidAccountPage.tapVisitHistory();
    }

    @Override
    public void accountTabShouldBeCorrectlyDisplayed() {
        assertTrue("Login button is not displayed on Account Tab", androidAccountPage.isLoginButtonDisplayed());
        assertTrue("Change langugae is not displayed on Account Tab", androidAccountPage.isChangeLanguageDisplayed());
        assertTrue("Privacy Policy is not displayed on Account Tab", androidAccountPage.isPrivacyPolicyDisplayed());
        assertTrue("Terms And Conditions is not displayed on Account Tab", androidAccountPage.isTermsAndConditionsDisplayed());
    }

    @Override
    public void rtaShouldBeDisplayed() {
        assertTrue("RTA is not displayed when expected", androidAccountPage.isRTADisplayed());
    }

    @Override
    public void rtaShouldNotBeDisplayed() {
        assertFalse("RTA - Member Entitlements are displayed when not expected", androidAccountPage.areMemberEntitlementsDisplayed());
        assertFalse("RTA - Guest Entitlements are displayed when not expected", androidAccountPage.areGuestEntitlementsDisplayed());
    }

    @Override
    public void memberOnlyEntitlementsShouldBeDisplayed() {
        assertTrue("RTA - Member Entitlements are not displayed when expected", androidAccountPage.areMemberEntitlementsDisplayed());
        assertFalse("RTA - Guest Entitlements are displayed when not expected", androidAccountPage.areGuestEntitlementsDisplayed());
    }

    @Override
    public void infiniteMemberEntitlementsShouldBeDisplayed() {
        assertTrue("RTA - Infinite Member Entitlements are not displayed when expected", androidAccountPage.isInfiniteMemberEntitlementDisplayed());
    }

    @Override
    public void userShouldBeLoggedIn() {
        assertFalse("User is not logged in where expected to login", androidHomePage.isLoginButtonDisplayed());
    }

    @Override
    public void loginErrorShouldBeDisplayed() {
        assertTrue("Error relating to Login is not displayed", androidLoginPage.isLoginErrorDisplayed());
    }

    // TAB
    @Override
    public void addToWallet() {
        //NOTHING
    }

    @Override
    public void dmcQrCodeShouldBeDisplayed() {
        assertTrue("QR Code is not displayed when expected", androidMyCardPage.isQRCodeDisplayed());
    }

    @Override
    public void loginFromAccount(String userName, String password) {
        androidAccountPage.tapLogin();
        androidLoginPage.login(userName, password);
    }

    @Override
    public void navigateToHome() {
        androidTab.navigateToHome();
    }

    @Override
    public void navigateToDMC() {
        androidTab.navigateToDMC();
    }

    @Override
    public void navigateToHelp() {
        androidTab.navigateToHelp();
    }

    @Override
    public void navigateToAccount() {
        androidTab.navigateToAccount();
    }

    @Override
    public void accountTabShouldBeDisplayed() {
        assertTrue("Account tab is not displayed when expected", androidTab.isAccountTabDisplayed());
    }

    @Override
    public void helpTabShouldBeDisplayed() {
        assertTrue("Help tab is not displayed when expected", androidTab.isHelpTabDisplayed());
    }

    @Override
    public void homeTabShouldBeDisplayed() {
        assertTrue("Home tab is not displayed when expected", androidTab.isHomeTabDisplayed());
    }

    @Override
    public void cardTabShouldBeDisplayed() {
        assertTrue("Card tab is not displayed when expected", androidTab.isCardTabDisplayed());
    }

    @Override
    public void cardTabShouldNotBeDisplayed() {
        assertFalse("Card tab is displayed when not expected", androidTab.isCardTabDisplayed());
    }

    @Override
    public void switchToFAQ() {
        androidHelpPage.switchToFAQ();
    }

    @Override
    public void switchToContactUs() {
        androidHelpPage.switchToContactUs();
    }

    @Override
    public void areFAQSDisplayed() {
        assertTrue("FAQ's are not displayed when expected", androidHelpPage.getFQACount() > 0);
    }

    @Override
    public void contactUsShouldBeDisplayed() {
        assertTrue("Contact Us is not displayed when expected", androidHelpPage.getContactUsContentSize() > 0);
    }

    @Override
    public void termsAndConditionsShouldBeDisplayed() {
        assertTrue("Terms And Conditions is not displayed when expected", androidTermsOfUsePage.isTermsOfUseDisplayed());
    }

    @Override
    public void privacyPolicyShouldBeDisplayed() {
        assertTrue("Privacy Policy is not displayed when expected", androidPrivacyPolicyPage.isPrivacyPolicyDisplayed());
    }

    @Override
    public void allLanguagesShouldBeDisplayed() {
        assertEquals("All languages not displayed as expected", 9, androidChangeLanguagePage.getLanguageCount());
    }

    @Override
    public void PPRegistrationShouldBeDisplayed() {
        assertTrue("PP Registration is not displayed when expected", androidRegisterWithPriorityPassPage.isRegisterWithPriorityPassDisplayed());
    }

    @Override
    public void joinPPShouldBeDisplayed() {
        assertTrue("JOIN PP is not displayed when expected", androidJoinPriorityPassPage.isJoinPPHeaderDisplayed());
    }

    @Override
    public void forgotDetailsShouldBeDisplayed() {
        assertTrue("Forogt Details is not displayed when expected", androidForgottenDetailsPage.isForgottenDetailsDisplayed());
    }

    @Override
    public void visitHistoryShouldBeDisplayed() {
        assertTrue("Visit History is not displayed when expected", androidVisitHistoryPage.isNoteLabelDisplayed());
    }

    @Override
    public void tapOnVisitWithLoungeName(String loungeName) {
        androidVisitHistoryPage.tapOnVisitWithLoungeName(loungeName);
    }

    @Override
    public void inputTextInQuickSearch(String searchText) {
        androidQuickSearchPage.searchForAirport(searchText);
    }

    @Override
    public void searchBoxShouldBeDisplayed() {
        assertTrue("Find a lounge not displayed when expected", androidQuickSearchPage.isSearchBoxDisplayed());
    }

    @Override
    public void selectAirportFromList(int airportNo) {
        androidQuickSearchPage.tapOnAirport(airportNo);
    }

    @Override
    public void verifyTerminalsDisplayed(int terminals) {
        assertEquals("Number of terminals displayed is not as expected", terminals, androidTerminalPage.getNumberOfTerminalsDisplayed());
    }

    @Override
    public void loungeDetailsScreenShouldBeDisplayed() {
        assertTrue("Lounge details is not displayed when expected", androidLoungeDetailsPage.isLoungeTitleDisplayed());
    }

    @Override
    public void loungeInformationShouldBeDisplayed() {
        assertTrue("Lounge Title is not displayed when expected", androidLoungeDetailsPage.isLoungeTitleDisplayed());
        assertTrue("Airport Name is not displayed when expected", androidLoungeDetailsPage.isAirportDisplayed());
        assertTrue("Opening Hours are not displayed when expected", androidLoungeDetailsPage.areOpeningHoursDisplayed());
        assertTrue("Facilities are not displayed when expected", androidLoungeDetailsPage.areFacilitiesDisplayed());
        assertTrue("Lounge Conditions are not displayed when expected", androidLoungeDetailsPage.areLoungeConditionsDisplayed());
    }

    @Override
    public void verifyOfferInformationIsDisplayed() {
        assertTrue("Offer Information is not displayed when expected", androidOfferDetails.isOfferInformationDisplayed());
    }

    @Override
    public void tapOnRedeemOffer() {
        androidOfferDetails.tapOnRedeem();
    }

    @Override
    public void verifyGeneratedOfferDetailsDisplayed() {
        assertTrue("Generated Offer Details is not displayed", androidOfferCodePage.isGeneratedOfferCodeDetailsDisplayed());
    }

    @Override
    public void offerRedemptionQRCodeShouldBeDisplayed() {
        assertTrue("Offer Redemption QR Code is not displayed", androidOfferCodePage.isQRCodeGenerated());
    }

    @Override
    public void tapOnViewAllLounges() {
        androidLoungesAndOffersPage.tapOnViewAllLounges();
    }

    @Override
    public void tapOnViewAllRetailOffers() {
        androidLoungesAndOffersPage.tapOnViewAllRetailOffers();
    }

    @Override
    public void tapOnViewAllDiningOffers() {
        androidLoungesAndOffersPage.tapOnViewAllDiningOffers();
    }

    @Override
    public void selectOfferFromList(int offerNo) {
        androidLoungesAndOffersPage.tapOnOffer(offerNo);
    }

    @Override
    public void selectTerminalFromList(int terminalNo) {
        androidTerminalPage.tapOnTerminal(terminalNo);
    }

    @Override
    public void onlyLoungesShouldBeDisplayed() {
        assertFalse("Only Lounges are not displayed when expected", androidLoungesAndOffersPage.doOffersExists());
    }

    @Override
    public void loungesAndOffersShouldBeDisplayed() {
        assertTrue("Lounges and Offers are displayed when expected", androidLoungesAndOffersPage.doOffersExists());
    }

    @Override
    public void waitUntilAppIsReady() {
        androidTab.waitUntilHomeTabIsDisplayed();
    }

    @Override
    public void navigateToLogin() {
        androidTab.navigateToAccount();
        androidAccountPage.tapAccountLoginButton();
    }

    @Override
    public void navigateToForgotDetails() {
        androidLoginPage.tapOnForgotPassword();
    }

    @Override
    public void navigateToRegisterWithPP() {
        androidLoginPage.tapOnRegisterHere();
    }

    @Override
    public void navigateToJoinPP() {
        androidLoginPage.tapOnJoinPP();
    }
}
