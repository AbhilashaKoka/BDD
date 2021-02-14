package cucumber;
import managers.MobileDriverManager;
import managers.PageObjectManager;
import managers.WebDriverManager;

//Test Context class to hold all the objects state.
//Text Context class shall encompass all information your Steps files are using
public class TestContext{
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	public ScenarioContext scenarioContext;
	private MobileDriverManager mobileDriverManager;

	
	public TestContext()
	 {
		if(webDriverManager==null)
		{
			webDriverManager=new WebDriverManager();
		  	//webDriverManager = new WebDriverManager();
		}
		    pageObjectManager =  new PageObjectManager(webDriverManager.getDriver());

	 
	 }
	
	public WebDriverManager getWebDriverManager()
	{
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager()
	{
		return pageObjectManager;
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