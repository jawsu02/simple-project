package com.tcg.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Lazy
@Component
public class AndroidTab extends AndroidAbstractPage {
    @Autowired
    public AndroidTab(AndroidDriver driver) {
        super(driver);
    }

    public void navigateToHome() {
        this.homeTab.click();
    }

    public void navigateToHelp() {
        this.helpTab.click();
    }

    public void navigateToAccount() {
        this.AccountTab.click();
    }

    public void navigateToDMC() {
        this.cardTab.click();
    }

    public boolean isDMCDisplayed() {
        return isElementPresentAndDisplayed(cardTab);
    }

    public boolean isAccountTabDisplayed() {
        return isElementPresentAndDisplayed(AccountTab);
    }

    public boolean isHelpTabDisplayed() {
        return isElementPresentAndDisplayed(helpTab);
    }

    public boolean isHomeTabDisplayed() {
        return isElementPresentAndDisplayed(homeTab);
    }

    public boolean isCardTabDisplayed() {
        return isElementPresentAndDisplayed(cardTab);
    }

    public void waitUntilHomeTabIsDisplayed() {
        WaitUntilElementIsVisible(homeTab);
    }
}
