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
public class IOSQuickSearchPage extends IOSAbstractPage {
    @Autowired
    IOSQuickSearchPage(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "App.SearchView")
    private MobileElement searchBox;

    @iOSFindBy(accessibility = "SearchResultsErrorLabel")
    private MobileElement noResultsText;

    @iOSFindBy(accessibility = "RESULTS")
    private MobileElement resultsHeader;

    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[1]")
    private List<MobileElement> airportName;

    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[2]")
    private List<MobileElement> city;

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
