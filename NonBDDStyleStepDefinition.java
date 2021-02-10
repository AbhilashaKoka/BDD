package stepDefinitions.apisteps;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hamcrest.core.IsNot;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import ExtentReport.APIVerification;
import ExtentReport.ExtentReportUtils;
import Utility.APIConstant;
import Utility.RestAssuredExtension;
import Utility.RestAssuredExtensionv2;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import pojo.Address;
import pojo.Location;
import pojo.Posts;
import pojo.TokenBody;
import Utility.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class NonBDDStyleStepDefinition extends ExtentReportUtils{	
public static ResponseOptions<Response> response;
public static String token;
private static ExtentTest test;
final static Logger LOGGER=LogManager.getLogger(NonBDDStyleStepDefinition.class);

	public NonBDDStyleStepDefinition() {
		//super(testContext);
		
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
	
	@Given("I perform GET operation with path parameter for address {string}")
	public void i_perform_GET_operation_with_path_parameter_for_address(String uri, DataTable table) {
	    try {
	    	List<List<String>> data=table.cells();
	    	Map<String , String> queryparams=new HashMap<>();
	    	queryparams.put("id", data.get(1).get(0));
	    	RestAssuredExtensionv2 restAssuredExtensionv2=new RestAssuredExtensionv2(uri, "GET", token);
	    	response=restAssuredExtensionv2.ExecuteWithQueryParams(queryparams);
	        System.out.println(response.getBody().print());
	        }
	    catch(Exception ex)
	    {
	    	ex.getMessage();
	    	LOGGER.error(ex.getMessage());
	    }
	    LOGGER.info("I perform GET operation with path parameter for address"+uri+"");
	}

	@Then("I should see the street name as {string} for the {string} address")
	public void i_should_see_the_street_name_as_for_the_address(String streetName, String type) {
		try {
			    Location[] location= response.getBody().as(Location[].class);
			    System.out.println(response.getBody().print());
			    Address address=location[0].getAddress().stream().filter(x ->x.getType().equalsIgnoreCase(type)).findFirst().orElse( null);
		        assertThat(address.getStreet(), equalTo(streetName));
		        System.out.println(response.getBody().print());
				}
			 catch(Exception ex)
		       {
			    	ex.getMessage();
			    	LOGGER.error(ex.getMessage());
			    }
		LOGGER.info("I should see the street name as "+streetName+" for the "+type+" address");
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
		}
		catch(Exception ex) 
		{
			System.out.println(ex.getMessage());
		     LOGGER.error(ex.getMessage());
	    }
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
	    	
	    }catch(Exception ex) 
	    	{
	    	System.out.println(ex.getMessage());
		     LOGGER.error(ex.getMessage());	     	
	    }
	    	LOGGER.info("I perform GET operation for  get_the_StopSeqCoord "+url+".....");
	}
	
	
	@When("I perform GET operation for  Weather Utilites {string}")
	public void i_perform_GET_operation_for_Weather_Utilites(String url) {
	    // Write code here that turns the phrase above into concrete actions
	   try {
		   
		    response=RestAssuredExtension.GetOpsWithToken(url, token);
		    System.out.println("**************** get the StopSeqCoord  ***************");
		    System.out.println( response.body().prettyPrint());
	        System.out.println(response.statusLine());   
	   }
	   catch(Exception ex) {
		   System.out.println(ex.getMessage());
		     LOGGER.error(ex.getMessage()); 
	   }
	   LOGGER.info("I perform GET operation for  Weather Utilites "+url+".....");
	}

	@Given("I perform GET operation for  tripRequest-shorttest-leasttime {string}")
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
	     }
		 catch(Exception ex) 
		 {
	     System.out.println(ex.getMessage());
	     LOGGER.error(ex.getMessage());
		 }
		LOGGER.info("I perform GET operation for  tripRequest-shorttest-leasttime "+url+".....");
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

	@Then("I should see the author name as {string}")
	public void i_should_see_the_author_name_as(String authorName) 
	{
		    try {
//		    	Posts posts=new Posts.Builder().build();
//		    	Posts post=response.getBody().as(posts.getClass());
//		    	assertThat(post.getAuthor(), equalTo(authorName));		    	
			    //without builder pattern
                // Posts posts=response.getBody().as(Posts.class);
                //System.out.println(response.getBody().print());
			   //assertThat(posts.getAuthor(), equalTo(authorName));
			   	 }
		   catch(Exception ex) 
		    {	   
	       System.out.println(ex.getMessage());
	        LOGGER.error(ex.getMessage());
		    }
		    LOGGER.info("I should see the author name as "+authorName+"");
	}

	@Given("I perform GET operation for  tripRequest-shorttest-leastWalking {string}")
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
//	       APIVerification.responseCodeValiddation(response, 200);
//	         APIVerification.responseTimeValidation(response);
	       test.log(Status.INFO, "My test has been ended.....");
		}
		catch(Exception ex)
		{			
			ex.getMessage();
			LOGGER.error(ex.getMessage());
		}
		LOGGER.info("I perform GET operation for  tripRequest-shorttest-leastWalking"+url+"");
	}
	@Given("I perform GET operation for  fastest slow {string}")
	public void i_perform_GET_operation_for_fastest_slow(String url) {
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
		    pathParam.put("routeType","leasttime");
		    pathParam.put("itdDate","20210208");
		    pathParam.put("calcNumberOfTrips","4");
		    pathParam.put("itdTime","2000");
		    pathParam.put("itdTripDateTimeDepArr","arr");
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
		    System.out.println("**************** Fastest Slow  Get Method Response ***************");
		    System.out.println( response.body().prettyPrint());
	       System.out.println(response.statusLine());
//	       APIVerification.responseCodeValiddation(response, 200);
//	         APIVerification.responseTimeValidation(response);
        test.log(Status.INFO, "My test has been ended.....");
	    }
	    catch(Exception ex) 
	    {
	    	System.out.println(ex.getMessage());
	    	LOGGER.error(ex.getMessage());
	    }
	    LOGGER.info("I perform GET operation for  fastest slow"+url+"");
	}

	@Given("I perform GET operation for  fastest fast {string}")
	public void i_perform_GET_operation_for_fastest_fast(String url) {
	    try {
	    	// test.log(Status.INFO, "My test started.....");
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
			    pathParam.put("routeType","leasttime");
			    pathParam.put("itdDate","20210208");
			    pathParam.put("calcNumberOfTrips","4");
			    pathParam.put("itdTime","2000");
			    pathParam.put("itdTripDateTimeDepArr","arr");
			    pathParam.put("calcOneDirection","1");
			    pathParam.put("excludedMeans","5");
			    pathParam.put("includedMeans","5");
			    pathParam.put("trITMOT","100");
			    pathParam.put("trITMOTvalue","10");
			    pathParam.put("ptOptionsActive","1");
			    pathParam.put("itOptionsActive","1");
			    pathParam.put("cyclingActive","1");
			    pathParam.put("speedFactorBicycle","100");
			    pathParam.put("changeSpeed","fast");
			    pathParam.put("showItdInterchangePathCoordinates","1");
			    pathParam.put("showItdPathCoordinates","1");
			    response=RestAssuredExtension.GetWithQueryParamsWithToken(url, pathParam, token);
			    System.out.println("**************** Fastest Fast Get Method Response ***************");
			    System.out.println( response.body().prettyPrint());
		       System.out.println(response.statusLine());
//		       APIVerification.responseCodeValiddation(response, 200);
//		         APIVerification.responseTimeValidation(response);
//		        test.log(Status.INFO, "My test has been ended.....");
	    }catch(Exception ex)
	    {
	    	System.out.println(ex.getMessage());
	    	LOGGER.error(ex.getMessage());
	    }
	    LOGGER.info("I perform GET operation for  fastest fast"+url+"");
	}

	@Given("I perform GET operation for  departure Time {string}")
	public void i_perform_GET_operation_for_departure_Time(String url) {
	    try {
	    	//test.log(Status.INFO, "My test started....");
	    	Map<String, String> pathParam = new LinkedHashMap<String, String>();
		    pathParam.put("ext_macro","trip");
		    pathParam.put("ext_macro","trip");
		     pathParam.put ("outputFormat","rapidJSON");
		     pathParam.put ("coordOutputFormat","WGS84%5BDD.DDDDD%5D");
		     pathParam.put ("locationServerActive","1");
		     pathParam.put ("useRealtime","1");
		     pathParam.put("useUT","1");
		     pathParam.put("type_origin","any");
		     pathParam.put ("name_origin","80000221");
		     pathParam.put ("type_destination","any");
		     pathParam.put ("name_destination","80000214");
		     pathParam.put ("routeType","leasttime");
		     pathParam.put ("itdDate","20210208");
		     pathParam.put ("calcNumberOfTrips","4");
		     pathParam.put ( "itdTime","1400");
		     pathParam.put ( "itdTripDateTimeDepArr","dep");
		     pathParam.put ( "calcOneDirection","1");
		     pathParam.put ( "excludedMeans","5");
		     pathParam.put ( "includedMeans","5");
		     pathParam.put ( "trITMOT","100");
		    pathParam.put ( "trITMOTvalue","10");
		    pathParam.put ( "ptOptionsActive","1");
		    pathParam.put ( "itOptionsActive","1");
		     pathParam.put ( "cyclingActive","1");
	    	pathParam.put ( "speedFactorBicycle","100");
	    	pathParam.put ( "changeSpeed","slow");
	    	pathParam.put ( "showItdInterchangePathCoordinates","1");
	    	pathParam.put ( "showItdPathCoordinates","1");
	    	response=RestAssuredExtension.GetWithQueryParamsWithToken(url, pathParam, token);
		    System.out.println("***************departure Time  Get Method Response ***************");
		    System.out.println( response.body().prettyPrint());
	       System.out.println(response.statusLine());
//	       APIVerification.responseCodeValiddation(response, 200);
//	         APIVerification.responseTimeValidation(response);
//	        test.log(Status.INFO, "My test has been ended.....");  
	    
	    }
	    catch(Exception ex) {
	    	
	    System.out.println(	ex.getMessage());
	    LOGGER.error(ex.getMessage());
	    }
	    LOGGER.info("I perform GET operation for  departure Time "+url+"");
	}

	@Given("I perform GET operation for  arrival Time {string}")
	public void i_perform_GET_operation_for_arrival_Time(String url) {
	    try {
	    	//test.log(Status.INFO, "My test started.....");
	    	Map<String, String> pathParam = new LinkedHashMap<String, String>();
			pathParam.put("ext_macro","trip");
			pathParam.put("outputFormat","rapidJSON");
			pathParam.put("coordOutputFormat","WGS84%5BDD.DDDDD%5D");
			pathParam.put("locationServerActive","1");
			pathParam.put("useRealtime","1");
			pathParam.put("useUT","1");
			pathParam.put("type_origin","any");
			pathParam.put("name_origin","80000221");
			pathParam.put( "type_destination","any");
			pathParam.put("name_destination","80000214");
			pathParam.put( "routeType","leasttime");
			pathParam.put( "itdDate","20210208");
			pathParam.put( "calcNumberOfTrips","4");
			pathParam.put("itdTime","2000");
			pathParam.put("itdTripDateTimeDepArr","arr");
			pathParam.put("calcOneDirection","1");
			pathParam.put("excludedMeans","5");
			pathParam.put("includedMeans","5");
			pathParam.put( "trITMOT","100");
			pathParam.put("trITMOTvalue","10");
			pathParam.put("ptOptionsActive","1");
			pathParam.put("itOptionsActive","1");
			pathParam.put("cyclingActive","1");
			pathParam.put("speedFactorBicycle","100");
			pathParam.put( "changeSpeed","slow");
			pathParam.put("showItdInterchangePathCoordinates","1");
	        pathParam.put("showItdPathCoordinates","1");
	        response=RestAssuredExtension.GetWithQueryParamsWithToken(url, pathParam, token);
		    System.out.println("**************** ArrivalTime Get Method Response***************");
		    System.out.println( response.body().prettyPrint());
	       System.out.println(response.statusLine());
//	       APIVerification.responseCodeValiddation(response, 200);
//	         APIVerification.responseTimeValidation(response);
//	        test.log(Status.INFO, "My test has been ended.....");
	  
	    }catch(Exception ex){
	    	
	    	System.out.println(ex.getMessage());
	    	LOGGER.error(ex.getMessage());
	    }
	    LOGGER.info("I perform GET operation for  arrival Time "+url+"");
	}


	
	
 @Then("I should verify the author names")
	public void i_should_verify_the_author_names() {
		 try {
			 System.out.println();	    
		      }
		   catch(Exception ex) 
		   {	   
			System.out.println(ex.getMessage());
			LOGGER.error(ex.getMessage());
		   }	    
		 LOGGER.info("I should verify the author names");
	}

	@Then("I should  verify GET Parameter")
	public void i_should_verify_GET_Parameter() {
		 try {
			 System.out.println();	    
		      }
		   catch(Exception ex) 
		   {	   
			System.out.println(ex.getMessage());
			LOGGER.error(ex.getMessage());
		   }	
		 LOGGER.info("I should  verify GET Parameter");
	}

	@Then("I should  verify GET  path Parameter")
	public void i_should_verify_GET_path_Parameter() {
		 try {
			 System.out.println();	    
		     }
		   catch(Exception ex) 
		   {	   
			System.out.println(ex.getMessage());
			LOGGER.error(ex.getMessage());
		   }
		 LOGGER.info("I should  verify GET  path Parameter");
	}

	@Then("I should  verify POST path parameter")
	public void i_should_verify_POST_path_parameter() {
		  try {
			  System.out.println();	    
		      }
		   catch(Exception ex) 
		   {	   
			System.out.println(ex.getMessage());
			LOGGER.error(ex.getMessage());
		   }
		  LOGGER.info("I should  verify POST path parameter");
	}
	
	@Given("I Perform POST operation for {string} with body")
	public void i_Perform_POST_operation_for_with_body(String url, DataTable table) throws Throwable {
		 try {
			List<List<String>> data = table.cells();
	        HashMap<String, String> body = new HashMap<>();
	        body.put("name", data.get(1).get(0));
	        HashMap<String, String> pathParams = new HashMap<>();
	        pathParams.put("profileNo", data.get(1).get(1));
	        System.out.println(response.body().print());	    
	      }
	   catch(Exception ex) 
	   {	   
		ex.getMessage();
		LOGGER.error(ex.getMessage());
	   }	
		 LOGGER.info("I Perform POST operation for "+url+" with body");
	}
	

	@Then("I should see the body has name as {string}")
	public void i_should_see_the_body_has_name_as(String name) {
	    try {
	    	 assertThat(response.getBody().jsonPath().get("name"), equalTo(name));
		    }
	   catch(Exception ex) 
	       {	   
		  System.out.println( ex.getMessage());
		  LOGGER.error(ex.getMessage());
	       }	
	    LOGGER.info("I should see the body has name as "+name+"");
     	}
	
	@Given("I ensure to Perform POST operation for {string} with body as")
	public void i_ensure_to_Perform_POST_operation_for_with_body_as(String url, DataTable table) {
		try {
			    List<List<String>> data = table.cells();
		        Map<String, String> body = new HashMap<>();
		        body.put("id", data.get(1).get(0));
		        body.put("title", data.get(1).get(1));
		        body.put("author", data.get(1).get(2));
		       	System.out.println(response.getBody().print());
	      }
	   catch(Exception ex) 
	   {	   
		System.out.println(ex.getMessage());
		LOGGER.error(ex.getMessage());
	   }
		LOGGER.info("I ensure to Perform POST operation for "+url+" with body as");
	}

	@Given("I Perform DELETE operation for {string}")
	public void i_Perform_DELETE_operation_for(String url, DataTable table) {
		try {
		   	List<List<String>> data = table.cells();
	        Map<String, String> pathParams = new HashMap<>();
	        pathParams.put("postid", data.get(1).get(0));
            RestAssuredExtension.DeleteOpsWithPathParams(url, pathParams);
	      }
	   catch(Exception ex) 
	   {	   
		System.out.println(ex.getMessage());
		LOGGER.error(ex.getMessage());
	   }
		LOGGER.info("I Perform DELETE operation for"+url+"");
	}

	@Given("I perform GET operation with path parameter for {string}")
	public void i_perform_GET_operation_with_path_parameter_for(String url, DataTable table) {
		try {
		   	List<List<String>> data = table.cells();
	        Map<String, String> pathParams = new HashMap<>();
	        pathParams.put("postid", data.get(1).get(0));
	        response = RestAssuredExtension.GetWithPathParams(url, pathParams);
	       // myComponent.getResource(url);
            }
	   catch(Exception ex) 
	     {	   
		   System.out.println(ex.getMessage());
		   LOGGER.error(ex.getMessage());
	     }	
		LOGGER.info("I perform GET operation with path parameter for "+url+"");
	}

	@Then("I {string} see the body with title as {string}")
	public void i_see_the_body_with_title_as(String condition, String title) {
		try {
		   	if (condition.equalsIgnoreCase("should not"))
		         assertThat(response.getBody().jsonPath().get("title"), IsNot.not(title));
	        else
	             assertThat(response.getBody().jsonPath().get("title"), is(title));
            }
	 	  //response.getEntity().consumeContent();
	   catch(Exception ex) 
	   {	   
		System.out.println(ex.getMessage());
		LOGGER.error(ex.getMessage());
	   }	
		LOGGER.info("I "+condition+"see the body with title as "+title+"");
	}

	@Given("I Perform PUT operation for {string}")
	public void i_Perform_PUT_operation_for(String url, DataTable table) {
	   try {
		    List<List<String>> data = table.cells();
	        Map<String, String> body = new HashMap<>();
	        body.put("id", data.get(1).get(0));
	        body.put("title", data.get(1).get(1));
	        body.put("author", data.get(1).get(2));	        
	        Map<String, String> pathParams = new HashMap<>();
	        pathParams.put("postid", data.get(1).get(0));
	        RestAssuredExtension.PutOpsWithBodyAndPathParams(url, body, pathParams);
	       }
	   catch(Exception ex)
	   {
	    System.out.println(ex.getMessage());
	    LOGGER.error(ex.getMessage());
	   }
	   LOGGER.info("I Perform PUT operation for "+url+"");
	}

	@Given("I perform authentication operation for {string} with body")
	public void i_perform_authentication_operation_for_with_body(String url, DataTable table)
	{
		try {
		    List<List<String>> data = table.cells();
//          TokenBody tokenBody=new TokenBody();
//		    tokenBody.setGrantType(data.get(1).get(0));
//		    tokenBody.setUsername(data.get(1).get(1));
//		    tokenBody.setPassword(data.get(1).get(2));		    
		    RestAssuredExtensionv2 restAssuredExtensionv2=new RestAssuredExtensionv2(url, APIConstant.ApiMethods.POST, null);
	        token=restAssuredExtensionv2.Authenticate2();
	      //  System.out.println("Token generated:"+token);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			LOGGER.error(ex.getMessage());
		}
		LOGGER.info("I perform authentication operation for "+url+" with body");
	 }
	
	
}
