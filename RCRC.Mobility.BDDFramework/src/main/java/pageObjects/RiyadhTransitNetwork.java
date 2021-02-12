package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import dataProvider.ConfigFileReader;

public class RiyadhTransitNetwork {
	WebDriver driver;
	ConfigFileReader configFileReader;
	
		public RiyadhTransitNetwork(WebDriver driver) 
		{
			 PageFactory.initElements(driver, this);
			 configFileReader= new ConfigFileReader();
		}
		 @FindBy(how = How.XPATH, using = "//*[@id=\"btnLogin\"]") 
		 private WebElement bt_login;
		 
		 
}