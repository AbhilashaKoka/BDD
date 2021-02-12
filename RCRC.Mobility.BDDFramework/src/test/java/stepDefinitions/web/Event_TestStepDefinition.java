package stepDefinitions.web;
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
import pageObjects.EventsPage;
import pageObjects.LogInPage;
import pageObjects.PrivacyErrorPage;
import pageObjects.RegisterPage;
import testData.LoginDetails;

public class Event_TestStepDefinition {
	 String title=null;
	 String EventsName;
	private WebDriver driver=null; 
	TestContext testContext;
     PrivacyErrorPage privacyErr;	 
	 RegisterPage registerPage;
	 EventsPage eventPage;
	 LogInPage loginPage;
	 private static Logger LOGGER=LogManager.getLogger(Event_TestStepDefinition.class);
	 
	 public Event_TestStepDefinition(TestContext context) {		 
		  testContext = context;
		  eventPage = testContext.getPageObjectManager().getEventsPage();
		  privacyErr=testContext.getPageObjectManager().getPrivacyErrorPage();
		  title=testContext.getWebDriverManager().getTitle();	
		  driver =testContext.getWebDriverManager().getDriver();
		  loginPage = testContext.getPageObjectManager().getLogInPage();
	}	
	 
	 
	 @Given("User SignIn with valid credentials")
	 public void user_SignIn_with_valid_credentials() {
	    try {
	    	 Wait.untilPageLoadComplete(driver);
	 		if(loginPage.ClickOnSignIn()==true)
	 		{			
	 	     System.out.println("User is in  SignIn Page...............!!!");
	 	     LOGGER.info("User SignIn with valid credentials");
	 	    
	 		 }
	 		List<LoginDetails> logindetails = FileReaderManager.getInstance().getJsonReader().getLoginDetailsData();
		    Wait.untilPageLoadComplete(driver);
		    for(LoginDetails login : logindetails) {	 
			String uname=login.username;
			String pwd=login.password;
			String chkbox=login.rememberme;
			  if(loginPage.LoginIn_SignInPage(uname, pwd, chkbox)==true)
				{
				  System.out.println("User Successfully  SignIn with credential.....!!!");
				  LOGGER.info("User Successfully  SignIn with credential");
				 
				}
		
		    }
	    }
	    catch(Exception ex) {
	    	LOGGER.error(ex.getMessage());
	     throw new cucumber.api.PendingException();
	    }
	 }

  @When("User Navigate to Events Page")
   public void user_Navigate_to_Events_Page() {
    try {
    	Wait.untilPageLoadComplete(driver);			
	    if(eventPage.NavigateToEventPage(title)== true)
		{
		 System.out.println("User Navigate to Event Page........!!!");
		 LOGGER.info("User Navigate to Events Page");
		
     }
    }
    catch(Exception ex) 
    {    
    	LOGGER.error(ex.getMessage());
    	 throw new cucumber.api.PendingException();	
    }   
}

  @When("User  click on Add Event")
  public void user_click_on_Add_Event() {
  try {
	 Wait.untilPageLoadComplete(driver);			
    if(eventPage.ClickOnAddNewEventTab()== true)
	{
	 System.out.println("User Navigate to Add New Event Page........!!!");
		LOGGER.info("User click on Add Event");
    }
  }
    catch(Exception ex) {
    	LOGGER.error(ex.getMessage());
    	 throw new cucumber.api.PendingException();	
    } 
}

@When("USer fills Event Details and Save")
public void user_fills_Event_Details_and_Save() {
try {
	List<LoginDetails> logindetails = FileReaderManager.getInstance().getJsonReader().getLoginDetailsData();
    Wait.untilPageLoadComplete(driver);
    for(LoginDetails login : logindetails)
    {
    	String eventname=login.eventname;
    	String eventcoordinate=login.eventcoordinate;
    	String eventstartdate=login.eventstartdate;
    	String eventenddate=login.eventenddate;
    	String eventstarttime=login.eventstartdate;
    	String eventeventtime=login.eventenddate;
    	String programstarttime=login.programstarttime;
	    String programendtime=login.programendtime;
	    String eventurl=login.eventurl;
	    String selectcurrency=login.selectcurrency;
	    String eventprice=login.eventprice;
	    String eventdescription=login.eventdescription;
	    String filelocation="C:\\Users\\10655479\\eclipse-workspace\\Cucumberframework_updated\\CucumberFramework\\CucumberFramework\\src\\test\\resource\\testDataResources\\download.jpg";
	    if(eventPage.FillingNewEventDetails(eventname,eventcoordinate,eventstartdate,eventenddate,eventstarttime,eventeventtime,programstarttime,programendtime,eventurl,selectcurrency,eventprice,eventdescription,filelocation)== true)
	     {
		 System.out.println("User fill new event details to  new event page........!!!");
		 LOGGER.info("User fills Event Details and Save"+eventname+""+eventcoordinate+""+eventstartdate+""+eventenddate+""+eventstarttime+""+eventeventtime+""+programstarttime+""+programendtime+""+eventurl+""+selectcurrency+""+eventprice+""+eventdescription+""+filelocation+"");
	     }
    }
    }
catch(Exception ex) {
LOGGER.error(ex.getMessage());	
}
}

@Then("User can verify new Event created Successfully")
public void user_can_verify_new_Event_created_Successfully() {
try {
	Wait.untilPageLoadComplete(driver);			
    if(eventPage.VerifyNewEventsCreated(EventsName)== true)
	{
	 System.out.println("User fill new event details to  new event page........!!!");
	LOGGER.info("User can verify new Event created Successfully");
    }	
    }
    catch(Exception ex) {
    	LOGGER.error(ex.getMessage());
    	 throw new cucumber.api.PendingException();	
    } 
}

@When("User able to read details")
public void user_able_to_read_details() {
try {
	Wait.untilPageLoadComplete(driver);			
    if(eventPage.ReadEventsDetails(EventsName)== true)
	{
	 System.out.println("User fill new event details to  new event page........!!!");
	LOGGER.info("User able to read details");
    }
}
    catch(Exception ex) {
    	LOGGER.error(ex.getMessage());
    	 throw new cucumber.api.PendingException();	
    } 
}

@Then("User can verify new Event read Successfully")
public void user_can_verify_new_Event_read_Successfully() {
try {
	Wait.untilPageLoadComplete(driver);			
    if(eventPage.VerifyNewEventsCreated(EventsName)== true)
	{
	 System.out.println("User fill new event details to  new event page........!!!");
		LOGGER.info("User can verify new Event read Successfully");
    }
}
    catch(Exception ex)
{
    	LOGGER.error(ex.getMessage());
    	 throw new cucumber.api.PendingException();	
 } 
}

@When("User able to edit event details")
public void user_able_to_edit_event_details() {
try {
	Wait.untilPageLoadComplete(driver);			
    if(eventPage.EditEventsDetails(EventsName)== true)
	{
	 System.out.println("User fill new event details to  new event page........!!!");
	 LOGGER.info("User able to edit event details");
	}
    	
    }
    catch(Exception ex) {
    	LOGGER.error(ex.getMessage());
    	 throw new cucumber.api.PendingException();	
    } 
}

@Then("User can verify new Event edit Successfully")
public void user_can_verify_new_Event_edit_Successfully() {
try {
	Wait.untilPageLoadComplete(driver);			
    if(eventPage.VerifyNewEventsCreated(EventsName)== true)
	{
	 System.out.println("User fill new event details to  new event page........!!!");
	LOGGER.info("User can verify new Event edit Successfully");
	}
    	
    }
    catch(Exception ex) {
    	LOGGER.error(ex.getMessage());
    	 throw new cucumber.api.PendingException();	
    } 
}

@When("User able to delete event details")
public void user_able_to_delete_event_details() {
try {
	Wait.untilPageLoadComplete(driver);			
    if(eventPage.DeleteEventsDetails(EventsName)== true)
	{
	 System.out.println("User fill new event details to  new event page........!!!");
	LOGGER.info("User able to delete event detail");
	}
    }
    catch(Exception ex) {
    	LOGGER.error(ex.getMessage());
    	 throw new cucumber.api.PendingException();	
    } 
}

@Then("User can verify new Event delete Successfully")
public void user_can_verify_new_Event_delete_Successfully() {
try {
	Wait.untilPageLoadComplete(driver);			
    if(eventPage.VerifyNewEventsCreated(EventsName)== true)
	{
	 System.out.println("User fill new event details to  new event page........!!!");
	 LOGGER.info("User can verify new Event delete Successfully");
	}	
    }
    catch(Exception ex) {
    	LOGGER.error(ex.getMessage());
    	 throw new cucumber.api.PendingException();	
    } 
}

}