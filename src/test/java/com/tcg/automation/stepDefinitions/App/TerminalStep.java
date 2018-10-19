package com.tcg.automation.stepDefinitions.App;

import com.tcg.automation.session.SessionVariablesApp;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class TerminalStep {
    @Autowired
    SessionVariablesApp sessionVariablesApp;

    @And("^i input (.*) in quick search$")
    public void inputInQuickSearch(String searchText) throws Throwable {
        sessionVariablesApp.getDriver().inputTextInQuickSearch(searchText);
    }

    @When("^i select result (\\d+) in Airports$")
    public void iSelectAirport(int airportNo) throws Throwable {
        sessionVariablesApp.getDriver().selectAirportFromList(airportNo);
    }

    @And("^i select result (\\d+) in Terminals$")
    public void iSelectTerminal(int terminalNo) throws Throwable {
        sessionVariablesApp.getDriver().selectTerminalFromList(terminalNo);
    }

    @Then("^(\\d+) terminals should be displayed$")
    public void terminalsShouldBeDisplayed(int terminals) throws Throwable {
        sessionVariablesApp.getDriver().verifyTerminalsDisplayed(terminals);
    }
}
