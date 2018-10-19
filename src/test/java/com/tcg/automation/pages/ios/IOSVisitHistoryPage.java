package com.tcg.automation.pages.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class IOSVisitHistoryPage extends IOSAbstractPage {
    @Autowired
    IOSVisitHistoryPage(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "noteLabel")
    private MobileElement noteLabel;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='headingLabel']")
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
