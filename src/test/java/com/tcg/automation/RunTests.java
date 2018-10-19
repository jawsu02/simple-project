package com.tcg.automation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(format = {"json:target/tcg/cucumber.json"}, tags = "@Test")
public class RunTests {
}