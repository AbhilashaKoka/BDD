import java.io.IOException;



//public class E2E_Test {
//	private static WebDriver driver;
//	public static void main(String[] args) throws InterruptedException, IOException {
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\10655479\\git\\repository\\CucumberFramework\\driver\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("https://opensource-demo.orangehrmlive.com/");
//		WebElement username= driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
//		WebElement password=driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
//		WebElement login=driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
//		username.sendKeys("Admin");
//		password.sendKeys("admin123");
//		login.click();
//		Command.execCommand("test");
//		driver.close();	
//	}
	
	
//	import java.io.*;
//	import okhttp3.*;
//	public class E2E_Test {
//	  public static void main(String []args) throws IOException{
//	    OkHttpClient client = new OkHttpClient().newBuilder()
//	      .build();
//	    MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
//	    RequestBody body = RequestBody.create(mediaType, "grant_type=password&username=apisubscriber&password=apisubscriber");
//	    Request request = new Request.Builder()
//	      .url("http://192.168.59.12:8280/token")
//	      .method("POST", body)
//	      .addHeader("Authorization", "Basic Vzd1ZmZCUFh6NjRfRFEwZmhfTmh5VlM1TzZBYToweThtYWU0Y3ZHbkp4OUI0Zm5Eb3RmUzV4WThh")
//	      .addHeader("Content-Type", "application/x-www-form-urlencoded")
//	      .build();
//	    Response response = client.newCall(request).execute();
//	    System.out.println(response.body().string());
//	  }
//	}

import java.io.*;
import okhttp3.*;
public class E2E_Test {
  public static void main(String []args) throws IOException{
    OkHttpClient client = new OkHttpClient().newBuilder()
      .build();
    Request request = new Request.Builder()
      .url("https://192.168.59.12:8243/trip/1.0.0/XML_TRIP_REQUEST2?ext_macro=trip&outputFormat=rapidJSON&coordOutputFormat=WGS84%5BDD.DDDDD%5D&locationServerActive=1&useRealtime=1&useUT=1&type_origin=any&name_origin=80000221&type_destination=any&name_destination=80000214&routeType=leasttime&itdDate=20210114&calcNumberOfTrips=4&itdTime=1115&itdTripDateTimeDepArr=arr&calcOneDirection=1&excludedMeans=5&includedMeans=5&trITMOT=100&trITMOTvalue=10&ptOptionsActive=1&itOptionsActive=1&cyclingActive=1&speedFactorBicycle=100&changeSpeed=slow&showItdInterchangePathCoordinates=1&showItdPathCoordinates=1")
      .method("GET", null)
      .addHeader("Authorization", 
    		  "Bearer eyJ4NXQiOiJObVkzWWpVMk1EVTNNVFJtWVRZek5tUmxOVGRqTmpFNE1tUmxOelkzTnpBd056UXlOVE0wTkRreVpXUmhaV0ppTUdWbVpUYzRZekUxT1RFNFptVTFZUSIsImtpZCI6Ik5tWTNZalUyTURVM01UUm1ZVFl6Tm1SbE5UZGpOakU0TW1SbE56WTNOekF3TnpReU5UTTBORGt5WldSaFpXSmlNR1ZtWlRjNFl6RTFPVEU0Wm1VMVlRX1JTMjU2IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJhcGlzdWJzY3JpYmVyIiwiYXV0IjoiQVBQTElDQVRJT05fVVNFUiIsImF1ZCI6WyJXN3VmZkJQWHo2NF9EUTBmaF9OaHlWUzVPNkFhIiwiaHR0cDpcL1wvb3JnLndzbzIuYXBpbWd0XC9nYXRld2F5Il0sIm5iZiI6MTYxMDUyMjYzMywiYXpwIjoiVzd1ZmZCUFh6NjRfRFEwZmhfTmh5VlM1TzZBYSIsInNjb3BlIjoiZGVmYXVsdCIsImlzcyI6Imh0dHBzOlwvXC9sb2NhbGhvc3Q6OTQ0M1wvb2F1dGgyXC90b2tlbiIsImV4cCI6MTYxMDg4MjYzMywiaWF0IjoxNjEwNTIyNjMzLCJqdGkiOiI1NWNkYmUzYS0xYzUzLTQ2YjktYWZhNi00MjZkYTVmODMzZmYifQ.eWzyfcozYZ9uK55L39t-coQIoUTpphfMRwmLlk_WGkhs1_ZgETHRbt6XvIiF2zHjq1eoVM6cDPrXyTiON0Q_RZbvEUNRFGLglIv3CzvSU8SDGN9JwU_4wyKmpAOqra_2NNfv7OcZFHWbGBwIxpl6pzoFGWbhJ34C6lUjmVhZLXg-ev3HaW8BiErq7pIQpIjR8SM8zTh_-3iFNAaEUBpwuOoSGxtAvaUeMlhP7o_rQXz3pxMN-ZQDR49XDr5aOzo_1VSdnm6K7lJX_SbTop2n44y3RhRQ-K2rgv5mnFvF_Z709EHnLe_4CmcPJvQmKEcTC8DWue1TQy1vdcFILAbOQw")
      .build();
    Response response = client.newCall(request).execute();
    System.out.println(response.body().string());
  }
}

	
	
	

	//}

