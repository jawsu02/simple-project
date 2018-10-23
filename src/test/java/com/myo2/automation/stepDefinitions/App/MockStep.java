package com.myo2.automation.stepDefinitions.App;

import cucumber.api.java.en.Given;
import com.myo2.automation.utils.MockUtils;
import com.myo2.automation.session.SessionVariablesApp;
import org.springframework.beans.factory.annotation.Autowired;

public class MockStep {
    @Autowired
    MockUtils mockUtils;

    @Given("^i mock (.*) endpoint to return (.*) response$")
    public void mockDefaultResponse(String endpoint, String responseType) throws Throwable {
        mockUtils.createDefaultMappingFor(endpoint);
    }

    @Given("^i reset mock$")
    public void resetMock() throws Throwable {
        mockUtils.resetMappings();
    }

    @Given("^i mock all login dependant endpoints to default response$")
    public void mockLoginDependantEndpointsToDefault() throws Throwable {

        mockUtils.createDefaultMappingFor("airports");
        mockUtils.createDefaultMappingFor("lounges");
        mockUtils.createDefaultMappingFor("head_airports");
        mockUtils.createDefaultMappingFor("head_lounges");
        mockUtils.createDefaultMappingFor("generate_tokens");
        mockUtils.createDefaultMappingFor("offersets");
        mockUtils.createDefaultMappingFor("userinfo");
        mockUtils.createDefaultMappingFor("user_token");
        mockUtils.createDefaultMappingFor("visits");
        mockUtils.createDefaultMappingFor("real_time_allocation");
        mockUtils.createDefaultMappingFor("faq");

    }
}
