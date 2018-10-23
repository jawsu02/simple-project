package com.myo2.automation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(format = {"json:target/myo2/cucumber.json"}, tags = "@Test")
public class RunTests {
}