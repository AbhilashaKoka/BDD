package stepDefinitions.apisteps;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertThat;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;

import apiPageObjects.RestAssuredExtension;
import apiPageObjects.RestAssuredExtensionv2;
import cucumber.APITestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import managers.FileReaderManager;

public class JsonValidation_StepDefinition{	
	public static ResponseOptions<Response> response;
	public static String token;
	private static ExtentTest test;
	public  String baseURL=FileReaderManager.getInstance().getConfigReader().getBaseUrl();
	final static Logger LOGGER=LogManager.getLogger(ComplexGetData_TestStepDefinition.class);
	 RestAssuredExtensionv2 restAssuredExtensionv2;

		public JsonValidation_StepDefinition(APITestContext testContext) {
			super();
			restAssuredExtensionv2=testContext.getRestAssuredExtensionv2();
		}
		
		@Given("I perform GET operation for {string}")
		public void i_perform_GET_operation_for(String url) {
			 try {
				// response=RestAssuredExtension.GetOpsWithToken(url, response.getBody().jsonPath().get("access_token"));
				 response=RestAssuredExtension.GetOpsWithToken(url, token);
				 System.out.println(response.getBody().print());
				// myComponent.getResource(url);
			     }
		   catch(Exception ex) 
				 {
			     System.out.println(ex.getStackTrace());   
				 System.out.println(ex.getMessage());
				 }
		}

		@Then("I should see the author name as {string} with json validation")
		public void i_should_see_the_author_name_as_with_json_validation(String string) {
		    try {	    	
		         String resposeBody=response.getBody().asString();
		    	 assertThat(resposeBody, matchesJsonSchemaInClasspath("post.json"));
		   	    }
		    catch(Exception ex)
		    {
		    	ex.getMessage();
		    	LOGGER.error(ex.getMessage());
		    }
		   LOGGER.info("I should see the author name as"+string+" with json validation"); 
		}
}
