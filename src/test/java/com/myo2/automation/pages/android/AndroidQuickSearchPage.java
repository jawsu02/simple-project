package com.myo2.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class AndroidQuickSearchPage extends AndroidAbstractPage {

    AndroidQuickSearchPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/search_src_text")
    private MobileElement searchBox;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/textView_header")
    private MobileElement noResultsText;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/textView_header")
    private MobileElement resultsHeader;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/textView_airport_name")
    private List<MobileElement> airportName;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/textView_city")
    private List<MobileElement> city;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/textView_country")
    private List<MobileElement> country;

    public boolean isSearchBoxDisplayed() {
        return isElementPresentAndDisplayed(searchBox);
    }

    public boolean isNoMatchingAirportsTextDisplayed() {
        return isElementPresentAndDisplayed(noResultsText);
    }

    public void searchForAirport(String searchText) {
        searchBox.sendKeys(searchText);
    }

    public void tapOnAirport(int airportNo) {
        airportName.get(airportNo - 1).click();
    }

    public String getAirportName(int number) {
        return airportName.get(number - 1).getText();
    }

}
