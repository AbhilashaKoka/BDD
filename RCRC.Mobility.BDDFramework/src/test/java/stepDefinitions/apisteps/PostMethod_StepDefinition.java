package stepDefinitions.apisteps;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;

import apiPageObjects.RestAssuredExtensionv2;
import cucumber.APITestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import managers.FileReaderManager;

public class PostMethod_StepDefinition {	
	public static ResponseOptions<Response> response;
	public static String token;
	private static ExtentTest test;
	public  String baseURL=FileReaderManager.getInstance().getConfigReader().getBaseUrl();
	final static Logger LOGGER=LogManager.getLogger(ComplexGetData_TestStepDefinition.class);
	 RestAssuredExtensionv2 restAssuredExtensionv2;

		public PostMethod_StepDefinition(APITestContext testContext) {
			super();
			restAssuredExtensionv2=testContext.getRestAssuredExtensionv2();
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
		
//		@Given("I ensure to Perform POST operation for {string} with body as")
//		public void i_ensure_to_Perform_POST_operation_for_with_body_as(String url, DataTable table) {
//			try {
//				    List<List<String>> data = table.cells();
//			        Map<String, String> body = new HashMap<>();
//			        body.put("id", data.get(1).get(0));
//			        body.put("title", data.get(1).get(1));
//			        body.put("author", data.get(1).get(2));
//			       	System.out.println(response.getBody().print());
//		      }
//		   catch(Exception ex) 
//		   {	   
//			System.out.println(ex.getMessage());
//			LOGGER.error(ex.getMessage());
//		   }
//			LOGGER.info("I ensure to Perform POST operation for "+url+" with body as");
		//}
		
}
