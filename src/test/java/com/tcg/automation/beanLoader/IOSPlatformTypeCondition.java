package com.tcg.automation.beanLoader;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;


public class IOSPlatformTypeCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String platformType = System.getProperty("PLATFORM");
        return (platformType != null && platformType.equalsIgnoreCase("IOS"));
    }
}