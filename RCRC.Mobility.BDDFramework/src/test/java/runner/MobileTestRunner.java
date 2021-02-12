package runner;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features = "C:\\Users\\10655479\\git\\repository10\\RCRC.Mobility.BDDFramework\\src\\test\\resource\\feature\\mobile",
glue={"stepDefinitions.mobilesteps"}, 
dryRun = false,
monochrome = true,
strict=true,
tags= {"@SmokeTests"},
plugin = {
		"pretty",
		"html:target/cucumber-reports/Mobilecucumber.html",
		"json:target/Mobilecucumber.json",
		"rerun:target/rerun.txt"
		}

)
public class MobileTestRunner extends AbstractTestNGCucumberTests{
 @Override
	  @DataProvider
//	 // @DataProvider(parallel = true)
	  public Object[][] scenarios() {
	    return super.scenarios();
	  }	
}
