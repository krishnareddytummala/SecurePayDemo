package com.ausPost.stepdefs;

import com.ausPost.common.ExtentReportListener;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.lang.StringUtils;

import java.net.MalformedURLException;

public class Hooks extends ExtentReportListener{
	public static String featureName;
	

	@Before
	public void before(Scenario scenario) throws MalformedURLException {
		String featureName= getFeatureFileNameFromScenarioId(scenario);
		startReport();  
		setDriver();
	}

	private String getFeatureFileNameFromScenarioId(Scenario scenario) {
		featureName = "Feature ";
		String rawFeatureName = scenario.getId().split(";")[0].replace("-"," ");
		featureName = StringUtils.substringAfterLast(rawFeatureName, "/").split(".feature")[0];
		return featureName;
	}

	@After
	public void after(Scenario scenario){
//		closeDriver(scenario);
		extent.flush();
	}


}
