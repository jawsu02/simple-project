package com.myo2.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class AndroidLoungesAndOffersPage extends AndroidAbstractPage {

    AndroidLoungesAndOffersPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/section_name")
    private List<MobileElement> header;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/name")
    private List<MobileElement> lounges;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/title")
    private List<MobileElement> offers;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/button_show_all")
    private List<MobileElement> viewAll;

    public String getHeader(int number) {
        return header.get(number - 1).getText();
    }

    public String getLounge(int number) {
        return lounges.get(number - 1).getText();
    }

    public void tapOnLounge(int number) {
        lounges.get(number - 1).click();
    }

    public String getOffer(int number) {
        return offers.get(number - 1).getText();
    }

    public void tapOnOffer(int number) {
        offers.get(number - 1).click();
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
