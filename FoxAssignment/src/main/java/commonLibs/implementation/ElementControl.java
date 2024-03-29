package commonLibs.implementation;

import org.openqa.selenium.WebElement;

import commonLibs.contracts.ICommonElement;


public class ElementControl implements ICommonElement {

	@Override
	public String getText(WebElement element) throws Exception {
			
		return element.getText();
	}

	@Override
	public void clickElement(WebElement element) throws Exception {

		
		element.click();
	}

	@Override
	public String getAttribute(WebElement element, String attribute) throws Exception {
		// TODO Auto-generated method stub
		
		return element.getAttribute(attribute);
	}

	@Override
	public String getCssValue(WebElement element, String csspropertyName) throws Exception {
		// TODO Auto-generated method stub
		return element.getCssValue(csspropertyName);
	}

	@Override
	public boolean isElementEnabled(WebElement element) throws Exception {
		return element.isEnabled();
	}

	@Override
	public boolean isElementVisible(WebElement element) throws Exception {
		return element.isDisplayed();
	}

	@Override
	public boolean isElementSelected(WebElement element) throws Exception {
		return element.isSelected();
	}

	@Override
	public void setText(WebElement element, String textToWrite) throws Exception {
		element.sendKeys(textToWrite);
	}

	@Override
	public void clearText(WebElement element) throws Exception {
		element.clear();
		
	}

	@Override
	public void changeCheckboxStatus(WebElement element, boolean status) throws Exception {
		boolean currentStatus=element.isSelected();
		
		if((currentStatus && !status) ||(!currentStatus && status))
		{
			element.click();
		}
		// another way
		/*if(currentStatus!=status)
		{
			element.click();
			
		}*/
		
		
	}

}
