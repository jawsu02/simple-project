package com.tcg.automation.pages.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Lazy
@Component
public class IOSLoginPage extends IOSAbstractPage {

    @Autowired
    public IOSLoginPage(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name='Priority Pass']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    private MobileElement username;

    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name='Priority Pass']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField")
    private MobileElement password;

    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name='Priority Pass']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
    private MobileElement clearPasswordField;

    @iOSFindBy(accessibility = "LOG IN")
    private MobileElement login;

    @iOSFindBy(accessibility = "Forgot details?")
    private MobileElement forgotPassword;

    @iOSFindBy(id = "show")
    private MobileElement revealPassword;

    @iOSFindBy(accessibility = "Register here")
    private MobileElement registerHere;

    @iOSFindBy(accessibility = "Join Priority Pass")
    private MobileElement joinPP;

    @iOSFindBy(accessibility = "close")
    private MobileElement close;

    @iOSFindBy(accessibility = "close")
    private MobileElement loginError;

    public void inputUserName(String user) {
        this.username.sendKeys(user);
    }

    public void inputPassword(String password) {
        this.password.sendKeys(password);
    }

    public void tapOnLoginButton() {
        this.login.click();
    }

    public void tapOnForgotPassword() {
        this.forgotPassword.click();
    }

    public void tapOnRevealPassword() {
        revealPassword.click();
    }

    public void tapOnRegisterHere() {
        registerHere.click();
    }

    public void tapOnJoinPP() {
        joinPP.click();
    }

    public void login(String userName, String password) {
        inputUserName(userName);
        inputPassword(password);
        tapOnLoginButton();
        WaitUntilEitherOfElementIsVisible(homeTab, login);
    }

    public boolean isLoginErrorDisplayed() {
        return loginError.isDisplayed();
    }

    public String getPasswordFieldText() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (isElementPresentAndDisplayed(password)) ? password.getText() : clearPasswordField.getText();

    }
}
