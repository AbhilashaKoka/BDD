package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Utility.CommonUtils;
import dataProvider.ConfigFileReader;

public class ForgotPasswordPage {
	
	private WebDriver driver=null;
	ConfigFileReader configFileReader;
	
	public ForgotPasswordPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	    configFileReader= new ConfigFileReader();
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_ctvk____\"]")
	private WebElement lnk_forgotPwd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_screenName\"]")
	private WebElement txt_ScreenName;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_ymjo\"]")
	private WebElement btn_SendNewPassword;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_ctvk____\"]")
	private WebElement lnk_SignIn;
	
	
	
	 public void NavigateToForgotPassword() {
		 try {
			   CommonUtils.Clicks(lnk_forgotPwd);
			 }
		 catch(Exception ex) 
		 {
			 ex.getStackTrace();
		 }
	 }
	 
	 public SignInPage FillDetailsToResetPassword(String username) {
		 try {
			  CommonUtils.EnterText(txt_ScreenName,username);
			  CommonUtils.Clicks(txt_ScreenName);
			 }
		 catch(Exception ex) 
		 {
			 ex.getStackTrace();
		 }
		 return new SignInPage(driver);
	 }
	
	}

