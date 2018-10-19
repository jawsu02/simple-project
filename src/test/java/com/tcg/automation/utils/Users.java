package com.tcg.automation.utils;

import com.tcg.automation.session.SessionVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

@Component
public class Users {

    private Map<String, Map<String, String>> values;

    @Autowired
    public Users(SessionVariables sessionVariables) {
        Yaml yaml = new Yaml();
        try {
            values = (Map<String, Map<String, String>>) yaml
                    .load(new FileInputStream(new File(sessionVariables.getUsersFilePath())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getUserName(String profile) {
        return values.get(profile).get("username");
    }

    public String getPassword(String profile) {
        return values.get(profile).get("password");
    }
}
