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
public class IOSRegisterWithPriorityPassPage extends IOSAbstractPage {

    @Autowired
    public IOSRegisterWithPriorityPassPage(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "Register | Priority Pass")
    private MobileElement createYourAccountHeader;

    public boolean isRegisterWithPriorityPassDisplayed() {
        WaitUntilElementIsVisible(createYourAccountHeader);
        return createYourAccountHeader.isDisplayed();
    }
}
