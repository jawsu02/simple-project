package com.tcg.automation.stepDefinitions.API;

import com.tcg.automation.session.SessionVariablesApi;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertThat;

public class ResponseStep {
    @Autowired
    SessionVariablesApi sessionVariablesApi;

    @Then("^response status code should be (\\d+)$")
    public void responseCodeShouldBe(int responseStatusCode) throws Throwable {
        assertEquals("Response code is incorrect", responseStatusCode, sessionVariablesApi.getResponse().statusCode());
    }

    @And("^response body should contain key (.*)$")
    public void responseBodyShouldContain(String tag) throws Throwable {
        assertTrue("Response body missing expected key: " + tag, sessionVariablesApi.getResponse().getBody().jsonPath().getString(tag) != null);
    }

    @And("^I store the value of body path (.*) as (.*)$")
    public void storeValueOfPathInVariable(String path, String keyToUse) throws Throwable {
        sessionVariablesApi.setGlobalVariable(keyToUse, sessionVariablesApi.getResponse().getBody().jsonPath().get(path).toString());
    }

    @And("^response body should contain value of (.*) for key (.*)")
    public void responseBodyShouldContainValueForKey(String value, String key) throws Throwable {
        assertEquals("Value is incorrect for key: " + key, value, sessionVariablesApi.getResponse().getBody().jsonPath().get(key).toString());
    }

    @And("^response body should be valid according to schema file (.*)$")
    public void responseBodyShouldAdhereSchema(String file) throws Throwable {
        assertThat(sessionVariablesApi.getResponse().getBody().asString(), matchesJsonSchema(new File(sessionVariablesApi.getSchemaFilesLocation() + file)));
    }

    @When("^I store the size of body path (.*) as (.*)")
    public void iStoreTheValueOfSize(String path, String keyToUse) throws Throwable {
        sessionVariablesApi.setGlobalVariable(keyToUse, String.valueOf(sessionVariablesApi.getResponse().getBody().jsonPath().getList(path).size()));
    }

    @When("^I store the response body as (.*)")
    public void iStoreResponseBody(String keyToUse) throws Throwable {
        sessionVariablesApi.setGlobalVariable(keyToUse, sessionVariablesApi.getResponse().getBody().toString());
    }

    @Then("^(.*) should be equal to (.*)")
    public void compareSessionVariables(String key1, String key2) throws Throwable {
        assertEquals("Session variables are not equal", sessionVariablesApi.getGlobalVariables(key1), sessionVariablesApi.getGlobalVariables(key2));
    }

    @And("^I print the response body$")
    public void iPrintTheResponseBody() throws Throwable {
        sessionVariablesApi.getResponse().prettyPrint();
    }

}
