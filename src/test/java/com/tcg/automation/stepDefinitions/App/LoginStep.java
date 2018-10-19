package com.tcg.automation.stepDefinitions.App;

import com.tcg.automation.session.SessionVariablesApp;
import com.tcg.automation.utils.Users;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;


public class LoginStep {
    @Autowired
    private SessionVariablesApp sessionVariablesApp;

    @Autowired
    private Users users;

    @When("^i sign in with '(.*)', '(.*)'$")
    public void signInWith(String user, String password) throws Throwable {
        sessionVariablesApp.getDriver().loginFromHome(user, password);
    }

    @When("^i sign in with (.*) user profile$")
    public void signInWithProfile(String userProfile) throws Throwable {
        sessionVariablesApp.getDriver().loginFromHome(users.getUserName(userProfile), users.getPassword(userProfile));
    }

    @Then("^i should be logged out$")
    public void iShouldBeLoggedOut() throws Throwable {
        sessionVariablesApp.getDriver().userShouldBeLoggedOutAndOnAccountScreen();
    }

    @And("^i sign in with (.*) user profile from Account$")
    public void iSignInWithFromAccount(String userProfile) throws Throwable {
        sessionVariablesApp.getDriver().loginFromAccount(users.getUserName(userProfile), users.getPassword(userProfile));
    }

    @When("^i input (.*) in password field$")
    public void iInputDataIntoField(String textToInput) throws Throwable {
        sessionVariablesApp.getDriver().inputDataIntoPasswordField(textToInput);
    }

    @Then("^the value in password field should be (.*)$")
    public void compareValueOfField(String valueToCompare) throws Throwable {
        sessionVariablesApp.getDriver().verifyValueInPasswordFieldIs(valueToCompare);
    }
}
