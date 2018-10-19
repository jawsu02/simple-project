package com.tcg.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;


@Lazy
@Component
public class AndroidAccountPage extends AndroidAbstractPage {

    public AndroidAccountPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/accountLoginButton")
    private MobileElement accountLoginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Change Language']")
    private MobileElement changeLanguage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms & Conditions']")
    private MobileElement termsAndConditions;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
    private MobileElement privacyPolicy;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/logoutText")
    private MobileElement logout;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/rowProfile")
    private MobileElement headerProfile;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/membershipNumber")
    private MobileElement memberShipNumber;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/rowVisitHistory")
    private MobileElement visitHistory;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/account_allocation")
    private MobileElement myEntitlementsPanel;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.tigerspike.prioritypass:id/allocation_infinity_iv']")
    private List<MobileElement> infiniteVisits;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.tigerspike.prioritypass:id/allocation_visitremaining_tv']")
    private List<MobileElement> visitsRemaining;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.tigerspike.prioritypass:id/allocation_visitsused_tv']")
    private List<MobileElement> visitsUsed;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.tigerspike.prioritypass:id/allocation_visitspending_tv']")
    private List<MobileElement> visitsPending;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/account_guestallocation")
    private MobileElement guestEntitlementPanel;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/account_visithistory_lastupdated_tv")
    private MobileElement lastUpdated;

    public void tapAccountLoginButton() {
        this.accountLoginButton.click();
    }

    public void tapChangeLanguage() {
        scrollToStringDisplayed("Change Language");
        this.changeLanguage.click();
    }

    public void tapTermsAndConditions() {
        scrollToStringDisplayed("Terms & Conditions");
        this.termsAndConditions.click();
    }

    public void tapPrivacyPolicy() {
        scrollToStringDisplayed("Privacy Policy");
        this.privacyPolicy.click();
    }

    public void tapLogout() {
        scrollToStringDisplayed("Log Out");
        this.logout.click();
    }

    public void tapVisitHistory() {
        this.visitHistory.click();
    }

    public void tapLogin() {
        this.accountLoginButton.click();
    }

    public boolean isProfileDisplayed() {
        return headerProfile.isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return accountLoginButton.isDisplayed();
    }

    public boolean isChangeLanguageDisplayed() {
        return changeLanguage.isDisplayed();
    }

    public boolean isPrivacyPolicyDisplayed() {
        return privacyPolicy.isDisplayed();
    }

    public boolean isTermsAndConditionsDisplayed() {
        return termsAndConditions.isDisplayed();
    }

    public boolean isRTADisplayed() {
        return areMemberEntitlementsDisplayed() && areGuestEntitlementsDisplayed();
    }

    public boolean areMemberEntitlementsDisplayed() {
        return isElementPresentAndDisplayed(myEntitlementsPanel);
    }

    public boolean areGuestEntitlementsDisplayed() {
        return isElementPresentAndDisplayed(guestEntitlementPanel);
    }

    public boolean isInfiniteMemberEntitlementDisplayed() {
        return infiniteVisits.size() > 0;
    }
}
