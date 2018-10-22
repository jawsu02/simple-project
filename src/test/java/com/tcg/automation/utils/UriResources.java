package com.tcg.automation.utils;

import com.tcg.automation.session.SessionVariablesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Profile("!APP")
@Component
public class UriResources {

    private Map<String, String> uriResources = new HashMap<String,String>();

    @Autowired
    public UriResources(SessionVariablesApi sessionVariablesApi) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(sessionVariablesApi.getUriResourcesFilePath())));
            for (String key : properties.stringPropertyNames()) {
                String value = properties.getProperty(key);
                uriResources.put(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUriFor(String UriName) {
        return uriResources.getOrDefault(UriName, UriName);
    }
}
