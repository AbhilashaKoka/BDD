package cucumber;
import apiPageObjects.RestAssuredExtension;
import apiPageObjects.RestAssuredExtensionv2;
import managers.FileReaderManager;
//Test Context class to hold all the objects state.
//Text Context class shall encompass all information your Steps files are using
public class APITestContext {
	//private final String BASE_URL = "https://bookstore.toolsqa.com";
	// private final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
	private final String uri=null;
	private final String method=null;
	private final String token=null;
	private final String baseURL= FileReaderManager.getInstance().getConfigReader().getBaseUrl();
	// private EndPoints endPoints;
	private RestAssuredExtension restAssuredExtension;
	private RestAssuredExtensionv2 restAssuredExtensionv2;
	 private ScenarioContext scenarioContext;
	 
	 public APITestContext() {
	// endPoints = new EndPoints(BASE_URL);
	 restAssuredExtension=new RestAssuredExtension(baseURL);
	 restAssuredExtensionv2=new RestAssuredExtensionv2( uri,  method,  token, baseURL);
	 scenarioContext = new ScenarioContext();
	// scenarioContext.setContext(Context.USER_ID, USER_ID);
	 }
	 
//	 public EndPoints getEndPoints() {
//	        return endPoints;
//	    }
	 public RestAssuredExtension getRestAssuredExtension() {
		 return restAssuredExtension;
		 
	 }
	 
	 public RestAssuredExtensionv2 getRestAssuredExtensionv2() {
		 return restAssuredExtensionv2;
	 }
	 
	 public ScenarioContext getScenarioContext() {
	 return scenarioContext;
	 }

}
