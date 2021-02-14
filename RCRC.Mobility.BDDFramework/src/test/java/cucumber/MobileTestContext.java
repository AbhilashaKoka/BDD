package cucumber;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import managers.MobileDriverManager;
import managers.MobilePageObjectManager;
import managers.PageObjectManager;

//Test Context class to hold all the objects state.
//Text Context class shall encompass all information your Steps files are using
public class MobileTestContext {
	private AndroidDriver<MobileElement> mobiledriver;
	private MobilePageObjectManager mobilePageObjectManager;
	public ScenarioContext scenarioContext;
	private MobileDriverManager mobileDriverManager;

	
	public MobileTestContext()
	 {
		if(mobileDriverManager==null)
	 {
		    mobileDriverManager=new MobileDriverManager();
	 }
		    mobilePageObjectManager =  new MobilePageObjectManager(mobileDriverManager.getMobileDriver());
	 }
	
	
	
	public MobileDriverManager getMobileDriverManager()
	{
	return mobileDriverManager;
	}
	
	
	public MobilePageObjectManager getMobilePageObjectManager() {
		
		
		return mobilePageObjectManager;
		
	}
	
	//List<RegisterDetails> registerdetails = FileReaderManager.getInstance().getJsonReader().getRegisterDetailsData();
	//Include ScenarioContext in TextContext, 
	//so that it can be shared across all the Cucumber Steps using Pico-Container library.
	//Also, to make sure to add a getter method as getScenarioContext() to get the scenarioContext object.
	
	public ScenarioContext getScenarioContext()
	{
		 return scenarioContext;
    }


}
