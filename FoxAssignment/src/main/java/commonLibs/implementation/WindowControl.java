package commonLibs.implementation;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IWindow;

public class WindowControl implements IWindow{
	private WebDriver driver;
	
	public WindowControl(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@Override
	public void switchToAnyWindow(String windowhandle) throws Exception {
		// TODO Auto-generated method stub
		
		driver.switchTo().window(windowhandle);
		
		
	}

	@Override
	public void switchToAnyWindow(int childWindowIndex) throws Exception {
		// TODO Auto-generated method stub
		
		String childwindowhandle=driver.getWindowHandles().toArray()[childWindowIndex].toString();
		
		driver.switchTo().window(childwindowhandle);
		
	}

	@Override
	public String getWindowHandle() throws Exception {
		// TODO Auto-generated method stub
		 return driver.getWindowHandle();
		
	}

	@Override
	public Set<String> getWindowHandles() throws Exception {
		
		return driver.getWindowHandles();
	}

}
