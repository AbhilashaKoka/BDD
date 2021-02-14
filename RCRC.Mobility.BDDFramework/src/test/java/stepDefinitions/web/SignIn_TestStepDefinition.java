package stepDefinitions.web;
import static org.testng.Assert.assertTrue;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import Utility.Wait;
import cucumber.TestContext;
import enums.DocumentType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pageObjects.*;
import testData.LoginDetails;

public class SignIn_TestStepDefinition  extends WebBase_TestStepDefinition{
	 private WebDriver driver=null; 
	 TestContext testContext;
	 LogInPage loginPage;
	 PrivacyErrorPage privacyErr;	 
	 String title=null;	
	 RegisterPage registerPage;	 
	 static Logger LOGGER=LogManager.getLogger(SignIn_TestStepDefinition.class);
	
	public SignIn_TestStepDefinition(TestContext context)  
	{
		  super(context);
		  testContext = context;
		  registerPage = testContext.getPageObjectManager().getRegisterPage();
		  loginPage = testContext.getPageObjectManager().getLogInPage();
		  privacyErr=testContext.getPageObjectManager().getPrivacyErrorPage();
		  title=testContext.getWebDriverManager().getTitle();	
		  driver =testContext.getWebDriverManager().getDriver();		 
		  //testContext.getScenarioContext().setContext(DocumentType.PASSPORT, "1");		  
     }	
	

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		try {
		Wait.untilPageLoadComplete(driver);
		if(loginPage.ClickOnSignIn()==true)
		{	
		 assertTrue(true);
		 LOGGER.info("User Navigate to Login Page");
	    }
		}
		catch(Exception ex)
		{
		LOGGER.error(ex.getMessage());		
		throw new cucumber.api.PendingException();
		}
	}

	
	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {	
		try {			
			List<LoginDetails> logindetails = FileReaderManager.getInstance().getJsonReader().getLoginDetailsData();
		    Wait.untilPageLoadComplete(driver);
		    for(LoginDetails login : logindetails) {
		    String uname=login.username;
			String pwd=login.password;
			String chkbox=login.rememberme;	
			  if(loginPage.LoginIn_SignInPage(uname, pwd, chkbox)==true)
				{
				  assertTrue(true);
				  LOGGER.info("User enters UserName " +uname+" and Password"+pwd+"");
				}
			     LOGGER.info("User not able to SignIn with "+uname+" and "+pwd+"");
		    }
		}
		catch(Exception ex)
		{
			LOGGER.error(ex.getMessage());
			throw new cucumber.api.PendingException();
			
		}
		
	}


	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		try {
		    Wait.untilPageLoadComplete(driver);
		    LOGGER.info("User logged in  Successfully");
		    }	
	    catch(Exception ex)
		{
	    	LOGGER.error(ex.getMessage());
		    throw new cucumber.api.PendingException();
	   }
	}	
}


