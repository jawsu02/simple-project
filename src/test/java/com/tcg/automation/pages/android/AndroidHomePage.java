package com.tcg.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by rajkumar.engu on 02/02/18.
 */
@Lazy
@Component
public class AndroidHomePage extends AndroidAbstractPage {

    @Autowired
    public AndroidHomePage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/loginButton")
    private MobileElement loginButton;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/textView2")
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
