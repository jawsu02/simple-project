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
public class IOSLoungeDetailsPage extends IOSAbstractPage {
    @Autowired
    IOSLoungeDetailsPage(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "loungeTitle")
    private MobileElement loungeName;

    @iOSFindBy(accessibility = "loungeSubTitle")
    private MobileElement airportName;

    @iOSFindBy(accessibility = "loungeOpeningHoursContent")
    private MobileElement openingHours;

    @iOSFindBy(accessibility = "loungeFacilityShowAllTitle")
    private MobileElement showAllFacilities;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='loungeFacilityTitle']")
    private List<MobileElement> facilityText;

    @iOSFindBy(accessibility = "loungeLocationContent")
    private MobileElement loungeLocation;

    @iOSFindBy(accessibility = "loungeConditionsContent")
    private MobileElement loungeConditions;

    @iOSFindBy(id = "loungeAdditionalTitle")
    private MobileElement additionalInfo;

    @iOSFindBy(accessibility = "loungeDMCButton")
    private MobileElement viewYourCard;

    @iOSFindBy(accessibility = "accessButton")
    private MobileElement login;

    public boolean isLoungeTitleDisplayed() {
        return isElementPresentAndDisplayed(loungeName);
    }

    public boolean isAirportDisplayed() {
        return isElementPresentAndDisplayed(airportName);
    }

    public boolean areOpeningHoursDisplayed() {
        return isElementPresentAndDisplayed(openingHours);
    }

    public boolean areFacilitiesDisplayed() {
        scrollToElement(openingHours,"up");
        showAllFacilities.click();
        return (facilityText.size() > 0);
    }

    public boolean isLoungeLocationDisplayed() {
        scrollToElement(openingHours,"up");
        return isElementPresentAndDisplayed(loungeLocation);
    }

    public boolean areLoungeConditionsDisplayed() {
        scrollToElement(loungeLocation,"up");
        return isElementPresentAndDisplayed(loungeConditions);
    }

    public int getNumberOfFacilities() {
        return facilityText.size();
    }
}
