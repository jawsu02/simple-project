package com.tcg.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class AndroidOfferCodePage extends AndroidAbstractPage {
    AndroidOfferCodePage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/offer_code_merchant_name")
    private MobileElement merchantName;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/offer_code_short_dec")
    private MobileElement offerCodeShortDescription;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/offer_code_qr_image")
    private MobileElement qrImage;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/offer_code_voucher_code")
    private MobileElement voucherCode;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/offer_code_redemption")
    private MobileElement redemptionText;

    public boolean isGeneratedOfferCodeDetailsDisplayed() {
        return (merchantName.isDisplayed() && offerCodeShortDescription.isDisplayed()
                && qrImage.isDisplayed() & voucherCode.isDisplayed() && redemptionText.isDisplayed());
    }

    public boolean isQRCodeGenerated() {
        return isElementPresentAndDisplayed(qrImage);
    }
}
