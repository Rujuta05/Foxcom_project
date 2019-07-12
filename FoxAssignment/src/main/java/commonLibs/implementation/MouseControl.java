package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import commonLibs.contracts.IActions;

public class MouseControl implements IActions{

	
private WebDriver driver;
	
	public MouseControl(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private Actions getaction(WebDriver  driver)
	{
		Actions action= new Actions(driver);
		return action;
				
		
	}
	@Override
	public void dragAndDrop(WebElement element1, WebElement element2) throws Exception {
		
		getaction(driver).dragAndDrop(element1, element2).build().perform();
		

	}

	@Override
	public void moveToElement(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		getaction(driver).moveToElement(element).build().perform();
	}
	

	@Override
	public void rightClick(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		
		getaction(driver).contextClick(element).build().perform();
		
	}

	@Override
	public void doubleClick(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		
		getaction(driver).doubleClick(element).build().perform();
		
		
	}

	@Override
	public void moveToElementAndClick(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		
		getaction(driver).moveToElement(element).click().build().perform();
	}

}
