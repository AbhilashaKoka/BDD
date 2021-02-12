package Utility;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import managers.FileReaderManager;

public class RestAssuredExtension {
	
public static RequestSpecification Request;
//public String baseURL="https://192.168.59.12:8243";
public String baseURL= FileReaderManager.getInstance().getConfigReader().getBaseUrl();

	public RestAssuredExtension()
	{
		//Arrange
		    RequestSpecBuilder builder = new RequestSpecBuilder();
	        builder.setBaseUri(baseURL);
	        builder.setContentType(ContentType.URLENC);
	        RequestSpecification requestSpec = builder.build();
	        Request = RestAssured.given().spec(requestSpec);
	    }
	
	
	 public static ResponseOptions<Response> GetWithQueryParamsWithToken(String url,Map<String, String> pathParams, String token)  {
	        Request.header(new Header("Authorization", "Bearer " + token));
	        System.out.println("****************Request***************");
	        Request.queryParams(pathParams).log().everything();
	        return Request.get(url);
	    }

	 public static ResponseOptions<Response> GetOpsWithToken(String url, String token) {
	        //Act
	        try {
	            Request.header(new Header("Authorization", "Bearer " + token));
	            return Request.get(new URI(url));
	        } 
	        catch (URISyntaxException e)
	        {
	            e.printStackTrace();
	        }
	        return null;
	    }

	public static boolean GetOpsWithPathParameter(String url, Map<String, String> pathParams)
	{
		boolean  bol=false;
		  //Act
          Request.pathParams(pathParams);
        try {
             Request.get(new URI(url));
             bol=true;
            }
        catch (URISyntaxException e)
            {
            e.printStackTrace();
            }
        return bol;
    }

	
	
	 public static ResponseOptions<Response> GetOps(String url)
	 {
	        try {
	            return Request.get(new URI(url));
	            } 
	        catch (URISyntaxException e)
	           {
	            e.printStackTrace();
	            }
	        return null;
	    }
	 
	 
	 public static ResponseOptions<Response> GetOpsQueryParams(String url,String queryParams)
	 {
	        try {
	        	 Request.queryParam(queryParams);
	             return Request.get(new URI(url));
	            } 
	        catch (URISyntaxException e)
	            {
	            e.printStackTrace();
	            }
	        return null;
	    }
	 
	 
	 public static ResponseOptions<Response> PostOpsWithBodyAndPathParams(String url,Map<String, String> pathParams, Map<String, String> body) 
	    {
	      try {
	        	Request.pathParams(pathParams);
	        	Request.body(body);
	            return Request.post(new URI(url));
	          }	   
	   catch (URISyntaxException e)
	           {
	            e.printStackTrace();
	            }
	        return null;
	        }
	 
	 
	 public static ResponseOptions<Response> PostOpsWithBody(String url,Map<String, String> body)  {
	        Request.body(body);
	        return Request.post(url);
	    }

	 
	public static ResponseOptions<Response> DeleteOpsWithPathParams(String url,Map<String, String> pathParams)  {
	        Request.pathParams(pathParams);
	        return Request.delete(url);
	    }


	public static ResponseOptions<Response> GetWithPathParams(String url,Map<String, String> pathParams)  {
        Request.pathParams(pathParams);
        return Request.get(url);
    }
	
	
	 public static ResponseOptions<Response> PutOpsWithBodyAndPathParams(String url,Map<String, String> body,Map<String, String> pathParams)  {
	     Request.pathParams(pathParams);   
		 Request.body(body);
	        return Request.put(url);
	    }
}
