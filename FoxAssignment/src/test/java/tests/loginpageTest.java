package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.loginpage;

public class loginpageTest extends basePageTest {

	@Test
	public void verifyLogin() throws Exception {
		extentTest = extentreport.createTest("TC - 001 - Verify Login Functionality");
		cmndriver.setPageLoadTimeout(60);
		cmndriver.setElementDetectionTimeout(50);
		String username = configProperties.getProperty("username");
		String password = configProperties.getProperty("password");
		login.getLogin(username, password);
		System.out.println("log in is done..!");
		extentTest.log(Status.INFO, "Verified Login Functionality successfully");

	}

	@Test(dependsOnMethods = {"verifyLogin"})
	public void verifygetData() throws Exception {
		extentTest = extentreport.createTest("TC - 002 - Getting Data from fox.com and writing into Excel Data Functionality");
		cmndriver.setPageLoadTimeout(40);
		cmndriver.setElementDetectionTimeout(60);
		login.getData();
		extentTest.log(Status.INFO, "Verified GetData Functionality successfully");
	}
}
