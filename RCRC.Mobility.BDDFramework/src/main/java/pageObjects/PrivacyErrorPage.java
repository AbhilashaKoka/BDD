package pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utility.CommonUtils;
import dataProvider.ConfigFileReader;

  public class PrivacyErrorPage {
	 
	 ConfigFileReader configFileReader;
	 
	 public PrivacyErrorPage(WebDriver driver) { 
	 PageFactory.initElements(driver, this);
		 configFileReader= new ConfigFileReader();
		 
		 
	}
	 
	 @FindBy(how = How.XPATH, using = "//*[@id=\"body\"]/div/div[2]//button[3]") 
 	 private WebElement btn_Advanced;
 	 
 	 @FindBy(how = How.XPATH, using = "//*[@id=\"details\"]/p[2]/a") 
 	 private WebElement lnk_continue;
 	 
 public boolean handlingPrivacyErrorPage(String title) {
	
	 boolean bool=false;
	try
	{
		
	if(title.equalsIgnoreCase("Privacy error"))
	 {
		//btn_Advanced.click();
		CommonUtils.Clicks(btn_Advanced);
		//lnk_continue.click();
		CommonUtils.Clicks(lnk_continue);
		bool=true;
	 }			
	  else
	  {
		System.out.println("No Privacy Error");
	   }
	}	
	catch(Exception ex) {
		System.out.println(ex.getCause());
		System.out.println(ex.getMessage());
		ex.getStackTrace();
	}	
	return bool;	
	}
}
