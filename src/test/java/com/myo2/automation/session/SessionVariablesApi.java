package com.myo2.automation.session;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

@Profile("!APP")
@Component
public class SessionVariablesApi {

    @Value("${xapiScheme}")
    private String xapiScheme;
    @Value("${xapiHost}")
    private String xapiHost;

    @Value("${lbScheme}")
    private String lbScheme;
    @Value("${lbHost}")
    private String lbHost;

    @Value("${basicAuthUser}")
    private String basicAuthUser;
    @Value("${basicAuthPassword}")
    private String basicAuthPassword;

    RequestSpecBuilder requestSpecBuilder;
    private Response response;

    private HashMap<String, String> globalVariables = new HashMap<String, String>();

    public void createXApiNewSpecBuilder() {
        requestSpecBuilder = new RequestSpecBuilder().setBaseUri(xapiScheme + "://" + xapiHost);
    }

    public void createHTTPNewSpecBuilder() {
        requestSpecBuilder = new RequestSpecBuilder().setBaseUri("http://" + xapiHost);
    }

    public void createLBNewSpecBuilder() {
        requestSpecBuilder = new RequestSpecBuilder().setBaseUri(lbScheme + "://" + lbHost);
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getGlobalVariables(String valueToUse) {
        return globalVariables.get(valueToUse);
    }

    public void setGlobalVariable(String key, String value) {
        this.globalVariables.put(key, value);
    }

    public String getSchemaFilesLocation() {
        return System.getProperty("user.dir") + "/src/test/resources/com/myo2/automation/schemaFiles/";
    }

    public String getQueryFilesLocation() {
        return System.getProperty("user.dir") + "/src/test/resources/com/myo2/automation/queryFiles/";
    }

    public String getUriResourcesFilePath() {
        return System.getProperty("user.dir") + "/src/test/resources/com/myo2/automation/config/url.properties";
    }

    public String getXapiScheme() {
        return xapiScheme;
    }

    public String getXapiHost() {
        return xapiHost;
    }

    public String getLbScheme() {
        return lbScheme;
    }

    public String getLbHost() {
        return lbHost;
    }

    public String getBasicAuthUser() {
        return basicAuthUser;
    }

    public String getBasicAuthPassword() {
        return basicAuthPassword;
    }

    public RequestSpecBuilder getRequestSpecBuilder() {
        return requestSpecBuilder;
    }
}