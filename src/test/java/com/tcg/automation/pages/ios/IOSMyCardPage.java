package com.tcg.automation.pages.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Lazy
@Component
public class IOSMyCardPage extends IOSAbstractPage{

    @Autowired
    public IOSMyCardPage(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(id = "qrCodeDetailDMC")
    private MobileElement qrCode;

    @iOSFindBy(id = "flipDetailDMC")
    private MobileElement flipDMC;

    @iOSFindBy(id = "Member Name-Value")
    private MobileElement memberName;

    @iOSFindBy(id = "Membership Number-Value")
    private MobileElement memberNumber;

    @iOSFindBy(id = "Digital Card Creation Date-Value")
    private MobileElement dmcCreationDate;

    @iOSFindBy(id = "Membership Expiry Date-Value")
    private MobileElement dmcExpiryDate;

    @iOSFindBy(id = "addToWalletBasicDMC")
    private MobileElement addToAppleWallet;

    public void addToWallet(){
        addToAppleWallet.click();
    }

    public boolean isQRCodeDisplayed() {
        return isElementPresentAndDisplayed(qrCode);
    }
}
