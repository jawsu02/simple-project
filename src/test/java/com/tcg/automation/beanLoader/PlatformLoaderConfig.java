package com.tcg.automation.beanLoader;

import com.tcg.automation.config.AndroidDriverFactory;
import com.tcg.automation.config.IOSDriverFactory;
import com.tcg.automation.config.WebDriverFactory;
import com.tcg.automation.session.SessionVariablesApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by rajkumar.engu on 06/02/18.
 */
@Profile("APP")
@Configuration
public class PlatformLoaderConfig {

    @Autowired
    SessionVariablesApp sessionVariablesApp;

    @Bean
    @Conditional(AndroidPlatformTypeCondition.class)
    public AndroidDriverFactory androidDriver() {
        return new AndroidDriverFactory(sessionVariablesApp);
    }

    @Bean
    @Conditional(IOSPlatformTypeCondition.class)
    public IOSDriverFactory iosDriver() {
        return new IOSDriverFactory(sessionVariablesApp);
    }

    @Bean
    @Conditional(WebPlatformTypeCondition.class)
    public WebDriverFactory webDriver() {
        return new WebDriverFactory(sessionVariablesApp);
    }
}
