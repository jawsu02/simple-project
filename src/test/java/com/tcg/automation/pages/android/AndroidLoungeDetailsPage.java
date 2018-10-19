package com.tcg.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class AndroidLoungeDetailsPage extends AndroidAbstractPage {

    AndroidLoungeDetailsPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/tv_lounge_name")
    private MobileElement loungeName;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/tv_airport_name")
    private MobileElement airportName;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/tv_openinghours")
    private MobileElement openingHours;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/tv_facility_count")
    private MobileElement showAllFacilities;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/tv_facility_name")
    private List<MobileElement> facilityText;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/tv_location")
    private MobileElement loungeLocation;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/tv_conditions")
    private MobileElement loungeConditions;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/tv_additionalinfo")
    private MobileElement additionalInfo;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/textView_access")
    private MobileElement viewYourCard;

    @AndroidFindBy(accessibility = "LOG IN")
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
        scrollToStringDisplayed("Show All");
        showAllFacilities.click();
        return (facilityText.size() > 0);
    }

    public boolean isLoungeLocationDisplayed() {
        scrollToStringDisplayed("LOCATION");
        return isElementPresentAndDisplayed(loungeLocation);
    }

    public boolean areLoungeConditionsDisplayed() {
        scrollToStringDisplayed("CONDITIONS");
        return isElementPresentAndDisplayed(loungeConditions);
    }

    public int getNumberOfFacilities() {
        return facilityText.size();
    }

}
