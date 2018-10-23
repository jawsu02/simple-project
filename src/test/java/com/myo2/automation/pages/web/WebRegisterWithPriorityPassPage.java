package com.myo2.automation.pages.web;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class WebRegisterWithPriorityPassPage extends WebAbstractPage {
    WebRegisterWithPriorityPassPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='join-process']/section/div/div/div/h3")
    private WebElement createYourAccountHeader;

    public boolean isRegisterWithPriorityPassDisplayed() {
        return isElementPresentAndDisplayed(createYourAccountHeader);
    }
}
