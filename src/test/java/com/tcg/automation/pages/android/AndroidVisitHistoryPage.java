package com.tcg.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class AndroidVisitHistoryPage extends AndroidAbstractPage {
    @Autowired
    AndroidVisitHistoryPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"This may not be the most\")")
    private MobileElement noteLabel;

    @iOSFindBy(id = "com.tigerspike.prioritypass:id/tv_lounge_name")
    private List<MobileElement> loungeNames;

    public boolean isNoteLabelDisplayed() {
        WaitUntilElementIsVisible(noteLabel);
        return noteLabel.isDisplayed();
    }

    public void tapOnVisitWithLoungeName(String loungeName) {
        for (MobileElement lounge : loungeNames) {
            if (lounge.getAttribute("value").equals(loungeName)) {
                lounge.click();
            }
        }
    }
}
