package com.tcg.automation.pages.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Lazy
@Component
public class IOSHelpPage extends IOSAbstractPage {

    @Autowired
    public IOSHelpPage(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Contact Us']")
    private MobileElement contactUs;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name='FAQ']")
    private MobileElement faq;

    @iOSFindBy(id = "//XCUIElementTypeOther[@name='Contact Us']")
    private MobileElement contactUsPage;

    @iOSFindBy(id = "//XCUIElementTypeOther[@name='FAQ']")
    private MobileElement faqPage;

    @iOSFindBy(xpath = "//XCUIElementTypeScrollView//XCUIElementTypeOther/XCUIElementTypeStaticText")
    private List<MobileElement> contactUsContent;

    @iOSFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell")
    private List<MobileElement> faqsList;

    public void switchToContactUs() {
        this.contactUs.click();
    }

    public void switchToFAQ() {
        this.faq.click();
    }

    public int getFQACount() {
        return faqsList.size();
    }

    public int getContactUsContentSize() {
        return contactUsContent.size();
    }

}
