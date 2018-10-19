package com.tcg.automation.pages.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Lazy
@Component
public class IOSAccountPage extends IOSAbstractPage {

    IOSDriver driver;

    @Autowired
    public IOSAccountPage(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "accountLoginButton")
    private MobileElement accountLoginButton;

    @iOSFindBy(id = "Language Settings")
    private MobileElement changeLanguage;

    @iOSFindBy(id = "Terms Of Use")
    private MobileElement termsAndConditions;

    @iOSFindBy(id = "Privacy Policy")
    private MobileElement privacyPolicy;

    @iOSFindBy(id = "Log Out")
    private MobileElement logout;

    @iOSFindBy(id = "Profile")
    private MobileElement headerProfile;

    @iOSFindBy(id = "Membership Number")
    private MobileElement memberShipNumber;

    @iOSFindBy(id = "Visit History")
    private MobileElement visitHistory;

    @iOSFindBy(id = "member entitlements")
    private MobileElement myEntitlementsPanel;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='remaining value']")
    private List<MobileElement> infiniteVisits;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='remaining value']")
    private List<MobileElement> visitsRemaining;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='used value']")
    private List<MobileElement> visitsUsed;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='pending value']")
    private List<MobileElement> visitsPending;

    @iOSFindBy(id = "guest entitlements")
    private MobileElement guestEntitlementPanel;

    @iOSFindBy(id = "last updated label")
    private MobileElement lastUpdated;

    public void tapAccountLoginButton() {
        this.accountLoginButton.click();
    }

    public void tapChangeLanguage() {
        this.changeLanguage.click();
    }

    public void tapTermsAndConditions() {
        this.termsAndConditions.click();
    }

    public void tapPrivacyPolicy() {
        this.privacyPolicy.click();
    }

    public void tapLogout() {
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
        scrollToElement(myEntitlementsPanel, "up");
        return isElementPresentAndDisplayed(guestEntitlementPanel);
    }

    public boolean isInfiniteMemberEntitlementDisplayed() {
        return infiniteVisits.size() > 0;
    }
}

