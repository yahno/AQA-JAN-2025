package org.prog.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/homeWorkFS.feature",
        glue = "org.prog.cucumber.steps_fakestore") //шлях де шукати кроки

public class CucumberRunnerFS extends AbstractTestNGCucumberTests {


}
