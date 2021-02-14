package mobilePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SignIn_MobilePage {
	private AndroidDriver<MobileElement> mobiledriver;
	
	
	public SignIn_MobilePage(AndroidDriver<MobileElement> mobiledriver) {
		super();
		// TODO Auto-generated constructor stub
		 PageFactory.initElements(mobiledriver, this);
	}

	
	@FindBy(how = How.XPATH, using = "//*[@id=\"wrapper\"]/header/div/div[1]/div[4]/a[1]")
	 private MobileElement lnk_SignIn;
	
}
