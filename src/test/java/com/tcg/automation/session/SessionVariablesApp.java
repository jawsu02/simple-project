package com.tcg.automation.session;


import com.github.tomakehurst.wiremock.admin.RequestSpec;
import com.tcg.automation.strategy.PageStrategy;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile("APP")
@Component
public class SessionVariablesApp {

    @Value("${url}")
    private String webUrl;

    @Value("${android_device}")
    private String androidDevice;
    @Value("${android_os}")
    private String androidOs;
    @Value("${appAndroidPath}")
    private String appAndroidPath;
    @Value("${appIOSSimulatorPath}")
    private String appIOSSimulatorPath;
    @Value("${android_mock}")
    private String androidMockHost;

    @Value("${ios_udid}")
    private String iosUdid;
    @Value("${ios_os}")
    private String iosOs;
    @Value("${appIOSDevicePath}")
    private String appIOSDevicePath;
    @Value("${ios_mock}")
    private String iosMockHost;

    private PageStrategy driver;
    private String mockPath;

    RequestSpecBuilder requestSpecBuilder;

    public String getAndroidDevice() {
        return androidDevice;
    }

    public String getAndroidOs() {
        return androidOs;
    }

    public String getIosUdid() {
        return iosUdid;
    }

    public String getIosOs() {
        return iosOs;
    }

    public PageStrategy getDriver() {
        return driver;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setDriver(PageStrategy driver) {
        this.driver = driver;
    }

    public String getAppAndroidPath() {
        return System.getProperty("user.dir") + appAndroidPath;
    }

    public String getAppIOSDevicePath() {
        return System.getProperty("user.dir") + appIOSDevicePath;
    }

    public String getAppIOSSimulatorPath() {
        return System.getProperty("user.dir") + appIOSSimulatorPath;
    }

    public String getIosMockHost() {
        return iosMockHost;
    }

    public String getAndroidMockHost() {
        return androidMockHost;
    }

    public void setMockPath(String mockPath) {
        this.mockPath = mockPath;
    }

    public String getMockPath() {
        return mockPath;
    }

    public void createMockRequestSpecBuilder() {
        requestSpecBuilder = new RequestSpecBuilder().setBaseUri(getMockPath());
    }

    public RequestSpecBuilder getRequestSpecBuilder() {
        return requestSpecBuilder;
    }

}
