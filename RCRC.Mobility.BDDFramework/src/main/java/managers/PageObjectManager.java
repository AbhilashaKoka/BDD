package managers;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import pageObjects.AboutKAPRATPage;
import pageObjects.ContactUsPage;
import pageObjects.EventsPage;
import pageObjects.ServiceStatusPage;
import pageObjects.FareMediaPage;
import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LineTrackerPage;
import pageObjects.LogInPage;
import pageObjects.PrivacyErrorPage;
import pageObjects.RegisterPage;
import pageObjects.SignInPage;

//in the case of multiple-step definition files, we will be creating an object of Pages again and again
public class PageObjectManager
{
	private WebDriver driver;	
	private LogInPage loginPage;
	private PrivacyErrorPage privacyErrorPage;
	private AboutKAPRATPage aboutKAPRATPage;
	private ContactUsPage contactUsPage;
	private ServiceStatusPage faqPage;
	private FareMediaPage fareMediaPage;
	private HomePage homePage;
	private LineTrackerPage lineTrackerPage;
	private RegisterPage registerPage;
	private EventsPage eventsPage;
	private ForgotPasswordPage forgotPasswordPage;
	private SignInPage signInPage;
	
	public PageObjectManager(WebDriver driver) {
	this.driver = driver;
	}	
	
	
	public SignInPage getSignInPage() {
		return(signInPage==null)?signInPage=new SignInPage(driver):signInPage;
		
	}

	public LogInPage getLogInPage(){
	return (loginPage == null) ? loginPage = new LogInPage(driver) : loginPage;
	}
	
	public PrivacyErrorPage getPrivacyErrorPage() {
	return (privacyErrorPage==null)?privacyErrorPage=new PrivacyErrorPage(driver):privacyErrorPage;
	}
	public AboutKAPRATPage getAboutKAPRATPage() {
	return (aboutKAPRATPage==null)?aboutKAPRATPage=new AboutKAPRATPage(driver):aboutKAPRATPage;	
	}
	public ContactUsPage getContactUsPage() {
	return(contactUsPage==null)?contactUsPage=new ContactUsPage(driver):contactUsPage;
	}
	public ServiceStatusPage getFAQPage() {
	return(faqPage==null)?faqPage=new ServiceStatusPage(driver):faqPage;	
	}
	public FareMediaPage getFareMediaPage() {
	return (fareMediaPage==null)?fareMediaPage=new FareMediaPage(driver):fareMediaPage;
	}
	public HomePage getHomePage() {
	return (homePage==null)?homePage=new HomePage(driver):homePage;
	}
    
    public RegisterPage getRegisterPage(){
   return(registerPage==null)?registerPage=new RegisterPage(driver):registerPage;
   }
   public  EventsPage getEventsPage() {
   return(eventsPage==null)?eventsPage=new EventsPage(driver):eventsPage;
   }
   public  ForgotPasswordPage getForgotPasswordPage()
   {
	   return ( forgotPasswordPage==null)? forgotPasswordPage=new  ForgotPasswordPage(driver): forgotPasswordPage;
   }


}

