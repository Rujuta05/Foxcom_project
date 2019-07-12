package tests;

import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonLibs.implementation.CommonDriver;
import commons.GetFox;
import commons.loginpage;
import commons.signUp;
import utils.ConfigFileReader;

public class basePageTest {

	CommonDriver cmndriver;
	WebDriver driver;
	loginpage login;
	GetFox getfox;
	signUp signup;
	ExtentHtmlReporter htmlReporter;
	static Properties configProperties;
	static ConfigFileReader configreader;
	static String currentWorkingDirectory;

	String testExecutionstartTime;

	ExtentHtmlReporter htmlreporter;
	ExtentReports extentreport;
	ExtentTest extentTest;

	static {
		currentWorkingDirectory = System.getProperty("user.dir");
		String filename = String.format("%s/config/config.properties", currentWorkingDirectory);
		try {
			configProperties = configreader.readProperties(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

	@BeforeClass(alwaysRun = true)
	public void invokeBrowser() throws Exception {
		
		String browserType = configProperties.getProperty("browserType");
		cmndriver = new CommonDriver(browserType);
		String url = configProperties.getProperty("baseurl");
		cmndriver.setPageLoadTimeout(80);
		cmndriver.navigateToFirstUrl(url);
		driver = cmndriver.getDriver();
		initializePages();
		initializetmlReport();

	}

	private void initializePages() {
		login = new loginpage(driver);
		getfox = new GetFox(driver);

	}

	private void initializetmlReport() {
		Date date = new Date();
		testExecutionstartTime = String.valueOf(date.getTime());
		String htmlReportFile = String.format("%s/reports/FoxTest_%s.html", currentWorkingDirectory,
				testExecutionstartTime);
		htmlreporter = new ExtentHtmlReporter(htmlReportFile);
		extentreport = new ExtentReports();
		extentreport.attachReporter(htmlreporter);
	}

	@AfterMethod
	public void afterAMethod(ITestResult result) throws Exception {
		String testcaseName = result.getName();
		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass("Test case passed : " + testcaseName);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.fail("Test case Failed : " + testcaseName);
		} else {
			extentTest.skip("Test case skipped : " + testcaseName);
		}
	}

	@AfterSuite
	public void flushcleanup() {
		extentreport.flush();
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() throws Exception {
		closingBrowsers();

	}

	private void closingBrowsers() throws Exception {
		cmndriver.closeAllBrowsers();

	}
}
