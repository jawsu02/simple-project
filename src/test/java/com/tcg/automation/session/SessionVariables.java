package com.tcg.automation.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SessionVariables {
    @Autowired
    private Environment environment;

    public String getUsersFilePath() {
        return System.getProperty("user.dir") + "/src/test/resources/com/tcg/automation/config/data-" + this.environment.getActiveProfiles()[0].toLowerCase() + ".yml";
    }

}
