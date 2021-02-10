package stepDefinitions.mobilesteps;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ExtentReport.ExtentReportUtils;
import cucumber.TestContext;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;




public class AppiumUtils extends ExtentReportUtils{
	public static  Scenario scenario;
    static Logger LOGGER=LogManager.getLogger(AppiumUtils.class);
    String logPath=System.getProperty("user.dir")+"\\Configs\\log4j.properties";
	TestContext testContext;
	public static AndroidDriver<MobileElement> mobiledriver=null;
	
	
	public AppiumUtils(TestContext context) {
		testContext = context;   
	}
	
	@Before
	public void BeforeStep(Scenario scenario) {	
		PropertyConfigurator.configure(logPath);	
		try {
		  AppiumUtils.scenario=scenario;
          System.out.println("Before steps ...................");  
          LOGGER.info("Before steps......");
		}
		catch(Exception ex) {
			LOGGER.error(ex.getMessage());
		}         

	}
	
	@AfterStep
	public void AfterSteps(Scenario scenario)
	{
	AppiumUtils.scenario=scenario;
	if(scenario.isFailed()){
	try{
	LOGGER.info("Test Step is Fail");
	scenario.write(" Test Step is Fail");
	//final byte[] screenshot=((TakesScreenshot) mobiledriver).getScreenshotAs(OutputType.BYTES);
	//scenario.embed(screenshot, "image/png");
	
	}
	catch(Exception e)
	{
	LOGGER.error(e.getMessage());
	e.printStackTrace();
	}
	}
	else{
	try{
	LOGGER.info("Test Step is pass");
	scenario.write("Test Step is pass");
 //   scenario.embed(((TakesScreenshot) mobiledriver).getScreenshotAs(OutputType.BYTES),"image/png");
    }
	catch(Exception e)
	{
	LOGGER.error(e.getMessage());
	e.printStackTrace();
	}
	}
	}
	 @After(order = 0)
	    public void AfterSteps(){	
		 try {
		testContext.getWebDriverManager().closeAndroidDriver();
		LOGGER.info("Driver Close");
		 }
		 catch(Exception e) {
			 e.getMessage();
			 LOGGER.error(e.getMessage());
		 }
	 }
}