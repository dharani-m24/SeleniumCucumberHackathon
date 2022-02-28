package com.runnerClass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles", 
				glue="com.stepDefinition",
				dryRun=false,
				plugin = {"html:target/cucumber-html-report","com.cucumber.listener.ExtentCucumberFormatter:target/ extend reports/extendreport.html"},
				tags= {"@amazon"})
public class TestRunner {

}
