package stepDefinitions.apisteps;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hamcrest.core.IsNot;

import com.aventstack.extentreports.ExtentTest;

import apiPageObjects.RestAssuredExtension;
import apiPageObjects.RestAssuredExtensionv2;
import cucumber.APITestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import managers.FileReaderManager;

public class Delete_Method_TestStepDefinition {	
		public static ResponseOptions<Response> response;
		public static String token;
		private static ExtentTest test;
		public  String baseURL=FileReaderManager.getInstance().getConfigReader().getBaseUrl();
		final static Logger LOGGER=LogManager.getLogger(NonBDDStyleStepDefinition.class);
		 RestAssuredExtensionv2 restAssuredExtensionv2;

			public Delete_Method_TestStepDefinition(APITestContext testContext) {
				super();
				restAssuredExtensionv2=testContext.getRestAssuredExtensionv2();
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
//			@Given("I perform GET operation with path parameter for {string}")
//			public void i_perform_GET_operation_with_path_parameter_for(String url, DataTable table) {
//				try {
//				   	List<List<String>> data = table.cells();
//			        Map<String, String> pathParams = new HashMap<>();
//			        pathParams.put("postid", data.get(1).get(0));
//			        response = RestAssuredExtension.GetWithPathParams(url, pathParams);
//			       // myComponent.getResource(url);
//		            }
//			   catch(Exception ex) 
//			     {	   
//				   System.out.println(ex.getMessage());
//				   LOGGER.error(ex.getMessage());
//			     }	
//				LOGGER.info("I perform GET operation with path parameter for "+url+"");
//			}
//			
//			@Then("I {string} see the body with title as {string}")
//			public void i_see_the_body_with_title_as(String condition, String title) {
//				try {
//				   	if (condition.equalsIgnoreCase("should not"))
//				         assertThat(response.getBody().jsonPath().get("title"), IsNot.not(title));
//			        else
//			             assertThat(response.getBody().jsonPath().get("title"), is(title));
//		            }
//			 	  //response.getEntity().consumeContent();
//			   catch(Exception ex) 
//			   {	   
//				System.out.println(ex.getMessage());
//				LOGGER.error(ex.getMessage());
//			   }	
//				LOGGER.info("I "+condition+"see the body with title as "+title+"");
//			}
//
}
