package com.myo2.automation.pages.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class IOSJoinPriorityPassPage extends IOSAbstractPage {

    @Autowired
    public IOSJoinPriorityPassPage(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "Join | Priority Pass")
    private MobileElement joinPPHeader;

    public boolean isJoinPPHeaderDisplayed() {
        WaitUntilElementIsVisible(joinPPHeader);
        return joinPPHeader.isDisplayed();
    }
}
