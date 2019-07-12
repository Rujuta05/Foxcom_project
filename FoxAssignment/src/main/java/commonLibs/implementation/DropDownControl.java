package commonLibs.implementation;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import commonLibs.contracts.IDropDwon;


public class DropDownControl implements IDropDwon {
	
private Select getSelect(WebElement element)
{
		Select select=new Select(element);
		return select;
		
}

public void selectViaVisibleText(WebElement element, String visibleText) throws Exception {
	// TODO Auto-generated method stub
	
	getSelect(element).selectByVisibleText(visibleText);
	
}

public void selectViaValue(WebElement element, String value) throws Exception {
	// TODO Auto-generated method stub
	
	getSelect(element).selectByValue(value);
}

@Override
public void selectViaIndex(WebElement element, int index) throws Exception {
	// TODO Auto-generated method stub
	
	getSelect(element).selectByIndex(index);
	
}

@Override
public boolean isMultiple(WebElement element) throws Exception {
	return getSelect(element).isMultiple();
}

@Override
public List<WebElement> getAllOptions(WebElement element) throws Exception {
	return getSelect(element).getOptions();
}

@Override
public List<WebElement> getAllSelectedOptions(WebElement element) throws Exception {
	return getSelect(element).getAllSelectedOptions();
}

@Override
public WebElement getFirstSectedOption(WebElement element) throws Exception {
	return getSelect(element).getFirstSelectedOption();
}
	


}
