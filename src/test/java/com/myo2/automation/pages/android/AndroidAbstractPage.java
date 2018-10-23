package com.myo2.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

public abstract class AndroidAbstractPage {

    protected AndroidDriver driver;

    @Autowired
    AndroidAbstractPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/action_home")
    protected MobileElement homeTab;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/action_help")
    protected MobileElement helpTab;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/action_account")
    protected MobileElement AccountTab;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/action_mycard")
    protected MobileElement cardTab;

    void scrollToStringDisplayed(String str) {
        ((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
                        + str + "\").instance(0))");
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
