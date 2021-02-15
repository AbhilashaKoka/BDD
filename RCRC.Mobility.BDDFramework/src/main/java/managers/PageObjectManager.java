package managers;
import org.openqa.selenium.WebDriver;
import pageObjects.AboutKAPRATPage;
import pageObjects.ContactUsPage;
import pageObjects.EventsPage;
import pageObjects.ServiceStatusPage;
import pageObjects.FareMediaPage;
import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LineTrackerPage;
import pageObjects.NewsPage;
import pageObjects.PrivacyErrorPage;
import pageObjects.RegisterPage;
import pageObjects.RiyadhTransitNetwork;
import pageObjects.SignInPage;

//FYI:In the case of multiple-step definition files, we will be creating an object of Pages again and again
public class PageObjectManager
{
	private WebDriver driver;	
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
	private RiyadhTransitNetwork riyadhTransitNetworkPage;
	private NewsPage newsPage;
	
	public PageObjectManager(WebDriver driver) {
	this.driver = driver;
	}	
	
	public PrivacyErrorPage getPrivacyErrorPage() {
		return (privacyErrorPage==null)?privacyErrorPage=new PrivacyErrorPage(driver):privacyErrorPage;
		}
	public SignInPage getSignInPage() {
		return(signInPage==null)?signInPage=new SignInPage(driver):signInPage;
		
	}
	
	public RegisterPage getRegisterPage(){
		   return(registerPage==null)?registerPage=new RegisterPage(driver):registerPage;
		   }
	
	public HomePage getHomePage() {
		return (homePage==null)?homePage=new HomePage(driver):homePage;
		}
	    
		
   public RiyadhTransitNetwork geRiyadhTransitNetwork() {
			return(riyadhTransitNetworkPage==null)?riyadhTransitNetworkPage=new RiyadhTransitNetwork(driver):riyadhTransitNetworkPage;
			
		}

   public LineTrackerPage getLineTrackerPage() {
		return (lineTrackerPage==null)?lineTrackerPage=new LineTrackerPage(driver):lineTrackerPage;
		}

   public FareMediaPage getFareMediaPage() {
		return (fareMediaPage==null)?fareMediaPage=new FareMediaPage(driver):fareMediaPage;
		}
   
   public ContactUsPage getContactUsPage() {
		return(contactUsPage==null)?contactUsPage=new ContactUsPage(driver):contactUsPage;
		}
		
   public  NewsPage geNewsPage() {
	   return(newsPage==null)?newsPage=new NewsPage(driver):newsPage;
	   }
	
	public AboutKAPRATPage getAboutKAPRATPage() {
	return (aboutKAPRATPage==null)?aboutKAPRATPage=new AboutKAPRATPage(driver):aboutKAPRATPage;	
	}
	
	public ServiceStatusPage getFAQPage() {
	return(faqPage==null)?faqPage=new ServiceStatusPage(driver):faqPage;	
	}
	
  
   public  EventsPage getEventsPage() {
   return(eventsPage==null)?eventsPage=new EventsPage(driver):eventsPage;
   }
   public  ForgotPasswordPage getForgotPasswordPage()
   {
	   return ( forgotPasswordPage==null)? forgotPasswordPage=new  ForgotPasswordPage(driver): forgotPasswordPage;
   }


}

