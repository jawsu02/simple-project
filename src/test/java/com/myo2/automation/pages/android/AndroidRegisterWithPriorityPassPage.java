package com.myo2.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class AndroidRegisterWithPriorityPassPage extends AndroidAbstractPage {

    public AndroidRegisterWithPriorityPassPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Create your account (Step 1 of 2)']")
    private MobileElement createYourAccountHeader;

    public boolean isRegisterWithPriorityPassDisplayed() {
        return createYourAccountHeader.isDisplayed();
    }
}