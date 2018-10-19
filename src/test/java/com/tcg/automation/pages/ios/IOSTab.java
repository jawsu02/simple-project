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

import java.util.concurrent.TimeUnit;

/**
 * Created by rajkumar.engu on 06/02/18.
 */
@Lazy
@Component
public class IOSTab extends IOSAbstractPage {

    @Autowired
    public IOSTab(IOSDriver driver) {
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
