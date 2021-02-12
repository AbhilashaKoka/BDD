package ExtentReport;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;


public class APIVerification extends ExtentReportUtils {

	public static void responseCodeValiddation(ResponseOptions<Response> response, int statusCode) {

		try {
			Assert.assertEquals(statusCode, response.getStatusCode());
			scenario.log(Status.PASS,"Successfully validdated status code, status code is :: " + response.getStatusCode());
		} 
		catch (AssertionError e) 
		{
			scenario.log(Status.FAIL, e.fillInStackTrace());
			scenario.log(Status.FAIL,"Expected status code is :: " + statusCode + " , insted of getting :: " + response.getStatusCode());
		} 
		catch (Exception e) 
		{
			scenario.log(Status.FAIL, e.fillInStackTrace());
		}
	}

	public static void responseKeyValidationfromArray(ResponseOptions<Response> response, String key) {
		try {
			JSONArray array = new JSONArray(response.getBody().asString());
			for(int i=0; i<array.length();i++) 
			{
				JSONObject obj = array.getJSONObject(i);
				scenario.log(Status.PASS, "Validetd values are  " + obj.get(key));
				
			}
		} 
		catch (Exception e)
		{
			scenario.log(Status.FAIL, e.fillInStackTrace());
		}
	}
	
	
	public static void responseKeyValidationFromJsonObject(ResponseOptions<Response> response, String key) {
		try {
			JSONObject json = new JSONObject(response.getBody().asString());
			if(json.has(key) && json.get(key)!= null) 
			{
				scenario.log(Status.PASS, "Sucessfully validated value of " + key + " It is " + json.get(key));
			}else
			{
				scenario.log(Status.FAIL,"Key is not availble");
			}
		}
		catch (Exception e)
		{
			scenario.log(Status.FAIL, e.fillInStackTrace());
		}
	}
	
	
	public static void responseTimeValidation(ResponseOptions<Response> response) {
		try {
			long time=response.time();
			scenario.log(Status.INFO, "Api response time is :: " + time);
		} 
		catch (Exception e)
		{
			scenario.log(Status.FAIL, e.fillInStackTrace());
		}
	}

}
