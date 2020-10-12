package com.stackroute.finalcasestudy.cucumber;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.stackroute.finalcasestudy.utils.BrowserUtils;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = {
		"src\\test\\java\\com\\stackroute\\finalcasestudy\\cucumber\\PlaySampleQuizzes.feature" }, glue = {
				"com.stackroute.finalcasestudy.cucumber" }, plugin = { "pretty", "html: reports/reports.html" })
public class CucumberRunnerTest {
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUp(){
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//		BrowserUtils browserUtils = new BrowserUtils();
//		browserUtils.init();
	}

	@Test(groups = "cucumber scenarios", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void scenario(PickleWrapper pickleEvent, FeatureWrapper cucumberFeature) throws Throwable {
		testNGCucumberRunner.runScenario(pickleEvent.getPickle());
	}

	@DataProvider
	public Object[][] scenarios() {
		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown(){
//		BrowserUtils.close();
		testNGCucumberRunner.finish();
	}
}
