package com.tcg.automation.pages.web;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public class WebAbstractPage {

    protected WebDriver driver;

    @Autowired
    WebAbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "JOIN")
    WebElement joinPP;

    @FindBy(xpath = "//*[@id='site-header']/div/div[3]/div/div/div[2]/a")
    WebElement ppMainIcon;

    void WaitUntilElementIsVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(this.driver, 60);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void navigateToHome() {
        this.ppMainIcon.click();
    }

    boolean isTextDisplayed(String text) {
        return driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]")).size() > 0;
    }

    boolean isElementPresentAndDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean waitForJSandJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        // wait for jQuery to load
        JavascriptExecutor js = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) (js.executeScript("return jQuery.active")) == 0);
                } catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    void reset() {
        driver.manage().deleteAllCookies();
//        driver.quit();
    }


}
