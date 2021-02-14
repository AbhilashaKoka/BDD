package stepDefinitions.apisteps;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;

import ExtentReport.APIVerification;
import Utility.APIConstant;
import Utility.CommonUtils;
import apiPageObjects.RestAssuredExtension;
import apiPageObjects.RestAssuredExtensionv2;
import cucumber.APITestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import managers.FileReaderManager;

public class Get_StopSeqCoordReq_TestStepDefinition {	
	public static ResponseOptions<Response> response;
	public static String token;
	private static ExtentTest test;
	public  String baseURL=FileReaderManager.getInstance().getConfigReader().getBaseUrl();
	final static Logger LOGGER=LogManager.getLogger(ComplexGetData_TestStepDefinition.class);
	 RestAssuredExtensionv2 restAssuredExtensionv2;

		public Get_StopSeqCoordReq_TestStepDefinition(APITestContext testContext) {
			super();
			restAssuredExtensionv2=testContext.getRestAssuredExtensionv2();
		}
		
	
		
		@When("I perform GET operation for get the StopSeqCoord {string}")
		public void i_perform_GET_operation_for_get_the_StopSeqCoord(String url) {
		    // Write code here that turns the phrase above into concrete actions
		       	try {
					Map<String, String> pathParam = new LinkedHashMap<String, String>();
				    pathParam.put("ext_macro","trip");
				    pathParam.put("outputFormat","rapidJSON");
				    pathParam.put("coordOutputFormat","WGS84%5BDD.DDDDD%5D");
				    pathParam.put("line","rda%3A01008%3A%2520%3AR%3Aa20");
				    pathParam.put("stop","80000143");
				    pathParam.put("tripCode","48");
				    pathParam.put("date","20200826");
				    pathParam.put("time","0730");
				    pathParam.put("tStOTType","ALL");
				    response=RestAssuredExtension.GetWithQueryParamsWithToken(url, pathParam, token);
				    System.out.println("**************** get the StopSeqCoord  ***************");
				    System.out.println( response.body().prettyPrint());
			        System.out.println(response.statusLine());
			        String responseAsString= response.getBody().asString();
			        byte[] responseAsStringByte = responseAsString.getBytes();
					File targetFileForString = new File(System.getProperty("user.dir")+"//APIResource//StopSeqCoord.json");
					CommonUtils.WriteResponseOnJosonFile(responseAsStringByte,targetFileForString);
		    	
		    }catch(Exception ex) 
		    	{
		    	System.out.println(ex.getMessage());
			     LOGGER.error(ex.getMessage());	     	
		    }
		    	LOGGER.info("I perform GET operation for  get_the_StopSeqCoord "+url+".....");
		}
	
}
