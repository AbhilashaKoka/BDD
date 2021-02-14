package stepDefinitions.apisteps;
import cucumber.APITestContext;
import cucumber.ScenarioContext;
import cucumber.TestContext;
import enums.Context;
import enums.DocumentType;

import static org.hamcrest.Matchers.equalToObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtentReport.ExtentReportUtils;
import apiPageObjects.RestAssuredExtension;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import stepDefinitions.mobilesteps.AppiumUtils;
import io.cucumber.core.api.Scenario;



public class APIUtils extends ExtentReportUtils{
	APITestContext testContext;
	private static ExtentTest test;
	private static  Scenario scenario;	
	final static Logger LOGGER=LogManager.getLogger(APIUtils.class);
	String logPath=System.getProperty("user.dir")+"\\Configs\\log4j.properties";
	private ScenarioContext scenarioContext;
	
	public APIUtils(APITestContext context) 
	{		
	
		testContext = context;
		Object rest = testContext.getScenarioContext().getContext(DocumentType.RESPONSE);
	}

	@Before
	public void testSetUp(Scenario scenario) 
	{
	    PropertyConfigurator.configure(logPath);	
		LOGGER.info("I am inside setup");
	//    RestAssuredExtension restAssuredExtension=new RestAssuredExtension();
		APIUtils.scenario=scenario;		
    	scenario.write("API Test Setup........................");
    	ExtentReportUtils.setExtent();
	}
	
	
	@AfterStep
	public void AfterSteps(Scenario scenario)
	{
	AppiumUtils.scenario=scenario;
	if(scenario.isFailed()){
	try{
	LOGGER.info(Status.FAIL);
	scenario.write(" Test Step is Fail");
	ExtentReportUtils.tearDown();
	}
	catch(Exception e)
	{
	LOGGER.error(e.getMessage());
	e.printStackTrace();
	}
	}
	else{
	try
	 {
	LOGGER.info(Status.PASS);	
	scenario.write(" Test Step is pass");

//	scenarioContext.getContext(Context.USER);
      }
	catch(Exception e){
	e.printStackTrace();
	LOGGER.error(e.getMessage());
	}
	}
	}
	
	

}
