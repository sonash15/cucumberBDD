package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( //features = {".//features/login.feature",
					//		 ".//features/Registration.feature",
						//	".//features/LoginDDTExcel.feature"} ,
					features = {".//features/login.feature"},
				 glue ={"stepsDefinations","hooks"},
				// features= {"@target/rerun.txt"},
				 plugin = {
						 "pretty","html:reports/myreport.html",
						 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						 "rerun:target/rerun.txt",},
				 dryRun = false,
				 monochrome = true,
				 publish = true,
				 tags="@sanity or @regression")
public class TestRun {

}
