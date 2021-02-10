package runner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
features = "C:\\Users\\10655479\\git\\repository10\\RCRC.Mobility.BDDFramework\\src\\test\\resource\\feature\\web",
glue={"stepDefinitions.web"},
dryRun = false,
monochrome = true,
strict=true,
tags= {"@SmokeTests"},
plugin = {
		"pretty",
		"html:target/cucumber-reports/Webcucumber.html",
		"json:target/cucumber.json",
		"rerun:target/rerun.txt"
		}
       )

public class TestNGTestRunner extends AbstractTestNGCucumberTests{	 

	@Override	 
	    @DataProvider  
	    public Object[][] scenarios() {  
	       	       return super.scenarios();
	    } 
	 

}
