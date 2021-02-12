package cucumber;

import managers.MobileDriverManager;
import managers.MobilePageObjectManager;
import managers.PageObjectManager;
import managers.WebDriverManager;

public class MobileTestContext {
	
	private MobilePageObjectManager mobilePageObjectManager;
	public ScenarioContext scenarioContext;
	private MobileDriverManager mobileDriverManager;

	
	public MobileTestContext()
	 {
		
		//if(driver == null) driver = createDriver();
				
	        mobileDriverManager=new MobileDriverManager();
		    mobilePageObjectManager =  new MobilePageObjectManager(mobileDriverManager.getMobileDriver());
	 
	 }
	
	
	
	public PageObjectManager getPageObjectManager()
	{
		return getPageObjectManager();
	}	
	
	public MobileDriverManager getMobileDriverManager()
	{
		return mobileDriverManager;
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
