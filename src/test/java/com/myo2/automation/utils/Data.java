package com.myo2.automation.utils;

import com.myo2.automation.session.SessionVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

@Component
public class Data {

    private Map<String, Map<String, String>> values;

    @Autowired
    public Data(SessionVariables sessionVariables) {
        Yaml yaml = new Yaml();
        try {
            values = (Map<String, Map<String, String>>) yaml
                    .load(new FileInputStream(new File(sessionVariables.getUsersFilePath())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getElementDataForProfile(String profile, String element) {
        return values.get(profile).get(element);
    }
}
