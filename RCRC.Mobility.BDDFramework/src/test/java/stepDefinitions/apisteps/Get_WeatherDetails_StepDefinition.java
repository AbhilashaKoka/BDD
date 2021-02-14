package stepDefinitions.apisteps;

import java.io.File;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;

import Utility.CommonUtils;
import apiPageObjects.RestAssuredExtension;
import apiPageObjects.RestAssuredExtensionv2;
import cucumber.APITestContext;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import managers.FileReaderManager;

public class Get_WeatherDetails_StepDefinition {	
	public static ResponseOptions<Response> response;
	public static String token;
	private static ExtentTest test;
	public  String baseURL=FileReaderManager.getInstance().getConfigReader().getBaseUrl();
	final static Logger LOGGER=LogManager.getLogger(ComplexGetData_TestStepDefinition.class);
	 RestAssuredExtensionv2 restAssuredExtensionv2;

		public Get_WeatherDetails_StepDefinition(APITestContext testContext) {
			super();
			restAssuredExtensionv2=testContext.getRestAssuredExtensionv2();
		}
		
		
		@When("I perform GET operation for  Weather Utilites {string}")
		public void i_perform_GET_operation_for_Weather_Utilites(String url) {
		    // Write code here that turns the phrase above into concrete actions
		   try {
			   
			    response=RestAssuredExtension.GetOpsWithToken(url, token);
			    System.out.println("**************** get the StopSeqCoord  ***************");
			    System.out.println( response.body().prettyPrint());
		        System.out.println(response.statusLine());  
		        String responseAsString= response.getBody().asString();
		        byte[] responseAsStringByte = responseAsString.getBytes();
				File targetFileForString = new File(System.getProperty("user.dir")+"//APIResource//WeatherUtilites.json");
				CommonUtils.WriteResponseOnJosonFile(responseAsStringByte,targetFileForString);
		   }
		   catch(Exception ex) {
			   System.out.println(ex.getMessage());
			     LOGGER.error(ex.getMessage()); 
		   }
		   LOGGER.info("I perform GET operation for  Weather Utilites "+url+".....");
		}
}
