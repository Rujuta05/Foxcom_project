package commonLibs.implementation;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import commonLibs.contracts.IDriver;

public class CommonDriver implements IDriver {
	
	private WebDriver driver;	
	private int pageLoadTimeout;	
	private int elementDetectionTimeout;
	
	public CommonDriver(String browserType) throws Exception
	{
		
		pageLoadTimeout =20;
		
		elementDetectionTimeout=10;
		
		
		browserType=browserType.trim();
		//trim is to remove extra white spaces user can make mistake while copy pasting.
		if(browserType.equals("chrome"))
		{		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rujut\\eclipse-workspace\\libs\\chromedriver_win32_chrome74\\chromedriver.exe");
		driver=new ChromeDriver();		
		driver.manage().window().maximize();			
		driver.manage().deleteAllCookies();		
		//driver.get("http:\\demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		}
		else if(browserType.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\rujut\\eclipse-workspace\\libs\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			
			driver=new FirefoxDriver();
			
		}else if(browserType.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\rujut\\eclipse-workspace\\libs\\MicrosoftWebDriver.exe");
	 		
			driver=new EdgeDriver();
		}
		else if(browserType.equalsIgnoreCase("remote-chrome"))
		{
				ChromeOptions options=new ChromeOptions();
				
				URL hubUrl=new URL("http://192.168.103.200:12212/wd/hub");
				
				driver=new RemoteWebDriver(hubUrl,options);
				
			}else
			{
				throw new Exception("Invalid browser type"+browserType);
			}
				
		
		
	}

	
	public WebDriver getDriver() {
		return driver;
	}

	
	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	
	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	@override
	public void navigateToFirstUrl(String url) throws Exception {
		
		url=url.trim();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		
		driver.get(url);
	}

	@override
	public String getTitle() throws Exception {
			
		return driver.getTitle();
	
	}

	@override
	public String getCurrentUrl() throws Exception {
				
		return driver.getCurrentUrl();
		
	}

	@override
	public String getPageSource() throws Exception {
		
		return driver.getPageSource();
		
		}
	@override
	public void navigateToUrl(String url) throws Exception {
		
		url=url.trim();
		driver.navigate().to(url);
		
	}
	@override
	public void navigateForward() throws Exception {

		
		driver.navigate().forward();
		
		
	}

	@override
	public void navigateBackward() throws Exception {
		// TODO Auto-generated method stub
		
		driver.navigate().back();
		
	}

	@override
	public void refresh() throws Exception {
		// TODO Auto-generated method stub
		driver.navigate().refresh();
	}

	@override
	public void closeBrowser() throws Exception {
		
		if(driver!=null)
		{
		driver.close();
		}
	}

	
	public void closeAllBrowsers() throws Exception {
		
		if(driver!=null)
		{
		driver.quit();
		}
		}
	
	

}
