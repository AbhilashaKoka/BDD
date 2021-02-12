package stepDefinitions.web;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import ExtentReport.ExtentReportUtils;
import cucumber.TestContext;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import managers.FileReaderManager;

public class WebUtils extends ExtentReportUtils {
	TestContext testContext;
	private static ExtentTest test;
	private static  Scenario scenario;
	private static String path;
	private static String url;
	private static WebDriver driver;
	String logPath=System.getProperty("user.dir")+"\\Configs\\log4j.properties";
	
    static Logger LOGGER=LogManager.getLogger(WebUtils.class);

	public WebUtils(TestContext context)
	{
		testContext = context;
		path=FileReaderManager.getInstance().getConfigReader().getChromeDriverPath();
	    driver=testContext.getWebDriverManager().getDriver();
        url=FileReaderManager.getInstance().getConfigReader().getApplicationUrl();   
	}
	

	@Before
	public void BeforeScenario(Scenario scenario) {
		try {
			PropertyConfigurator.configure(logPath);	
			WebUtils.scenario=scenario;
		    System.setProperty("webdriver.chrome.driver",path);
	    	driver.get(url);	
		    LOGGER.info("launching URL");
		}
		catch(Exception ex) 
		{
		LOGGER.error(ex.getMessage());	
		}
   
	}
	
	@BeforeStep
	public void BeforeSteps(Scenario scenario) {
		try {
		    WebUtils.scenario=scenario;
		    }
		catch(Exception e) 
		{
		LOGGER.error(e.getMessage());
		}
	}
	

	@AfterStep
	public void AfterSteps(Scenario scenario)
	{
	WebUtils.scenario=scenario;
	if(scenario.isFailed())
	{
	try{
	LOGGER.info(Status.FAIL);
	scenario.write(" Test Step is Fail");
	final byte[] screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	scenario.embed(screenshot, "image/png");
	 
	}
	catch(Exception e)
	{
	e.printStackTrace();
	LOGGER.error(e.getMessage());
	}
	}
	else{
	try{ 
	LOGGER.info("Test Step is pass");		
	scenario.write(" Test Step is pass");
    scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES),"image/png");
   
	}
	catch(Exception e)
	{
	e.printStackTrace();
	LOGGER.error(e.getMessage());
	}
	}
	}
	
 
	 @After(order = 0)
	 public void teardown(Scenario scenario){
	 try {
	 WebUtils.scenario=scenario;
   //  testContext.getWebDriverManager().closeDriver();
     LOGGER.info("Driver close");
	  }
		 catch(Exception e) 
	 {
	 LOGGER.error(e.getMessage());
	 }

   }
	 
}