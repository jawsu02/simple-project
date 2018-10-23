package com.myo2.automation.pages.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class IOSOfferDetails extends IOSAbstractPage {
    @Autowired
    IOSOfferDetails(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "redeemButton")
    private MobileElement redeem;

    @iOSFindBy(accessibility = "offerOutletName")
    private MobileElement offerDescription;

    @iOSFindBy(accessibility = "offerShortDescription")
    private MobileElement outletName;

    @iOSFindBy(accessibility = "offerOpenHoursContent")
    private MobileElement openingHours;

    public boolean isOfferInformationDisplayed() {
        return (offerDescription.isDisplayed() && outletName.isDisplayed() && openingHours.isDisplayed());
    }

    public void tapOnRedeem() {
        redeem.click();
    }
}
