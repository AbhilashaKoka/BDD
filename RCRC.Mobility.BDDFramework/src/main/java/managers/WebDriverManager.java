package managers;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {
	
	private  WebDriver driver;
	private RemoteWebDriver remotedriver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private String url;
	
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String INTERNETEXPLORER_DRIVER_PROPERTY= "webdriver.ie.driver";
	private static final String GECKO_DRIVER_PROPERTY="webdriver.gecko.driver";
	
	
	private static RemoteWebDriver remoteWebDriver;
	
	static Logger LOGGER=LogManager.getLogger(WebDriverManager.class);
	String logPath=System.getProperty("user.dir")+"\\Configs\\log4j.properties";
	    
	public WebDriverManager()
	{
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
	    environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver()  {
		try 
		{
		if(driver == null) driver = createDriver();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			LOGGER.error(ex.getMessage());
		}
		return driver;
	}
	

	private WebDriver createDriver() 
	{
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
		LOGGER.error(ex.getMessage());
	}
      return driver;
	}
	
	
	private WebDriver createLocalDriver() {
        switch (driverType)
        {	    
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
        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()==false)        	
        	driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
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
		   break;
		   case CHROME:
		   String nodeURL3 = "http://169.254.111.81:1339";
		   System.setProperty(CHROME_DRIVER_PROPERTY,FileReaderManager.getInstance().getConfigReader().getChromeDriverPath());
		   DesiredCapabilities capability2 = DesiredCapabilities.chrome();
		   capability2.setBrowserName("chrome");
		   capability2.setPlatform(Platform.WIN8_1);
		   driver = new RemoteWebDriver(new URL(nodeURL3), capability2);
		   break;
		   }
	   }
			
	  catch(Exception ex)
			{
			ex.getStackTrace();
			LOGGER.error(ex.getMessage());
			}
	   
	   return remotedriver;
		   
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
        

	public String getTitle( ) 
	{
		 String title=driver.getTitle();
		return title;
	}

	public void closeDriver() 
	{
	driver.quit();
	}
	
	

}