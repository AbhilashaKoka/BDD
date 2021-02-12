package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utility.CommonUtils;

import dataProvider.ConfigFileReader;


public class RegisterPage {
	WebDriver driver;
	ConfigFileReader configFileReader;
    String filepath="C:\\Users\\10655479\\eclipse-workspace\\CucumberFramework (22)\\CucumberFramework (21)\\CucumberFramework\\src\\test\\resource\\testDataResources\\download.jpg";
	
		public RegisterPage(WebDriver driver) 
		{
			 PageFactory.initElements(driver, this);
			 configFileReader= new ConfigFileReader();
			 
		}
		
		 @FindBy(how = How.XPATH, using = "//*[@id=\"navbar_com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet\"]/ul/li[10]/a") 
		 private WebElement lnk_Register;
		 
		 @FindBy(how = How.XPATH, using = "//*[@id=\"_com_register_RegisterPortlet_INSTANCE_lYJeFlZNysHo_name\"]") 
		 private WebElement txt_Name;
		 
		 @FindBy(how = How.XPATH, using =  "//*[@id=\"_com_register_RegisterPortlet_INSTANCE_lYJeFlZNysHo_surName\"]")
		 private WebElement txt_Surname;
		 
		 @FindBy(how = How.XPATH, using =  "//*[@id=\"_com_register_RegisterPortlet_INSTANCE_lYJeFlZNysHo_documentType\"]")
		 private WebElement drp_DocumentType;
		 
		 @FindBy(how = How.XPATH, using = "//*[@id=\"_com_register_RegisterPortlet_INSTANCE_lYJeFlZNysHo_documentId\"]") 
		 private WebElement txt_PersonalID;
		 
		 @FindBy(how = How.XPATH, using = "//*[@id=\"_com_register_RegisterPortlet_INSTANCE_lYJeFlZNysHo_birthDate\"]")
		 private WebElement txt_Date;
		 
		 @FindBy(how = How.XPATH, using = "//*[@id=\"_com_register_RegisterPortlet_INSTANCE_lYJeFlZNysHo_phoneNumber\"]") 
		 private WebElement txt_PhoneNo; 
		 
		 @FindBy(how = How.XPATH, using = "//*[@id=\"_com_register_RegisterPortlet_INSTANCE_lYJeFlZNysHo_email\"]") 
		 private WebElement txt_Email;
		 
		 @FindBy(how = How.XPATH, using = "//*[@id=\"_com_register_RegisterPortlet_INSTANCE_lYJeFlZNysHo_gender_1\"]") 
		 private WebElement chk_Male;
		 
		 @FindBy(how = How.XPATH, using = "//*[@id=\"_com_register_RegisterPortlet_INSTANCE_lYJeFlZNysHo_gender_3\"]") 
		 private WebElement chk_Female;
		 
		 @FindBy(how = How.XPATH, using = "//*[@id=\"_com_register_RegisterPortlet_INSTANCE_lYJeFlZNysHo_eligibleConcession_1\"]")
		 private WebElement chk_eligibleconssessionYes;
		 
		 @FindBy(how = How.XPATH, using ="//*[@id=\"_com_register_RegisterPortlet_INSTANCE_lYJeFlZNysHo_eligibleConcession_3\"]") 
		 private WebElement chk_eligibleconssessionNo;
		 
		 @FindBy(how = How.XPATH, using ="//*[@id=\"_com_register_RegisterPortlet_INSTANCE_lYJeFlZNysHo_reseller_1\"]")
		 private WebElement chk_resellerYes;
		 
		 @FindBy(how = How.XPATH, using ="//*[@id=\"_com_register_RegisterPortlet_INSTANCE_lYJeFlZNysHo_reseller_3\"]")
		 private WebElement chk_resellerNo;
		 
		 @FindBy(how = How.XPATH, using ="//*[@id=\"_com_register_RegisterPortlet_INSTANCE_lYJeFlZNysHo_locale\"]")
		 private WebElement drp_Locale;
		 
		 @FindBy(how = How.XPATH, using ="//input[@type=\"file\"]") 
		 private WebElement btn_UploadFile;
		 
		 @FindBy(how = How.XPATH, using ="")
		 private WebElement btn_Preview;
		 
		 @FindBy(how = How.XPATH, using ="//*[@id=\"_com_register_RegisterPortlet_INSTANCE_lYJeFlZNysHo_fm\"]/div/div/div[3]/button")
		 private WebElement btn_Submit;
		 
//		     public void select_DocumentType(int productNumber) {
//			 prd_List.get(productNumber).click();
//			 }
		 
		 
		       public boolean NavigateToRegisterPage(String title) {
			   boolean bol=false; 
				try
				{
				CommonUtils.Clicks(lnk_Register);
				
				if(title.equalsIgnoreCase("Register - Liferay DXP"))
				 {
				  System.out.println("User should able to navigate to  Register Page");
				 }					  
				  System.out.println("User should  not able to navigate to  Register Page");
				 
				   bol=true;
				}				
				catch(Exception ex) {
					System.out.println(ex.getCause());
					System.out.println(ex.getMessage());
					ex.getStackTrace();
				}	
				 
				return bol;	
				}
		 
		       public boolean EnterRegisterDetails( String name, String surname,  String DocumentType, String DocumentID,  String DOB, String phonenumber,   String Email, String gender,
		    		    String eligibility, String reseller,  String Locale, String upload)
		       {
				   boolean bol=false; 
					try
					{
					Thread.sleep(1000);
					CommonUtils.EnterText(txt_Name, name);
					Thread.sleep(1000);
					CommonUtils.EnterText(txt_Surname, surname);
					Thread.sleep(1000);
					CommonUtils.selectValueFromDropdown(drp_DocumentType, DocumentType);
					Thread.sleep(1000);
					CommonUtils.EnterText(txt_PersonalID, DocumentID);
					Thread.sleep(1000);
					CommonUtils.EnterText(txt_Date, DOB);
					Thread.sleep(1000);
					CommonUtils.EnterText(txt_PhoneNo, phonenumber);
					Thread.sleep(1000);
					CommonUtils.EnterText(txt_Email, Email);
					Thread.sleep(1000);
					if(gender=="Male")
					{
					CommonUtils.SelectCheckBox2(chk_Male);
					}
					else
					CommonUtils.SelectCheckBox2(chk_Female);
					Thread.sleep(1000);
					if(eligibility=="Yes")
					{
					CommonUtils.SelectCheckBox2(chk_eligibleconssessionYes);
					Thread.sleep(1000);
					}
					else
					CommonUtils.SelectCheckBox2(chk_eligibleconssessionNo);
					Thread.sleep(1000);
					if(reseller=="Yes")
					{
					CommonUtils.SelectCheckBox2(chk_resellerYes);
					}
					else
					Thread.sleep(1000);
					CommonUtils.SelectCheckBox2(chk_resellerNo);
					Thread.sleep(1000);
					CommonUtils.selectValueFromDropdown(drp_Locale, Locale);
					Thread.sleep(1000);	
					CommonUtils.EnterText(btn_UploadFile, filepath);
					Thread.sleep(1000);
					CommonUtils.Clicks(btn_Submit);
					   bol=true;
					}				
					catch(Exception ex) {
						System.out.println(ex.getCause());
						System.out.println(ex.getMessage());
						ex.getStackTrace();
					}	
					 
					return bol;	
					}
		       
			 
			    
		 
}