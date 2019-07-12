package tests;

import org.testng.annotations.Test;

public class getFoxTest extends basePageTest{

	
	@Test(dependsOnMethods = {"verifyLogin"})
	public void verifygetData() throws Exception
	{
		cmndriver.setPageLoadTimeout(40);
		cmndriver.setElementDetectionTimeout(60);
		getfox.getData();
		
	}
}
