package commonLibs.implementation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IJavaScriptExecutor;

public class JavaScriptControl implements IJavaScriptExecutor{

	
	private  JavascriptExecutor jsEngine;
	
	
	public JavaScriptControl(WebDriver driver)
	{
	
		jsEngine=(JavascriptExecutor) driver;
		
	}
	@Override
	public void executeJavaScript(String scriptToExecute) throws Exception {
		
		
	jsEngine.executeScript(scriptToExecute);
	
		
	}

	@Override
	public void scrollDown(int x, int y) throws Exception {
							
			String Jscommand = String.format("window.scrollBy(%d,%d)",x,y);
			
			jsEngine.executeScript(Jscommand);
		
			
			
	}

	@Override
	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {
		// TODO Auto-generated method stub
		return jsEngine.executeScript(scriptToExecute).toString();
	}

}
