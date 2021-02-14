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

public class Get_tripStopTime_StepDefinition {	
	public static ResponseOptions<Response> response;
	public static String token;
	private static ExtentTest test;
	public  String baseURL=FileReaderManager.getInstance().getConfigReader().getBaseUrl();
	final static Logger LOGGER=LogManager.getLogger(ComplexGetData_TestStepDefinition.class);
	 RestAssuredExtensionv2 restAssuredExtensionv2;

		public Get_tripStopTime_StepDefinition(APITestContext testContext) {
			super();
			restAssuredExtensionv2=testContext.getRestAssuredExtensionv2();
		}
		
	
		
		@When("I perform GET operation for get the Tripcode, stopId, line time and date {string}")
		public void i_perform_GET_operation_for_get_the_Tripcode_stopId_line_time_and_date(String url) {
			try {
				Map<String, String> pathParam = new LinkedHashMap<String, String>();
			    pathParam.put("outputFormat","rapidJSON");
			    pathParam.put("coordOutputFormat","WGS84[DD.DDDDD]");
			    pathParam.put("name_origin","80000143");
			    pathParam.put("type_origin","any");
			    pathParam.put("name_destination","80000042");
			    pathParam.put("type_destination","any");
			    pathParam.put("itdDate","20210119");
			    pathParam.put("itdTime","0745");
			    response=RestAssuredExtension.GetWithQueryParamsWithToken(url, pathParam, token);
			    System.out.println("****************the Tripcode, stopId, line time and date  ***************");
			    System.out.println( response.body().prettyPrint());
		        System.out.println(response.statusLine());
		        String responseAsString= response.getBody().asString();
		        byte[] responseAsStringByte = responseAsString.getBytes();
				File targetFileForString = new File(System.getProperty("user.dir")+"//APIResource//TripcodestopIdlinetimedate.json");
				CommonUtils.WriteResponseOnJosonFile(responseAsStringByte,targetFileForString);
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			     LOGGER.error(ex.getMessage());
		    
			}
		}
		
		
		@When("I perform GET operation for get the stop sequence, including arrival and departure-times {string}")
		public void i_perform_GET_operation_for_get_the_stop_sequence_including_arrival_and_departure_times(String url) {
			try {
				Map<String, String> pathParam = new LinkedHashMap<String, String>();
			    pathParam.put("stopID","18020367");
				pathParam.put("tripCode","58");
				pathParam.put("outputFormat","rapidJSON");
				pathParam.put("coordOutputFormat","WGS84%5BDD.DDDDD%5D");
				pathParam.put("itdDate","20210119");
				pathParam.put("itdTime","0745");
				pathParam.put("line","rda%3A01008%3A%3AR%3Ay20");
			    response=RestAssuredExtension.GetWithQueryParamsWithToken(url, pathParam, token);
			    System.out.println("**************** the stop sequence, including arrival and departure-times ***************");
			    System.out.println( response.body().prettyPrint());
		        System.out.println(response.statusLine());
		        String responseAsString= response.getBody().asString();
		        byte[] responseAsStringByte = responseAsString.getBytes();
				File targetFileForString = new File(System.getProperty("user.dir")+"//APIResource//stopsequenceincludingarrivaldeparturetimes.json");
				CommonUtils.WriteResponseOnJosonFile(responseAsStringByte,targetFileForString);
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			     LOGGER.error(ex.getMessage());
		    
			}
		}
		
		@When("I perform GET operation for  get filter the stop sequence {string}")
		public void i_perform_GET_operation_for_get_filter_the_stop_sequence(String url) {
			try {
				Map<String, String> pathParam = new LinkedHashMap<String, String>();
			    pathParam.put("ext_macro","trip");
			    pathParam.put("stopID","18020367");
			    pathParam.put("tripCode","58");
			    pathParam.put("outputFormat","rapidJSON");
			    pathParam.put("coordOutputFormat","WGS84%5BDD.DDDDD%5D");
			    pathParam.put("itdDate","20210119");
			    pathParam.put("itdTime","0745");
			    pathParam.put("line","rda%3A01008%3A%3AR%3Ay20");
			    pathParam.put("tStOTType","all");
			    response=RestAssuredExtension.GetWithQueryParamsWithToken(url, pathParam, token);
			    System.out.println("**************** get filter the stop sequence ***************");
			    System.out.println( response.body().prettyPrint());
		        System.out.println(response.statusLine());
		        String responseAsString= response.getBody().asString();
		        byte[] responseAsStringByte = responseAsString.getBytes();
				File targetFileForString = new File(System.getProperty("user.dir")+"//APIResource//filterthestopsequence.json");
				CommonUtils.WriteResponseOnJosonFile(responseAsStringByte,targetFileForString);
			}
			catch(Exception ex) 
			{
				 System.out.println(ex.getMessage());
			     LOGGER.error(ex.getMessage());
		    }
		}
		
		
	
}