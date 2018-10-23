package com.myo2.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class AndroidHelpPage extends AndroidAbstractPage {

    @Autowired
    public AndroidHelpPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[@text='Contact Us']")
    private MobileElement contactUs;

    @AndroidFindBy(xpath = "//*[@text='FAQ']")
    private MobileElement faq;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/viewpager")
    private MobileElement contactUsPage;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/faqlist_rv")
    private MobileElement faqPage;

    @AndroidFindBy(xpath = "//android.widget.ScrollView//android.widget.LinearLayout/android.widget.TextView")
    private List<MobileElement> contactUsContent;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/faqlist_row_title")
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
