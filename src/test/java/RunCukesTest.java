
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(dryRun=false, plugin = {"html:target/cucumber-htmlreport.html","json:target/cucumber-report.json","com.pega.config.test.CustomFormatter"})
public class RunCukesTest extends AbstractTestNGCucumberTests{

	@SuppressWarnings("unused")
	String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	String VERSION = "$Id: RunCukesTest.java 121819 2018-01-26 07:29:51Z SachinVellanki $";

}
