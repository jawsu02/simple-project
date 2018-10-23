package com.myo2.automation.utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class ApiClient {

    @Autowired
    public ApiClient() {
    }

    public Response performRequest(RequestSpecification requestSpec, String endpointURL, String httpMethod) {

        switch (httpMethod) {
            case "POST":
                // Return the response from the POST request using rest-assured client.
                return requestSpec.post(endpointURL).andReturn();
            case "PUT":
                // Return the response from the POST request using rest-assured client.
                return requestSpec.put(endpointURL).andReturn();
            case "DELETE":
                // Return the response from the DELETE request using rest-assured client.
                return requestSpec.delete(endpointURL).andReturn();
            case "HEAD":
                // Return the response from the HEAD request using rest-assured client.
                return requestSpec.head(endpointURL).andReturn();
            case "PATCH":
                // Return the response from the PATCH request using rest-assured client.
                return requestSpec.patch(endpointURL).andReturn();
            case "OPTIONS":
                // Return the response from the OPTIONS request using rest-assured client.
                return requestSpec.options(endpointURL).andReturn();
            default:
                // Return the response from the GET request using rest-assured client.
                return requestSpec.get(endpointURL).andReturn();
        }
    }
}
