package stepDefinitions.web;

import ExtentReport.ExtentReportUtils;
import cucumber.ScenarioContext;
import cucumber.TestContext;

public class WebBase_TestStepDefinition extends ExtentReportUtils {
	 private ScenarioContext scenarioContext;

	public WebBase_TestStepDefinition(TestContext testContext) 
	{
		scenarioContext = testContext.getScenarioContext();
	}
	
	
	 public ScenarioContext getScenarioContext() {
	        return scenarioContext;
	    }

}
