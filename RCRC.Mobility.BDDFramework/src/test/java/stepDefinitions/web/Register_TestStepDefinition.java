package stepDefinitions.web;
import static org.testng.Assert.assertEquals;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import Utility.Wait;
import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pageObjects.LogInPage;
import pageObjects.PrivacyErrorPage;
import pageObjects.RegisterPage;
import testData.LoginDetails;

    public class Register_TestStepDefinition {
	private WebDriver driver=null; 
	TestContext testContext;
	 LogInPage loginPage;
	 PrivacyErrorPage privacyErr;	 
	 String title=null;	
	 RegisterPage registerPage;
	 private static Logger LOGGER=LogManager.getLogger(Register_TestStepDefinition.class);
	
	public Register_TestStepDefinition(TestContext context) {
		 testContext = context;
		  registerPage = testContext.getPageObjectManager().getRegisterPage();
		  loginPage = testContext.getPageObjectManager().getLogInPage();
		  privacyErr=testContext.getPageObjectManager().getPrivacyErrorPage();
		  title=testContext.getWebDriverManager().getTitle();	
		  driver =testContext.getWebDriverManager().getDriver();
	}
	@Given("User is on Home Page")
	public void user_is_on_home_page() throws Exception {
		try {
			Wait.untilPageLoadComplete(driver);	
			assertEquals(privacyErr.handlingPrivacyErrorPage(title), true);
		    if(privacyErr.handlingPrivacyErrorPage(title)== true)
			 {
			 System.out.println("User Successfully Navigate through  Privacy  Page........!!!");
			 LOGGER.info("User is on Home Page"+title+"");
			 }
		     else if(loginPage.ValidateHomePage(title)==true)
		     {
		      System.out.println("User Successfully Navigate to  Home Page........!!!");
		   	 }
		
	}
	 catch(Exception ex)
		{
		 LOGGER.error(ex.getMessage());
		 throw new cucumber.api.PendingException();
	   }
	}
	
	
	
	@When("User Navigate to Register Page")
	public void user_Navigate_to_Register_Page() {
		try {
			Wait.untilPageLoadComplete(driver);	
			assertEquals(registerPage.NavigateToRegisterPage(title), true);
		    if(registerPage.NavigateToRegisterPage(title)== true)
			{
			 System.out.println("User Navigate to Register Page........!!!");
			LOGGER.info("User Navigate to Register Page");
			}
		}
		catch(Exception ex) {
			LOGGER.error(ex.getMessage());
	    
		throw new cucumber.api.PendingException();
	}
	}

	@When("User enters details")
	public void user_enters_details() {
		try {
		List<LoginDetails> logindetails = FileReaderManager.getInstance().getJsonReader().getLoginDetailsData();
	    Wait.untilPageLoadComplete(driver);
	    for(LoginDetails login : logindetails) {
		String name =login.name,surname = login.surname,DocumentType = login.document,	DocumentID = login.documentid,	DOB = login.dob,phonenumber = login.phonenumber, 
		Email = login.email,gender=login.gender,eligible=login.eligible, reseller = login.reseller,Locale = login.locale,upload = null;	
		assertEquals(registerPage.EnterRegisterDetails(name, surname, DocumentType, DocumentID, DOB, phonenumber, Email, gender, eligible, reseller, Locale, upload), true);
		if(registerPage.EnterRegisterDetails(name, surname, DocumentType, DocumentID, DOB, phonenumber, Email, gender, eligible, reseller, Locale, upload)==true)
		{
		System.out.println("User  enters details Register Page........!!!");
		LOGGER.info("User  enters details Register Page::Name:"+name+"Surname:"+surname+ "DocumentType:"+DocumentType+"DocumentID:"+DocumentID+"DateOFBirth:"+DOB+"PhoneNumber:"+phonenumber+"Email:"+Email+"Gender:"+gender+"Eligible:"+eligible+"Reseller:"+reseller+"Locale:"+Locale+"upload:"+upload+"");
		}
	    }
		}
	    catch(Exception ex)
	    {
	    	LOGGER.error(ex.getMessage());
	    	throw new cucumber.api.PendingException();
	    }
	 }
	@Then("Message dispayed Register Successfully")
	public void message_dispayed_Register_Successfully() {
	  try {
		  System.out.println("Successfully Register!!") ;
		  LOGGER.info("Message dispayed Register Successfully");
	    }
	  catch(Exception ex) {
		  LOGGER.error(ex.getMessage());
		throw new cucumber.api.PendingException();
	}
	}


}
