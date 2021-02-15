package stepDefinitions.web;

import ExtentReport.ExtentReportUtils;
import cucumber.ScenarioContext;
import cucumber.TestContext;

public class WebCommon_TestStepDefinition extends ExtentReportUtils {
	 private ScenarioContext scenarioContext;

	public WebCommon_TestStepDefinition(TestContext testContext) 
	{
		scenarioContext = testContext.getScenarioContext();
	}
	
	
	 public ScenarioContext getScenarioContext() {
	        return scenarioContext;
	    }

}
