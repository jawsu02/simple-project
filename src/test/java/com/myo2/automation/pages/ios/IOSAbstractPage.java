package com.myo2.automation.pages.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public abstract class IOSAbstractPage {

    protected IOSDriver driver;

    @Autowired
    IOSAbstractPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 60, TimeUnit.SECONDS), this);
    }

    @iOSFindBy(accessibility = "HOME")
    protected MobileElement homeTab;

    @iOSFindBy(accessibility = "HELP")
    protected MobileElement helpTab;

    @iOSFindBy(accessibility = "ACCOUNT")
    protected MobileElement AccountTab;

    @iOSFindBy(accessibility = "CARD")
    protected MobileElement cardTab;

    void scrollToElement(MobileElement element, String direction) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            HashMap<String, String> swipeObject = new HashMap<String, String>();
            if (direction.equalsIgnoreCase("down")) {
                swipeObject.put("direction", "down");
            } else if (direction.equalsIgnoreCase("up")) {
                swipeObject.put("direction", "up");
            } else if (direction.equalsIgnoreCase("left")) {
                swipeObject.put("direction", "left");
            } else if (direction.equalsIgnoreCase("right")) {
                swipeObject.put("direction", "right");
            }
            swipeObject.put("element", element.getId());
            js.executeScript("mobile:swipe", swipeObject);
        } catch (Exception e) {
            //Do nothing
        }
    }

    boolean isElementPresentAndDisplayed(MobileElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    void WaitUntilElementIsVisible(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(this.driver, 60);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    void WaitUntilEitherOfElementIsVisible(MobileElement element1, MobileElement element2) {
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(
                ExpectedConditions.or(
                        ExpectedConditions.visibilityOf(element1),
                        ExpectedConditions.visibilityOf(element2)
                )
        );
    }

    void WaitUntilElementIsClickable(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(this.driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    void tapOnLinkInsideTextView(MobileElement element) {
        int x = element.getLocation().getX() + element.getSize().getWidth() * 9 / 10;
        int y = element.getCenter().getY();
        new TouchAction(driver).tap(x, y).perform();
    }

    void resetApp() {
        driver.resetApp();
    }
}
