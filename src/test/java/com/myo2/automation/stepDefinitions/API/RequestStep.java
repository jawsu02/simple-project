package com.myo2.automation.stepDefinitions.API;

import com.google.gson.JsonObject;
import com.myo2.automation.utils.ApiClient;
import com.myo2.automation.session.SessionVariablesApi;
import com.myo2.automation.utils.Data;
import com.myo2.automation.utils.UriResources;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static io.restassured.RestAssured.*;

public class RequestStep {

    @Autowired
    SessionVariablesApi sessionVariablesApi;

    @Autowired
    ApiClient apiClient;

    @Autowired
    Data data;

    @Autowired
    UriResources uriResources;

    @Given("^I set (.*) basic authentication credentials$")
    public void setBasicAuthentication(String basicAuthenticationType) throws Throwable {
        switch (basicAuthenticationType.toUpperCase()) {
            case "VALID":
                sessionVariablesApi.getRequestSpecBuilder().setAuth(preemptive().basic(sessionVariablesApi.getBasicAuthUser(), sessionVariablesApi.getBasicAuthPassword()));
                break;
            case "INVALID_USER":
                sessionVariablesApi.getRequestSpecBuilder().setAuth(preemptive().basic("INVALID", sessionVariablesApi.getBasicAuthPassword()));
                break;
            case "INVALID_PASSWORD":
                sessionVariablesApi.getRequestSpecBuilder().setAuth(preemptive().basic(sessionVariablesApi.getBasicAuthUser(), "INVALID"));
                break;
        }
    }

    @And("^I set client_credentials_flow form parameters to (.*) details")
    public void setClientCredentialsFlowParams(String clientCredentialsType) throws Throwable {
        sessionVariablesApi.getRequestSpecBuilder().addHeader("Content-Type", "application/x-www-form-urlencoded");

        switch (clientCredentialsType.toUpperCase()) {
            case "VALID":
                sessionVariablesApi.getRequestSpecBuilder().addFormParam("grant_type", "client_credentials");
                break;
            case "INVALID_TYPE":
                sessionVariablesApi.getRequestSpecBuilder().addFormParam("INVALID", "client_credentials");
                break;
            case "INVALID_VALUE":
                sessionVariablesApi.getRequestSpecBuilder().addFormParam("grant_type", "INVALID");
                break;
        }
    }

    @When("^I perform (.*) on (.*) resource$")
    public void iPerformRequest(String httpMethod, String resource) throws Throwable {
        sessionVariablesApi.setResponse(
                apiClient.performRequest(given().spec(
                        sessionVariablesApi.getRequestSpecBuilder().build()),
                        uriResources.getUriFor(resource.toUpperCase()), httpMethod)
        );
    }

    @And("^I set password_flow form parameters to (.*) details$")
    public void setPasswordFlowParams(String passwordFlowParamsType) throws Throwable {
        sessionVariablesApi.getRequestSpecBuilder().addHeader("Content-Type", "application/x-www-form-urlencoded");
        switch (passwordFlowParamsType.toUpperCase()) {
            case "VALID":
                sessionVariablesApi.getRequestSpecBuilder().addFormParam("grant_type", "password");
                sessionVariablesApi.getRequestSpecBuilder().addFormParam("username", data.getElementDataForProfile("DEFAULT", "username"));
                sessionVariablesApi.getRequestSpecBuilder().addFormParam("password", DigestUtils.sha256Hex(data.getElementDataForProfile("DEFAULT", "password")).toUpperCase());
                break;
            case "INVALID_GRANT":
                sessionVariablesApi.getRequestSpecBuilder().addFormParam("grant_type", "INVALID");
                sessionVariablesApi.getRequestSpecBuilder().addFormParam("username", data.getElementDataForProfile("DEFAULT", "username"));
                sessionVariablesApi.getRequestSpecBuilder().addFormParam("password", DigestUtils.sha256Hex(data.getElementDataForProfile("DEFAULT", "password")).toUpperCase());
                break;
            case "INVALID_CREDS":
                sessionVariablesApi.getRequestSpecBuilder().addFormParam("grant_type", "password");
                sessionVariablesApi.getRequestSpecBuilder().addFormParam("username", "INVALID");
                sessionVariablesApi.getRequestSpecBuilder().addFormParam("password", "INVALID");
                break;
            default:
                sessionVariablesApi.getRequestSpecBuilder().addFormParam("grant_type", "password");
                sessionVariablesApi.getRequestSpecBuilder().addFormParam("username", data.getElementDataForProfile(passwordFlowParamsType.toUpperCase(), "username"));
                sessionVariablesApi.getRequestSpecBuilder().addFormParam("password", DigestUtils.sha256Hex(data.getElementDataForProfile(passwordFlowParamsType.toUpperCase(), "password")).toUpperCase());
        }
    }

    @Given("^I set bearer token to (.*)")
    public void setBearerTokenTo(String valueToUse) throws Throwable {
        sessionVariablesApi.getRequestSpecBuilder().setAuth(oauth2(sessionVariablesApi.getGlobalVariables(valueToUse)));
    }

    @Given("^I create a NEW (.*) request$")
    public void iCreateANewRequest(String platform) throws Throwable {
        switch (platform.toUpperCase()) {
            case "XAPI":
                sessionVariablesApi.createXApiNewSpecBuilder();
                break;
            case "HTTP":
                sessionVariablesApi.createHTTPNewSpecBuilder();
                break;
            default:
                sessionVariablesApi.createLBNewSpecBuilder();
        }
    }

    @And("^I set request body to json with$")
    public void iSetRequestBodyToJsonWith(DataTable dataTable) throws Throwable {
        List<List<String>> data = dataTable.raw();
        JsonObject jsonObject = new JsonObject();
        for (int i = 0; i < data.size(); i++) {
            jsonObject.addProperty(data.get(i).get(0), data.get(i).get(1));
        }
        sessionVariablesApi.getRequestSpecBuilder().setBody(jsonObject.toString());
    }

    @And("^I set query parameters (.*) to (.*)$")
    public void iSetQueryParameter(String key, String value) throws Throwable {
        sessionVariablesApi.getRequestSpecBuilder().addQueryParam(key, determineValue(value));
    }

    @And("^I set path parameters (.*) to (.*)$")
    public void iSetPathParameter(String key, String value) throws Throwable {
        sessionVariablesApi.getRequestSpecBuilder().addPathParam(key, determineValue(value));
    }

    @And("^I set header (.*) to (.*)$")
    public void iSetHeader(String key, String value) throws Throwable {
        sessionVariablesApi.getRequestSpecBuilder().addHeader(key, determineValue(value));
    }

    @And("^I set form parameter (.*) to (.*)")
    public void iSetFormParameter(String key, String value) throws Throwable {
        sessionVariablesApi.getRequestSpecBuilder().addFormParam(key, determineValue(value));
    }

    private String determineValue(String value) {

        if (value.contains("SESSION:")) {
            return sessionVariablesApi.getGlobalVariables(value.replace("SESSION:", "").trim());
        } else if (value.contains("DATA:")) {
            return data.getElementDataForProfile(value.split(":")[1], value.split(":")[2]);
        } else {
            return value;
        }
    }
}
