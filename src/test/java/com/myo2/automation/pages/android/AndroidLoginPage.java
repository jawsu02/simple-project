package com.myo2.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Lazy
@Component
public class AndroidLoginPage extends AndroidAbstractPage {

    @Autowired
    public AndroidLoginPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/editText_username")
    private MobileElement username;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/editText_password")
    private MobileElement password;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/button_login")
    private MobileElement login;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/button_forgot_password")
    private MobileElement forgotPassword;

    @AndroidFindBy(id = "Toggle password visibility")
    private MobileElement revealPassword;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/textview_register")
    private MobileElement registerHere;

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/textview_join")
    private MobileElement joinPP;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private MobileElement close;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
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
        driver.hideKeyboard();
        this.forgotPassword.click();
    }

    public void tapOnRevealPassword() {
        revealPassword.click();
    }

    public void tapOnRegisterHere() {
        driver.hideKeyboard();
        tapOnLinkInsideTextView(registerHere);
    }

    public void tapOnJoinPP() {
        driver.hideKeyboard();
        tapOnLinkInsideTextView(joinPP);
    }

    public void login(String userName, String password) {
        inputUserName(userName);
        inputPassword(password);
        tapOnLoginButton();
        WaitUntilEitherOfElementIsVisible(login,homeTab);
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
        return password.getText();}
}
