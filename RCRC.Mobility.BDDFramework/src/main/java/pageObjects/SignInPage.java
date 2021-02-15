package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Utility.CommonUtils;
import dataProvider.ConfigFileReader;

public class SignInPage {
	private WebDriver driver;
	ConfigFileReader configFileReader;
	
	public SignInPage(WebDriver driver) 
	{
		 PageFactory.initElements(driver, this);
		 configFileReader= new ConfigFileReader();
	}
	
	
	 @FindBy(how = How.XPATH, using = "//*[@id=\"wrapper\"]/header/div/div[1]/div[5]/a[1]") 
	 private WebElement lnk_SigIn;
	 
	 @FindBy(how = How.XPATH, using = "//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_login\"]") 
	 private WebElement txt_ScreenName;
	 
	 @FindBy(how = How.XPATH, using = "//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_password\"]") 
	 private WebElement txt_Password;
	
	 @FindBy(how = How.XPATH, using = "//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_rememberMe\"]") 
	 private WebElement chk_RememberMe;
	 
	 @FindBy(how = How.XPATH, using = "//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_loginForm\"]/fieldset/div[2]/button[1]") 
	 private WebElement btn_SignIn;
	

     @FindBy(how = How.XPATH, using = "//*[@id=\"portlet_com_liferay_login_web_portlet_LoginPortlet\"]/div/div[1]/div[2]/h2[contains(text(),'Sign In')]")
	 private WebElement hd_signIn;
	
	public boolean ValidateSignInPage() {
		boolean bol=false; 
		try
		{				
		if(hd_signIn.getAttribute("Sign In").contains("Sign In"))
		 {
		 System.out.println("User should able to navigate to  Sign In Page");
		 }			  
		  System.out.println("User should  not able to navigate to  Sign In Page");
		 
		   bol=true;
		}	
		
		catch(Exception ex) {
			System.out.println(ex.getCause());
			System.out.println(ex.getMessage());
			ex.getStackTrace();
		}	
		 
		return bol;	
		
	}
	 public boolean ClickOnSignIn() {
			
		 boolean bol=false;
		try
		{
		 
		 CommonUtils.Clicks(lnk_SigIn);
		 {
			System.out.println("User should able to click on SignIn");
		 }		  
			System.out.println("User should not able to click on SignIn");
		    bol=true;
		}	
		catch(Exception ex) {
			System.out.println(ex.getCause());
			System.out.println(ex.getMessage());
			ex.getStackTrace();
		}	
		return bol;	
		}
	 
	 public boolean LoginIn_SignInPage(String username, String password, String rem ) {
		 
		boolean bool=false;
		 try {			
			
			 CommonUtils.Clicks(txt_ScreenName);
			 CommonUtils.EnterText(txt_ScreenName, username);
			 Thread.sleep(1000);
			 CommonUtils.EnterText(txt_Password, password);	
			 Thread.sleep(1000);
			 CommonUtils.Clicks(btn_SignIn);
			 // txt_Password.sendKeys(Keys.RETURN);		
			 Thread.sleep(5000);
			bool=true;
		} catch (Exception e) {			
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
			e.printStackTrace();
		}
		return bool; 
		 
	 }
	 
	 public boolean LogOut_SignInPage() {
		 
			boolean bool=false;
			 try {
				
				 bool=true;
				
			   } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bool; 
			 
		 }
	
	
	
}
