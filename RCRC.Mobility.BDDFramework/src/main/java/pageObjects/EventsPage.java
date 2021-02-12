package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Utility.CommonUtils;
import dataProvider.ConfigFileReader;

public  class EventsPage {
	private WebDriver driver=null;
	ConfigFileReader configFileReader;
    

public EventsPage(WebDriver driver){
	 PageFactory.initElements(driver, this);
	 configFileReader= new ConfigFileReader();
}

@FindBy(how = How.XPATH, using = "//*[@id=\"navbar_com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet\"]/ul/li[11]/a")
private WebElement lnk_Events;
@FindBy(how = How.LINK_TEXT, using = "Add Event")
private WebElement btn_addEvents;
@FindBy(how = How.XPATH, using = "//*[@id=\"table\"]/tbody/tr")
private WebElement table_EventTable;
@FindBy(how = How.XPATH, using = "//*[@id=\"table\"]/tbody/tr/td[7]")
private WebElement table_edit;
@FindBy(how = How.XPATH, using = "//*[@id=\"table\"]/tbody/tr/td[8]")
private WebElement table_delete;
@FindBy(how = How.XPATH, using = "//*[@id=\"_com_rcrc_event_Lang_RcrcEventsNewPortlet_INSTANCE_hAmQAWnz3ysd_eventname\"]")
private WebElement txt_eventName;
@FindBy(how = How.XPATH, using = "//*[@id=\"lat\"]")
private WebElement txt_eventCoordinate;
@FindBy(how = How.XPATH, using = "//*[@id=\"myBtn\"]")
private WebElement btn_location;
@FindBy(how = How.XPATH, using = "//*[@id=\"_com_rcrc_event_Lang_RcrcEventsNewPortlet_INSTANCE_hAmQAWnz3ysd_startDate\"]")
private WebElement txt_eventStartDate;
@FindBy(how = How.XPATH, using = "//*[@id=\"_com_rcrc_event_Lang_RcrcEventsNewPortlet_INSTANCE_hAmQAWnz3ysd_endDate\"]")
private WebElement txt_eventEndDate;
@FindBy(how = How.XPATH, using = "//*[@id=\"_com_rcrc_event_Lang_RcrcEventsNewPortlet_INSTANCE_hAmQAWnz3ysd_starttime\"]")
private WebElement txt_eventStartTime;
@FindBy(how = How.XPATH, using = "//*[@id=\"_com_rcrc_event_Lang_RcrcEventsNewPortlet_INSTANCE_hAmQAWnz3ysd_endtime1\"]")
private WebElement txt_eventEndTime;
@FindBy(how = How.XPATH, using = "//*[@id=\"_com_rcrc_event_Lang_RcrcEventsNewPortlet_INSTANCE_hAmQAWnz3ysd_ProgramStartTime\"]")
private WebElement txt_programStartTime;
@FindBy(how = How.XPATH, using = "//*[@id=\"_com_rcrc_event_Lang_RcrcEventsNewPortlet_INSTANCE_hAmQAWnz3ysd_ProgramEndTime\"]")
private WebElement txt_programEndTime;
@FindBy(how = How.XPATH, using = "//*[@id=\"_com_rcrc_event_Lang_RcrcEventsNewPortlet_INSTANCE_hAmQAWnz3ysd_eventurl\"]")
private WebElement txt_EventUrl;
@FindBy(how = How.XPATH, using = "//*[@id=\"_com_rcrc_event_Lang_RcrcEventsNewPortlet_INSTANCE_hAmQAWnz3ysd_options\"]")
private WebElement drp_SelectCurrency;
@FindBy(how = How.XPATH, using = "//*[@id=\"_com_rcrc_event_Lang_RcrcEventsNewPortlet_INSTANCE_hAmQAWnz3ysd_eventprice\"]")
private WebElement txt_EventPrice;
@FindBy(how = How.XPATH, using = "//*[@id=\"_com_rcrc_event_Lang_RcrcEventsNewPortlet_INSTANCE_hAmQAWnz3ysd_eventDesc\"]")
private WebElement txt_EventDesc;
@FindBy(how = How.XPATH, using = "//*[@type=\"file\"]")
private WebElement txt_EventImg;
@FindBy(how = How.XPATH, using = "//*[@id=\"_com_rcrc_event_Lang_RcrcEventsNewPortlet_INSTANCE_hAmQAWnz3ysd_saveButton\"]")
private WebElement btn_EventSave;

public boolean NavigateToEventPage(String title) {
	   boolean bol=false; 
		try
		{
		CommonUtils.Clicks(lnk_Events);
		
		if(title.equalsIgnoreCase("Events - Liferay DXP"))
		 {
		  System.out.println("User should able to navigate to  Events Page");
		 }					  
		  System.out.println("User should  not able to navigate to  Events Page");
		 
		   bol=true;
		}				
		catch(Exception ex) {
			System.out.println(ex.getCause());
			System.out.println(ex.getMessage());
			ex.getStackTrace();
		}	
		 
		return bol;	
		}


public boolean ValidateEventPage(String title) {
 boolean bol=false; 
	try
	{			
	if(title.equalsIgnoreCase("Events - Liferay DXP"))
	 {
	 System.out.println("User should able to navigate to  Event Page");
	 }			  
	  System.out.println("User should  not able to navigate to  Event Page");
     bol=true;
	}	
	catch(Exception ex) {
		System.out.println(ex.getCause());
		System.out.println(ex.getMessage());
		ex.getStackTrace();
	}	
	return bol;	
	}
 
 
 public boolean ClickOnAddNewEventTab() {
	boolean bol=false;
	try
	{	 
	 CommonUtils.Clicks(btn_addEvents);
	 {
	System.out.println("User should able to click on AddEvent");
	 }			
    System.out.println("User should not able to click on AddEvent");
	bol=true;
	}	
	catch(Exception ex) {
		System.out.println(ex.getCause());
		System.out.println(ex.getMessage());
		ex.getStackTrace();
	}	
	return bol;	
	}

 
 public boolean FillingNewEventDetails(String eventname,String eventcoordinate,String eventstartdate,String eventenddate,String eventstarttime,String eventeventtime,String programstarttime,
		 String programendtime,String eventurl,String selectcurrency,String eventprice,String eventdescription, String filelocation) {
  boolean bol=false;
	try
	{	 
	 CommonUtils.EnterText(txt_eventName, eventname);
	 //CommonUtils.EnterText(txt_eventCoordinate, eventcoordinate);
	 //CommonUtils.Clicks(btn_location);
	 CommonUtils.EnterText(txt_eventStartDate, eventstartdate);
	 CommonUtils.EnterText(txt_eventEndDate, eventenddate);
	 CommonUtils.EnterText(txt_eventStartTime, eventstarttime);
	 CommonUtils.EnterText(txt_eventEndTime, eventeventtime);
	 CommonUtils.EnterText(txt_programStartTime, programstarttime);
	 CommonUtils.EnterText(txt_programEndTime, programendtime);
	 CommonUtils.EnterText(txt_EventUrl, eventurl);
	// CommonUtils.EnterText(drp_SelectCurrency, selectcurrency);
	 CommonUtils.EnterText(txt_EventPrice, eventprice);
	 CommonUtils.EnterText(txt_EventDesc, eventdescription);
   //CommonUtils.EnterText(btn_addEvents, filelocation);
	 CommonUtils.Clicks(btn_EventSave);
	 {
	System.out.println("User should able to click on EventLinks");
	 }			
	 System.out.println("User should not able to click on EventLinks");
	   bol=true;
	}	
	catch(Exception ex) {
		System.out.println(ex.getCause());
		System.out.println(ex.getMessage());
		ex.getStackTrace();
	}	
	return bol;	
	}
 
 public boolean VerifyNewEventsCreated(String EventsName) {
	   boolean bol=false; 
		try
		{
		CommonUtils.DisplayDynamicTable(table_EventTable);		
//		if(title.equalsIgnoreCase("Events - Liferay DXP"))
//		  {
//		  System.out.println("User should able to navigate to  Events Page");
//		  }					  
//		  System.out.println("User should  not able to navigate to  Events Page");
	    bol=true;
		}				
		catch(Exception ex) {
			System.out.println(ex.getCause());
			System.out.println(ex.getMessage());
			ex.getStackTrace();
		}	
		 
		return bol;	
		}
 public boolean EditEventsDetails(String EventsName) {
	   boolean bol=false; 
		try
		{
	   CommonUtils.DisplayDynamicTable(table_EventTable);		
//		if(title.equalsIgnoreCase("Events - Liferay DXP"))
//		 {
//		  System.out.println("User should able to navigate to  Events Page");
//		 }					  
//		  System.out.println("User should  not able to navigate to  Events Page");
	    bol=true;
		}				
		catch(Exception ex) {
			System.out.println(ex.getCause());
			System.out.println(ex.getMessage());
			ex.getStackTrace();
		}	
		 
		return bol;	
		}
 
 public boolean ReadEventsDetails(String EventsName) {
	   boolean bol=false; 
		try
		{
	    CommonUtils.DisplayDynamicTable(table_EventTable);		
//		if(title.equalsIgnoreCase("Events - Liferay DXP"))
//		 {
//		  System.out.println("User should able to navigate to  Events Page");
//		 }					  
//		  System.out.println("User should  not able to navigate to  Events Page");
	    bol=true;
		}				
		catch(Exception ex) {
			System.out.println(ex.getCause());
			System.out.println(ex.getMessage());
			ex.getStackTrace();
		}	
		 
		return bol;	
		}

 public boolean DeleteEventsDetails(String EventsName) {
	   boolean bol=false; 
		try
		{
	  CommonUtils.DisplayDynamicTable(table_EventTable);		
    //if(title.equalsIgnoreCase("Events - Liferay DXP"))
    //{
    //System.out.println("User should able to navigate to  Events Page");
    //}					  
    //System.out.println("User should  not able to navigate to  Events Page");
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
