package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import dataProvider.ConfigFileReader;

public class NewsPage {
	private WebDriver driver;
	ConfigFileReader configFileReader;
	
	public NewsPage(WebDriver driver) 
	{
		 PageFactory.initElements(driver, this);
		 configFileReader= new ConfigFileReader();
	}

}
