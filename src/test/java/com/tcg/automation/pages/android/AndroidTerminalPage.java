package com.tcg.automation.pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class AndroidTerminalPage extends AndroidAbstractPage {

    AndroidTerminalPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.tigerspike.prioritypass:id/name")
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
