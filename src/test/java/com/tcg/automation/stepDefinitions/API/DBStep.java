package com.tcg.automation.stepDefinitions.API;

import com.tcg.automation.session.SessionVariablesApi;
import com.tcg.automation.utils.DBUtils;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

public class DBStep {
    @Autowired
    SessionVariablesApi sessionVariablesApi;
    @Autowired
    DBUtils dbUtils;

    @And("^database count for (.*) should be equal to (.*)")
    public void databaseCountShouldBe(String queryFile, String valueToCompare) throws Throwable {

        String queryStatement = new Scanner(new File(sessionVariablesApi.getQueryFilesLocation() + queryFile + ".sql")).useDelimiter("\\Z").next();
        assertEquals("count from database is not as expected, ",
                sessionVariablesApi.getGlobalVariables(valueToCompare),
                String.valueOf(dbUtils.executeStatement(queryStatement).getInt(1)));
    }

    @And("^I store the database count for (.*) with params (.*), (.*) as (.*)")
    public void iFetchCountWithParamsIn(String queryFile, String param1, String param2, String keyToUse) throws Throwable {
        String queryStatement = new Scanner(new File(sessionVariablesApi.getQueryFilesLocation() + queryFile + ".sql")).useDelimiter("\\Z").next();
        queryStatement = queryStatement.replace("PARAM1", param1).replace("PARAM2", param2);
        sessionVariablesApi.setGlobalVariable(keyToUse, String.valueOf(dbUtils.executeStatement(queryStatement).getInt(1)));
    }
}
