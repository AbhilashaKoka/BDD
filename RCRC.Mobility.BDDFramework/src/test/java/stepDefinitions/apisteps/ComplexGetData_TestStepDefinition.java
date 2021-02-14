package stepDefinitions.apisteps;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;

import Utility.APIConstant;
import apiPageObjects.RestAssuredExtensionv2;
import cucumber.APITestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import managers.FileReaderManager;
import pojo.Address;
import pojo.Location;

public class ComplexGetData_TestStepDefinition {	
	public static ResponseOptions<Response> response;
	public static String token;
	private static ExtentTest test;
	public  String baseURL=FileReaderManager.getInstance().getConfigReader().getBaseUrl();
	final static Logger LOGGER=LogManager.getLogger(ComplexGetData_TestStepDefinition.class);
	 RestAssuredExtensionv2 restAssuredExtensionv2;

		public ComplexGetData_TestStepDefinition(APITestContext testContext)
		{
			super();
			restAssuredExtensionv2=testContext.getRestAssuredExtensionv2();
		}
	
	@When("I perform GET operation with path parameter for address {string}")
	public void i_perform_GET_operation_with_path_parameter_for_address(String uri, DataTable table) {
	    try {
	    	List<List<String>> data=table.cells();
	    	Map<String , String> queryparams=new HashMap<>();
	    	queryparams.put("id", data.get(1).get(0));
	    	 restAssuredExtensionv2=new RestAssuredExtensionv2(uri, "GET", token, baseURL);
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

}
