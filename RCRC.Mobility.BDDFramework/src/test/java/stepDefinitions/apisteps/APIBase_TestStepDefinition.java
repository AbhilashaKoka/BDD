package stepDefinitions.apisteps;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;

import ExtentReport.APIVerification;
import Utility.APIConstant;
import apiPageObjects.RestAssuredExtensionv2;
import cucumber.APITestContext;
import cucumber.ScenarioContext;
import cucumber.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import managers.FileReaderManager;

public class APIBase_TestStepDefinition {
	public static ResponseOptions<Response> response;
	public static String token;
	private static ExtentTest test;
	public  String baseURL=FileReaderManager.getInstance().getConfigReader().getBaseUrl();
	final static Logger LOGGER=LogManager.getLogger(NonBDDStyleStepDefinition.class);
	 RestAssuredExtensionv2 restAssuredExtensionv2;
	
	private ScenarioContext scenarioContext;

	public APIBase_TestStepDefinition(APITestContext testContext) {
		super();
		scenarioContext = testContext.getScenarioContext();
		restAssuredExtensionv2=testContext.getRestAssuredExtensionv2();
	}
	
	
	 public ScenarioContext getScenarioContext() {
	        return scenarioContext;
	
}
	 
	 @Given("I perform authentication operation for {string} with body")
		public void i_perform_authentication_operation_for_with_body(String url, DataTable table)
		{
			try {
			    List<List<String>> data = table.cells();
//	          TokenBody tokenBody=new TokenBody();
//			    tokenBody.setGrantType(data.get(1).get(0));
//			    tokenBody.setUsername(data.get(1).get(1));
//			    tokenBody.setPassword(data.get(1).get(2));		    
			     restAssuredExtensionv2=new RestAssuredExtensionv2(url, APIConstant.ApiMethods.POST, null,baseURL);
		        token=restAssuredExtensionv2.Authenticate2();
		      //  System.out.println("Token generated:"+token);
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
				LOGGER.error(ex.getMessage());
			}
			
        }
	 
	 
		@Then("I should see statuscode as {string}")
		public void i_should_see_statuscode_as(String statusLINE) {
		   	  try {
			     APIVerification.responseCodeValiddation(response, 200);
		         APIVerification.responseTimeValidation(response);
			     assertThat(response.getStatusLine(),equalTo(statusLINE)); 
				  }
		   	  catch(Exception ex) 
		    { 
			  System.out.println(ex.getMessage());
			  LOGGER.error(ex.getMessage());
		    }
			LOGGER.info("I should see statuscode as "+statusLINE+".........");
}
}