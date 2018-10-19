package com.tcg.automation.pages.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by rajkumar.engu on 06/02/18.
 */
@Lazy
@Component
public class IOSHomePage extends IOSAbstractPage {

    @Autowired
    public IOSHomePage(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "LOG IN")
    private MobileElement loginButton;

    @iOSFindBy(accessibility = "searchButton")
    private MobileElement quickSearch;

    public void tapLoginButton() {
        this.loginButton.click();
    }

    public void tapQuickSearch() {
        this.quickSearch.click();
    }

    public boolean isLoginButtonDisplayed() {
        return isElementPresentAndDisplayed(loginButton);
    }
}
