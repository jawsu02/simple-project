package com.myo2.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class AndroidTermsOfUsePage extends AndroidAbstractPage {

    public AndroidTermsOfUsePage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='TERMS OF USE']")
    private MobileElement termsOfUseBanner;

    public boolean isTermsOfUseDisplayed() {
        return termsOfUseBanner.isDisplayed();
    }
}