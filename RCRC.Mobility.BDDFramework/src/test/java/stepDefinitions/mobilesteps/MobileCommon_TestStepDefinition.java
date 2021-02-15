package stepDefinitions.mobilesteps;

import cucumber.MobileTestContext;
import cucumber.ScenarioContext;
import cucumber.TestContext;

public class MobileCommon_TestStepDefinition {
	private ScenarioContext scenarioContext;

	
	public MobileCommon_TestStepDefinition(MobileTestContext testContext) {
		super();
		scenarioContext = testContext.getScenarioContext();
	}
	
	
	 public ScenarioContext getScenarioContext() {
	        return scenarioContext;
	    }
}
