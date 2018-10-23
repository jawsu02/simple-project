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
public class IOSLoungesAndOffersPage extends IOSAbstractPage {
    @Autowired
    IOSLoungesAndOffersPage(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='horizontalListTitle']")
    private List<MobileElement> header;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='LoungeTitleLabel']")
    private List<MobileElement> lounges;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='OffersListCellTitleLabel']")
    private List<MobileElement> offers;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='View All']")
    private List<MobileElement> viewAll;

    public String getHeader(int number) {
        return header.get(number-1).getText();
    }

    public String getLounge(int number) {
        return lounges.get(number-1).getText();
    }

    public void tapOnLounge(int number) {
        lounges.get(number-1).click();
    }

    public String getOffer(int number) {
        return offers.get(number-1).getText();
    }

    public void tapOnOffer(int number) {
        offers.get(number-1).click();
    }

    public void tapOnViewAllLounges() {
        viewAll.get(0).click();
    }

    public void tapOnViewAllRetailOffers() {
        viewAll.get(1).click();
    }

    public void tapOnViewAllDiningOffers() {
        viewAll.get(2).click();
    }

    public boolean doOffersExists() {
        return viewAll.size() > 0;
    }
}
