package ExtentReport;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.And;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.gherkin.model.Then;
import com.aventstack.extentreports.gherkin.model.When;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportUtils implements ITestListener{
	static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest  feature;
	public static ExtentTest scenario;
	public static ExtentTest GivenStep;
	public static ExtentTest AndStep;
	public static ExtentTest WhenStep;
	public static ExtentTest ThenStep;
	public static  File reportOutputDirectory = new File("target");
	public static String projectName = "testng-cucumber";
	public static ITestResult result = null;
		
	public ExtentReportUtils()
	{
		
	}
	
	@BeforeTest
	public static void setExtent()
	{		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/html/extent.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		extent =new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "LTILPUN23200595");
		extent.setSystemInfo("OS", "Window10");
		extent.setSystemInfo("TesterName", "Abhilasha Koka");
		extent.setSystemInfo("BrowserName", "Chrome");
	}	
	
	public static void createTestCase(String testnumber,String description)
	{
		feature=extent.createTest(Feature.class ,description);
		feature.log(Status.INFO, description);
		Assert.assertTrue(true);
	}		
	
	
	public static void createTestNode(String nodenumber, String description) 
	{
		 scenario=feature.createNode(Scenario.class, description);
		 scenario.log(Status.INFO, description);
			Assert.assertTrue(true);
	}
	
	public static void createTestSteps(String stepType, String description)
	{
		switch(stepType)
		{
		case"Given":
			 GivenStep=scenario.createNode(Given.class, description);
			 GivenStep.log(Status.INFO, description);
				Assert.assertTrue(true);
				
			break;
		case"And":
			 AndStep=scenario.createNode(And.class, description);
			 AndStep.log(Status.INFO, description);
				Assert.assertTrue(true);
			break;
		case "When":
			  WhenStep=scenario.createNode(When.class, description);
			  WhenStep.log(Status.INFO, description);
				Assert.assertTrue(true);
			break;
		case "Then":
			 ThenStep=scenario.createNode(Then.class, description);
			 ThenStep.log(Status.INFO, description);
				Assert.assertTrue(true);
			break;
		case "default":
			System.out.println();
			
		}
		
	}
	
	@AfterTest
	public  static void endReport() 
	{		
		extent.flush();
	}
	
	
	
	@AfterMethod
		public  static void tearDown() throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			feature.log(Status.FAIL, "TestCase Fail is "+result.getName());
			feature.log(Status.FAIL, "TestCase Fail is "+result.getThrowable());
			String ScreenShotPath=ExtentReportUtils.getScreenshot(driver, result.getName());
			feature.addScreenCaptureFromPath(ScreenShotPath);
		}
		else if(result.getStatus()==ITestResult.SKIP) {			
			feature.log(Status.SKIP, "TestCase Skip is "+result.getName());
			
		}
      else if(result.getStatus()==ITestResult.SUCCESS){
			
    	  feature.log(Status.PASS, "TestCase Passed is "+result.getName());	
		}
		
		
		
	}
	
	
	private  static  String getScreenshot(WebDriver driver ,String screenshotName) throws IOException {
		String dateName=new SimpleDateFormat("yyyyddmmhhmmss").format(new Date());
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File source=screenshot.getScreenshotAs(OutputType.FILE);		
		String destination=System.getProperty("user.dir")+"/Screenshot/"+screenshotName+dateName+".png";
		File finalDestination=new File(destination);
		FileUtils.copyFile(source,finalDestination);
		return destination;
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	


	
	
	


	}


