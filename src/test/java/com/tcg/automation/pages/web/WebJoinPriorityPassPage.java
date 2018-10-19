package com.tcg.automation.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class WebJoinPriorityPassPage extends WebAbstractPage {
    WebJoinPriorityPassPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='enrolment-country text-centre']")
    private WebElement joinPPHeader;

    public boolean isJoinPPHeaderDisplayed() {
        return isElementPresentAndDisplayed(joinPPHeader);
    }
}
