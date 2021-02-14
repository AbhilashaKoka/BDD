package stepDefinitions.web;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Utility.Wait;
import cucumber.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pageObjects.ForgotPasswordPage;
import pageObjects.LogInPage;
import pageObjects.PrivacyErrorPage;
import pageObjects.SignInPage;
import testData.LoginDetails;


public class ForgotPassword_StepDefinitions  extends WebBase_TestStepDefinition{
	

	private WebDriver driver=null; 
	 TestContext testContext;
	 LogInPage loginPage;
	 PrivacyErrorPage privacyErr;	 
	 String title=null;	
	 ForgotPasswordPage forgotPasswordPage;
	 SignInPage signInPage;
	 private static Logger LOGGER=LogManager.getLogger(SignIn_TestStepDefinition.class);

	 
	 public ForgotPassword_StepDefinitions(TestContext context) {
		 super(context);
		  testContext = context;
		  privacyErr=testContext.getPageObjectManager().getPrivacyErrorPage();
		  forgotPasswordPage = testContext.getPageObjectManager().getForgotPasswordPage();
		  signInPage=testContext.getPageObjectManager().getSignInPage();
		  loginPage=testContext.getPageObjectManager().getLogInPage();
		  title=testContext.getWebDriverManager().getTitle();	
		  driver =testContext.getWebDriverManager().getDriver();	
		}

@When("Click on Forgot Password")
public void click_on_Forgot_Password() {
    try {
    	Wait.untilPageLoadComplete(driver);		
    	assertEquals(privacyErr.handlingPrivacyErrorPage(title), true);
	    if(privacyErr.handlingPrivacyErrorPage(title)== true)
		{
		 System.out.println("User Successfully Navigate through  Privacy  Page........!!!");
		 LOGGER.info("Click on Forgot Password");
		 }
//	     else if(loginPage.ValidateHomePage(title)==true) {
//	      System.out.println("User Successfully Navigate to  Home Page........!!!");
	      Thread.sleep(5000);	      
	      loginPage.ClickOnSignIn();
	      Thread.sleep(5000);
    	forgotPasswordPage.NavigateToForgotPassword();
  //  }
    }
    catch(Exception ex) {
    	LOGGER.error(ex.getMessage());
    ex.getCause();	
    }
}

@When("Enter the details and Click Send")
public void enter_the_details_and_Click_Send() {
	 try {
		 List<LoginDetails> logindetails = FileReaderManager.getInstance().getJsonReader().getLoginDetailsData();
		    Wait.untilPageLoadComplete(driver);
		    for(LoginDetails login : logindetails)
		    {	 
			String uname=login.username;
	        forgotPasswordPage.FillDetailsToResetPassword(uname);	
	        LOGGER.info("Enter the details and Click Send");
	    }
	 }
	    catch(Exception ex) {
	    	LOGGER.error(ex.getMessage());
	    	ex.getCause();
	    }
}

@Then("User should verify the SignIn Page")
public void user_should_verify_the_SignIn_Page() {
	 try {
		 assertEquals(signInPage.ValidateSignInPage(), true);
	     signInPage.ValidateSignInPage();
	     LOGGER.info("User should verify the SignIn Page");
	    }
	    catch(Exception ex) {
	    	LOGGER.error(ex.getMessage());
	    	ex.getCause();
	    }
}

}