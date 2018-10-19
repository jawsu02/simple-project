package com.tcg.automation.pages.web;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class WebHomePage extends WebAbstractPage {

    @Autowired
    public WebHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='header-panel-links']/li[1]/a[1]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='header-panel-links']/li[1]/a[2]")
    private WebElement registerButton;

    @FindBy(id = "lounge-finder")
    private WebElement quickSearch;

    public void waitUntilQuickSearchIsDisplayed() {
        WaitUntilElementIsVisible(quickSearch);
    }

    public void tapLoginButton() {
        this.loginButton.click();
    }

    public void tapRegisterButton() {
        this.registerButton.click();
    }

    public void tapQuickSearch() {
        this.quickSearch.click();
    }

}
