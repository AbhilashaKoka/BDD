package managers;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import pageObjects.PrivacyErrorPage;
import pageObjects.SignInPage;

public class MobilePageObjectManager {
	private AndroidDriver<MobileElement> mobileDriver;
//	private LogInPage loginPage;
//	private PrivacyErrorPage privacyErrorPage;

	public MobilePageObjectManager(AndroidDriver<MobileElement> mobileDriver) {
		// TODO Auto-generated constructor stub
		this.mobileDriver=mobileDriver;
	}
//	public SignInPage getSignInPage() {
//		return(signInPage==null)?signInPage=new SignInPage(driver):signInPage;
//		
//	}

}
