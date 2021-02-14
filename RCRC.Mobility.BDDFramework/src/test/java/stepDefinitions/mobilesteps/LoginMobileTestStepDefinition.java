package stepDefinitions.mobilesteps;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.FluentWait;
import com.google.common.base.Function;
import Utility.CommonUtils;
import Utility.Wait;
import cucumber.MobileTestContext;
import cucumber.TestContext;
import cucumber.api.PendingException;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;


public class LoginMobileTestStepDefinition extends MobileBase_TestStepDefinition{
	MobileTestContext mobiletestContext;
	public static AndroidDriver<MobileElement> mobiledriver=null;
	private String MobileURL=null;
	

	public LoginMobileTestStepDefinition(MobileTestContext context)  
	{	
		super(context);
		mobiletestContext = context;
		mobiledriver =mobiletestContext.getMobileDriverManager().getMobileDriver();
		//MobileURL=FileReaderManager.getInstance().getConfigReader().getApplicationUrl();
		//MobileURL="http://192.168.59.11:8080/web/guest/home";
		MobileURL="https://opensource-demo.orangehrmlive.com/";
	}

	@Given("I am able to launch appium")
	public void i_am_able_to_launch_appium() 
	{
	    try{	
	       	  mobiledriver.manage().deleteAllCookies(); 
	    	    System.out.println("###........CONNECTION SUCCESSFULLY ESTABLISHED WITH NODE DEVICE........###");
	  	        mobiledriver.get(MobileURL);	    	  
	    	    System.out.println("Browser Started.............");
	           	MobileElement btn_Advanced =mobiledriver.findElementByXPath("//*[@id=\"body\"]/div/div[2]//button[3]");
				CommonUtils.Clicks(btn_Advanced);
				Wait.waitUntil(mobiledriver);
				MobileElement lnk_continue =mobiledriver.findElementByXPath("//*[@id=\"details\"]/p[2]/a");
				CommonUtils.Clicks(lnk_continue);
				Function<AndroidDriver<MobileElement>, Boolean> waitCondition = new Function<AndroidDriver<MobileElement>, Boolean>() 
				{
  				public Boolean apply(AndroidDriver<MobileElement> mobiledriver) 
		         {
  					MobileElement element =mobiledriver.findElementByXPath("//*[@id=\"wrapper\"]/header/div/div[1]/div[4]/a[1]");
					String color = element.getCssValue("color");
						System.out.println("The button text has color :" + color);
						if (color.equals("rgba(255, 255, 0, 1)"))
				    {
						return true;
						}
						return false;
				}
				};
				//Wait.untilPageLoadComplete(mobiledriver,160L);
     			MobileElement sign_In = mobiledriver.findElementByXPath("//*[@id=\"wrapper\"]/header/div/div[1]/div[4]/a[1]");
				CommonUtils.Clicks(sign_In);
		   }
	    catch(Exception ex)
	       {
	    	  throw new PendingException();
	       }
	}

	@When("user enter credentials")
	public void user_enter_credentials()
	{
		try{
			MobileElement screenName = mobiledriver.findElementByXPath("//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_loginForm\"]/fieldset/fieldset/div/div[1]/input");
			CommonUtils.EnterText(screenName, "");
			MobileElement Password = mobiledriver.findElementByXPath("//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_loginForm\"]/fieldset/fieldset/div/div[2]/input");
			CommonUtils.EnterText(Password, "");
			MobileElement RememberMe = mobiledriver.findElementByXPath("//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_rememberMe\\");
			CommonUtils.Clicks(RememberMe);
					
			}
	    catch(Exception ex)
	    {
	    	throw new PendingException();
	    }
	}

	@When("user click login")
	public void user_click_login() 
	{
		try
		{
		MobileElement SaveButton = mobiledriver.findElementByXPath("//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_loginForm\"]/fieldset/div[2]/button");			
		CommonUtils.Clicks(SaveButton);
	    System.out.println("User Successfully login");
	    }
	    catch(Exception ex)
	      { 
	        throw new PendingException();
	      }
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
	   try
	   {
		   mobiletestContext.getMobileDriverManager().closeAndroidDriver();
	   }
		   catch(Exception ex)
	   {
	    throw new PendingException();
	   }
	}
}
