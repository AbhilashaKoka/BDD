package managers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.google.common.collect.ImmutableMap;
import Utility.CommonUtils;
import enums.AndroidDriverType;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class MobileDriverManager {
	private static AndroidDriver<MobileElement> mobiledriver;
	private static AndroidDriverType mobiledriverType;
	private static AppiumDriverLocalService service=null;
	private String url;
	static Logger LOGGER=LogManager.getLogger(MobileDriverManager.class);
	String logPath=System.getProperty("user.dir")+"\\Configs\\log4j.properties";
		
	public  MobileDriverManager()
	{
	mobiledriverType=FileReaderManager.getInstance().getConfigReader().getMobileBrowser();
	}
	
	public AndroidDriver<MobileElement> getMobileDriver()
	{
		try {
		if(mobiledriver == null) mobiledriver = createAndroidDriver();
		 }
		catch(Exception ex) {
			ex.printStackTrace();
			LOGGER.error(ex.getMessage());
		}
		return mobiledriver;
	}
	
	
	private AndroidDriver<MobileElement> createAndroidDriver() 
	{
	 switch (mobiledriverType)
		   {		 
		 case BROWSERAPP:
		          DesiredCapabilities capabilities=setCapabilitiesForAndroid();	
		          try {
						if(service.isRunning()==true)
					    {
					    CommonUtils.execKill(1L);
					    service.start();
					   }
					   mobiledriver = new AndroidDriver<>(service, capabilities);
			         	}
					catch(Exception ex)
					{
						ex.getStackTrace();
						LOGGER.error(ex.getMessage());
					 }		   
		      break;
		 case NATIVE:
			 DesiredCapabilities capabilities2=setCapabilitiesForAndroidNativeapp();
			 try {
					if(service.isRunning()==true)
				    {
				    CommonUtils.execKill(1L);
				    service.start();
				   }					
				   mobiledriver = new AndroidDriver<>(service, capabilities2);
				   
		         	}
				catch(Exception ex)
				{
					ex.getStackTrace();
					LOGGER.error(ex.getMessage());
					
				}		   
		   
		    
			 break;
		   }
			
		 return mobiledriver;  
        
    }	
	
	 private DesiredCapabilities setCapabilitiesForAndroidNativeapp() {
		 try {
		    	service=AppiumDriverLocalService.buildDefaultService();
				DesiredCapabilities cap=new DesiredCapabilities();
				cap.setCapability("platformName", "Android");      
		        cap.setCapability("platformVersion", "10");		
				cap.setCapability("deviceName","Moto g(7)");			
				cap.setCapability("udid", "ZF6224BG9B");
				cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
				cap.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
		        cap.setCapability(MobileCapabilityType.FORCE_MJSONWP, true);
		       // cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		        cap.setCapability(AndroidMobileCapabilityType.SUPPORTS_ALERTS,true);
		        cap.setCapability("nativeWebScreenshot", true);
		        cap.setCapability("chromedriverUseSystemExecutable", true);
		        cap.setCapability("autoGrantPermissions", true);   
		        cap.setCapability("appPackage","com.rcrc.riyadhjourneyplanner");
				cap.setCapability("appActivity","com.rcrc.riyadhjourneyplanner.modules.authentication.activity.authenticationactivity.view.AuthenticationActivity");
		       // cap.setCapability ("appPackage","com.google.android.calculator");
		       // cap.setCapability("appActivity","com.android.calculator2.Calculator");
				//cap.setCapability(MobileCapabilityType.APP, "/storage/emulated/0/Download/app-tester.apk");
		        return cap;
		        	}
		        	catch(Exception ex) 
		        	{
		        		LOGGER.error(ex.getMessage());
		        		throw new IllegalArgumentException("Browser isn't supported.");
		        	}
	}

	
        private DesiredCapabilities setCapabilitiesForAndroid() 
        {
        try {
    	service=AppiumDriverLocalService.buildDefaultService();
		DesiredCapabilities cap=new DesiredCapabilities();
		//cap.setCapability("platformVersion", "5.0");
    	//cap.setCapability("deviceName", "ASUS_Z00AD");
    	//cap.setCapability("udid", "F8AZFG017568");
    	cap.setCapability("platformName", "Android");      
        cap.setCapability("platformVersion", "10");		
		cap.setCapability("deviceName","Moto g(7)");			
		cap.setCapability("udid", "ZF6224BG9B");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);	
		cap.setCapability("browserName", "CHROME");	
		cap.setCapability("appium:ChromeOptions", ImmutableMap.of("w3c",false));
		ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.setExperimentalOption("w3c", false);
	    cap.merge(chromeOptions);		
      return cap;
        	}
        	catch(Exception ex) 
        	{
        		LOGGER.error(ex.getMessage());
        		throw new IllegalArgumentException("Browser isn't supported.");
        	}
     
    }
    
    public void closeAndroidDriver() 
	{
		
		try {
			if(service.isRunning()==true)
		    {
		     CommonUtils.execKill(1L);
		     service.stop();
		    }
         	}
		catch(Exception ex)
		{
			LOGGER.error(ex.getMessage());
			ex.getStackTrace();
		}
	}

}
