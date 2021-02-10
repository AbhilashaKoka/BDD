package managers;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.google.common.collect.ImmutableMap;
import Utility.CommonUtils;
import enums.AndroidDriverType;
import enums.DriverType;
import enums.EnvironmentType;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;



public class WebDriverManager {
	private  WebDriver driver;
	private RemoteWebDriver remotedriver;
	private static DriverType driverType;
	private static AndroidDriverType mobiledriverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String INTERNETEXPLORER_DRIVER_PROPERTY= "webdriver.ie.driver";
	private static final String GECKO_DRIVER_PROPERTY="webdriver.gecko.driver";
	private static AndroidDriver<MobileElement> mobiledriver;
	private static RemoteWebDriver remoteWebDriver;
	private static AppiumDriverLocalService service=null;
	private String url;

	public WebDriverManager()
	{
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		mobiledriverType=FileReaderManager.getInstance().getConfigReader().getMobileBrowser();
	    environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver()  {
		try {
		if(driver == null) driver = createDriver();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return driver;
	}
	


	private WebDriver createDriver() {
	try {
		   switch (environmentType)
		   {	    
	        case LOCAL : driver = createLocalDriver();
	        	break;
	        case REMOTE : driver = createRemoteDriver();
	        	break;	        	
	        	        
		   }
	}
	catch(Exception ex)
	{
		ex.getStackTrace();
	}
		   return driver;
	}
	
   private RemoteWebDriver createRemoteDriver() 
    {
	   try {
             
		   switch (driverType)
		   {
		   case INTERNETEXPLORER:
		   String nodeURL1 = "http://10.0.0.7:4444/wd/hub";
		   System.setProperty(INTERNETEXPLORER_DRIVER_PROPERTY,FileReaderManager.getInstance().getConfigReader().getIEDriverPath());
		   DesiredCapabilities capability1 = DesiredCapabilities.internetExplorer();
		   capability1.setBrowserName("internet explorer");
		   capability1.setPlatform(Platform.WIN8_1);
		   driver = new RemoteWebDriver(new URL(nodeURL1), capability1);
		   break;		   
//		    String exePath = "C:\\Users\\abc\\Documents\\IEDriverServer\\IEDriverServer.exe";
//			InternetExplorerDriverService.Builder serviceBuilder = new InternetExplorerDriverService.Builder();
//			serviceBuilder.usingPort(1080); // This specifies that sever should start at this port
//			serviceBuilder.usingDriverExecutable(new File(exePath)); //Tell it where you server exe is
//			serviceBuilder.withHost("2.45.0.0");
//			InternetExplorerDriverService service = serviceBuilder.build(); //Create a driver service and pass it to Internet explorer driver instance
//			InternetExplorerDriver driver = new InternetExplorerDriver(service);
		   case FIREFOX:
		   String[] nodeURL2 = {"http://10.0.0.4:5566/wd/hub"} ;
		   System.setProperty(GECKO_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getGeckoDriverPath());
		   DesiredCapabilities capability = DesiredCapabilities.firefox();
		   capability.setBrowserName("firefox");
		   capability.setPlatform(Platform.WIN8_1);
		   //driver.get("http://www.google.com");
		   break;
		   case CHROME:
		   String nodeURL3 = "http://169.254.111.81:1339";
		   System.setProperty(CHROME_DRIVER_PROPERTY,FileReaderManager.getInstance().getConfigReader().getChromeDriverPath());
		   DesiredCapabilities capability2 = DesiredCapabilities.chrome();
		   capability2.setBrowserName("chrome");
		   capability2.setPlatform(Platform.WIN8_1);
		   driver = new RemoteWebDriver(new URL(nodeURL3), capability2);
		   //driver.get("http://www.google.com");
		   break;
		   }
	   }
			
	  catch(Exception ex)
			{
			ex.getStackTrace();
			}
	   
	   return remotedriver;
		   
    }
        
	

   
    
	private WebDriver createLocalDriver() {
        switch (driverType) {	    
        case FIREFOX :
        	System.setProperty(GECKO_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getGeckoDriverPath());
        	driver = new FirefoxDriver();
	    	break;
        case CHROME : 
        	System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getChromeDriverPath());
        	driver = new ChromeDriver();
    		break;
        case INTERNETEXPLORER : 
    		System.setProperty(INTERNETEXPLORER_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getIEDriverPath());
           	driver = new InternetExplorerDriver();
    		break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}
	
	public String getTitle( ) {
		 String title=driver.getTitle();
		return title;
	}

	public void closeDriver() {
	driver.quit();
	}
	
	
	public AndroidDriver<MobileElement> getMobileDriver()  {
		try {
		if(mobiledriver == null) mobiledriver = createAndroidDriver();
		 }
		catch(Exception ex) {
			ex.printStackTrace();
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
						
					}		   
			   
			   //  return mobiledriver;
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
					
				}		   
		   
		    
			 break;
		   }
			
		 return mobiledriver;  
        
    }


	private DesiredCapabilities setCapabilityForRemote()
	 {
	        switch (driverType)
	        {
	            case FIREFOX:
	               System.out.println("Opening firefox driver in Node");
	                return DesiredCapabilities.firefox();
	            case CHROME:	            	
	            	System.out.println("Opening chrome driver in Node");
	                return DesiredCapabilities.chrome();
	            case INTERNETEXPLORER:
	            	System.out.println("Opening IE driver in Node");
	                return DesiredCapabilities.internetExplorer();
	            default:
	                throw new InvalidArgumentException("browser : " + driverType + " is invalid.");
	         }
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
				cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/storage/emulated/0/Download/3cfa86c6bd70556218bafbbce1c522d509c53f7fcea5160fd1e457116ce5d359 (5).apk");
		        cap.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
		        cap.setCapability(MobileCapabilityType.FORCE_MJSONWP, true);
		        cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		        cap.setCapability(AndroidMobileCapabilityType.SUPPORTS_ALERTS,true);
		        cap.setCapability("nativeWebScreenshot", true);
		        cap.setCapability("chromedriverUseSystemExecutable", true);
		        cap.setCapability("autoGrantPermissions", true);   
		      	cap.setCapability("appPackage","com.rcrc.riyadhjourneyplanner1.0");
				cap.setCapability("appActivity","com.rcrc.riyadhjourneyplanner.modules.authentication.activity.authenticationactivity.view.AuthenticationActivity");
				cap.setCapability("appActivity","com.rcrc.riyadhjourneyplanner.modules.onboarding.activity.onboardingactivity.view.OnBoardingActivity");
			    cap.setCapability("appActivity","com.rcrc.riyadhjourneyplanner.modules.SplashScreenActivity");
		        return cap;
		        	}
		        	catch(Exception ex) 
		        	{
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
			ex.getStackTrace();
		}
        
    }

}