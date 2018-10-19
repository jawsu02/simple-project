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
public class IOSForgottenDetailsPage extends IOSAbstractPage {

    @Autowired
    public IOSForgottenDetailsPage(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "Forgot your details | Priority Pass")
    private MobileElement forgotYourDetailsHeader;

    public boolean isForgottenDetailsDisplayed() {
        return forgotYourDetailsHeader.isDisplayed();
    }
}
