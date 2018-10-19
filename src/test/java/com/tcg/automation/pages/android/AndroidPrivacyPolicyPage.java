package com.tcg.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class AndroidPrivacyPolicyPage extends AndroidAbstractPage {

    public AndroidPrivacyPolicyPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='PRIVACY POLICY']")
    private MobileElement privacyPolicyBanner;

    public boolean isPrivacyPolicyDisplayed() {
        return privacyPolicyBanner.isDisplayed();
    }
}
