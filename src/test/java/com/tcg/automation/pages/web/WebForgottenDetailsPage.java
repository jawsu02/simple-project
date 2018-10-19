package com.tcg.automation.pages.web;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class WebForgottenDetailsPage extends WebAbstractPage {

    WebForgottenDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='recovery-process']/section/div/div/div/h3")
    private WebElement forgotYourDetailsHeader;

    public boolean isForgottenDetailsDisplayed() {
        return isElementPresentAndDisplayed(forgotYourDetailsHeader);
    }
}
