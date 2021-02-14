package stepDefinitions.apisteps;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utility.APIConstant;
import Utility.CommonUtils;
import apiPageObjects.RestAssuredExtension;
import apiPageObjects.RestAssuredExtensionv2;
import cucumber.APITestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import managers.FileReaderManager;

public class Get_tripRequest_shorttest_TestStepDefinition {	
	public static ResponseOptions<Response> response;
	public static String token;
	private static ExtentTest test;
	public  String baseURL=FileReaderManager.getInstance().getConfigReader().getBaseUrl();
	final static Logger LOGGER=LogManager.getLogger(ComplexGetData_TestStepDefinition.class);
	 RestAssuredExtensionv2 restAssuredExtensionv2;

		public Get_tripRequest_shorttest_TestStepDefinition(APITestContext testContext) {
			super();
			restAssuredExtensionv2=testContext.getRestAssuredExtensionv2();
		}
		
		
		
		@When("I perform GET operation for  tripRequest-shorttest-leasttime {string}")
		public void i_perform_GET_operation_for_tripRequest_shorttest_leasttime(String url) {
		    // Write code here that turns the phrase above into concrete actions
			try {		  
			    Map<String, String> pathParam = new LinkedHashMap<String, String>();
			    pathParam.put("ext_macro","trip");
			    pathParam.put("outputFormat","rapidJSON");
			   // pathParam.put("coordOutputFormat","WGS84%5BDD.DDDDD%5D");
			    pathParam.put("locationServerActive","1");
			    pathParam.put("useRealtime","1");
			    pathParam.put("useUT","1");
			    pathParam.put("type_origin","any");			    
			    pathParam.put("name_origin","80000221");
			    pathParam.put("routeType","leasttime");
			    pathParam.put("type_destination","any");
			    pathParam.put("name_destination","80000214");
			    pathParam.put( "itdDate","20210208");
			    pathParam.put("calcNumberOfTrips","4");
			    pathParam.put("itdTime","1115");
			    pathParam.put("itdTripDateTimeDepArr","arr");
			    pathParam.put("calcOneDirection","1");
			    pathParam.put("excludedMeans","5");
			    pathParam.put("includedMeans","5");
			    pathParam.put ("trlTMOT","100");
			    pathParam.put("trlTMOTvalue","10");
			    pathParam.put("ptOptionsActive","1");
			    pathParam.put("itOptionsActive","1");
			    pathParam.put("cyclingActive","1");
			    pathParam.put("speedFactorBicycle","100");
			    pathParam.put("changeSpeed","slow");
			    pathParam.put("showItdInterchangePathCoordinates","1");
			    pathParam.put("showItdPathCoordinates","1");
			    response=RestAssuredExtension.GetWithQueryParamsWithToken(url, pathParam, token);
			    System.out.println("**************** Least Time Get Method Response ***************");
			    System.out.println( response.body().prettyPrint());		    
		        System.out.println(response.statusLine());
		        String responseAsString= response.getBody().asString();
		        byte[] responseAsStringByte = responseAsString.getBytes();
				File targetFileForString = new File(System.getProperty("user.dir")+"//APIResource//tripRequestshorttestleasttime.json");
				CommonUtils.WriteResponseOnJosonFile(responseAsStringByte,targetFileForString);
		     }
			 catch(Exception ex) 
			 {
		     System.out.println(ex.getMessage());
		     LOGGER.error(ex.getMessage());
			 }
			LOGGER.info("I perform GET operation for  tripRequest-shorttest-leasttime "+url+".....");
		}

		@When("I perform GET operation for  tripRequest-shorttest-leastWalking {string}")
		public void i_perform_GET_operation_for_tripRequest_shorttest_leastWalking(String url) {
			try {
			    test.log(Status.INFO, "My test Started.....");
			    Map<String, String> pathParam = new LinkedHashMap<String, String>();
			    pathParam.put("ext_macro","trip");
			    pathParam.put("outputFormat","rapidJSON");
			    pathParam.put("coordOutputFormat","WGS84%5BDD.DDDDD%5D");
			    pathParam.put("locationServerActive","1");
			    pathParam.put("useRealtime","1");
			    pathParam.put("useUT","1");
			    pathParam.put("type_origin","any");
			    pathParam.put("name_origin","80000221");
			    pathParam.put("type_destination","any");
			    pathParam.put("name_destination","80000214");
			    pathParam.put("routeType","leastwalking");
			    pathParam.put("itdDate","20210208");
			    pathParam.put("calcNumberOfTrips","4");
			    pathParam.put("itdTime","1400");
			    pathParam.put("itdTripDateTimeDepArr","dep");
			    pathParam.put("calcOneDirection","1");
			    pathParam.put("excludedMeans","5");
			    pathParam.put("includedMeans","5");
			    pathParam.put("trITMOT","100");
			    pathParam.put("trITMOTvalue","10");
			    pathParam.put("ptOptionsActive","1");
			    pathParam.put("itOptionsActive","1");
			    pathParam.put("cyclingActive","1");
			    pathParam.put("speedFactorBicycle","100");
			    pathParam.put("changeSpeed","slow");
			    pathParam.put("showItdInterchangePathCoordinates","1");
			    pathParam.put("showItdPathCoordinates","1");
			    response=RestAssuredExtension.GetWithQueryParamsWithToken(url, pathParam, token);
			    System.out.println("**************** LeastWalking  Get method Response ***************");
			    System.out.println( response.body().prettyPrint());
		       System.out.println(response.statusLine());
//		       APIVerification.responseCodeValiddation(response, 200);
//		         APIVerification.responseTimeValidation(response);
		       test.log(Status.INFO, "My test has been ended.....");
		       String responseAsString= response.getBody().asString();
		        byte[] responseAsStringByte = responseAsString.getBytes();
				File targetFileForString = new File(System.getProperty("user.dir")+"//APIResource//TripcodestopIdlinetimedate.json");
				CommonUtils.WriteResponseOnJosonFile(responseAsStringByte,targetFileForString);
			
			}
			catch(Exception ex)
			{			
				ex.getMessage();
				LOGGER.error(ex.getMessage());
			}
			LOGGER.info("I perform GET operation for  tripRequest-shorttest-leastWalking"+url+"");
		}
}
