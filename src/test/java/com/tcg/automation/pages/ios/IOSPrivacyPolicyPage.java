package com.tcg.automation.pages.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class IOSPrivacyPolicyPage extends IOSAbstractPage {

    @Autowired
    public IOSPrivacyPolicyPage(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "Privacy Policy | Priority Pass")
    private MobileElement privacyPolicyBanner;

    public boolean isPrivacyPolicyDisplayed() {
        WaitUntilElementIsVisible(privacyPolicyBanner);
        return privacyPolicyBanner.isDisplayed();
    }
}
