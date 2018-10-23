package com.myo2.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class AndroidOfferDetails extends AndroidAbstractPage {

    AndroidOfferDetails(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/btn_offer_redeem")
    private MobileElement redeem;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/tv_offer_desc")
    private MobileElement offerDescription;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/tv_outlet_name")
    private MobileElement outletName;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/tv_outlet_name")
    private MobileElement openingHours;

    public boolean isOfferInformationDisplayed() {
        return (offerDescription.isDisplayed() && outletName.isDisplayed() && openingHours.isDisplayed());
    }

    public void tapOnRedeem() {
        redeem.click();
    }
}
