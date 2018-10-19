package com.tcg.automation.pages.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class IOSTerminalPage extends IOSAbstractPage {
    @Autowired
    IOSTerminalPage(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
    private List<MobileElement> terminal;

    public int getNumberOfTerminalsDisplayed() {
        return terminal.size();
    }

    public void tapOnTerminal(int number) {
        terminal.get(number - 1).click();
    }

    public String getTerminalName(int number) {
        return terminal.get(number - 1).getText();
    }
}
