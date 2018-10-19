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
public class IOSTermsOfUsePage extends IOSAbstractPage {

    @Autowired
    public IOSTermsOfUsePage(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "Terms of Use | Priority Pass")
    private MobileElement termsOfUseBanner;

    public boolean isTermsOfUseDisplayed() {
        WaitUntilElementIsVisible(termsOfUseBanner);
        return termsOfUseBanner.isDisplayed();
    }
}
