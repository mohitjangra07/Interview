package test.app.utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class GenerateTestReport {

	public static void generateCucumberReport() {
		File reportOutputDirectory = new File("target/build");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add(System.getProperty("user.dir") + "\\target\\cucumber.json");

		
		String projectName = "AppiumTest";
		Configuration configuration = new Configuration(reportOutputDirectory, projectName);

		configuration.addClassifications("Browser", JSONData.baseConfig().getBrowserName());
		configuration.addClassifications("Branch", JSONData.baseConfig().getAppTestUrl());
		configuration.addClassifications("Test Type", JSONData.baseConfig().getTestType());
		configuration.setSortingMethod(SortingMethod.NATURAL);
		configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
		configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);
		configuration.setTrendsStatsFile(new File("target/test-classes/demo-trends.json"));

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
	}

}
