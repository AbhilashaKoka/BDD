package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import dataProvider.ConfigFileReader;
public class HomePage {
	
		private WebDriver driver;
		ConfigFileReader configFileReader;
		
			public HomePage(WebDriver driver) 
			{
				 PageFactory.initElements(driver, this);
				 configFileReader= new ConfigFileReader();
			}
			
			
			 @FindBy(how = How.XPATH, using = "//*[@id=\"wrapper\"]/header/div/div[1]/div[4]/a[1]")
			 private WebElement lnk_SignIn;	
			 @FindBy(how = How.XPATH, using = "//*[@id=\\\"navbar_com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet\\\"]/ul[1]/li[10]") 
			 private WebElement btn_register;
			 @FindBy(how = How.XPATH, using = "//*[@id=\"navbar_com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet\"]/ul[1]/li[1]") 
			 private WebElement btn_home;
			 @FindBy(how = How.XPATH, using = "//*[@id=\\\"navbar_com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet\\\"]/ul[1]/li[2]") 
			 private WebElement btn_riyadhTransitNetwork;
			 @FindBy(how = How.XPATH, using = "//*[@id=\\\"navbar_com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet\\\"]/ul[1]/li[3]") 
			 private WebElement btn_linetracker;
			 @FindBy(how = How.XPATH, using = "//*[@id=\\\"navbar_com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet\\\"]/ul[1]/li[4]") 
			 private WebElement btn_faremedia;
			 @FindBy(how = How.XPATH, using = "//*[@id=\\\"navbar_com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet\\\"]/ul[1]/li[5]") 
			 private WebElement btn_contactus;
			 @FindBy(how = How.XPATH, using = "//*[@id=\\\"navbar_com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet\\\"]/ul[1]/li[6]") 
			 private WebElement btn_News;
			 @FindBy(how = How.XPATH, using = "//*[@id=\\\"navbar_com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet\\\"]/ul[1]/li[7]") 
			 private WebElement btn_servicestatus;			 			 
			 @FindBy(how = How.XPATH, using = "//*[@id=\\\"navbar_com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet\\\"]/ul[1]/li[9]") 
			 private WebElement btn_aboutkaprat;
			 
			  
			
			 
			 public void NavigateToHomePage( ) {				 
					
				 try {
					 
					 if(driver.getTitle()=="Home - Liferay DXP") {
						 
						 System.out.println("User is in HomePage");
					 }
					 String option="home";
					 
					 switch( option)
					 {
					 case "home":
					 btn_home.click();
					 break;
					 case "btn_servicestatus":
					btn_servicestatus.click();
					break;
					 case "linetracker":
					btn_linetracker.click();
					break;
					 case "faremedia":
					btn_faremedia.click();
					break;					
					 case "contactus":
					btn_contactus.click();
					break;
					 case "aboutkaprat":
					btn_aboutkaprat.click();
					break;
					 case "register":
					btn_register.click();
					break;
					 case "btn_riyadhTransitNetwork":
						 btn_riyadhTransitNetwork.click();
					default:
					System.out.println("no match");
					 }
					Thread.sleep(2000);
					
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			 
			 
			 public void NavigateToSignIn() {
				 try {
					 lnk_SignIn.click();
					 
				     }
				 catch(Exception ex) {
					 ex.getStackTrace();
				 }
			 }
}
