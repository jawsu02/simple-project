package com.myo2.automation.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class WebAccountPage extends WebAbstractPage {
    WebAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='name-highlight']")
    private WebElement displayName;

    public void waitUntilDisplayNameIsVisible() {
        WaitUntilElementIsVisible(displayName);
    }
}
