package com.tcg.automation.pages.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class IOSOfferCodePage extends IOSAbstractPage {
    @Autowired
    IOSOfferCodePage(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "OfferRedemptionMerchantNameLabel")
    private MobileElement merchantName;

    @iOSFindBy(accessibility = "OfferRedemptionDescriptionLabel")
    private MobileElement offerCodeShortDescription;

    @iOSFindBy(accessibility = "OfferRedemptionCodeQRImage")
    private MobileElement qrImage;

    @iOSFindBy(accessibility = "OfferRedemptionCodeLabel")
    private MobileElement voucherCode;

    @iOSFindBy(accessibility = "OfferRedemptionInstructions")
    private MobileElement redemptionText;

    public boolean isGeneratedOfferCodeDetailsDisplayed() {
        return (merchantName.isDisplayed() && offerCodeShortDescription.isDisplayed()
                && voucherCode.isDisplayed() && qrImage.isEnabled());
    }

    public boolean isQRCodeGenerated() {
        return qrImage.isEnabled();
    }
}
