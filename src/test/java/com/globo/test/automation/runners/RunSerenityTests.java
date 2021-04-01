package com.globo.test.automation.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.globo.test.automation.steps", "com.globo.test.automation.hooks"}
        //tags = "@teste"
        )
public class RunSerenityTests {
}
