package com.tcg.automation.pages.web;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class WebLoginPage extends WebAbstractPage {

    WebLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='sign-in-process']/div/div/div[1]/div/section[1]/div[1]/button")
    private WebElement loginUsingUserName;

    @FindBy(xpath = "//*[@id='sign-in-process']/div/div/div[1]/div/section[2]/div[1]/button")
    private WebElement loginUsingMembershipNumber;

    @FindBy(xpath = "//*[@id='Username_FormField']")
    private WebElement username;

    @FindBy(xpath = "//*[@id=\"Password_FormField\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"sign-in-process\"]/div/div/div[1]/div/section[1]/div[2]/div/div[7]/div/button")
    private WebElement login;

    @FindBy(partialLinkText = "REGISTER")
    private WebElement registerHere;

    @FindBy(partialLinkText = "Forgot your details")
    private WebElement forgotPassword;

    public void clickLoginUsingUserName() {
        loginUsingUserName.click();
    }

    public void inputUserName(String user) {
        this.username.sendKeys(user);
    }

    public void inputPassword(String password) {
        this.password.sendKeys(password);
    }

    public void tapOnLoginButton() {
        this.login.click();
    }

    public void login(String userName, String password) {
        WaitUntilElementIsVisible(username);
        inputUserName(userName);
        inputPassword(password);
        tapOnLoginButton();
    }

    public void tapOnForgotDetails() {
        WaitUntilElementIsVisible(forgotPassword);
        this.forgotPassword.click();
    }

    public void tapOnRegisterHere() {
        this.registerHere.click();
    }

    public void tapOnJoinPP() {
        this.joinPP.click();
    }
}
