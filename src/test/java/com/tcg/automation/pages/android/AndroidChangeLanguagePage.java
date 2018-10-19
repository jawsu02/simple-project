package com.tcg.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class AndroidChangeLanguagePage extends AndroidAbstractPage {

    public AndroidChangeLanguagePage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[@text='Brazilian Portuguese']")
    private MobileElement brazilianPortugese;

    @AndroidFindBy(xpath = "//*[@text='English']")
    private MobileElement english;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/img_selected")
    private MobileElement languageSelector;

    @AndroidFindBy(xpath = "//*[@text='French']")
    private MobileElement french;

    @AndroidFindBy(xpath = "//*[@text='Japanese']")
    private MobileElement japanese;

    @AndroidFindBy(xpath = "//*[@text='Korean']")
    private MobileElement korean;

    @AndroidFindBy(xpath = "//*[@text='Latin American Spanish']")
    private MobileElement spanish;

    @AndroidFindBy(xpath = "//*[@text='Russian']")
    private MobileElement russian;

    @AndroidFindBy(xpath = "//*[@text='Simplified Chinese']")
    private MobileElement simplifiedChinese;

    @AndroidFindBy(xpath = "//*[@text='Traditional Chinese']")
    private MobileElement traditionalChinese;

    @AndroidFindBy(xpath = "//*[@class='android.support.v7.widget.RecyclerView']/android.widget.LinearLayout")
    private List<MobileElement> allLanguages;

    public int getLanguageCount() {
        //Change language header is also a linear layout in Android
        return allLanguages.size() - 1;
    }

    public boolean isLanguageSelectorDisplayed() {
        return languageSelector.isDisplayed();
    }
}
