package com.myo2.automation.pages.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class IOSChangeLanguagePage extends IOSAbstractPage {

    @Autowired
    public IOSChangeLanguagePage(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name='languageSettingsCellLabel'])[1]")
    private MobileElement simplifiedChinese;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name='languageSettingsCellLabel'])[2]")
    private MobileElement traditionalChinese;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name='languageSettingsCellLabel'])[3]")
    private MobileElement english;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name='languageSettingsCellLabel'])[4]")
    private MobileElement french;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name='languageSettingsCellLabel'])[5]")
    private MobileElement japanese;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name='languageSettingsCellLabel'])[6]")
    private MobileElement korean;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name='languageSettingsCellLabel'])[7]")
    private MobileElement brazilianPortugese;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name='languageSettingsCellLabel'])[8]")
    private MobileElement russian;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name='languageSettingsCellLabel'])[9]")
    private MobileElement spanish;

    @iOSFindBy(xpath = "//XCUIElementTypeTable[@name='LanguageSettingsTableView']/XCUIElementTypeCell")
    private List<MobileElement> allLanguages;

    public int getLanguageCount() {
        return allLanguages.size();
    }
}
