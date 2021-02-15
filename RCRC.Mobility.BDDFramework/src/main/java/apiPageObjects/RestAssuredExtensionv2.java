package apiPageObjects;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import managers.FileReaderManager;
import Utility.APIConstant;
import Utility.APIConstant.ApiMethods;

import java.util.Map;

public class RestAssuredExtensionv2 
{
    private RequestSpecBuilder builder = new RequestSpecBuilder();
    private String method;
    private String url;
//    public String baseURL= FileReaderManager.getInstance().getConfigReader().getBaseUrl();
    /**
     * RestAssuredExtensionv2 constructor to pass the initial settings for the the following method
     * @param uri
     * @param method
     * @param token
     */
    public RestAssuredExtensionv2(String uri, String method, String token, String baseURL) {
        RestAssured.baseURI=baseURL;
        this.url = baseURL + uri;
        this.method = method;
        if(token != null)
        builder.addHeader("Authorization", "Bearer " + token);
        builder.addHeader("Authorization", "Basic Vzd1ZmZCUFh6NjRfRFEwZmhfTmh5VlM1TzZBYToweThtYWU0Y3ZHbkp4OUI0Zm5Eb3RmUzV4WThh");
        builder.addHeader("Content-Type", "application/x-www-form-urlencoded");
        builder.addFormParam("grant_type","password");
        builder.addFormParam("username", "apisubscriber");
        builder.addFormParam("password","apisubscriber");
    }

    /**
     * ExecuteAPI to execute the API for GET/POST/DELETE
     * @return ResponseOptions<Response>
     */
    private ResponseOptions<Response> ExecuteAPI() {
        RequestSpecification requestSpecification = builder.build();
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.spec(requestSpecification);
        if(this.method.equalsIgnoreCase(APIConstant.ApiMethods.POST))
            return request.post(this.url);
        else if(this.method.equalsIgnoreCase(APIConstant.ApiMethods.DELETE))
            return request.delete(this.url);
        else if(this.method.equalsIgnoreCase(APIConstant.ApiMethods.GET))
            return request.get(this.url);
        return null;
    }

    /**;
     * Authenticate to get the token variable
     * @param body
     * @return string token
     */
    public String Authenticate(Object body) {
    	 builder.setBody(body);
    	 return ExecuteAPI().getBody().jsonPath().get("access_token");
    }
    
    /**
     * Executing API with query params being passed as the input of it
     * @param formParams
     * @return Reponse
     */
    public String Authenticate2() {   	 	 
    	return  ExecuteAPI().getBody().jsonPath().get("access_token");
   	
   }

    /**
     * Executing API with query params being passed as the input of it
     * @param queryPath
     * @return Reponse
     */
    public ResponseOptions<Response> ExecuteWithQueryParams(Map<String, String> queryPath) {
        builder.addQueryParams(queryPath);
        return ExecuteAPI();
    }

    /**
     * ExecuteWithPathParams
     * @param pathParams
     * @return
     */
    public ResponseOptions<Response> ExecuteWithPathParams(Map<String, String> pathParams) {
        builder.addPathParams(pathParams);
        return ExecuteAPI();
    }

    /**
     * ExecuteWithPathParamsAndBody
     * @param pathParams
     * @param body
     * @return
     */
    public ResponseOptions<Response> ExecuteWithPathParamsAndBody(Map<String, String> pathParams, Map<String, String> body) {
        builder.setBody(body);
        builder.addPathParams(pathParams);
        return ExecuteAPI();
    }

}
