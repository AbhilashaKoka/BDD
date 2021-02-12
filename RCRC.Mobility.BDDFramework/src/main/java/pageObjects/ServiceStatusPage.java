package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import dataProvider.ConfigFileReader;

public class ServiceStatusPage {
	 private WebDriver driver;
	 ConfigFileReader configFileReader;
	
	public ServiceStatusPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
		 configFileReader= new ConfigFileReader();
	}
	
}