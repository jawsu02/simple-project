package com.myo2.automation.utils;

import com.myo2.automation.session.SessionVariablesApp;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Profile("APP")
@Component
public class MockUtils {
    private SessionVariablesApp sessionVariablesApp;

    @Autowired
    private ApiClient apiClient;

    @Autowired
    public MockUtils(SessionVariablesApp sessionVariablesApp) {
        this.sessionVariablesApp = sessionVariablesApp;
    }

    public void createDefaultMappingFor(String endpointName) throws FileNotFoundException {
        sessionVariablesApp.createMockRequestSpecBuilder();
        String fileToRead = System.getProperty("user.dir") + "/src/test/resources/com/myo2/automation/responseFiles/";
        String urlPattern = "";
        String methodToMock = "";

        switch (endpointName.toLowerCase()) {
            case "airports":
                fileToRead = fileToRead + "airports.json";
                urlPattern = "/prioritypass/v1/airports.*";
                methodToMock = "GET";
                break;
            case "lounges":
                fileToRead = fileToRead + "lounges.json";
                urlPattern = "/prioritypass/v1/lounges.*";
                methodToMock = "GET";
                break;
            case "head_airports":
                fileToRead = fileToRead + "airports.json";
                urlPattern = "/prioritypass/v1/airports.*";
                methodToMock = "HEAD";
                break;
            case "head_lounges":
                fileToRead = fileToRead + "lounges.json";
                urlPattern = "/prioritypass/v1/lounges.*";
                methodToMock = "HEAD";
                break;
            case "client_token":
                fileToRead = fileToRead + "clientToken.json";
                urlPattern = "/oauth/v1/token";
                methodToMock = "POST";
                break;
            case "generate_tokens":
                fileToRead = fileToRead + "generateTokens.json";
                urlPattern = "/prioritypass/v1/consumer/offers/generateTokens.*";
                methodToMock = "GET";
                break;
            case "offersets":
                fileToRead = fileToRead + "offerSets.json";
                urlPattern = "/prioritypass/v1/consumer/offerSet.*";
                methodToMock = "GET";
                break;
            case "userinfo":
                fileToRead = fileToRead + "userInfo.json";
                urlPattern = "/prioritypass/v1/consumer/userInfo";
                methodToMock = "GET";
                break;
            case "user_token":
                fileToRead = fileToRead + "userToken.json";
                urlPattern = "/oauth/v1/token";
                methodToMock = "POST";
                break;
            case "visits":
                fileToRead = fileToRead + "visits.json";
                urlPattern = "/prioritypass/v1/consumer/visits.*";
                methodToMock = "GET";
                break;
            case "real_time_allocation":
                fileToRead = fileToRead + "realtimeAllocation.json";
                urlPattern = "/prioritypass/v1/consumer/realtimeAllocation.*";
                methodToMock = "GET";
                break;
            case "faq":
                fileToRead = fileToRead + "faq.json";
                urlPattern = "/prioritypass/v1/FAQs.*";
                methodToMock = "GET";
                break;
        }

        String mockResponseBody = new Scanner(new File(fileToRead)).useDelimiter("\\Z").next();
        sessionVariablesApp.getRequestSpecBuilder().setBody(buildRequestBodyForMock(methodToMock, urlPattern, 200, mockResponseBody));
        Response stubCreationResponse = apiClient.performRequest(given().spec(sessionVariablesApp.getRequestSpecBuilder().build()), "__admin/mappings/new", "POST");

        assertEquals("stub creation failed for resource: " + endpointName, 201, stubCreationResponse.statusCode());
    }

    public void resetMappings() {
        sessionVariablesApp.createMockRequestSpecBuilder();
        Response stubCreationResponse = apiClient.performRequest(given().spec(sessionVariablesApp.getRequestSpecBuilder().build()), "__admin/mappings/reset", "POST");
        assertEquals("reset mappings failed on Mock", 200, stubCreationResponse.statusCode());
    }

    private String buildRequestBodyForMock(String methodToMock, String urlPattern, int httpStatus, String mockResponseBody) {

        JSONObject mockRequestBody = new JSONObject();
        JSONObject requestBody = new JSONObject();
        JSONObject responseBody = new JSONObject();
        JSONObject responseHeaders = new JSONObject();

        requestBody.put("method", methodToMock);
        requestBody.put("urlPattern", urlPattern);

        String generatedMD5 = DigestUtils.md5Hex(mockResponseBody);

        responseHeaders.put("ETag", '"' + generatedMD5 + '"');
        responseHeaders.put("Content-MD5", generatedMD5);
        responseHeaders.put("Content-Type", "application/json;charset=UTF-8");

        responseBody.put("status", httpStatus);
        responseBody.put("headers", responseHeaders);
        responseBody.put("body", mockResponseBody);

        mockRequestBody.put("request", requestBody);
        mockRequestBody.put("response", responseBody);
        mockRequestBody.put("priority", 1);

        return mockRequestBody.toJSONString();
    }
}
