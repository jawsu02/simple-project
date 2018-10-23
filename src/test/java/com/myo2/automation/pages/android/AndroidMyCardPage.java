package com.myo2.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Lazy
@Component
public class AndroidMyCardPage extends AndroidAbstractPage {

    @Autowired
    public AndroidMyCardPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/img_qr_code")
    private MobileElement qrCode;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/img_flip_detail")
    private MobileElement flipDMC;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/tv_dmc_detail_member_name")
    private MobileElement memberName;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/tv_dmc_detail_member_no")
    private MobileElement memberNumber;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/tv_dmc_detail_creation_date")
    private MobileElement dmcCreationDate;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/tv_dmc_detail_expiry_date")
    private MobileElement dmcExpiryDate;

    public boolean isQRCodeDisplayed() {
        return isElementPresentAndDisplayed(qrCode);
    }


}
