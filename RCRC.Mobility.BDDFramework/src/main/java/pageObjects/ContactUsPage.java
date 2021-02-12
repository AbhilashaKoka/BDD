package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import dataProvider.ConfigFileReader;

public class ContactUsPage {
	 private WebDriver driver;
	 ConfigFileReader configFileReader;
	
		public ContactUsPage(WebDriver driver) 
		{
			  PageFactory.initElements(driver, this);
			  configFileReader= new ConfigFileReader();
		}
		
@FindBy(how = How.XPATH, using = "//*[@id=\"navbar_com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet\"]/ul/li[8]")
private WebElement lnk_Contacts;

@FindBy(how = How.XPATH, using = "//*[@id=\"ddmFormqQRe9ROJ\"]/div/div[1]/div[2]/div/div/div[1]/div[1]/div/inputt")
private WebElement txt_name;
	 
//@FindBy(how = How.XPATH, using = "//*[@id=\"ddmFormuhxeJDBO\"]/div/div[1]/div[2]/div/div/div[1]/div[1]/div/input")
//private WebElement rad_position;

//@FindBy(how =How.XPATH, using ="")
//private WebElement drp_region;


//@FindBy(how =How.XPATH, using ="")
//private WebElement drp_country;


//@FindBy(how =How.XPATH, using ="")
//private WebElement txt_email;

//@FindBy(how =How.XPATH, using ="")
//private WebElement txt_address;
		 
}