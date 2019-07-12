package commons;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibs.implementation.DropDownControl;
import commonLibs.implementation.ElementControl;
import commonLibs.implementation.IFrameControl;
import commonLibs.implementation.JavaScriptControl;
import utils.WaitUtils;

public class base {

	ElementControl elementcontrol;

	DropDownControl dropdowncontrol;

	JavaScriptControl jscontrol;

	IFrameControl iframecontrol;

	WaitUtils waits;

	JavascriptExecutor jsexecutor;

	public base(WebDriver driver) {

		elementcontrol = new ElementControl();

		dropdowncontrol = new DropDownControl();

		jsexecutor = (JavascriptExecutor) driver;

		iframecontrol = new IFrameControl(driver);


	}
}
