package com.myo2.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class AndroidForgottenDetailsPage extends AndroidAbstractPage {

    public AndroidForgottenDetailsPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Forgot your details']")
    private MobileElement forgotYourDetailsHeader;

    public boolean isForgottenDetailsDisplayed() {
        return forgotYourDetailsHeader.isDisplayed();
    }
}
