package com.myo2.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class AndroidJoinPriorityPassPage extends AndroidAbstractPage {

    public AndroidJoinPriorityPassPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='JOIN PRIORITY PASS AND GAIN ACCESS TO OVER 1000 AIRPORT LOUNGES']")
    private MobileElement joinPPHeader;

    public boolean isJoinPPHeaderDisplayed() {
        return joinPPHeader.isDisplayed();
    }
}
