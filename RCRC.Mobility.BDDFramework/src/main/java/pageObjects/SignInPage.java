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
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"wrapper\"]/header/div/div[1]/div[4]/a[1]")
	 private WebElement lnk_SignIn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_loginForm\"]/fieldset/fieldset/div/div[1]/label/following-sibling::input")
	 private WebElement txt_ScreenName;
////*[@id="_com_liferay_login_web_portlet_LoginPortlet_login"]
	@FindBy(how = How.XPATH, using = "//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_password\"]")
	 private WebElement txt_Password;

	@FindBy(how = How.XPATH, using = "//*[@id=\"wrapper\"]/header/div/div[1]/div[4]/a[1]")
	 private WebElement chk_RememberMe;

	@FindBy(how = How.XPATH, using = "//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_ozsx\"]")
	 private WebElement btn_SignIn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"wrapper\"]/header/div/div[1]/div[4]/a[1]")
	 private WebElement lnk_ForgetPassword;
	
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
	
	
}
